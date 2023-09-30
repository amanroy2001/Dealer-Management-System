//emp id- 927836 Aman Roy

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
public class HRDepartment extends Department implements Employee {
	private List<String> employeeNames;
    private List<Integer> employeeIds;

    public HRDepartment(String name) {
        super(name);
        employeeNames = new ArrayList<>();
        employeeIds = new ArrayList<>();
		employeeNames.add("John Doe");
		employeeNames.add("Uday");
		employeeNames.add("Piyanshu");
		employeeNames.add("Aman");
		employeeNames.add("Darshan");
		employeeNames.add("Shravani");
		employeeNames.add("Arsh");
		employeeNames.add("Eswar");
		employeeIds.add(12345);
		employeeIds.add(916220);
		employeeIds.add(927818);
		employeeIds.add(927836);
		employeeIds.add(927826);
		employeeIds.add(927832);
		employeeIds.add(927894);
		employeeIds.add(927895);
		
        
    }

    @Override
    public void performTask() {
        String output = name + " department is managing HR functions.";
        System.out.println(output);
        writeToLogFile(output);
    }

    @Override
    public void work() {
        String output = "HR employee is conducting interviews.";
        System.out.println(output);
        writeToLogFile(output);
    }
    public void viewAllEmployees() {
    	System.out.println("-----------------------------------------------------------------------");
        System.out.println("\nEmployee Database:");
        for (int i = 0; i < employeeNames.size(); i++) {
            String employeeName = employeeNames.get(i);
            Integer employeeId = employeeIds.get(i);
            String output1="Name: " + employeeName + ", ID: " + employeeId;
           // System.out.println("Name: " + employeeName + ", ID: " + employeeId);
            System.out.println(output1);
        	writeToLogFile("-----------------------------------------------------------------------");
            writeToLogFile(output1);
        	writeToLogFile("-----------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    
    public void addEmployee(String employeeName, Integer employeeId) {
        employeeNames.add(employeeName);
        employeeIds.add(employeeId);
        String output = "Employee added: Name - " + employeeName + ", ID - " + employeeId;
        System.out.println(output);
        writeToLogFile(output);
    }
    public void findEmployeeInfo(String employeeName) {
        String output;
        int index = employeeNames.indexOf(employeeName);
        if (index != -1) {
            String foundEmployeeName = employeeNames.get(index);
            Integer foundEmployeeId = employeeIds.get(index);
            output = "Employee found: Name - " + foundEmployeeName + ", ID - " + foundEmployeeId;
        } else {
            output = "Employee not found: " + employeeName;
        }
        System.out.println(output);
        writeToLogFile(output);
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
