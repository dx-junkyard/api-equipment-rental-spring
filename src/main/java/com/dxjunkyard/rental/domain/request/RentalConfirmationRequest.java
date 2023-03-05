package com.dxjunkyard.rental.domain.request;

import lombok.Data;

@Data
public class RentalConfirmationRequest {
    private String reservationId;
    private String renterId;
}
