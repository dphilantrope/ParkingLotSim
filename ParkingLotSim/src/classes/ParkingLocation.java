package classes;

import java.util.Comparator;

public class ParkingLocation implements Comparable<ParkingLocation>, Comparator<ParkingLocation>{
  public int floor,
             space;

  public ParkingLocation(int floor, int space){
    this.floor=floor;
    this.space=space;
  }

  @Override
  public int compareTo(ParkingLocation location){
    int floorComparison=floor-location.floor;
    return floorComparison!=0? floorComparison: space-location.space;
  }
  @Override
  public int compare(ParkingLocation location1, ParkingLocation location2){
    int floorComparison=location1.floor-location2.floor;
    return floorComparison!=0? floorComparison: location1.space-location2.space;
  }
  @Override
  public boolean equals(Object object){
    if(object instanceof ParkingLocation){
      ParkingLocation location=(ParkingLocation)object;
      return floor==location.floor && space==location.space;
    }
    return false;
  }
}