import java.util.ArrayList;
import java.util.List;

/**
 * The type Noeud.
 */
public class Noeud {

    /**
     * getter
     *
     * @return arcs arcs
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
     *
     * @param n the n
     */
    public Noeud(String n) {
        this.nom = n;
        arcs = new ArrayList<Arc>();
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
            if (n.nom.equals(this.nom)) res = true;
            else res = false;
        } else res = false;
        return res;
    }

    /**
     * Ajouter arc.
     *
     * @param destination the destination
     * @param cout        the cout
     * @throws Exception the exception
     */
    public void ajouterArc(String destination, double cout) throws Exception {
        Arc a = new Arc(destination, cout);
        arcs.add(a);
    }

    /**
     * Ajouter arc lab.
     *
     * @param destination the destination
     */
    public void ajouterArcLab(String destination) {
        try {
            Arc a = new Arc(destination,0);
            arcs.add(a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    public String toString() {
        StringBuffer st = new StringBuffer(this.nom + " -> ");
        for (Arc a : arcs) {
            st.append(a.getDest() + "("+a.getCout()+") ");
        }
        return st.toString();
    }
}