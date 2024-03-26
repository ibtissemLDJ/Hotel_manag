package AppHotel;

public class Administrateur extends User {
   private boolean active;
   private double salary;
  public Administrateur(String name, String lastName, String email, String password, String phonenumber,boolean active, double salary) {
	super(name, lastName, email, password, phonenumber);
	this.active=active;
	this.salary=salary;
  }
  public boolean isActive() {
	return active;
  }
  public void setActive(boolean active) {
	this.active = active;
  }
  public double getSalary() {
	return salary;
  }
  public void setSalary(double salary) {
	this.salary = salary;
  }
  public void verifierReservation() {
  }
  public double calculateTotalPrice() {
  }
  public boolean checkAvailableDate() {
  }
  public boolean checkAvailableRoom() {
  }
  public void addRoom() {
  }
  public void removeRoom() {
  }
  public void addClient() {
  }
  public void removeClient() {
  }
  public Client findClient() {
  }
  public int findRoom() {
  }
}
