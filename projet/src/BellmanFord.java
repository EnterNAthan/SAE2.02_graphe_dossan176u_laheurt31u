import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    public BellmanFord() {

    }

    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        List<String> listeNoeud = g.listeNoeud();
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
                for (int j = 0;i<g.suivants(listeNoeud.get(i)).size();i++){
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
