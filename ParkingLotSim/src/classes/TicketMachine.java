package classes;

public class TicketMachine{
  private Server _server;

  public TicketMachine(Server server){
    _server=server;
  }

  public void checkIn(Parker parker){
    ServerTicket serverTicket=new ServerTicket(_server.nextAvailableParking(), calculateTier(parker.getExpectedTime()), parker.getCarData());
    postTicket(serverTicket);
    parker.receiveTicket(new PrintedTicket(serverTicket));
  }
  private Ticket.Tier calculateTier(double selectedTime){
    if(selectedTime>0) {
      Ticket.Tier[] tiers=Ticket.Tier.values();
      int i;
      for(i=0; i<tiers.length-1; ++i){
        if(selectedTime>tiers[i].minTime && selectedTime<=tiers[i].maxTime){
          return tiers[i];
        }
      }
      if(selectedTime>tiers[i].minTime){
        return tiers[i];
      }
    }
    throw new IllegalArgumentException("Time selected is invalid.");
  }
  private void postTicket(ServerTicket ticket){
    _server.addTicket(ticket);
  }
}