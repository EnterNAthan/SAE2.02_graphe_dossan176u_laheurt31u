import java.util.List;

public interface Graphe {
    public List<String> listeNoeud();

    public List<String> suivant(String n);
}
