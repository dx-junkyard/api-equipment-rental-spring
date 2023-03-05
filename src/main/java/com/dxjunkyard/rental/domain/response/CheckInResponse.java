package com.dxjunkyard.rental.domain.response;

import com.dxjunkyard.rental.domain.Rental;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CheckInResponse {
    private List<Rental> rentalList;
    private String status;
}
