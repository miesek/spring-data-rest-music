package com.resources.springdatarestmusic.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.resources.springdatarestmusic.model.Instrument;

public interface InstrumentRepository extends PagingAndSortingRepository<Instrument, Long> {

    Instrument findByType(String type);
    Optional<Instrument> findInstrumentById(Long identifier);
    Optional<Instrument> findFirstInstrumentByTypeAndPrice(String type, String price);
    List<Instrument> findInstrumentByTypeAndPrice(String type, String price);
}
