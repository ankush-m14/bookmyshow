package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookMovieResponseDto {
     //Here specifically return the booking object directly
    //to simplify things on the client side when finally run this
    //but in reality it gives the booking id/amount

    private int amount;
    private Long bookingId;

    private ResponseStatus responseStatus;

}
