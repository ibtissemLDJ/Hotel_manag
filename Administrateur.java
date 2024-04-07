package AppHotel;

public class Administrateur extends User {
   private boolean active;
   private double salary;
  public Administrateur(String name, String lastName, String email, String password, String phonenumber,boolean active, double salary, String ID) {
	super(name, lastName, email, password, phonenumber, ID );
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
  

  public void verifierReservation(String ID ) {
    for (Map.Entry<String, HashMap<String, Date[]>> e: Main.reservations.entrySet()) {
  Map <String , Date []> map = new HashMap () ;
  map = e.getValue();
  if (map.containsKey(ID)) { //si hashmap contient ID du client
    Date [] tab = map.get(ID); //alors recuperer sa date de reservation 
    System.out.println("Vous avez une reservation du "+ tab[0]+ "au"+ tab[1]);
  }else {
    System.out.println("Vous n'avez pas de reservations");
  }
    } }
  
  public double calculateTotalPrice(Date deb , Date fin , String typeRoom) {
    double price = 0;
    int nbrJours = nbrDeNuits (deb , fin);
    if (typeRoom.equals ("single")) price = price1;
    else if (typeRoom.equals ("double")) price = price2;
    else if (typeRoom.equals ("triple")) price = price3;
    else if (typeRoom.equals ("suite")) price = price4;
    return price*nbrJours ;
  }
  
  public int checkAvailableRoomDate(String typeRoom , Date dateDebut , Date dateFin ) {//methode pour verifier la date chpisit par le client est disponible
    for (Entry<String, HashMap<String, Date[]>> e1: Main.reservations.entrySet()) {//parcourir la hashmap externe 
    if ( e1.getKey().startsWith(typeRoom)){ //si la cle commence par le type de la chambre demande
    String numRoom1 = (e1.getKey()).replaceAll("\\D", "");//
    int numRoom2 = Integer.parseInt(numRoom1);
      if (reservedRoom(typeRoom,numRoom2)== false) return numRoom2 ; //si la chambre nest reserver par personne retourner son numero directement
      else{//sinon verifier si la date est disponible
        Map <String , Date []> map = new HashMap () ; 
      map = e1.getValue();//mettre la hashmap interne dans une hashmap intermediere 
      boolean bool ;
      for (Entry<String,  Date[]> e2: map.entrySet()){
        //recuperer les dates en utilisant getValue
        Date [] tab = e2.getValue() ;
         bool = false ;
        if ((tab[0].month)==(dateDebut.month)) {
          if ((dateDebut.day) > (tab[0].day)) {//si la date du deb est > a la date du debut du tableau
            if((dateDebut.day) > (tab[1].day)) {//si la date du deb est > a la date du fin du tableau
              bool = true ;
            }
          } else if ((dateDebut.day) < (tab[0].day)) {//si la date du deb est < a la date de debut du tableau
            if ((dateFin.day) < (tab[0].day)){//si la date du fin est < a la date du debut du tableau
              bool = true ;
            }
          }
        }
          } if (bool = false) return 0 ;
          else return numRoom2;
      }
    }}
  }
  
  public void ajouterReservation(String ID ,String type, Date debut , Date fin) {
     int numRoom = checkAvailableRoomDate(type , debut , fin); //appel a la methode checkAvailableRoomDate
     if (!(numRoom == 0) ) { 
     String  numberRoom = String.valueOf(numRoom); //transformer le type de numero de la chambre en string
     String cle = type.concat(numberRoom); //former la cle en concatinant le type et le num de la chambre
    //ajouter la reservation 
     Date[] tab = { debut , fin }; //creer un tableau avec la date de resrvation
     Main.reservations.get(cle).put(ID, tab); //ajouter le tableau au hashmap 
     } else  //si num de la chambre =0 
     {
      System.out.println("Nous excusons, pas de chambres libres pour cette date"); 
     }
  }
  
  public void anullerReservation(String ID , int numRoom, String typeRoom){
    String  numberRoom = String.valueOf(numRoom);
    String cle = typeRoom.concat(numberRoom);
    if (Main.reservations.containsKey(cle)) {
    Main.reservations.get(cle).remove(ID);
    } 
    }
  
  public void modifierReservation(String ID , int numRoom, String typeRoom, Date nouvDateDeb , Date nouvDateFin) {
    String  numberRoom = String.valueOf(numRoom);
    String cle = typeRoom.concat(numberRoom);
    if (Main.reservations.containsKey(cle)) {
        //il faut verifier si la nouvelle date existe deja 
      HashMap<String , Date[]> map2 = new HashMap();
     map2=  Main.reservations.get(cle);
     Date [] tab2 ;
     for (Entry<String, Date[]> e3: map2.entrySet()) {
      tab2= e3.getValue();
     }
      Date [] tab = { nouvDateDeb , nouvDateFin} ;
      Main.reservations.get(cle).put(ID, tab);
    }
  }
  
  public void addRoom(Chambre chmbr) {
    if (Main.reservations.containsKey(chmbr.getNumber_chambre())) {//verifier si cette chambre existe deja avant de la creer
      System.out.println("Cette chambre existe deja !!");
    }
    else Main.chambres.put(chmbr.getNumber_chambre(), chmbr);
  }
  
  public void removeRoom(Chambre chmbr) {
    if (reservedRoom(chmbr.getType() , chmbr.getNumber_chambre()) == false)  {
  Main.chambres.remove(chmbr.getNumber_chambre());
  } 
  }
 
  public void addClient(Client clint) {
    if (Main.clients.containsKey(clint.getID())) {// verifier si le client existe deja 
      System.out.println("Ce client a deja une reservation !!");
    }
    else Main.clients.put(clint.getID(), clint);
  }
  
  public void removeClient (Client clint ) {
    Main.clients.remove(clint.getID());
  }
  
  public Client findClient(String ID) {
    Client client = Main.clients.get(ID);
    return client ;
  }
  
  public Chambre findRoom(int nbrRoom) {
    Chambre chmbr = Main.chambres.get(nbrRoom);
    return chmbr ;
  }
  
  public boolean reservedRoom (String type ,int numRoom) { //methode pour verifier si une chambre est deja reserve
    String  numberRoom = String.valueOf(numRoom);
    String cle = type.concat(numberRoom);
    HashMap <String , Date[]> map = new HashMap ();
  map = Main.reservations.get(cle);
  if(map.isEmpty()) return false ;
  else return true ;
  }
  
 
  


}
