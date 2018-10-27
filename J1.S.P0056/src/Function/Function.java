package Function;

import Validation.checkInput;
import Worker.History;
import Worker.Worker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Function extends ArrayList<Worker> {

    Scanner scan = new Scanner(System.in);

    public Function() {
        super();
    }
    checkInput checkValid = new checkInput();

    public int find(String ID, ArrayList<Worker> listWorker) {
        for (int i = 0; i < listWorker.size(); i++) {
            if (listWorker.get(i).getID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public String getValidID(ArrayList<Worker> listWorker) {
        String ID;
        int pos;
        do {
            ID = checkValid.getID();
            pos = find(ID, listWorker);
            if (pos >= 0) {
                System.out.println("This CODE has existed!");
            }
        } while (pos >= 0);
        return ID;
    }

    public void displayWorker(ArrayList<Worker> listWorker) {
        System.out.println("------------Display Information Worker------------");
        System.out.println("Code\tName\tAge\tSalary\tWork location");
        for (int i = 0; i < listWorker.size(); i++) {
            System.out.println(listWorker.get(i).getID() + "\t" + listWorker.get(i).getName() + "\t" + listWorker.get(i).getAge() + "\t" + listWorker.get(i).getSalary() + "\t" + listWorker.get(i).getLocation());

        }
    }

    

    public void addWorker(ArrayList<Worker> listWorker, ArrayList<History> listHistory) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String date = f.format(new Date());
            String ID = getValidID(listWorker);
            String name = checkValid.getName();
            int age = checkValid.getAge();
            double salary = checkValid.getSalary();
            String location = checkValid.getLocation();
            listWorker.add(new Worker(ID, name, age, salary, location));
            listHistory.add(new History("ORIGINAL", date, ID, name, age, salary, location));
    }

//    void addHistory(int pos, ArrayList<Worker> l, ArrayList<History> history, String status) {
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        String date = f.format(new Date());
//    history.add(new History(status, date, l.get(pos).getID(), l.get(pos).
//                getName(), l.get(pos).getAge(), l.get(pos).getSalary(), l.get(pos).getLocation()));
//
//    }

    public void changeSalary(ArrayList<Worker> l, ArrayList<History> history, String status) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String date = f.format(new Date());
        String ID = checkValid.getID();
        int pos = find(ID, l);
        if (pos == -1) {
            System.out.println("There is not CODE in list!");
        } else {
            if (status.equals("UP")) {
                double amount = checkValid.getAmount();
                double newSalary = amount + l.get(pos).getSalary();
                l.get(pos).setSalary(newSalary);
                //addHistory(pos, l, history, status);
                history.add(new History(status, date, l.get(pos).getID(), l.get(pos).
                getName(), l.get(pos).getAge(), l.get(pos).getSalary(), l.get(pos).getLocation()));
            } else if (status.equals("DOWN")) {
                double amount = checkValid.getAmount();
                double newSalary = l.get(pos).getSalary() - amount;
                l.get(pos).setSalary(newSalary);
                //addHistory(pos, l, history, status);
                history.add(new History(status, date, l.get(pos).getID(), l.get(pos).
                getName(), l.get(pos).getAge(), l.get(pos).getSalary(), l.get(pos).getLocation()));
            } 

        }
    }

    public void addHistory(ArrayList<Worker> l, ArrayList<History> history, String status) {
        String date;

    }
    
    public void displayChangSalary(ArrayList<History> listHistory){
        System.out.println("------------Display Information Salary------------");
        System.out.println("Code\tName\tAge\tSalary\tDate\t\tStatus");
        for (int i = 0; i < listHistory.size(); i++) { 
            System.out.println(listHistory.get(i).getID() + "\t" + listHistory.get(i).getName() + "\t" + listHistory.get(i).getAge() + "\t" + listHistory.get(i).getSalary() + "\t" + listHistory.get(i).getDate() + "\t" + listHistory.get(i).getStatus());
        }
    }
}
