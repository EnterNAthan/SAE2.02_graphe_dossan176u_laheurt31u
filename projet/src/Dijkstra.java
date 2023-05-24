import java.util.ArrayList;


/**
 * Entrees :
 * G un graphe oriente avec une ponderation (poids) positive des arcs
 * A un sommet (depart) de G
 * <p>
 * Debut
 * Q <- {} // utilisation d’une liste de noeuds a traiter
 * Pour chaque sommet v de G faire
 * v.distance <- Infini
 * v.parent <- Ind´efini
 * Q <- Q U {v} // ajouter le sommet v `a la liste Q
 * Fin Pour
 * A.distance <- 0
 * Tant que Q est un ensemble non vide faire
 * u <- un sommet de Q telle que u.distance est minimale
 * Q <- Q \ {u} // enlever le sommet u de la liste Q
 * Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
 * D <- u.distance + poids(u,v)
 * Si D < v.distance
 * Alors v.distance <- D
 * v.parent <- u
 * Fin Si
 * Fin Pour
 * Fin Tant que
 * Fin
 */
public class Dijkstra {
    public static Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();

        ArrayList<Noeud> ln = new ArrayList<Noeud>();
        for (String s : g.listeNoeuds()) {
            Noeud n = new Noeud(s);
            v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
            ln.add(n);
        }
        v.setValeur(depart, 0);
        while (ln.size() != 0) {
            Noeud u = ln.get(0);
            for (Noeud n : ln) {
                if (v.getValeur(n.getNom()) < v.getValeur(u.getNom())) {
                    u = n;
                }
            }
            ln.remove(u);
            for (Arc a : g.suivants(u.getNom())) {
                double Doub = v.getValeur(u.getNom()) + a.getCout();
                if (Doub < v.getValeur(a.getDest())) {
                    v.setValeur(a.getDest(), Doub);
                    v.setParent(a.getDest(), u.getNom());
                }
            }
        }
        return v;
    }
}
