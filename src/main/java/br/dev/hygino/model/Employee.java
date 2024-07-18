package br.dev.hygino.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Employee(

        String name,
        LocalDate dateOfBirth,
        BigDecimal salary,
        String department) {

}
