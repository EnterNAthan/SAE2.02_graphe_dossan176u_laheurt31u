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

    public void ajouterArc(String destination, double cout) throws Exception {
        Arc a = new Arc(destination, cout);
        arcs.add(a);
    }

    public String getNom() {
        return nom;
    }
    public String toString() {
        StringBuffer st = new StringBuffer(this.nom + " -> ");
        Arc a;
        for (int i = 0; i < arcs.size(); i++) {
            a = arcs.get(i);
            st.append(a.getDest() + "("+a.getCout()+") ");
        }
<<<<<<< HEAD
        return st.toString();

=======
        return st.toString();   
>>>>>>> db46a349d107b2c948623c9a89cafc22a3f0ae91
    }
}