import java.util.concurrent.ScheduledExecutorService;
import java.util.Iterator;
import java.util.Set;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

import classes.*;

public class ParkingLotDemo{
  public static void main(String[] args) {
    System.out.println("Fried & Riley's Lot.");
    System.out.println();
    ParkingLot parkingLot=new ParkingLot();

    CarMap carMap=new CarMap();
    Set<String> makes=carMap.keySet();
    for(int i=0; i<10; ++i){
      Iterator<String> iterator=makes.iterator();
      int n=(int)(Math.random()*makes.size());
      for(int j=0; j<n; ++j){
        iterator.next();
      }
      String make = iterator.next();
      String[] makeModels = carMap.get(make);
      String model=makeModels[(int)(Math.random()*makeModels.length)];
      ScheduledExecutorService timer=newSingleThreadScheduledExecutor();
      timer.schedule(
        () ->{
                Parker parker=new Parker(new Car(new CarData(make, model)), (int)(Math.random()*10+1));
                parkingLot.enter(parker);
             }, (long)(Math.random()*2), SECONDS);

      try{
        timer.awaitTermination((long)2, SECONDS);
      }catch (InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}