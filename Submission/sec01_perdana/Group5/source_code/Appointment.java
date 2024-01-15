class Appointment {
    private String CarAppointmentDate;

    public Appointment(String CarAppointmentDate) {
        this.CarAppointmentDate = CarAppointmentDate;
    }

    public String getCarAppointmentDate() {
        return CarAppointmentDate;
    }
  
  public String displayAppointmentInfo() { 
    SimpleDateFormatCar dateFormatcar = new SimpleDateFormatCar("dd-MM-yyyy HH:mm:ss");
    return "Car Appointment Date: " + dateFormatcar.format(CarAppointmentDate);
  }
      
}
