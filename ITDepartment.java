//emp id- 927836 Aman Roy
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ITDepartment extends Department implements Employee {
    private List<Laptop> laptops;
    Scanner scanner = new Scanner(System.in);
    public ITDepartment(String name) {
        super(name);
        laptops = new ArrayList<>();
        initializeLaptops();
    }

    private void initializeLaptops() {
        laptops.add(new Laptop("HP", 1200.0, 15));
        laptops.add(new Laptop("Dell", 1300.0, 20));
        laptops.add(new Laptop("Asus", 1100.0, 10));
    }

    @Override
    public void performTask() {
        System.out.println(name + " department is managing IT resources.");
        writeToLogFile("Performed IT department task.");
    }

    @Override
    public void work() {
        System.out.println("IT employee is working on a technical task.");
        writeToLogFile("IT employee is working on a technical task.");
    }

    public void viewLaptopInfo() {
        System.out.println("Laptop Inventory and Prices:");
        for (Laptop laptop : laptops) {
        	System.out.println("-----------------------------------------------------------------------");
            System.out.println("Brand: " + laptop.getBrand());
            System.out.println("Price: Rs." + laptop.getPrice());
            System.out.println("Inventory: " + laptop.getInventory());
        	System.out.println("-----------------------------------------------------------------------");
        	writeToLogFile("-----------------------------------------------------------------------");
            writeToLogFile("Brand: " + laptop.getBrand());
        	writeToLogFile("Price: Rs." + laptop.getPrice());
        	writeToLogFile("Inventory: " + laptop.getInventory());
        	writeToLogFile("-----------------------------------------------------------------------");

        }
        writeToLogFile("Viewed laptop info.");
    }
    public void buyLaptop(boolean isHomeBranch) {
        boolean laptopFound = false;
        Laptop selectedLaptop = null;

        while (!laptopFound) {
            System.out.println("Which Brand you want --> HP  Asus Dell");
            String brand = scanner.nextLine();
            
            for (Laptop laptop : laptops) {
                if (laptop.getBrand().equalsIgnoreCase(brand)) {
                    selectedLaptop = laptop;
                    laptopFound = true;
                    break; 
                }
            }

            if (!laptopFound) {
                System.out.println("Invalid brand. Please select from HP, Asus, or Dell.");
            }
        }

        double price = selectedLaptop.getPrice();
        if (isHomeBranch) {
            price *= 0.9; 
        }

        if (selectedLaptop.getInventory() > 0) {
            selectedLaptop.setInventory(selectedLaptop.getInventory() - 1);
        	System.out.println("-----------------------------------------------------------------------");

            System.out.println("Laptop purchased successfully.");
            System.out.println("Brand: " + selectedLaptop.getBrand());
            System.out.println("Price: Rs." + price);
        	System.out.println("-----------------------------------------------------------------------");
        	writeToLogFile("-----------------------------------------------------------------------");

            writeToLogFile("Purchased a laptop: Home Branch - " + isHomeBranch + ", Brand - " + selectedLaptop.getBrand());
        	writeToLogFile("-----------------------------------------------------------------------");

        } else {
            System.out.println("Sorry, the selected laptop is out of stock.");
        }
    }

	//final static String fileLocation="C:\\Users\\arr927836\\Desktop\\new.txt";


    public void writeToLogFile(String logMessage){
		try (FileOutputStream fos = new FileOutputStream("C:\\Users\\arr927836\\Desktop\\new.txt",true)){
  
    	String formattedLog = "[" + name + "] " + logMessage + "\n";
            fos.write(formattedLog.getBytes());
        
   // fos.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
}

}


