package com.feriados.prueba.dto;

import java.util.List;

public class HolidayResponse {

    private List<HolidayDTO> data;


    public List<HolidayDTO> getData() {
        return data;
    }

    public void setData(List<HolidayDTO> data) {
        this.data = data;
    }
}