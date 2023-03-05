package com.dxjunkyard.rental.domain;

import lombok.Data;

@Data
public class Participant {
    private String participantId;
    private Integer eventId;
    private String invitationCode;
}
