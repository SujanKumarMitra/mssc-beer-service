package com.github.sujankumarmitar.msscbeerservice.controller.v1;

import com.github.sujankumarmitar.msscbeerservice.dto.v1.CreateNewBeerRequestV1;
import com.github.sujankumarmitar.msscbeerservice.dto.v1.CreateNewBeerResponseV1;
import com.github.sujankumarmitar.msscbeerservice.dto.v1.GetBeerResponseV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerBuilderV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerStyleV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.ZoneId;

import static com.github.sujankumarmitar.msscbeerservice.model.v1.BeerBuilderImplV1.builder;
import static java.lang.String.valueOf;
import static java.time.ZonedDateTime.now;
import static java.util.UUID.randomUUID;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerControllerV1 {

    @GetMapping("/{beerId}")
    public ResponseEntity<GetBeerResponseV1> getBeer(@PathVariable String beerId) {
        return ResponseEntity.ok(new GetBeerResponseV1(withDummyBeerData(beerId).build()));
    }

    @PostMapping
    public ResponseEntity<CreateNewBeerResponseV1> createBeer(
            @RequestParam(name = "zoneId", defaultValue = "Asia/Kolkata") ZoneId zoneId,
            @RequestBody CreateNewBeerRequestV1 newBeer) {

        BeerV1 createdBeer = builder()
                .fromBeer(newBeer)
                .withCreatedAt(now(zoneId))
                .withLastModifiedAt(now(zoneId))
                .withId(valueOf(randomUUID()))
                .build();

        return ResponseEntity
                .status(CREATED)
                .body(new CreateNewBeerResponseV1(createdBeer));
    }

    private BeerBuilderV1 withDummyBeerData(String beerId) {
        return builder()
                .withId(beerId)
                .withName("Name")
                .withStyle(BeerStyleV1.PILSNER)
                .withUpc(1000L)
                .withPrice(new BigDecimal("100.00"))
                .withQuantityOnHand(1000)
                .withCreatedAt(now())
                .withLastModifiedAt(now());
    }

}
