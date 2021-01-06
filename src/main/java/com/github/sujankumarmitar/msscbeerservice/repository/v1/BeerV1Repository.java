package com.github.sujankumarmitar.msscbeerservice.repository.v1;

import com.github.sujankumarmitar.msscbeerservice.entity.v1.BeerEntityV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BeerV1Repository extends JpaRepository<BeerEntityV1, String> {

    @Modifying
    @Transactional
    Long deleteBeerEntityV1ById(String id);

}
