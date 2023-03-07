package com.dxjunkyard.rental.controller;

import lombok.extern.slf4j.Slf4j;
import com.dxjunkyard.rental.domain.request.*;
import com.dxjunkyard.rental.domain.response.*;
import com.dxjunkyard.rental.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api")
@Slf4j
public class Controller {
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private RentalService rentalService;

    /**
     *
     */
    @PostMapping("/equipment-reserve")
    @ResponseBody
    public NormalResponse makeReservation(
            @RequestBody ReservationRequest request){
        logger.info("rental API");
        try {
            // todo : parameter validation
            rentalService.reserve(request);
            return NormalResponse.builder().result("OK").build();
        } catch (Exception e) {
            logger.debug("rental" + e.getMessage());
            return NormalResponse.builder().result("NG").build();
        }
    }

    /**
     * 
     */
    @GetMapping("/check-in")
    @ResponseBody
    public CheckInResponse checkIn(
            @RequestParam("counterId") String counterId
            ,@RequestParam("userId") String userId
    ){
        logger.info("rental API");
        try {
            // todo : parameter validation
            return CheckInResponse.builder()
                    .rentalList(rentalService.checkin(counterId,userId))
                    .status("OK")
                    .build();
        } catch (Exception e) {
            logger.debug("rental" + e.getMessage());
            return CheckInResponse.builder().status("NG").build();
        }
    }

    /**
     *
     */
    @GetMapping("/check-out")
    @ResponseBody
    public CheckInResponse checkOut(
            @RequestParam("counterId") String counterId
            ,@RequestParam("userId") String userId
    ){
        logger.info("rental API");
        try {
            // todo : parameter validation
            return CheckInResponse.builder()
                    .rentalList(rentalService.checkin(counterId,userId))
                    .status("OK")
                    .build();
        } catch (Exception e) {
            logger.debug("rental" + e.getMessage());
            return CheckInResponse.builder().status("NG").build();
        }
    }

    /**
     *
     */
    @PostMapping("/rental-confirm")
    @ResponseBody
    public NormalResponse rentalConfirm(
            @RequestBody RentalConfirmationRequest request ) {
        logger.info("rental API");
        try {
            // todo : parameter validation
            return NormalResponse.builder().result("OK").build();
        } catch (Exception e) {
            logger.info("rental confirmation error : reservation id = " + request.getReservationId());
            logger.debug("rental" + e.getMessage());
            return NormalResponse.builder().result("NG").build();
        }
    }


    @GetMapping("/hello")
    @ResponseBody
    public NormalResponse checkin(){
        logger.info("疎通確認 URL");
        return NormalResponse.builder().result("OK").build();
    }

}
