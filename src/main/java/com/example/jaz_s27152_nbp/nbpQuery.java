package com.example.jaz_s27152_nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "jaz")
public class nbpQuery {
    @Schema(description = "Id sprawdzenia")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "Nazwa waluty")
    private String currency;
    @Schema(description = "Dzień poczatku")
    private LocalDate days;
    @Schema(description = "Średni kurs")
    private double averageRate;
    @Schema(description = "Końcowy dzień")
    private LocalDate daye;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDays() {
        return days;
    }

    public void setDays(LocalDate days) {
        this.days = days;
    }

    public LocalDate getDaye() {
        return daye;
    }

    public void setDaye(LocalDate daye) {
        this.daye = daye;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }


}
