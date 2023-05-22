
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
    public List<Arc> suivant(String n) throws Exception {
        for (Noeud noeud : ensNoeuds) {
            if(noeud.getNom().equals(n)){
                return noeud.getArcs();
                }
            }
        throw new Exception ("le noeud n'est pas dans le graphe");
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

    public String toString(){
        StringBuffer st = new StringBuffer();
        for (Noeud noeud : ensNoeuds){
            st.append(noeud.toString()+"\n");
        }
        return st.toString();
    }
}
