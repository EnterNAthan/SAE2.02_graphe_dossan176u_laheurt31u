import java.util.ArrayList;
import java.util.List;

public class Noeud {

    /**
     * getter
     *
     * @return arcs
     */
    public List<Arc> getArcs() {
        return arcs;
    }
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
        this.arcs = new ArrayList<Arc>();
    }

    /**
     * verification d'égalité
     *
     * @param o : Object, donner un type Noeud pour verifier l'egalite
     * @return true si les deux objets sont des Noeuds avec un nom identique, false sinon
     */
    public boolean equals(Object o) {
        boolean res;
        if (o instanceof Noeud) {
            Noeud n = (Noeud) (o);
            res = n.nom.equals(this.nom);
        } else res = false;
        return res;
    }

    public void ajouterArc(String destination, double cout) throws Exception {
        Arc a = new Arc(destination, cout);
        arcs.add(a);
    }

    public void ajouterArcLab(String destination) {
        try {
            Arc a = new Arc(destination,0);
            arcs.add(a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String getNom() {
        return nom;
    }
    public String toString() {
        StringBuilder st = new StringBuilder(this.nom + " -> ");
        for (Arc a : arcs) {
            st.append(a.getDest()).append("(").append(a.getCout()).append(") ");
        }
        return st.toString();
    }
}