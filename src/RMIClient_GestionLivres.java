import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class RMIClient_GestionLivres {

    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Recherche de l'objet distant
            LivreInterface service = (LivreInterface) registry.lookup("GestionLivres");

            Scanner sc = new Scanner(System.in);
            int choix = 0;

            while (choix != 4) {
                System.out.println();
                System.out.println("--- Menu ---");
                System.out.println("1. Ajouter un livre");
                System.out.println("2. Rechercher un livre");
                System.out.println("3. Lister tous les livres");
                System.out.println("4. Quitter");
                System.out.print("Choisissez une option : ");

                choix = sc.nextInt();
                sc.nextLine();

                if (choix == 1) {
                    System.out.print("ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    System.out.print("Auteur : ");
                    String auteur = sc.nextLine();

                    System.out.print("Prix : ");
                    double prix = sc.nextDouble();
                    sc.nextLine();

                    Livre livre = new Livre(id, titre, auteur, prix);
                    String reponse = service.ajouterLivre(livre);
                    System.out.println(reponse);

                } else if (choix == 2) {
                    System.out.print("Entrez un titre ou un auteur : ");
                    String critere = sc.nextLine();

                    List<Livre> resultats = service.rechercherLivre(critere);
                    if (resultats.isEmpty()) {
                        System.out.println("Aucun livre trouve.");
                    } else {
                        for (int i = 0; i < resultats.size(); i++) {
                            System.out.println(resultats.get(i));
                        }
                    }

                } else if (choix == 3) {
                    List<Livre> livres = service.listerTousLesLivres();
                    System.out.println("Nombre de livres : " + livres.size());
                    for (int i = 0; i < livres.size(); i++) {
                        System.out.println(livres.get(i));
                    }

                } else if (choix == 4) {
                    System.out.println("Au revoir.");
                } else {
                    System.out.println("Option invalide.");
                }
            }

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}