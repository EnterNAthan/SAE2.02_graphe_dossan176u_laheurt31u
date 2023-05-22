
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    List<Noeud> ensNoeuds;

    List<String> ensNom;
    /**
     * @return
     */

    public GrapheListe(){
        this.ensNoeuds = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();
    }


    @Override
    public List<String> listeNoeud() {
        return ensNom;
    }

    /**
     * @param n
     * @return
     */

    public List<Arc> suivants(String n) {
        for (Noeud noeud : ensNoeuds) {
            if(noeud.getNom().equals(n)){
                return noeud.getArcs();
                }
            }
        return null;
        }



    public void ajouterArc(String depart, String destination, double cout) throws Exception {
        if(!ensNom.contains(depart)){
            Noeud n = new Noeud(depart);
            ensNom.add(depart);
            ensNoeuds.add(n);
        }
        if(!ensNom.contains(destination)){
            Noeud n2 = new Noeud(destination);
            ensNom.add(destination);
            ensNoeuds.add(n2);
        }
        for (Noeud noeud : ensNoeuds) {
            if(noeud.getNom().equals(depart)){
                noeud.ajouterArc(destination, cout);
            }
        }
    }

    public String toGraphViz(){
        StringBuffer res = new StringBuffer("digraph G{\n");
        for (Noeud noeud : ensNoeuds){
            for (Arc a : noeud.getArcs()){
                res.append(noeud.getNom() + " -> "+a.getDest()+" [label = "+(int)(a.getCout())+"]\n");
            }
        }
        res.append("}");
        return res.toString();
    }

    public String toString(){
        StringBuffer st = new StringBuffer();
        for (Noeud noeud : ensNoeuds){
            st.append(noeud.toString()+"\n");
        }
        return st.toString();
    }
}
