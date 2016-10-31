package classes;

public final class CarData{
  public String make,
                model;
  private ParkingLocation _parkingLocation;
  private double _parkedTime;

  public CarData(String make, String model){
    this.make=make;
    this.model=model;
  }

  public ParkingLocation getParkingLocation(){
    return _parkingLocation;
  }
  public double getParkedTime(){
    return _parkedTime;
  }
  public void setParkingLocation(ParkingLocation parkingLocation){
    _parkingLocation=parkingLocation;
  }
  public void setParkedTime(double parkedTime){
    _parkedTime=parkedTime;
  }
  @Override
  public boolean equals(Object object){
    if(object instanceof CarData){
      CarData carData=(CarData)object;
      return make.equals(carData.make) && model.equals(carData.model);
    }
    return false;
  }
}
