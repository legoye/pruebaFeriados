package com.feriados.prueba.service;

import com.feriados.prueba.Repository.Holiday;
import com.feriados.prueba.Repository.HolidayRepository;
import com.feriados.prueba.dto.HolidayResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    private final HolidayRepository repository;

    public HolidayService(HolidayRepository repository) {
        this.repository = repository;
    }

    // Obtiene todos los feriados (prueba personal)
    public List<Holiday> getAllHolidays() {
        return repository.findAll();
    }

    // Obtiene todos feriados por tipo y rango)
    public List<Holiday> getHolidaysByTypeAndDateRange(String type, LocalDate startDate, LocalDate endDate) {
        return repository.findByTypeAndDateBetween(type, startDate, endDate);
    }


    public void readHolidaysAndSave() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.victorsanmartin.com/feriados/en.json";

        HolidayResponse response = restTemplate.getForObject(url, HolidayResponse.class);

        if (response != null && response.getData() != null) {
            var holidays = response.getData().stream().map(dto -> {
                Holiday h = new Holiday();
                h.setDate(dto.getDate());
                h.setTitle(dto.getTitle());
                h.setExtra(dto.getExtra());
                h.setType(dto.getType());
                h.setInalienable(dto.getInalienable());
                return h;
            }).collect(Collectors.toList());

            repository.saveAll(holidays);

        } else {

        }
    }
}
