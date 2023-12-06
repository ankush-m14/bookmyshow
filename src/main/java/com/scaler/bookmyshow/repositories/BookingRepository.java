package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Component

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    //it is optional of booking instead of booking
    //because to handel the null object
    //there might be case were the is no booking that particular Id
    @Override
    Optional<Booking> findById(Long aLong);

    @Override
    Booking save(Booking booking);
}
