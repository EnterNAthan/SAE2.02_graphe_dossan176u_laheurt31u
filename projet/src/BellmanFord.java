import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Bellman ford.
 */
public class BellmanFord {

    /**
     * Instantiates a new Bellman ford.
     */
    public BellmanFord() {

    }

    /**
     * Resoudre valeur.
     *
     * @param g      the g
     * @param depart the depart
     * @return the valeur
     */
    public static Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        List<String> listeNoeud = g.listeNoeuds();
        for (String s : listeNoeud) {
            if (s.equals(depart)) v.setValeur(s, 0);
            else v.setValeur(s, Double.MAX_VALUE);
        }

        boolean pF = false;
        String noeudEtu;
        double valNoeudEtu;
        double nouvVal;


        while(!pF){
            pF = true;
            for (int i = 0; i<listeNoeud.size();i++){
                for (int j = 0;j<g.suivants(listeNoeud.get(i)).size();j++){
                    noeudEtu = g.suivants(listeNoeud.get(i)).get(j).getDest();
                    valNoeudEtu = v.getValeur(noeudEtu);
                    nouvVal = v.getValeur(listeNoeud.get(i))+g.suivants(listeNoeud.get(i)).get(j).getCout();
                    if (nouvVal<valNoeudEtu){
                        v.setValeur(g.suivants(listeNoeud.get(i)).get(j).getDest(),nouvVal);
                        v.setParent(noeudEtu,listeNoeud.get(i));
                        pF = false;
                    }
                }
            }
        }
        return v;
    }
}
