package classes;

public class Car{
  private CarData _carData;

  public Car(CarData carData){
    _carData=carData;
  }

  public CarData getData(){
    return _carData;
  }
  public ParkingLocation getParkingLocation(){
    return _carData.getParkingLocation();
  }
  public double getParkedTime(){
    return _carData.getParkedTime();
  }
  public void setParkingLocation(ParkingLocation location){
    _carData.setParkingLocation(location);
  }

  public void park(double parkingTime, Server server){
    System.out.println(String.format("%s %s finished parking for %.1f hours at location %d%c.", _carData.make, _carData.model, parkingTime, getParkingLocation().floor, (char)(getParkingLocation().space+64)));
    _carData.setParkedTime(parkingTime);
    server.syncParkedTime(this);
  }
}