package com.agiwal77.FlightReservation.repos;

import com.agiwal77.FlightReservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
