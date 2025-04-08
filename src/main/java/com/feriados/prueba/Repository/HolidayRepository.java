package com.feriados.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday, String> {

    // Filtra por tipo , y rango de fechas
    List<Holiday> findByTypeAndDateBetween(String type, LocalDate startDate, LocalDate endDate);

}
