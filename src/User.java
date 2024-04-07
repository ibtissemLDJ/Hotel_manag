package AppHotel;

public abstract class  User {
  private String name;
  private String lastName;
  private String email;
  private String password;
  private String phonenumber;
  private int ID =0;
  
  public User(String name, String lastName, String email, String password, String phonenumber) {
	this.name = name;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.phonenumber = phonenumber;
  }

  public String getID(){
    return ID;
  }
  public void setID(int iD) {
      ID = iD;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getLastName() {
	return lastName;
  }
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }
  public String getEmail() {
	return email;
  }
  public void setEmail(String email) {
	this.email = email;
  }
  public String getPassword() {
	return password;
  }
  public void setPassword(String password) {
	this.password = password;
  }
  public String getPhonenumber() {
	return phonenumber;
  }
  public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
  }
  public abstract User signUp( );
  public abstract User signIn() ;
	  
  
  public void recoverPasswordByEmail(String email) { 
  }
}
/*public void signUpClient(int id, String name, String lastName, String email, String password, String phonenumber,String Adress)Throws AlreadyExist {
  if (Main.Clients.containsKey(id)){
    trhow new AlreadyExist;
  }else {
    Client client = new Client(id,name,lastname,email,password,phonenumber,Adress);
    Main.Clients.put(id,client);
  }

  ***************************
  public void signUpAdmin(int id ,String name, String lastName, String email, String password, String phonenumber,boolean active, double salary)Throws AlreadyExist,NotAdmin{
    if (password.equals("3365990-85462344")){
     if (Main.Administrateurs.containsKey(id)){
     trhow new AlreadyExist;
      }else {
       Administrateur admin = new Administrateur(id,name,lastname,email,password,phonenumber,true, 3000000,00);
       Main.Administrateurs.put(id,admin)
      }
    }else{
    throw new NotAdmin;  
    }
  } 
*/
/**************************************************************/
/*public void signInClient(String email, String password) throws ForgetPassword, DoesntExist {
    Client client;
    boolean found = false;

    for (Map.Entry<Integer, Client> entry : Clients.entrySet()) {
        client = entry.getValue();
        if (client.getEmail().equals(email)) { 
            found = true;
            if (client.getPassword().equals(password)) { 
                System.out.println("Welcome back, " + client.getName()); 
                break;
            } else {
                throw new ForgetPassword(); 
            }
        }
    }

    if (!found) {
        throw new DoesntExist();
    }
}

****************************************************************************

public void signInAdmin(String email, String password) throws ForgetPassword, DoesntExist {
    Administrateur admin;
    boolean found = false;

    for (Map.Entry<Integer, Administrateur> entry : Administrateurs.entrySet()) {
        admin = entry.getValue();

        found = true;
            if (admin.getPassword().equals(password)) { 
                System.out.println("Welcome back, " + admin.getName()); 
                break;
            } else {
                throw new ForgetPassword(); 
            }
        }
    }

    if (!found) {
        throw new DoesntExist();
    }
}
*/
/*public int checkAvailableRoomDate(String typeRoom , Date dateDebut , Date dateFin ) {//methode pour verifier la date chpisit par le client est disponible
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
    } */


/*
 * import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.*;
import java.mail.internet.*;

public class EmailSender {

  
  
  public static void sendEmail(String recipientEmail, String newPassword) {
        // Configuration de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com"); // Remplacez par le serveur SMTP de votre fournisseur de messagerie
        props.put("mail.smtp.port", "587"); // Port SMTP par défaut

        // Informations d'authentification
        String username = "votre_adresse_email@example.com"; // Remplacez par votre adresse email
        String password = "votre_mot_de_passe"; // Remplacez par votre mot de passe

        // Création d'une session avec authentification
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Nouveau mot de passe");
            message.setText("Votre nouveau mot de passe est : " + newPassword);

            // Envoi du message
            Transport.send(message);

            System.out.println("Email envoyé avec succès !");
        } catch (MessagingException e) {
            System.err.println("Erreur lors de l'envoi de l'email : " + e.getMessage());
        }
    }

    public static void main1(String[] args) {
        // Utilisation de la méthode pour envoyer un email
        sendEmail("destinataire@example.com", "nouveau_mot_de_passe");
    }
}
}
 */


