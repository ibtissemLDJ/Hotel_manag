package AppHotel;

import java.util.HashMap;

public class main {
	static HashMap <String, Administrateur> administrateurs = new hashMap<>();
	static HashMap<String, Client> clients = new HashMap<>();
	static HashMap<Integer, Chambre> chambres = new HashMap<>();
	static HashMap<String, HashMap<String, Date[]>> reservations = new HashMap<>();
 
	public static void main(String[] args) {
		System.out.println(" vous ete admin ou user ?");
		Scanner s = new Scanner (System.in);
        String type = s.nextLine();

	

		if(type.equals("admin")){
		   System.out.println("signup or login");
		   String var = s.nextLine();
		   if (var.equals("signup")){
			System.out.println("nom");
	String nom = s.nextLine();
	System.out.println("prenom");
	String prenom = s.nextLine();
	System.out.println("email");
	String email = s.nextLine();
	System.out.println("mot de passe");
	String mdp = s.nextLine();
	System.out.println("num de tele");
	String num = s.nextInt();
          Administrateur.signUpAdmin( ,prenom , nom , email , mdp , num , );
		   }


		}

	}




	}

}
