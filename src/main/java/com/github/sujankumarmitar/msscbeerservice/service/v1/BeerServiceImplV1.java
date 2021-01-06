package com.github.sujankumarmitar.msscbeerservice.service.v1;

import com.github.sujankumarmitar.msscbeerservice.dao.v1.BeerDaoV1;
import com.github.sujankumarmitar.msscbeerservice.exception.v1.BeerNotFoundExceptionV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerBuilderImplV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

import static java.lang.String.valueOf;
import static java.time.ZonedDateTime.now;
import static java.util.UUID.randomUUID;

@Service
public class BeerServiceImplV1 implements BeerServiceV1 {

    private BeerDaoV1 beerDao;

    @Autowired
    public BeerServiceImplV1(BeerDaoV1 beerDao) {
        this.beerDao = beerDao;
    }

    @Override
    public BeerV1 getBeer(String beerId) throws BeerNotFoundExceptionV1 {
        return beerDao.findBeerById(beerId)
                .orElseThrow(() -> new BeerNotFoundExceptionV1(beerId));
    }

    @Override
    public BeerV1 createBeer(ZoneId zoneId, BeerV1 beerToCreate) {
        BeerV1 beerToSave = BeerBuilderImplV1
                .builder()
                .fromBeer(beerToCreate)
                .withId(valueOf(randomUUID()))
                .withCreatedAt(now(zoneId))
                .withLastModifiedAt(now(zoneId))
                .build();
        return beerDao.createBeer(beerToSave);
    }

    @Override
    public void updateBeer(ZoneId zoneId, BeerV1 beerToUpdate) throws BeerNotFoundExceptionV1 {
        beerToUpdate = BeerBuilderImplV1
                .builder()
                .fromBeer(beerToUpdate)
                .withLastModifiedAt(now(zoneId))
                .build();
        boolean updated = beerDao.updateBeer(beerToUpdate);
        if (!updated)
            throw new BeerNotFoundExceptionV1(beerToUpdate.getId());
    }

    @Override
    public void deleteBeer(String beerId) throws BeerNotFoundExceptionV1 {
        boolean deleted = beerDao.deleteBeerById(beerId);
        if (!deleted)
            throw new BeerNotFoundExceptionV1(beerId);
    }
}
