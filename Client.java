package AppHotel;

public class Client extends User {
	private String Adress;
        public static int idClient;
	private HashMap<Integer, Client> clients ;
	private HashMap<Integer,Reservation> inforeservation ;
	private HashMap<Integer,String> Commentaire ;
	public Client(String name, String lastName, String email, String password, String phonenumber, String Adress) {
		super(name, lastName, email, password, phonenumber);
		idClient++;
		this.Adress=Adress;
		clients = new HashMap<>();
	        inforeservation = new HashMap<>();
	        Commentaire = new HashMap<>();
           
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}
	public void saisirReservation(int anneed,int moisd,int jourd,int anneef,int moisf,int jourf, String typeChambre, int nombrePersonnes, String typePersonne) {
        // Utilisation d'un scanner pour saisir les informations
        Scanner scanner = new Scanner(System.in);

        // Saisie des informations de la réservation
        System.out.println("Entrez l'année de debut de la réservation  : ");
        anneed = scanner.nextInt();
        System.out.println("Entrez le mois de debut de la réservation  : ");
        moisd = scanner.nextInt();
        System.out.println("Entrez le jour de debut de la réservation  : ");
        jourd=scanner.nextInt();
        System.out.println("Entrez l'année de fin de la réservation  : ");
        anneef = scanner.nextInt();
        System.out.println("Entrez le mois de fin de la réservation  : ");
        moisf = scanner.nextInt();
        System.out.println("Entrez le jour de fin de la réservation  : ");
        jourf = scanner.nextInt();
        System.out.println("Entrez le type de chambre : ");
        typeChambre = scanner.nextLine();
        System.out.println("Entrez le nombre de personnes : ");
        nombrePersonnes = scanner.nextInt();
        scanner.nextLine(); // Ignorer la fin de la ligne
        System.out.println("Entrez le type de personne (adultes, enfants) : ");
        typePersonne = scanner.nextLine();
        
    }
	
    public void leaveComment(int idClient,String c) {
                Commentaire.put(idClient,c);
		System.out.println("le commentaire du client sur l'hotel est" + c);
    }
    public void getReservations(int idClient) {
                clients.get(idClient);
		inforeservation.get(idClient);
    }
}
