package com.agiwal77.FlightReservation.controllers;

import com.agiwal77.FlightReservation.dto.ReservationRequest;
import com.agiwal77.FlightReservation.model.Flight;
import com.agiwal77.FlightReservation.model.Reservation;
import com.agiwal77.FlightReservation.repos.FlightRepository;
import com.agiwal77.FlightReservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){
        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight",flight);
        return "completeReservation";
    }

    @RequestMapping(value = "completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap){
        Reservation reservation = reservationService.bookFlight(reservationRequest);
        modelMap.addAttribute("msg","Reservation created successfully and the ID is "+reservation.getId());

        return "reservationConfirmation";
    }

}
