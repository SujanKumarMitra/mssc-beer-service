package com.github.sujankumarmitar.msscbeerservice.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sujankumarmitar.msscbeerservice.dto.v1.CreateNewBeerRequestV1;
import com.github.sujankumarmitar.msscbeerservice.dto.v1.CreateNewBeerResponseV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;

import static com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1.PILSNER;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerControllerV1.class)
class BeerControllerV1Test {

    public static final String VALID_BEER_ID = "a-valid-id";
    public static final String REQUEST_PATH = "/api/v1/beer";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void givenValidBeerId_ShouldReturnBeer() throws Exception {
        mockMvc
                .perform(get(REQUEST_PATH + "/{beerId}", VALID_BEER_ID))
                .andDo(print())
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
        request.setUpc(12345678L);
        request.setQuantityOnHand(1000);

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

}