package com.feriados.prueba.service;

import com.feriados.prueba.Repository.Holiday;
import com.feriados.prueba.Repository.HolidayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HolidayServiceTest {

    @Mock
    private HolidayRepository holidayRepository;

    @InjectMocks
    private HolidayService holidayService;

    private Holiday holiday1;

    @BeforeEach
    public void setUp() {
        holiday1 = new Holiday();
        holiday1.setTitle("Año Nuevo");
    }

    @Test
    public void testGetHolidaysByTypeAndDateRange() {
        when(holidayRepository.findByTypeAndDateBetween("Civil", LocalDate.now(), LocalDate.now().plusDays(7)))
                .thenReturn(Arrays.asList(holiday1));
        List<Holiday> holidays = holidayService.getHolidaysByTypeAndDateRange("Civil", LocalDate.now(), LocalDate.now().plusDays(7));

        assertEquals(1, holidays.size());
        assertEquals("Año Nuevo", holidays.get(0).getTitle());
    }

    @Test
    void getHolidaysByTypeAndDateRange() {
    }
}
