package com.agiwal77.FlightReservation.services;

import com.agiwal77.FlightReservation.dto.ReservationRequest;
import com.agiwal77.FlightReservation.model.Flight;
import com.agiwal77.FlightReservation.model.Passenger;
import com.agiwal77.FlightReservation.model.Reservation;
import com.agiwal77.FlightReservation.repos.FlightRepository;
import com.agiwal77.FlightReservation.repos.PassengerRepository;
import com.agiwal77.FlightReservation.repos.ReservationRepository;
import com.agiwal77.FlightReservation.util.EmailUtil;
import com.agiwal77.FlightReservation.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PdfGenerator pdfGenerator;
    @Autowired
    private EmailUtil emailUtil;

    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {

        //make payment
        Long flightId = reservationRequest.getFlightId();
        Flight flight = flightRepository.findById(flightId).get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);

        String filePath = "/home/ec2-user/FlightReservation/FlightBookingConfirmation"+savedReservation.getId()+".pdf";
        pdfGenerator.generateItinerary(savedReservation, filePath);
        emailUtil.sendItinerary(passenger.getEmail(),filePath);
        return savedReservation;
    }
}
