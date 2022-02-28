package shipping;

public class NationalPackage implements Transportable {

    private final static int BASIC_SHIPPING_PRICE = 1000;
    private int weight;
    private boolean isBreakable;

    public NationalPackage(int weight, boolean isBreakeable) {
        this.weight = weight;
        this.isBreakable = isBreakeable;
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
        return (isBreakable ? 2 : 1) * BASIC_SHIPPING_PRICE;
    }


}
