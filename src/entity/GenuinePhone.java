package entity;

public class GenuinePhone extends Phone{
    private double warrantyPeriod;
    private String warrantyScope;
    public GenuinePhone(int id, String name, double price, int quantity, String producer, double warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, producer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }
    public double getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(double warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }
}
