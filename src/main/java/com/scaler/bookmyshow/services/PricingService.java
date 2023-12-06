package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.ShowSeatType;
import org.springframework.stereotype.Service;
import com.scaler.bookmyshow.repositories.ShowSeatTypeRepository;

import java.util.List;

@Service
public class PricingService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    public int calculatePrice(List<ShowSeat> showSeats, Show show){
     List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        //also need to set amount like final show amount
        //it will depend on what type of seat user were select
        //but to know which show seatType do user select for that
        //In ShowSeat class we have Seat object and in that there is seatType
        //the showSeat class give all showSeatType and which were is match will give final amount.

        int amount = 0;
        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                   amount += showSeatType.getPrice();
                   break;
                }
            }
        }
        return amount;
    }
}
