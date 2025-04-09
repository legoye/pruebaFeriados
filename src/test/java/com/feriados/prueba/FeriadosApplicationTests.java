package com.feriados.prueba.service;

import com.feriados.prueba.Repository.Holiday;
import com.feriados.prueba.Repository.HolidayRepository;
import com.feriados.prueba.service.HolidayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class FeriadosApplicationTests {

	@Test
	void contextLoads() {
	}

	@ExtendWith(MockitoExtension.class)
	public static class HolidayServiceTest {

		@Mock
		private HolidayRepository holidayRepository;

		@InjectMocks
		private HolidayService holidayService;
		private Holiday holiday1;
		private Holiday holiday2;

		@BeforeEach
		public void setUp() {
			holiday1 = new Holiday();
			holiday1.setDate(LocalDate.of(2025, 1, 1));
			holiday1.setTitle("Año Nuevo");
			holiday1.setType("Civil");

			holiday2 = new Holiday();
			holiday2.setDate(LocalDate.of(2025, 12, 25));
			holiday2.setTitle("Navidad");
			holiday2.setType("Religioso");
		}

		@Test
		public void testGetHolidaysByTypeAndDateRange() {
			when(holidayRepository.findByTypeAndDateBetween("Civil", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31)))
					.thenReturn(Arrays.asList(holiday1));

			List<Holiday> holidays = holidayService.getHolidaysByTypeAndDateRange("Civil", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31));

			assertEquals(1, holidays.size(), "Debería haber 1 feriado de tipo 'Civil'");
			assertEquals("Año Nuevo", holidays.get(0).getTitle(), "El título del feriado debería ser 'Año Nuevo'");

			verify(holidayRepository, times(1)).findByTypeAndDateBetween("Civil", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31));
		}

		@Test
		public void testGetHolidaysByTypeAndDateRange_NoHolidaysFound() {
			when(holidayRepository.findByTypeAndDateBetween("FeriadoNoExistente", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31)))
					.thenReturn(Arrays.asList()); // Ningún feriado encontrado

			List<Holiday> holidays = holidayService.getHolidaysByTypeAndDateRange("FeriadoNoExistente", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31));

			assertTrue(holidays.isEmpty(), "No debería haber feriados para el tipo 'FeriadoNoExistente'");

			verify(holidayRepository, times(1)).findByTypeAndDateBetween("FeriadoNoExistente", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31));
		}

	}
}
