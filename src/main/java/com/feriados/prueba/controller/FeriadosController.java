package com.feriados.prueba.controller;

import com.feriados.prueba.Repository.Holiday;
import com.feriados.prueba.service.HolidayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/feriados/v1")
// Clase controlador para crear el endpoints para el usuario
public class FeriadosController {

    private final HolidayService service;

    public FeriadosController(HolidayService service) {
        this.service = service;
    }

    @GetMapping
    public List<Holiday> getHolidays() {
        return service.getAllHolidays();
    }


    @GetMapping("/filter")
    public List<Holiday> getFilteredHolidays(
            @RequestParam String type,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return service.getHolidaysByTypeAndDateRange(type, start, end);
    }
}
