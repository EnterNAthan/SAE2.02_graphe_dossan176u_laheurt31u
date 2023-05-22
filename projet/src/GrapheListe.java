
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
        return null;
    }

    /**
     * @param n
     * @return
     */
    public List<String> suivant(String n) {
        return null;
    }

    public void ajouterArc(String depart, String destination, double cout) throws Exception {
        if(!ensNom.contains(depart)){
            Noeud n = new Noeud(depart);
            Noeud n2 = new Noeud(destination);
            ensNom.add(depart);
            ensNoeuds.add(n);
            ensNoeuds.add(n2);
        }
        if(!ensNom.contains(destination)){
            Noeud n = new Noeud(depart);
            Noeud n2 = new Noeud(destination);
            ensNom.add(destination);
            ensNoeuds.add(n);
            ensNoeuds.add(n2);
        }
        for (Noeud noeud : ensNoeuds) {
            if(noeud.getNom().equals(depart)){
                noeud.ajouterArc(depart, cout);
            }
            else if(noeud.getNom().equals(destination)){
                noeud.ajouterArc(destination, cout);
            }
        }
    }

    public String toString(){
        StringBuffer st = new StringBuffer();
        for (Noeud noeud : ensNoeuds){
            st.append(noeud.toString()+"\n");
        }
        return st.toString();
    }
}
