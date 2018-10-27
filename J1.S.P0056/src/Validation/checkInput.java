
package Validation;

import java.util.Scanner;

public class checkInput {

    public checkInput() {
    }
    
    Scanner scan = new Scanner(System.in);
    
    public int getUserChoice(){
        String choice;
        boolean valid;
        do {            
            System.out.print("Enter Your Choice: ");
            choice = scan.nextLine();
            valid = choice.matches("[0-5]{1}");
            if(!valid){
                System.out.println("Re-enter your choice please!");
            }
        } while (!valid);
        return Integer.parseInt(choice);
    }
    
    public String getYN(){
        String choice;
        boolean valid;
        do {     
            System.out.println("Do you want to countinue (Y/N) ?");
            choice = scan.nextLine();
            valid = choice.matches("[ynYN]{1}");
            if(!valid){
                System.out.println("Please, enter Y or N only !");
            }
        } while (!valid);
        return choice;
    }
    
    public String getID(){
        String ID;
        boolean valid;
        do {            
            System.out.print("Enter Code: ");
            ID = scan.nextLine();
            valid = ID.matches("^W\\d{1,1000}$");
            if(!valid){
                System.out.println("Format Code: W and 1--->1000!");
            }
        } while (!valid);
        return ID;
    }
    
    public String getName(){
        String name;
        boolean valid;
        do { 
            System.out.print("Enter Name: ");
            name = scan.nextLine();
            valid = name.matches("[a-zA-Z]+");
            if(!valid){
                System.out.println("Name is not valid!");
            }
        } while (!valid);
        return name;
    }
    
    public int getAge(){
        int age = 0;
        while (true) {            
            try {
                System.out.print("Age: ");
                age = Integer.parseInt(scan.nextLine());
                if(age < 18 || age > 50){
                    System.out.println("Enter valid age!");
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not is number!");
                
            }
        }
        return age;
    }
    
    public double getAmount(){
        double amount = 0;
        while (true) {            
            try {
                System.out.print("Amount: ");
                amount = Double.parseDouble(scan.nextLine());
                if(amount <= 0){
                    System.out.println("Please enter positive number");
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not is number!");
                
            }
        }
        return amount;
    }
    
    public double getSalary(){
        double salary = 0;
        while (true) {            
            try {
                System.out.print("Salary: ");
                salary = Double.parseDouble(scan.nextLine());
                if(salary < 0){
                    System.out.println("Please enter positive number");
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not is number!");
                
            }
        }
        return salary;
    }
    
    public String getLocation(){
        String address;
        boolean valid;
        do {            
            System.out.print("Enter work location: ");
            address = scan.nextLine();
            valid = address.trim().isEmpty();
            if (valid) {
                System.err.println("Address can not be empty !");
            }
        } while (valid);
        return address;
    }
}
