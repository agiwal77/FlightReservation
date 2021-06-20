package com.agiwal77.FlightReservation.repos;

import com.agiwal77.FlightReservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
