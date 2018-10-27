/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0073;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JD
 */
public class HandleExpense {

    /**
     * @param args the command line arguments
     */
    
    public static double checkInput(String Mess, double min, double max) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(Mess);
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Your value inputted is out of range");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error input format !!");
            }
        } while (true);
    }

    public static String getdate() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        String date;
        do {
            try {
                System.out.print("Enter date: ");
                date = sc.nextLine();
                sdf.parse(date);
                return date;
            } catch (Exception e) {
                System.out.println("Wrong date, please try again");
            }
        } while (true);
    }

    public static double getAmount() {
        double amount = checkInput("Enter amount: ", 0, Double.MAX_VALUE);
        return amount;
    }
        
    public static String getContent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter content: ");
        String content = sc.nextLine();
        return content;
    }

    public static void addExpense(List<Expense> listOfExpense) {
        System.out.println("---------- Add an expense ----------");
        String date;
        double amount;
        String content;
        date = getdate();
        amount = getAmount();
        content = getContent();

        Expense expense = new Expense(date, amount, content);
        listOfExpense.add(expense);
        System.out.println("Expense has been added successfully");

    }

    public static void deleteExpense(List<Expense> listOfExpense) {
        double deleteID = checkInput("Enter ID: ", 1, Double.MAX_VALUE);

        boolean existID = false;
        for (int i = 0; i < listOfExpense.size(); i++) {
            if (listOfExpense.get(i).ID == deleteID) {
                existID = true;
                listOfExpense.remove(i);
            }
        }
        if (existID) {
            System.out.println("Delete an expense successful");
        } else {
            System.out.println("Delete an expense fail");
        }

    }

    public static void displayExpense(List<Expense> listOfExpense) {

        double total = 0;
        for (int i = 0; i < listOfExpense.size(); i++) {
            total += listOfExpense.get(i).amount;
        }
        System.out.println("----------- Display all expense ---------");
        System.out.println("ID \t Date      \t Amount     Content");
        for (int i = 0; i < listOfExpense.size(); i++) {
            listOfExpense.get(i).displayInfo();
            System.out.println();
        }
        System.out.println();
        System.out.println("Total: " + total);
        System.out.println();
    }

    public static void main(String[] args) {
        List<Expense> listOfExpense = new ArrayList<>();
        double choice;
        do {
            System.out.println("=========Handy Expense program==========");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            choice = checkInput("Your choice: ", 1, 4);
            
            switch ((int)choice) {
                case 1:
                    addExpense(listOfExpense);
                    break;
                case 2:
                    displayExpense(listOfExpense);
                    break;
                case 3:
                    deleteExpense(listOfExpense);
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
        
        
    }

}


//public static boolean emptyString(String checkString) {
//        if (checkString.isEmpty()) {
//            return false;
//        } else {
//            return checkString.trim().isEmpty();
//        }
//    }