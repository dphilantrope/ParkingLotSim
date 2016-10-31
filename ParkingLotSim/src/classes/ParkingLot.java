package classes;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ParkingLot{
  private ArrayBlockingQueue<Parker> _entranceLine;
  private Entrance _entrance;

  public ParkingLot(){
    _entrance=new Entrance();
    ParkingLevel lobby=new ParkingLevel();
    Server server=new Server();
    _entrance.setLevel(lobby, null, 0, new TicketMachine(server), new BillingMachine(server));
    ParkingLevel plaza=new ParkingLevel(null, lobby, 2, new Car[10], server);
    lobby.setLevel(plaza, _entrance, 1, new Car[6], server);
    server.setup(new ParkingLevel[]{lobby, plaza});
    _entranceLine=new ArrayBlockingQueue<Parker>(9);
  }

  public void enter(Parker parker){
    _entranceLine.offer(parker);
    ScheduledExecutorService timer=newSingleThreadScheduledExecutor();
    timer.schedule(
      () ->{
              Parker parkerUp=null;
              try{
                parkerUp=_entranceLine.take();
              }catch (InterruptedException e){
                e.printStackTrace();
              }
              System.out.println(String.format("%s %s entered parking lot.", parkerUp.getCarData().make, parkerUp.getCarData().model));
              _entrance.enter(parkerUp);
              timer.shutdown();
           }, (long)(Math.random()), SECONDS);
  }
}