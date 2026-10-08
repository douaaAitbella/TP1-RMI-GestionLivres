import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer_GestionLivres {

    public static void main(String[] args) {
        try {
            // Creation de l'objet distant
            LivreImpl service = new LivreImpl();

            // Creation du registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Enregistrement de l'objet distant
            registry.rebind("GestionLivres", service);

            System.out.println("RMI Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}