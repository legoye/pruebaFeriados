package com.feriados.prueba;

import com.feriados.prueba.service.HolidayService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class FeriadosComponent implements CommandLineRunner {

    private final HolidayService service;

    public FeriadosComponent(HolidayService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        service.readHolidaysAndSave();
    }
}
