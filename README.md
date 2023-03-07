# api-equipment-rental-spring

### 予約例
```
curl -XPOST -H "Content-Type: application/json"  http://localhost:8080/v1/api/equipment-reserve -d'{"equipmentList":[{"equipmentId":1,"equipmentN":3}],"eventId":1,"renterId":"UPxxxxxxxxxxxxxx01","startDate":"2023-03-20 00:00:00","endDate":"2023-03-22 00:00:00","usageDate":"2023-03-21 00:00:00","comment":"何かコメント"}'
```

### QRコード読み取り後のチェックイン
#### これより前のAPIで認証を済ませ、userIdを取得しておく
```
curl -XGET "http://localhost:8080/v1/api/check-in?counterId=COUNTER_ID_ABC&userId=UPxxxxxxxxxxxxxx01"
```