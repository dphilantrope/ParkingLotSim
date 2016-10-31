package classes;

public class ServerTicket extends Ticket{
  private int _parkedTime;

  public ServerTicket(ParkingLocation parkingLocation, Tier tier, CarData carData){
    super(parkingLocation, tier, carData);
  }

  public int getParkedTime(){
    return _parkedTime;
  }
  public void setParkedTime(double parkedTime){
    _parkedTime=(int)Math.ceil(parkedTime);
  }

  @Override
  public boolean equals(Object object){
    return super.equals(object);
  }
}