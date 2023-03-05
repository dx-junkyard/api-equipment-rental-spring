package com.dxjunkyard.rental.domain.response;

import com.dxjunkyard.rental.domain.Participant;
import lombok.Data;

import java.util.List;

@Data
public class GetParticipantsResponse {
    private List<Participant> participantList;
}
