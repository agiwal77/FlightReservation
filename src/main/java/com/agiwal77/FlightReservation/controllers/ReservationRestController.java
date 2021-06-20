package com.agiwal77.FlightReservation.controllers;

import com.agiwal77.FlightReservation.dto.ReservationUpdateRequest;
import com.agiwal77.FlightReservation.model.Reservation;
import com.agiwal77.FlightReservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        return reservationRepository.findById(id).get();
    }

    @RequestMapping("/reservation")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckIn());
        return reservationRepository.save(reservation);

    }
}
