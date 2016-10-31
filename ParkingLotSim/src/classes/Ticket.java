package classes;

public abstract class Ticket{
  public static enum Tier{
    Normal (5.49, 0, 2),
    Super  (9.49, 2, 4),
    Mega   (12.49, 4, 6),
    Ultra  (14.49, 6, 9);

    double charge;
    final int minTime,
              maxTime;
    Tier(double charge, int minTime, int maxTime){
      this.charge=charge;
      this.minTime=minTime;
      this.maxTime=maxTime;
    }
  }
  protected ParkingLocation _parkingLocation;
  protected Tier _tier;
  protected CarData _carData;

  public Ticket(ParkingLocation parkingLocation, Tier tier, CarData carData){
    _parkingLocation=parkingLocation;
    _tier=tier;
    _carData=carData;
  }

  public ParkingLocation getParkingLocation(){
    return _parkingLocation;
  }
  public Tier getTier(){
    return _tier;
  }
  public CarData getCarData(){
    return _carData;
  }
  public int getFloor(){
    return _parkingLocation.floor;
  }
  public int getSpace(){
    return _parkingLocation.space;
  }
  public String getMake(){
    return _carData.make;
  }
  public String getModel(){
    return _carData.model;
  }

  @Override
  public boolean equals(Object object){
    if(object instanceof Ticket){
      Ticket ticket=(Ticket)object;
      return _parkingLocation.equals(ticket.getParkingLocation()) && _tier.equals(ticket.getTier()) && _carData.equals(ticket.getCarData());
    }
    return false;
  }
}