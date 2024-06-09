public class Electronic extends Product{
    private String Brand ;
    private String WarrantyPeriod;
    public Electronic (){}

    public Electronic(String brand, String WarrantyPeriod) {
        Brand = brand;
        WarrantyPeriod=WarrantyPeriod;
    }

    public Electronic(String productID, String productName, int numberOfAvailableItems, double price, String brand, String warrantyPeriod) {
        super(productID, productName, numberOfAvailableItems, price);
        Brand = brand;
        WarrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getWarrantyPeriod() {
        return WarrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        WarrantyPeriod = warrantyPeriod;
    }
}
