package classes;

import java.util.Iterator;
import java.util.LinkedList;
import static java.util.Collections.sort;

public final class Server{
  /*private class ServerLinkedList<T>{
   //Innerclass data structure for the aggregate lists
   //iterator method, sort method
  }*/
  private ParkingLevel[] _levels;
  private LinkedList<ParkingLocation> _availableParkingList;
  private LinkedList<ServerTicket> _ticketList;

  public Server(){
  }

  public void setup(ParkingLevel[] levels){
    _levels=levels;
    _availableParkingList=new LinkedList<>();
    for(int i=0; i<levels.length; ++i){
      for(int j=0; j<levels[i].getParkingSpaces().length; ++j){
        _availableParkingList.add(new ParkingLocation(i+1, j+1));
      }
    }
    _ticketList=new LinkedList<>();
  }

  public void addAvailableParking(ParkingLocation parkingLocation){
    _availableParkingList.add(parkingLocation);
    sort(_availableParkingList);
  }
  public ParkingLocation nextAvailableParking(){
    return _availableParkingList.remove(0);
  }

  public void addTicket(ServerTicket ticket){
    _ticketList.add(ticket);
  }
  public ServerTicket findTicket(PrintedTicket ticket){
    return _ticketList.stream()
      .filter(serverTicket ->serverTicket.equals(ticket))
      .findFirst()
      .get();
  }
  public void syncParkedTime(Car car){
    ServerTicket ticket=findTicket(car);
    if(ticket!=null){
      ticket.setParkedTime(car.getParkedTime());
      return;
    }
    throw new IllegalArgumentException("Car not found in ticket list.");
  }
  public ServerTicket findTicket(Car car){
    ParkingLocation location=car.getParkingLocation();
    Iterator<ServerTicket> ticketsIterator=_ticketList.iterator();
    ServerTicket ticket;
    do{
      ticket=ticketsIterator.next();
    }while(!(ticket.getParkingLocation().equals(location)) && ticketsIterator.hasNext());

    if(ticket.getParkingLocation().equals(location)){
      return ticket;
    }
    return null;
  }
}