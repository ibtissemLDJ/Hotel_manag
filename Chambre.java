package AppHotel;

public class Chambre {
  private int number_chambre;
  private String type;
  private String telephone_chambre;
  private boolean isEmpty;
  private double prix_chambre;
  private int number_etage;

 public Chambre(int number_chambre, String type, String telephone_chambre, boolean isEmpty, double prix_chambre,
		int number_etage) {
	this.number_chambre = number_chambre;
	this.type = type;
	this.telephone_chambre = telephone_chambre;
	this.isEmpty = isEmpty;
	this.prix_chambre = prix_chambre;
	this.number_etage = number_etage;
 }
 public int getNumber_chambre() {
	return number_chambre;
 }
 public void setNumber_chambre(int number_chambre) {
	this.number_chambre = number_chambre;
 }
 public String getType() {
	return type;
 }
 public void setType(String type) {
	this.type = type;
 }
 public String getTelephone_chambre() {
	return telephone_chambre;
 }
 public void setTelephone_chambre(String telephone_chambre) {
	this.telephone_chambre = telephone_chambre;
 }
 public boolean isEmpty() {
	return isEmpty;
 }
 public void setEmpty(boolean isEmpty) {
	this.isEmpty = isEmpty;
 }
 public double getPrix_chambre() {
	return prix_chambre;
 }
 public void setPrix_chambre(double prix_chambre) {
	this.prix_chambre = prix_chambre;
 }
 public int getNumber_etage() {
    return number_etage;
 }
 public void setNumber_etage(int number_etage) {
   this.number_etage = number_etage;
 } 
}
