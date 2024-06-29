package com.example.jaz_s27152_nbp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class nbpService {

    private nbpQueryRepository repository;
    public nbpService(nbpQueryRepository repository) {
        this.repository = repository;
    }

    public double getAverageRate(String currency, LocalDate days, LocalDate daye) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + days + "/" + daye + "/?format=json";
        RestTemplate restTemplate = new RestTemplate();
        NbpResponse response = restTemplate.getForObject(url, NbpResponse.class);

        double sum = 0;
        for (Rate rate : response.getRates()) {
            sum += rate.getMid();
        }
        double averageRate = sum / response.getRates().length;

        nbpQuery query = new nbpQuery();
        query.setCurrency(currency);
        query.setAverageRate(averageRate);
        query.getDays();
        query.getDaye();
        repository.save(query);

        return averageRate;
    }
    private static class NbpResponse {
        private Rate[] rates;

        public Rate[] getRates() {
            return rates;
        }

        public void setRates(Rate[] rates) {
            this.rates = rates;
        }
    }

    private static class Rate {
        private double mid;

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }
    }
}
