
package Main;

import Function.Function;
import Validation.checkInput;
import Worker.History;
import Worker.Worker;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Function function = new Function();
        ArrayList<Worker> worker = new ArrayList<Worker>();
        ArrayList<History> history = new ArrayList<History>();
        checkInput checkValid = new checkInput();
        
        int userChoice;
        boolean check = true;
        do {            
            System.out.println("========WORKER MANAGEMENT========");
            System.out.println("1. Add worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display information salary");
            System.out.println("5. Display information worker");
            System.out.println("0. Exit");
            userChoice = checkValid.getUserChoice();
            switch(userChoice){
                case 1:{
                    function.addWorker(worker, history);
                    
            
                    break;
                }
                case 2:{
                    function.changeSalary(worker, history,"UP");
                    break;
                }
                case 3:{
                    function.changeSalary(worker, history,"DOWN");
                    break;
                }
                case 4:{
                    function.displayChangSalary(history);
                    break;
                }
                case 5:{
                    function.displayWorker(worker);
                    break;
                }
                case 0:{
                    check = false;
                    break;
                }
            }
        } while (check);
    }
}
