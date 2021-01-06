package com.github.sujankumarmitar.msscbeerservice.controller.v1;

import com.github.sujankumarmitar.msscbeerservice.dto.v1.*;
import com.github.sujankumarmitar.msscbeerservice.exception.v1.BeerNotFoundExceptionV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;
import com.github.sujankumarmitar.msscbeerservice.service.v1.BeerServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerControllerV1 {

    private BeerServiceV1 beerService;

    @Autowired
    public BeerControllerV1(BeerServiceV1 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<GetBeerResponseV1> getBeer(@PathVariable String beerId) {

        BeerV1 beer = beerService.getBeer(beerId);

        return ResponseEntity.ok(new GetBeerResponseV1(beer));
    }

    @PostMapping
    public ResponseEntity<CreateNewBeerResponseV1> createBeer(
            @RequestParam(name = "zoneId", defaultValue = "Asia/Kolkata") ZoneId zoneId,
            @RequestBody CreateNewBeerRequestV1 newBeer) {

        BeerV1 createdBeer = beerService.createBeer(zoneId, newBeer);

        return ResponseEntity
                .status(CREATED)
                .body(new CreateNewBeerResponseV1(createdBeer));
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(
            @RequestParam(name = "zoneId", defaultValue = "Asia/Kolkata") ZoneId zoneId,
            @PathVariable String beerId,
            @RequestBody UpdateBeerRequestV1 updateBeer) {
        updateBeer.setId(beerId);
        beerService.updateBeer(zoneId, updateBeer);

        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<Void> deleteBeer(@PathVariable String beerId) {
        beerService.deleteBeer(beerId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @ExceptionHandler(BeerNotFoundExceptionV1.class)
    public ResponseEntity<BeerNotFoundResponseV1> handleException(
            BeerNotFoundExceptionV1 exception) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(new BeerNotFoundResponseV1(exception));

    }

}
