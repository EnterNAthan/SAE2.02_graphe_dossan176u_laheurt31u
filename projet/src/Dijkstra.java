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
    public static Valeur resoudre (Graphe g, String depart){
        Valeur v = new Valeur();
        List<String> l = g.listeNoeud();
        List<String> compare;
        boolean present;
        for (String s : l){
            if (s.equals(depart)) v.setValeur(s,0.);
            else v.setValeur(s,Double.MAX_VALUE);
            v.setParent(s,null);
        }
        String sMin;
        String tempMin;
        double min;
        while (l.size()!=0){
            min = Double.MAX_VALUE;
            for (String s : l){
                tempMin = v.getValeur(s);
                if (tempMin<min){
                    min = tempMin;
                    sMin = s;
                }
            }
            List<String> compare = g.listeNoeud();;
            for (String s: compare){
                present = false;
                for (int i = 0;i<compare.size();i++){
                    for (int j = 0;j<g.suivants(compare.get(i)).size();j++){
                        
                    }
                }
            }
        }
    }
}
