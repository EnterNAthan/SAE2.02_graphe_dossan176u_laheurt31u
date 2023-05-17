import java.util.ArrayList;
import java.util.List;

public class Noeud {

    /**
     * attributs
     */
    private String nom;
    private List<Arc> arcs;

    /**
     * constructeur
     */
    public Noeud(String n) {
        this.nom = n;
        arcs = new ArrayList<Arc>();
    }

    /**
     * verification d'égalité
     * @param o : Object, donner un type Noeud pour verifier l'egalite
     * @return true si les deux objets sont des Noeuds avec un nom identique, false sinon
     */
    public boolean equals(Object o) {
        boolean res;
        if (o instanceof Noeud) {
            Noeud n = (Noeud) (o);
            if (n.nom.equals(this.nom)) res = true;
            else res = false;
        } else res = false;
        return res;
    }

    public void ajouterArc(String destination, double cout) throws Exception{
        Arc a = new Arc(destination,cout);
        arcs.add(a);
    }
}