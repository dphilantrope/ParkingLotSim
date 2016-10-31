package classes;

public class Bill extends Ticket{
  private double _charge;

  public Bill(ServerTicket ticket, double charge){
    super(ticket.getParkingLocation(), ticket.getTier(), ticket.getCarData());
    _charge=charge;
  }

  public double getCharge(){
    return _charge;
  }

  public String toString(){
    return String.format("{Charge: $%.2f; Tier: %s; Car data: %s %s}", _charge, getTier(), getMake(), getModel());
  }
}