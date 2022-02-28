package shipping;

public class InternationalPackage implements Transportable {

    private final static int BASIC_SHIPPING_PRICE = 1200;
    private int weight;
    private boolean isBreakable;
    private String destinationCountry;
    private int shippingDistance;

    public InternationalPackage(int weight, boolean isBreakable, String destinatinCountry, int shippingDistance) {
        this.weight = weight;
        this.isBreakable = isBreakable;
        this.destinationCountry = destinatinCountry;
        this.shippingDistance = shippingDistance;

    }

    public int getDistance() {
        return shippingDistance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return isBreakable;
    }

    @Override
    public int calculateShippingPrice() {
        return (isBreakable ? 2 : 1) * BASIC_SHIPPING_PRICE + (shippingDistance * 10 );
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }
}
