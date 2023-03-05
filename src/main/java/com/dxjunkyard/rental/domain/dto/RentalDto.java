package com.dxjunkyard.rental.domain.dto;


import com.dxjunkyard.rental.domain.EquipmentRental;
import com.dxjunkyard.rental.domain.Rental;
import com.dxjunkyard.rental.domain.RentalFlatten;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RentalDto {
    public static Rental rental(List<RentalFlatten> rentalList) {
        List<EquipmentRental> equipmentList = new ArrayList<>();
        try {
            for (RentalFlatten flatten : rentalList) {
                equipmentList.add(EquipmentRental.builder()
                        .equipmentId(flatten.getEquipmentId())
                        .equipmentN(flatten.getEquipmentN())
                        .build());
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 0:00:00");
            return Rental.builder()
                    .reservationId(rentalList.get(0).getReservationId())
                    .equipmentList(equipmentList)
                    .eventId(rentalList.get(0).getReservationId())
                    .renterId(rentalList.get(0).getRenterId())
                    .startDate(rentalList.get(0).getStartDate().format(formatter))
                    .endDate(rentalList.get(0).getEndDate().format(formatter))
                    .usageDate(rentalList.get(0).getUsageDate().format(formatter))
                    .comment(rentalList.get(0).getComment())
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}
