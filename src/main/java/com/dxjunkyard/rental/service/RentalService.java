package com.dxjunkyard.rental.service;

import com.dxjunkyard.rental.domain.Rental;
import com.dxjunkyard.rental.domain.EquipmentRental;
import com.dxjunkyard.rental.domain.RentalFlatten;
import com.dxjunkyard.rental.domain.dto.RentalDto;
import com.dxjunkyard.rental.domain.request.CheckInRequest;
import com.dxjunkyard.rental.domain.request.RentalRequest;
import com.dxjunkyard.rental.domain.request.ReservationRequest;
import com.dxjunkyard.rental.domain.response.GetRentalResponse;
import com.dxjunkyard.rental.repository.dao.mapper.RentalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RentalService {
    private Logger logger = LoggerFactory.getLogger(RentalService.class);

    @Autowired
    RentalMapper rentalMapper;

    public List<Rental> checkin(CheckInRequest request) {
        List<Rental> rentalList = new ArrayList<>();
        try {
            LocalDate today = LocalDate.now();
            LocalDateTime midnight = today.atStartOfDay();
            // カウンターID, 借り主のuserid, 貸出日付でレンタルする備品リストを取得
            List<Integer> reservationIdList = rentalMapper.getReservationIdList(
                    request.getCounterId()
                    , request.getUserId()
                    , midnight);

            for (Integer reservationId : reservationIdList) {
                List<RentalFlatten> flattenList = rentalMapper.getRental(reservationId);
                Rental rental = RentalDto.rental(flattenList);
                rentalList.add(rental);
            }
            return rentalList;
        } catch (Exception e) {
            logger.info("error" + e.getMessage());
            return rentalList;
        }
    }

    public void reserve(ReservationRequest request) {
        try {
            // todo: 各備品について、その日の在庫があるかどうかをチェックする必要がる
            List<RentalFlatten> reservationList= RentalDto.reserve(request);
            rentalMapper.addReservation(reservationList);
        } catch (Exception e) {
            logger.info("error" + e.getMessage());
        }
    }
}
