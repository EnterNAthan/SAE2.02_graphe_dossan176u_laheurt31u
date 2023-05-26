import java.util.List;

/**
 * The interface Graphe.
 */
public interface Graphe {
    /**
     * Liste noeuds list.
     *
     * @return the list
     */
    public List<String> listeNoeuds();


    /**
     * Suivants list.
     *
     * @param n the n
     * @return the list
     */
    public List<Arc> suivants(String n);


}
