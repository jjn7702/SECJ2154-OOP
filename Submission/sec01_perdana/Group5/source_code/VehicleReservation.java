class VehicleReservation{
    private String reservationNumber;
    private String creationDate;
    private enum status {Waiting, Pending, Confirmed, Completed, Canceled, None};
    private String dueDate;
    private String returnDate;
    private String pickupLocationName;
    private String returnLocationName;
}