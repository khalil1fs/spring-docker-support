package org.example.spring_docker.rest;


import org.example.spring_docker.dao.ReservationRepository;
import org.example.spring_docker.entity.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationRest {
    private final ReservationRepository reservationRepository;

    public ReservationRest(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public <S extends Reservation> List<S> saveAll(Iterable<S> entities) {
        return reservationRepository.saveAll(entities);
    }

    @GetMapping("/")
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public List<Reservation> findAllById(Iterable<Long> longs) {
        return reservationRepository.findAllById(longs);
    }
}
