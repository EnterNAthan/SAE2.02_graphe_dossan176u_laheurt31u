import java.util.ArrayList;
import java.util.List;


/**
 * Entrees :
 * G un graphe oriente avec une ponderation (poids) positive des arcs
 * A un sommet (depart) de G
 *
 * Debut
 *  Q <- {} // utilisation d’une liste de noeuds a traiter
 *  Pour chaque sommet v de G faire
 *      v.distance <- Infini
 *      v.parent <- Ind´efini
 *      Q <- Q U {v} // ajouter le sommet v `a la liste Q
 *  Fin Pour
 *  A.distance <- 0
 *  Tant que Q est un ensemble non vide faire
 *      u <- un sommet de Q telle que u.distance est minimale
 *      Q <- Q \ {u} // enlever le sommet u de la liste Q
 *      Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
 *          D <- u.distance + poids(u,v)
 *          Si D < v.distance
 *              Alors v.distance <- D
 *              v.parent <- u
 *          Fin Si
 *      Fin Pour
 *     Fin Tant que
 * Fin
 */
public class Dijkstra {
    public static Valeur resoudre(Graphe g, String depart){
        Valeur v = new Valeur();
        ArrayList<Noeud> Q = new ArrayList<Noeud>();
        for (String s : g.listeNoeuds()) {
            Noeud n = new Noeud(s);
            v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
            Q.add(n);
        }
        v.setValeur(depart, 0);
        while (Q.size() != 0){
            Noeud u = Q.get(0);
            for (Noeud n : Q) {
                if (v.getValeur(n.getNom()) < v.getValeur(u.getNom())) {
                    u = n;
                }
            }
            Q.remove(u);
            for (Arc a : g.suivants(u.getNom())) {
                double D = v.getValeur(u.getNom()) + a.getCout();
                if (D < v.getValeur(a.getDest())) {
                    v.setValeur(a.getDest(), D);
                    v.setParent(a.getDest(), u.getNom());
                }
            }
        }
        return v;
    }
}
