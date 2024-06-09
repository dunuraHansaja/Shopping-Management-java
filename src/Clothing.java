public class Clothing extends Product{
    private String Size;
    private String Colour;
    public Clothing (){}

    public Clothing(String Size, String Colour){
        Size=Size;
        Colour=Colour;
    }

    public Clothing(String productID, String productName, int numberOfAvailableItems, double price, String size, String colour) {
        super(productID, productName, numberOfAvailableItems, price);
        Size = size;
        Colour = colour;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }
}
