/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0073;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author JD
 */
public class Expense {
    String date;
    double amount;
    String content;
    int ID;
    static final AtomicInteger count = new AtomicInteger(0);

    public Expense(String date, double amount, String content) {
        this.date = date;
        this.amount = amount;
        this.content = content;
        this.ID= count.incrementAndGet();
    }
    
    public void displayInfo(){
        SimpleDateFormat sfd1 = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
        
        Date dateFomart = null;
        try{
            dateFomart = sfd1.parse(date);
        }catch(Exception e){
            System.out.println("Parse date is fail");
        }
        
        System.out.format(ID +" \t " +sdf2.format(dateFomart)+" \t "+amount+" \t    "+content);
    }
    
    
}
