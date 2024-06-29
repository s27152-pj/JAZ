package com.example.jaz_s27152_nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
public class nbpController {

    private nbpService service;
    public nbpController(nbpService service) {
        this.service = service;
    }
    @Operation(summary = "Zwraca Średnią sume kursów walut, przyjmuje wartość days - dzień od którego zacząć, daye - dzień na którym koniec")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Znbaleziony kurs",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "zadanie nieprawidłowo sformułowanych zapytań",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "brak danych dla prawidłowo określonego zakresu czasowego",
                    content = @Content) })
    @GetMapping("/rate/{currency}")
    public ResponseEntity<Double> getAverageRate(
            @PathVariable String currency,
            @RequestParam(defaultValue = "2024-06-28") LocalDate days, LocalDate daye) {
        double averageRate = service.getAverageRate(currency, days, daye);
        return ResponseEntity.ok(averageRate);
    }


}