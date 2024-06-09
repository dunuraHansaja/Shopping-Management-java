import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CustomerInterface{
    boolean quntExeeded = false;
    int elec = 0;
    int clo = 0;
    double total = 0;
    Object[] tableTopic ={"Product ID", "Name", "Category", "Price(£)", "Info"};
    Object[][] tableData;

    Object[] tableTopic_2 = {"Product", "Quantity", "Price"};
    Object[][] tableData_2;


    public CustomerInterface(){
        JFrame frame = new JFrame("Westminster Shopping Center ");
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(210, 173, 173));

        JComboBox selectBox = new JComboBox(new String[] {"All","Electronics","Clothing"});
        selectBox.setSize(200,30);
        selectBox.setLocation(400,50);
        frame.add(selectBox);

        JButton shoppingCartButton;
        shoppingCartButton = new JButton("Shopping Cart");
        shoppingCartButton.setSize(150,45);
        shoppingCartButton.setLocation(800,10);
        frame.add(shoppingCartButton);

        JButton addButton;
        addButton = new JButton("Add to Cart");
        addButton.setSize(150,45);
        addButton.setLocation(500,800);
        frame.add(addButton);




//  Main Table
        DefaultTableModel mainTableModel = new DefaultTableModel(tableData, tableTopic);
        JTable mainTable = new JTable(mainTableModel);
        JScrollPane jScrollPane = new JScrollPane(mainTable);
        frame.add (jScrollPane);
        jScrollPane.setSize(900,350);
        jScrollPane.setLocation((frame.getWidth() - jScrollPane.getWidth()) / 2, (frame.getHeight() - jScrollPane.getHeight()) / 2);

        jScrollPane.setLocation(50,125);

        for (int i = 0; i < Product.allProductList.size(); i++){
            if (Product.allProductList.get(i) instanceof Electronic){
                String[] row = {Product.allProductList.get(i).getProductID(),Product.allProductList.get(i).getProductName(),"Electronic", String.valueOf(Product.allProductList.get(i).getPrice()),((Electronic)Product.allProductList.get(i)).getBrand()};
                mainTableModel.addRow(row);
            } else {
                String[] row = {Product.allProductList.get(i).getProductID(),Product.allProductList.get(i).getProductName(),"Clothing", String.valueOf(Product.allProductList.get(i).getPrice()),((Clothing)Product.allProductList.get(i)).getColour(),((Clothing)Product.allProductList.get(i)).getSize()};
                mainTableModel.addRow(row);
            }
        }




//  Label for the Westminster shopping Cart
        JLabel labelDetails;
        labelDetails = new JLabel("Selected Product - Details");
        labelDetails.setSize(250, 20);
        labelDetails.setLocation(100, 500);
        labelDetails.setFont(new Font("Arial", Font.BOLD, 13));
        frame.add(labelDetails);

        JLabel labelProductID;
        labelProductID = new JLabel("Product Id:  - ");
        labelProductID.setSize(250, 15);
        labelProductID.setLocation(100, 535);
        frame.add(labelProductID);

        JLabel labelCategory;
        labelCategory = new JLabel("Category:   - ");
        labelCategory.setSize(250, 15);
        labelCategory.setLocation(100, 555);
        frame.add(labelCategory);

        JLabel labelName;
        labelName = new JLabel("Name: - ");
        labelName.setSize(250, 15);
        labelName.setLocation(100, 575);
        frame.add(labelName);

        JLabel labelSize;
        labelSize = new JLabel("Size:  - ");
        labelSize.setSize(250, 15);
        labelSize.setLocation(100, 595);
        frame.add(labelSize);

        JLabel labelColour;
        labelColour = new JLabel("Colour:  - ");
        labelColour.setSize(250, 15);
        labelColour.setLocation(100, 615);
        frame.add(labelColour);


        JLabel labelItems;
        labelItems = new JLabel("Items: - ");
        labelItems.setSize(250, 15);
        labelItems.setLocation(100, 635);
        frame.add(labelItems);

        JLabel labelItemsd;
        labelItemsd = new JLabel(" ");
        labelItemsd.setSize(250, 15);
        labelItemsd.setLocation(100, 655);
        frame.add(labelItemsd);





//  Second pane
        JFrame frame_2 = new JFrame ("Shopping Cart");
        frame_2.setSize(1000,800);
        frame_2.setVisible(true);
//        frame_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame_2.setBackground(new Color(193, 140, 139));

//  Second table
        DefaultTableModel secondTableModel = new DefaultTableModel(tableData_2,tableTopic_2);
        JTable secondTable = new JTable(secondTableModel);
        JScrollPane jScrollPane1 = new JScrollPane(secondTable);
        frame_2.add(jScrollPane1);
        jScrollPane1.setSize(800,350);

        jScrollPane1.setLocation(50,125);


//  Shopping Cart lables

        JLabel lableTotal;
        lableTotal = new JLabel("Total:        - ");
        lableTotal.setSize(400,15);
        lableTotal.setLocation(250,550);
        frame_2.add(lableTotal);


        JLabel lableFPD;
        lableFPD = new JLabel("First Purchase Discount (10%):   - ");
        lableFPD.setSize(400,15);
        lableFPD.setLocation(250,570);
        frame_2.add(lableFPD);


        JLabel lableTISD;
        lableTISD = new JLabel("Three Items in same Category Discount (20%): - ");
        lableTISD.setSize(750,15);
        lableTISD.setLocation(250,590);
        frame_2.add(lableTISD);


        JLabel lableFinalT;
        lableFinalT = new JLabel("Final Total:       - ");
        lableFinalT.setSize(400,15);
        lableFinalT.setLocation(250,620);
        frame_2.add(lableFinalT);

        JLabel lableFinalTr;
        lableFinalTr = new JLabel(" ");
        lableFinalTr.setSize(400,15);
        lableFinalTr.setLocation(250,710);
        frame_2.add(lableFinalTr);

        frame_2.setVisible(false);

        mainTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && mainTable.getSelectedRow() != -1){
                    int tableRow = mainTable.getSelectedRow();
                    String selectedId = (String) mainTableModel.getValueAt(tableRow,0);

                    for (int i = 0; i< Product.allProductList.size(); i++){
                        if (selectedId.equals(Product.allProductList.get(i).getProductID())){
                            if (Product.allProductList.get(i) instanceof Electronic){
                                labelProductID.setText("Product Id " + Product.allProductList.get(i).getProductID());
                                labelCategory.setText("Category Electronic");
                                labelName.setText("Product Name " + Product.allProductList.get(i).getProductName());
                                labelSize.setText("Brand " + ((Electronic) Product.allProductList.get(i)).getBrand());
                                labelColour.setText("Warranty " + ((Electronic) Product.allProductList.get(i)).getWarrantyPeriod());
                                labelItems.setText("Quantity " + Product.allProductList.get(i).getNumberOfAvailableItems());
                            } else {
                                labelProductID.setText("Product Id " + Product.allProductList.get(i).getProductID());
                                labelCategory.setText("Category Clothing");
                                labelName.setText("Product Name " + Product.allProductList.get(i).getProductName());
                                labelSize.setText("Size " + ((Clothing) Product.allProductList.get(i)).getSize());
                                labelColour.setText("Colour " + ((Clothing) Product.allProductList.get(i)).getColour());
                                labelItems.setText("Quantity " + Product.allProductList.get(i).getNumberOfAvailableItems());
                            }
                        }
                    }
                };

            }
        });

        selectBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectBoxValue = (String) selectBox.getSelectedItem();
                if (selectBoxValue.equals("Electronics")){
                    mainTableModel.setRowCount(0);
                    for (int i = 0; i < Product.allProductList.size(); i++){
                        if (Product.allProductList.get(i) instanceof Electronic){
                            String[] row = {Product.allProductList.get(i).getProductID(),Product.allProductList.get(i).getProductName(),"Electronic", String.valueOf(Product.allProductList.get(i).getPrice()),((Electronic)Product.allProductList.get(i)).getBrand()};
                            mainTableModel.addRow(row);

                        }
                    }
                } else if (selectBoxValue.equals("Clothing")) {
                    mainTableModel.setRowCount(0);
                    for (int i = 0; i < Product.allProductList.size(); i++){
                        if (Product.allProductList.get(i) instanceof Clothing){
                            String[] row = {Product.allProductList.get(i).getProductID(),Product.allProductList.get(i).getProductName(),"Clothing", String.valueOf(Product.allProductList.get(i).getPrice()),((Clothing)Product.allProductList.get(i)).getColour(),((Clothing)Product.allProductList.get(i)).getSize()};
                            mainTableModel.addRow(row);
                        }
                    }
                } else {
                    mainTableModel.setRowCount(0);
                    for (int i = 0; i < Product.allProductList.size(); i++){
                        if (Product.allProductList.get(i) instanceof Electronic){
                            String[] row = {Product.allProductList.get(i).getProductID(),Product.allProductList.get(i).getProductName(),"Electronic", String.valueOf(Product.allProductList.get(i).getPrice()),((Electronic)Product.allProductList.get(i)).getBrand()};
                            mainTableModel.addRow(row);
                        } else {
                            String[] row = {Product.allProductList.get(i).getProductID(),Product.allProductList.get(i).getProductName(),"Clothing", String.valueOf(Product.allProductList.get(i).getPrice()),((Clothing)Product.allProductList.get(i)).getColour(),((Clothing)Product.allProductList.get(i)).getSize()};
                            mainTableModel.addRow(row);
                        }
                    }
                }
            }
        });



        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                double first = 0;
                double three = 0;
                double finalPr = 0;

                if (mainTable.getSelectedRowCount() > 0){
                    int tableRow = mainTable.getSelectedRow();
                    String selectedId = (String) mainTableModel.getValueAt(tableRow,0);

                    for (int i = 0; i< Product.allProductList.size(); i++){
                        if (Product.allProductList.get(i).getNumberOfAvailableItems() <= 0){
                            quntExeeded = true;
                        }else {
                            if (selectedId.equals(Product.allProductList.get(i).getProductID())){
                                if (Product.allProductList.get(i) instanceof Electronic){
                                    String[] cartRow = {Product.allProductList.get(i).getProductID() + "," + Product.allProductList.get(i).getProductName(), String.valueOf(1), String.valueOf(Product.allProductList.get(i).getPrice())};
                                    secondTableModel.addRow(cartRow);
                                    elec++;
                                    total = total + Product.allProductList.get(i).getPrice();
                                    Product.allProductList.get(i).setNumberOfAvailableItems(Product.allProductList.get(i).getNumberOfAvailableItems() - 1);
                                } else {
                                    String[] cartRow = {Product.allProductList.get(i).getProductID() + "," + Product.allProductList.get(i).getProductName(), String.valueOf(1), String.valueOf(Product.allProductList.get(i).getPrice())};
                                    secondTableModel.addRow(cartRow);
                                    clo++;
                                    total = total + Product.allProductList.get(i).getPrice();
                                    Product.allProductList.get(i).setNumberOfAvailableItems(Product.allProductList.get(i).getNumberOfAvailableItems() - 1);
                                }
                            }
                        }

                    }

                    if (elec >= 3 || clo >= 3){
                        three = (total * 20)/100;
                    }
                    first = (total * 10)/100;
                    finalPr = total - (three + first);
                    lableTotal.setText("Total Price: " + total);
                    lableFPD.setText("First Purchased Discount(10%): " + first);
                    lableTISD.setText("Three Items in same Category Discount(20%)" + three);
                    lableFinalT.setText("Final Total" + finalPr);
                }
            }
        });
        if (quntExeeded == true){
            addButton.setVisible(false);
        }

        shoppingCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_2.setVisible(true);
            }
        });



    }




}
