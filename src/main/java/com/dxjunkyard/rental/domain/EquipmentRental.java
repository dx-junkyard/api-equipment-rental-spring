package com.dxjunkyard.rental.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipmentRental {
    private Integer equipmentId;
    private Integer equipmentN;
}
