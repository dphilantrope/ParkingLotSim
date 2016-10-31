package classes;

public final class ParkingLevel extends Level{
  private Car[] _parkingSpaces;
  private Server _server;

  public ParkingLevel(){
  }
  public ParkingLevel(Level nextLevel, Level previousLevel, int floor ,Car[] parkingSpaces, Server server){
    setLevel(nextLevel, previousLevel, floor, parkingSpaces, server);
  }

  public Car[] getParkingSpaces(){
    return _parkingSpaces;
  }
  public void setLevel(Level nextLevel, Level previousLevel, int floor, Car[] parkingSpaces, Server server){
    super.setLevel(nextLevel, previousLevel, floor);
    _parkingSpaces=parkingSpaces;
    _server=server;
  }

  @Override
  public void enter(Parker parker){
    if(_floor==parker.getTicket().getFloor()){
      parker.parkCar(this, _server);
    }
    else{
      super.enter(parker);
    }
  }
}