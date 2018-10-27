
package Worker;

public class History extends Worker{
    
    
    private String status;
    private String date;

    public History() {
        super();
    }

    public History(String status, String date, String ID, String name, int age, double salary, String location) {
        super(ID, name, age, salary, location);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
