package com.agiwal77.FlightReservation.services;

import com.agiwal77.FlightReservation.dto.ReservationRequest;
import com.agiwal77.FlightReservation.model.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest reservationRequest);
}
