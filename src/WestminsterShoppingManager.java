import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager{

    Scanner input= new Scanner(System.in);

    Product product = new Product() {
    };
    @Override
    public void addToSystem() {
        System.out.println("Enter product category");
        int productCategory = input.nextInt();



        if (productCategory == 1){

            System.out.println("Enter product Id");
            input.nextLine();


            String productId = input.nextLine();


            System.out.println("Enter product Name");
            String productName = input.nextLine();

            System.out.println("Enter number of available items");
            int availableItems = input.nextInt();

            System.out.println("Enter product price");
            double productPrice = input.nextDouble();

            System.out.println("Enter product brand");
            String brand = input.nextLine();

            input.nextLine();
           
            System.out.println("Enter warranty period");
            String WarrantyPeriod = input.nextLine();

            Product p1 = new Electronic(productId,productName,availableItems,productPrice,brand,WarrantyPeriod);
            Product.allProductList.add(p1);
            
        }
        else if (productCategory == 2){

            System.out.println("Enter product Id");
            input.nextLine();

            String NewproductId = input.nextLine();

            System.out.println("Enter product Name");
            String productName = input.nextLine();

            System.out.println("Enter number of available items");
            int availableItems = input.nextInt();

            System.out.println("Enter product price");
            double productPrice = input.nextDouble();

            System.out.println("Enter product size");
            String size = input.nextLine();

            input.nextLine();

            System.out.println("Enter product colour");
            String colour = input.nextLine();

            Product p1 = new Clothing(NewproductId,productName,availableItems,productPrice,size,colour);
            Product.allProductList.add(p1);

        }
        else {
            System.out.println("Enter correct input");

        }
    }
    public void removeFromSystem(){

        System.out.println("Enter your remove productId");
        String removeProductId = input.nextLine();

        for (int i = 0; i < Product.allProductList.size(); i++){

            if (removeProductId.equals(Product.allProductList.get(i).getProductID())){
                System.out.println(Product.allProductList.get(i).getProductName() + " successfully removed");
                Product.allProductList.remove(i);
                break;
            }
        }
    }

    public void list(){
        for (int i=0; i<Product.allProductList.size();i++){
            if (Product.allProductList.get(i) instanceof Electronic)
            {System.out.println(Product.allProductList.get(i).getProductID() + " " + Product.allProductList.get(i).getProductName() + " " + Product.allProductList.get(i).getNumberOfAvailableItems() + " " + Product.allProductList.get(i).getPrice() + " " + ((Electronic) Product.allProductList.get(i)).getBrand() + " " + ((Electronic) Product.allProductList.get(i)).getWarrantyPeriod());
            }else{
            System.out.println(Product.allProductList.get(i).getProductID() + " " + Product.allProductList.get(i).getProductName() + " " + Product.allProductList.get(i).getNumberOfAvailableItems() + " " + Product.allProductList.get(i).getPrice() + " " + ((Clothing) Product.allProductList.get(i)).getSize() + " " + ((Clothing) Product.allProductList.get(i)).getColour());
            }
        }
    }


    public void saveFile(){
        try{
            FileWriter writefile = new FileWriter ("OOPfile.txt");
//            writefile.write("added");
            for (int i=0; i<Product.allProductList.size();i++){

                writefile.write("\n");
                if(Product.allProductList.get(i) instanceof Electronic)
                writefile.write(Product.allProductList.get(i).getProductID() + " " + Product.allProductList.get(i).getProductName() + " " + Product.allProductList.get(i).getNumberOfAvailableItems() + " " + Product.allProductList.get(i).getPrice() + " " + ((Electronic) Product.allProductList.get(i)).getBrand() + " " + ((Electronic) Product.allProductList.get(i)).getWarrantyPeriod());

                else {
                    writefile.write(Product.allProductList.get(i).getProductID() + " " + Product.allProductList.get(i).getProductName() + " " + Product.allProductList.get(i).getNumberOfAvailableItems() + " " + Product.allProductList.get(i).getPrice() + " " + ((Clothing) Product.allProductList.get(i)).getSize() + " " + ((Clothing) Product.allProductList.get(i)).getColour());
                }
            }
            writefile.close();
            System.out.println("File wrote Sucessfull");
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
