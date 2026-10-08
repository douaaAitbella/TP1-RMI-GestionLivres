import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LivreInterface extends Remote {

    String ajouterLivre(Livre livre) throws RemoteException;

    List<Livre> rechercherLivre(String critere) throws RemoteException;

    List<Livre> listerTousLesLivres() throws RemoteException;
}