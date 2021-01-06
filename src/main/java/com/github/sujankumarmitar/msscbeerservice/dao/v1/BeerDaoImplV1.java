package com.github.sujankumarmitar.msscbeerservice.dao.v1;

import com.github.sujankumarmitar.msscbeerservice.entity.v1.BeerEntityV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.BeerV1;
import com.github.sujankumarmitar.msscbeerservice.model.v1.ImmutableBeerV1;
import com.github.sujankumarmitar.msscbeerservice.repository.v1.BeerV1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeerDaoImplV1 implements BeerDaoV1 {

    private BeerV1Repository repository;

    @Autowired
    public BeerDaoImplV1(BeerV1Repository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<BeerV1> findBeerById(String id) {
        return repository
                .findById(id)
                .map(beerEntity -> (BeerV1) beerEntity);
    }

    @Override
    public BeerV1 createBeer(BeerV1 beer) {
        BeerEntityV1 savedEntity = repository.save(new BeerEntityV1(beer));
        return new ImmutableBeerV1(savedEntity);
    }

    @Override
    public boolean updateBeer(BeerV1 beer) {
        Optional<BeerEntityV1> mightHaveBeer = repository.findById(beer.getId());
        if (mightHaveBeer.isEmpty())
            return false;
        repository.save(new BeerEntityV1(beer));
        return true;
    }

    @Override
    public boolean deleteBeerById(String id) {
        Long count = repository.deleteBeerEntityV1ById(id);
        return count.intValue() == 1;
    }
}
