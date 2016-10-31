package classes;

public final class Entrance extends Level{
  private TicketMachine _ticketMachine;
  private BillingMachine _billingMachine;

  public Entrance(){
  }

  public void setLevel(Level nextLevel, Level previousLevel, int floor, TicketMachine ticketMachine, BillingMachine billingMachine){
    super.setLevel(nextLevel, previousLevel, floor);
    _ticketMachine=ticketMachine;
    _billingMachine=billingMachine;
  }

  @Override
  public void enter(Parker parker){
    _ticketMachine.checkIn(parker);
    super.enter(parker);
  }
  @Override
  public void exit(Parker parker){
    _billingMachine.checkout(parker);
    parker.exitTo(_previousLevel);
    System.out.println("bill: "+((Bill)parker.getTicket()));
    System.out.println(String.format("%s %s left the parking lot.", parker.getCarData().make, parker.getCarData().model));
    System.out.println("Vroooooom!");
    System.out.println();
  }
}