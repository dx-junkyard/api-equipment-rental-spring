package com.dxjunkyard.rental.domain.response;

import com.dxjunkyard.rental.domain.Rental;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRentalResponse {
    private List<Rental> eventList;
}
