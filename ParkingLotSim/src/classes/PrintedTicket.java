package classes;

public class PrintedTicket extends Ticket{
  public PrintedTicket(ServerTicket ticket){
    super(ticket.getParkingLocation(), ticket.getTier(), ticket.getCarData());
  }
}