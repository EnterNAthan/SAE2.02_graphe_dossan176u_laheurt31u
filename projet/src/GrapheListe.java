import java.util.List;

public class GrapheListe implements Graphe {

    List<String> ensNom;

    List<Noeud> ensNoeuds;


    /**
     * @return
     */
    @Override
    public List<String> listeNoeud() {
        return null;
    }

    /**
     * @param n
     * @return
     */
    @Override
    public List<String> suivant(String n){
        return null;
    }

    public void ajouterArc(String depart, String destination, double cout) throws Exception {
        Noeud n = new Noeud(depart);
        Noeud n2 = new Noeud(destination);
        Arc a = new Arc(n2.toString(),cout);
        n.ajouterArc(a.toString(), cout);
        ensNoeuds.add(n);
    }
}
