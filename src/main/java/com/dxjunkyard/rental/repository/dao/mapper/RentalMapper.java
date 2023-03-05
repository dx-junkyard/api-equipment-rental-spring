package com.dxjunkyard.rental.repository.dao.mapper;

import com.dxjunkyard.rental.domain.RentalFlatten;
import org.apache.ibatis.annotations.Mapper;
import com.dxjunkyard.rental.domain.Rental;
import com.dxjunkyard.rental.domain.EquipmentRental;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface RentalMapper {
    List<Integer> getReservationIdList(String counterId , String renterId, LocalDateTime today);
    void addRental(Rental event);
    void addIncludeSportRental(Integer sportRentalId);
    List<RentalFlatten> getRental(Integer reservationId);
    List<EquipmentRental> getIncludedSportRental(Integer eventId);
}
