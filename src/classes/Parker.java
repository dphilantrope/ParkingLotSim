package classes;

import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Parker{
  private Car _car;
  private double _expectedTime;
  private Ticket _ticket;

  public Parker(Car car, int expectedTime){
    _car=car;
    _expectedTime=expectedTime;
  }

  public double getExpectedTime(){
    return _expectedTime;
  }
  public Ticket getTicket(){
    return _ticket;
  }
  public CarData getCarData(){
    return _car.getData();
  }

  public void receiveTicket(Ticket ticket){
    _ticket=ticket;
  }
  public void parkCar(ParkingLevel level, Server server){
    level.getParkingSpaces()[_ticket.getParkingLocation().space-1]=_car;
    _car.setParkingLocation(_ticket.getParkingLocation());
    final double parkingTime=_expectedTime+(new java.util.Random()).nextGaussian()*1.5+0.5;
    ScheduledExecutorService timer=newSingleThreadScheduledExecutor();
    timer.schedule(
      () ->{
              _car.park(parkingTime, server);
              level.getParkingSpaces()[_ticket.getParkingLocation().space-1]=null;
              level.exit(Parker.this);
              timer.shutdown();
           }, (long)parkingTime*10, SECONDS);
    }
  public void advanceTo(Level level){
    ScheduledExecutorService timer=newSingleThreadScheduledExecutor();
    timer.schedule(
      () ->{
              level.enter(Parker.this);
              timer.shutdown();
           }, (long)0.5, SECONDS);
  }
  public void exitTo(Level level){
    ScheduledExecutorService timer=newSingleThreadScheduledExecutor();
    timer.schedule(
      () ->{
              level.exit(Parker.this);
              timer.shutdown();
           }, (long)0.5, SECONDS);
  }
}
