package com.dxjunkyard.rental.domain.request;

import lombok.Data;

@Data
public class CheckInRequest {
    private String counterId;
    private String userId;
}
