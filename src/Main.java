import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//  Interface call
        SwingUtilities.invokeLater(() -> {
//            CustomerInterface customerInterface = new CustomerInterface();
//            customerInterface.setVisible(true);
        });

//  save file added
        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
//        westminsterShoppingManager.addToSystem();


        Scanner input = new Scanner(System.in);

        while (true){
//            System.out.println("Enter 1 for Electronic items \nEnter 2 for Clothing items");
//            System.out.println("");

            System.out.println("**************");
            System.out.println(" Enter 1 : Add product into system \n           Press '1' for ELECTRONIC items \n           Press '2' for CLOTHING items \n Enter 2 : Remove product from the system \n Enter 3 : Print the list \n Enter 4 : Save to the File \n Enter 5 : Open the Interface \n Enter 6 : Exit the Programme ");
            int mainOption = input.nextInt();

            if(mainOption==1){
                westminsterShoppingManager.addToSystem();
                System.out.println("Enter 1 : Add Product to the System ");
                System.out.println("Press '1' for ELECTRONIC items \n Press '2' for CLOTHING items ");

            }else if (mainOption == 2) {
                westminsterShoppingManager.removeFromSystem();
                System.out.println("Enter 2 : Remove product from the system ");
            }else if (mainOption == 3){
                westminsterShoppingManager.list();
                System.out.println("Enter 3 : Print the list ");
            }else if (mainOption == 4) {
                westminsterShoppingManager.saveFile();
                System.out.println("Enter 4 : Save to the File ");
            } else if (mainOption == 5) {
                CustomerInterface customerInterface = new CustomerInterface();
                System.out.println("Enter 5 : Open the Interface ");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}