package org.example.spring_docker;

import org.example.spring_docker.dao.ReservationRepository;
import org.example.spring_docker.entity.Reservation;
import org.example.spring_docker.entity.ReservationStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ReservationRepository reservationRepository) {
        return args -> {
            List<Reservation> reservationList = new ArrayList<>();
            reservationList.add(new Reservation("Test 1",Math.random(),ReservationStatus.OK));
            reservationList.add(new Reservation("Test 2",Math.random(),ReservationStatus.PENDING));
            reservationList.add(new Reservation("Test 3",Math.random(),ReservationStatus.PROCEEDED));
            reservationList.add(new Reservation("Test 4",Math.random(),ReservationStatus.VALIDATED));
            reservationList.add(new Reservation("Test 5",Math.random(),ReservationStatus.CANCELED));
            reservationRepository.saveAll(reservationList);

//            for (Reservation reservation : reservationRepository.findAll()) {
//                System.out.println(reservation.getPrice());
//            }
        };
    }
}
