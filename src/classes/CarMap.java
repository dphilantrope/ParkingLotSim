package classes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public final class CarMap{
  private HashMap<String, String[]> makesToModels;
  {
    makesToModels=new HashMap<>();
    makesToModels.put("Acura", new String[]{"MDX", "TLX"});
    makesToModels.put("Buick", new String[]{"LaCrosse", "Enclave"});
    makesToModels.put("Chevrolet", new String[]{"Corvette", "Camaro", "Equinox", "Impala", "Malibu", "Silverado"});
    makesToModels.put("Dodge", new String[]{"Charger", "Challenger", "Dart", "Viper"});
    makesToModels.put("Ford", new String[]{"Edge", "Explorer", "Focus", "Fusion", "Mustang", "Taurus"});
    makesToModels.put("Honda", new String[]{"Accord", "Civic", "CR-V", "CR-Z", "Odyssey", "Pilot"});
    makesToModels.put("Infiniti", new String[]{"Q50", "QX50", "Q70", "QX70"});
    makesToModels.put("Jeep", new String[]{"Cherokee", "Compass", "Patriot", "Renegade", "Wrangler"});
    makesToModels.put("Kia", new String[]{"Cadenza", "Forte", "Optima", "Sorento", "Soul", "Sportage"});
    makesToModels.put("Lexus", new String[]{"GS", "IS", "LS", "NX", "RC", "RX"});
    makesToModels.put("Mazda", new String[]{"3", "6", "CX-5", "CX-9"});
    makesToModels.put("Nissan", new String[]{"370Z", "Altima", "Frontier", "GT-R", "Juke", "Leaf", "Maxima", "Murano", "Rogue", "Sentra"});
    makesToModels.put("Toyota", new String[]{"4Runner", "Avalon", "Camry", "Corolla", "Highlander", "Prius", "RAV4", "Tacoma", "Tundra", "Yaris"});
    makesToModels.put("Volvo", new String[]{"S60", "S90", "XC60", "XC90"});
  }

  public String[] get(String key){
    return makesToModels.get(key);
  }
  public Set<String> keySet(){
    return makesToModels.keySet();
  }
  public Collection<String[]> values(){
    return makesToModels.values();
  }
}