package com.resources.springdatarestmusic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.resources.springdatarestmusic.model.Instrument;
import com.resources.springdatarestmusic.repository.InstrumentRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final InstrumentRepository repository;

    @Autowired
    public DatabaseLoader(InstrumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        String[] types = new String[]{"guitar", "guitar", "piano", "saxophone", "violin", "drums"};
        for (String type : types) {
            Instrument instrument = new Instrument();
            instrument.setType(type);
            instrument.setPrice("22.30");
            repository.save(instrument);
        }

        Instrument violin = repository.findByType("violin");
        System.out.println("Znaleziono: " + violin);

        Optional<Instrument> guitar = repository.findInstrumentById(5L);
        System.out.println("Znaleziono: " + guitar);

        Optional<Instrument> instrument1 = repository.findFirstInstrumentByTypeAndPrice("guitar", "11.22");
        System.out.println("znaleziono: "+instrument1);

        Optional<Instrument> instrument2 = repository.findFirstInstrumentByTypeAndPrice("guitar", "22.30");
        System.out.println("znaleziono: "+instrument2);

        List<Instrument> instruments = repository.findInstrumentByTypeAndPrice("guitar", "22.30");
        System.out.println("znalazlem " + instruments);

        
    }
}
