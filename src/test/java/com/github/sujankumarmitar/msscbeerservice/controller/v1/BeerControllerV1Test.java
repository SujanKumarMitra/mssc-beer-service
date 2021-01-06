package com.github.sujankumarmitar.msscbeerservice.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sujankumarmitar.msscbeerservice.dto.v1.CreateNewBeerRequestV1;
import com.github.sujankumarmitar.msscbeerservice.dto.v1.UpdateBeerRequestV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerBuilderImplV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;
import com.github.sujankumarmitar.msscbeerservice.service.v1.BeerServiceV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.UUID;

import static com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1.PILSNER;
import static java.lang.String.valueOf;
import static java.time.ZonedDateTime.now;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerControllerV1.class)
@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
class BeerControllerV1Test {

    public static final String VALID_BEER_ID = "a-valid-id";
    public static final String REQUEST_PATH = "/api/v1/beer";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    BeerServiceV1 beerService;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    void givenValidBeerId_ShouldReturnBeer() throws Exception {
        BeerV1 beer = BeerBuilderImplV1
                .builder()
                .withId(VALID_BEER_ID)
                .withStyle(PILSNER)
                .withName("Name")
                .withPrice(new BigDecimal("100.12"))
                .withQuantityOnHand(100)
                .withUpc("1234567890123")
                .withCreatedAt(now())
                .withLastModifiedAt(now())
                .build();

        doReturn(beer)
                .when(beerService)
                .getBeer(eq(VALID_BEER_ID));

        mockMvc
                .perform(get(REQUEST_PATH + "/{beerId}", VALID_BEER_ID))
                .andDo(print())
                .andDo(document(
                        "getBeer", pathParameters(
                                parameterWithName("beerId").description("id of beer")
                        )))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.beer.id").value(VALID_BEER_ID))
                .andReturn();
    }

    @Test
    void givenValidBeer_ShouldCreateNewBeer() throws Exception {

        CreateNewBeerRequestV1 request = new CreateNewBeerRequestV1();

        request.setName("beer name");
        request.setPrice(new BigDecimal("100.12"));
        request.setStyle(PILSNER);
        request.setUpc("1234567890123");
        request.setQuantityOnHand(1000);


        Mockito.doAnswer(invocation -> {
            ZoneId id = invocation.<ZoneId>getArgument(0);
            BeerV1 beerGiven = invocation.<BeerV1>getArgument(1);
            return BeerBuilderImplV1
                    .builder()
                    .withId(valueOf(UUID.randomUUID()))
                    .withCreatedAt(now(id))
                    .withLastModifiedAt(now(id))
                    .build();
        })
                .when(beerService)
                .createBeer(any(), any());

        MvcResult mvcResult = mockMvc
                .perform(
                        post(REQUEST_PATH)
                                .contentType(APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.createdBeer").exists())
                .andReturn();


    }

    @Test
    void givenBeerToUpdate_ShouldUpdateBeer() throws Exception {
        doNothing()
                .when(beerService)
                .updateBeer(any(), argThat(arg -> arg.getId().equals(VALID_BEER_ID)));

        UpdateBeerRequestV1 request = new UpdateBeerRequestV1();

        request.setId(VALID_BEER_ID);
        request.setName("Updated Name");
        request.setPrice(new BigDecimal("345.67"));
        request.setStyle(BeerStyleV1.GOSE);
        request.setQuantityOnHand(200);

        MvcResult mvcResult = mockMvc
                .perform(
                        put(REQUEST_PATH + "/{beerId}", VALID_BEER_ID)
                                .contentType(APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request)))

                .andExpect(status().isNoContent())
                .andReturn();

    }

    @Test
    void givenValidBeerId_ShouldDeleteBeer() throws Exception {
        doNothing()
                .when(beerService)
                .deleteBeer(eq(VALID_BEER_ID));

        mockMvc
                .perform(
                        delete(REQUEST_PATH + "/{beerId}", VALID_BEER_ID))
                .andExpect(status().isNoContent())
                .andReturn();

    }

}