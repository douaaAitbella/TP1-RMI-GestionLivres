import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class LivreImpl extends UnicastRemoteObject implements LivreInterface {

    private List<Livre> bibliotheque;

    protected LivreImpl() throws RemoteException {
        super();
        bibliotheque = new ArrayList<Livre>();
        bibliotheque.add(new Livre(1, "Le Petit Prince", "Saint-Exupery", 45.0));
        bibliotheque.add(new Livre(2, "1984", "George Orwell", 60.0));
        bibliotheque.add(new Livre(3, "L'Etranger", "Albert Camus", 50.0));
    }

    @Override
    public String ajouterLivre(Livre livre) throws RemoteException {
        for (int i = 0; i < bibliotheque.size(); i++) {
            if (bibliotheque.get(i).getId() == livre.getId()) {
                return "Erreur : un livre avec cet ID existe deja.";
            }
        }
        bibliotheque.add(livre);
        return "Livre ajoute avec succes.";
    }

    @Override
    public List<Livre> rechercherLivre(String critere) throws RemoteException {
        List<Livre> resultats = new ArrayList<Livre>();
        for (int i = 0; i < bibliotheque.size(); i++) {
            Livre l = bibliotheque.get(i);
            if (l.getTitre().toLowerCase().contains(critere.toLowerCase())
                    || l.getAuteur().toLowerCase().contains(critere.toLowerCase())) {
                resultats.add(l);
            }
        }
        return resultats;
    }

    @Override
    public List<Livre> listerTousLesLivres() throws RemoteException {
        return bibliotheque;
    }
}