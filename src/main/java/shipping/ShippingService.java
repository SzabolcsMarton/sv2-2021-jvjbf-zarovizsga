package shipping;

import java.util.*;

public class ShippingService {

    private List<Transportable> transportables = new ArrayList<>();

    public ShippingService() {
    }

    public void addPackage(Transportable transportable) {
        transportables.add(transportable);
    }

    public List<Transportable> getPackages() {
        return transportables;
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return transportables.stream()
                .filter(transportable -> transportable.getWeight() >= weight && transportable.isBreakable() == breakable)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> tranportByCountry = new HashMap<>();
        for(Transportable actual : transportables){
           if(!tranportByCountry.containsKey(actual.getDestinationCountry())) {
               tranportByCountry.put(actual.getDestinationCountry(), 1);
           }else {
               tranportByCountry.put(actual.getDestinationCountry(), tranportByCountry.get(actual.getDestinationCountry()) +1);
           }
        }
        return tranportByCountry;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return transportables.stream().filter(transportable -> transportable instanceof InternationalPackage)
                .sorted((o1, o2) -> ((InternationalPackage) o1).getDistance() -((InternationalPackage)o2).getDistance())
                .toList();
    }
}
