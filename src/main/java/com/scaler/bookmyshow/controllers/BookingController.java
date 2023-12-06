package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.dtos.BookMovieRequestDto;
import com.scaler.bookmyshow.dtos.BookMovieResponseDto;
import com.scaler.bookmyshow.dtos.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.scaler.bookmyshow.services.BookingService;

//To tell springboot to creat object
//use @Component it will object for us and store it in memory
//@Component

//springBoot says if we have controller and we want springBoot to
//creat an object for us instead of @Component use @Controller
//becoz if someone try read code it should know this is a Controller
@Controller
public class BookingController {
    private BookingService bookingService;

    //If manually created a constructor and if we said springboot to inject
    //this manual constructor use @Autowired

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto) {

        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();

        Booking booking;
        try {
             booking = bookingService.bookMovie(
                     bookMovieRequestDto.getUserId(),
                     bookMovieRequestDto.getShowSeatIds(),
                     bookMovieRequestDto.getShowId()
             );

             bookMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
             bookMovieResponseDto.setBookingId(booking.getId());
             bookMovieResponseDto.setAmount(booking.getAmount());
        }catch (Exception ex){
            bookMovieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return  bookMovieResponseDto;
    }
}
