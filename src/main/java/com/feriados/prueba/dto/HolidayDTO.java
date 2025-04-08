package com.feriados.prueba.dto;

import java.time.LocalDate;

public class HolidayDTO {
    private LocalDate date;
    private String title;
    private String extra;
    private String type;
    private Boolean inalienable;

    // Getters y setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Boolean getInalienable() {
        return inalienable;
    }

    public void setInalienable(Boolean inalienable) {
        this.inalienable = inalienable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}