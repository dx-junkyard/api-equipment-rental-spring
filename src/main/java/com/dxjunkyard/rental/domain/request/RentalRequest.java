package com.dxjunkyard.rental.domain.request;

import lombok.Data;

@Data
public class RentalRequest {
    private Integer counterId; //
    private Integer renterId; // 借り主の user id
}
