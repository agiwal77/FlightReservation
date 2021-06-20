package com.agiwal77.FlightReservation.repos;

import com.agiwal77.FlightReservation.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
