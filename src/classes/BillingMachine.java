package classes;

public class BillingMachine{
  private Server _server;

  public BillingMachine(Server server){
    _server=server;
  }

  public void checkout(Parker parker){
    Ticket ticket=parker.getTicket();
    ServerTicket correspondingTicket=_server.findTicket((PrintedTicket)ticket);
    parker.receiveTicket(new Bill(correspondingTicket, calculateCharge(correspondingTicket)));
    _server.addAvailableParking(correspondingTicket.getParkingLocation());
  }
  private double calculateCharge(ServerTicket ticket){
    int expiredTime=ticket.getParkedTime()-ticket.getTier().maxTime;
    return ((expiredTime>0? 3.50*expiredTime: 0)+ticket.getTier().charge)*1.08875;
  }
}