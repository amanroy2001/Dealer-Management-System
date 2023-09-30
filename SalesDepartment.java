//emp id- 927836 Aman Roy
import java.io.FileOutputStream;
import java.io.IOException;

public class SalesDepartment extends Department implements Employee {
    private int salesCount;

    public SalesDepartment(String name) {
        super(name);
        salesCount = 0;
    }

    @Override
    public void performTask() {
        System.out.println(name + " department is handling sales activities.");
        writeToLogFile(name + " department is handling sales activities.");
    }

    @Override
    public void work() {
        System.out.println("Sales employee is making sales calls.");
        writeToLogFile("Sales employee is making sales calls.");
    }

    public void viewSalesInfo() {
        System.out.println("Sales count: " + salesCount);
        writeToLogFile("Sales count: " + salesCount);
    }

    public void makeSale() {
        salesCount++;
        System.out.println("Sale made successfully.");
        writeToLogFile("Sale made successfully.");
    }

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
