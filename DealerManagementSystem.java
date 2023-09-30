//emp id- 927836 Aman Roy
import java.util.Scanner;

public class DealerManagementSystem {
    public static void main(String[] args) {
        ITDepartment itDept = new ITDepartment("IT");
        SalesDepartment salesDept = new SalesDepartment("Sales");
        HRDepartment hrDept = new HRDepartment("HR");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. IT Department");
            System.out.println("2. Sales Department");
            System.out.println("3. HR Department");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    itDepartmentMenu(itDept, scanner);
                    break;
                case 2:
                    salesDepartmentMenu(salesDept, scanner);
                    break;
                case 3:
                    hrDepartmentMenu(hrDept, scanner);
                    break;
                case 4:
                    System.out.println("Exiting the Dealer Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void itDepartmentMenu(ITDepartment itDept, Scanner scanner) {
    	itDept.performTask();
        itDept.work();
        while (true) {
        	
            System.out.println("\nIT Department Menu:");
            System.out.println("1. View Laptop Info");
            System.out.println("2. Buy Laptop");
            System.out.println("3. Return to Main Menu");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    itDept.viewLaptopInfo();
                    break;
                case 2:
                    System.out.print("Is this a home branch purchase? (true/false): ");
                    boolean isHomeBranch = scanner.nextBoolean();
                  //  System.out.println("Which Brand you want --> HP  Asus Dell");
                  //  String brand= scanner.nextLine(); 
                    itDept.buyLaptop(isHomeBranch);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void salesDepartmentMenu(SalesDepartment salesDept, Scanner scanner) {
    	salesDept.performTask();
        salesDept.work();
        while (true) {
        	
            System.out.println("\nSales Department Menu:");
            System.out.println("1. View Sales Info");
            System.out.println("2. Make Sale");
            System.out.println("3. Return to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    salesDept.viewSalesInfo();
                    break;
                case 2:
                    salesDept.makeSale();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

		private static void hrDepartmentMenu(HRDepartment hrDept, Scanner scanner) {
		    hrDept.performTask();
		    hrDept.work();
		    while (true) {
		        System.out.println("\nHR Department Menu:");
		        System.out.println("1. Add Employee");
		        System.out.println("2. Find Employee Info");
		        System.out.println("3. View All Employees");
		        System.out.println("4. Return to Main Menu");

		        System.out.print("Enter your choice: ");
		        int choice = scanner.nextInt();

		        switch (choice) {
		            case 1:
		                System.out.print("Enter employee name: ");
		                String employeeName = scanner.next();
		                System.out.print("Enter employee ID: ");
		                int employeeId = scanner.nextInt();
		                hrDept.addEmployee(employeeName, employeeId);
		                break;
		            case 2:
		                System.out.print("Enter employee name to find: ");
		                String searchName = scanner.next();
		                hrDept.findEmployeeInfo(searchName);
		                break;
		            case 3:
		                hrDept.viewAllEmployees();
		                break;
		            case 4:
		                return;
		            default:
		                System.out.println("Invalid choice. Please try again.");
		        }
		    }
		}

}


	
