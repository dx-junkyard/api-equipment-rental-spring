package com.dxjunkyard.rental.domain.request;

public class ReservationRequest {
    private Integer equipmentId;  // 借りる設備id
    private Integer eventId;  // 利用目的のイベントid
    private Integer renterId; // 借り主の user id
    private String startDate; // 貸出開始
    private String endDate; //　貸出終了
    private String usageDate; // 使用日
    private String comment; // コメント
}
