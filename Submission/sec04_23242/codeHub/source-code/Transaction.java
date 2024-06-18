import java.sql.Date;


class Transaction{
private int id;
private String description;
private double amount;
private Date date;

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public double getAmount() {
    return amount;
}
public void setAmount(double amount) {
    this.amount = amount;
}
public Date getDate() {
    return date;
}
public void setDate(Date date) {
    this.date = date;
}


}