package AppHotel;

public class Client extends User {
	private String Adress;

	public Client(String name, String lastName, String email, String password, String phonenumber, String Adress) {
		super(name, lastName, email, password, phonenumber);
		this.Adress=Adress;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}
	public void ajouterreservtn() {
	}
	public void annulerReservation() {
	}
	public void modifyReservation() {
	}
	public void leaveComment() {
    }
	public void changeParameterIfTypo() {
    }
	public void getReservations() {
	}
}
