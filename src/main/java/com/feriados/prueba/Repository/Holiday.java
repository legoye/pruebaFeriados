package com.feriados.prueba.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Holiday {

    @Id
    private LocalDate date;

    private String title;
    private String extra;
    private String type;
    private Boolean inalienable;

    public Holiday() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getInalienable() {
        return inalienable;
    }

    public void setInalienable(Boolean inalienable) {
        this.inalienable = inalienable;
    }
}

