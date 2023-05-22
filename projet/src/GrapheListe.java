
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

    public GrapheListe(String f) throws FileNotFoundException {
        this.ensNoeuds = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();
        String ligne;

        BufferedReader fichier = new BufferedReader(new FileReader(f));
        ligne = fichier.readLine();
        while (ligne!=null){

        }

    }
    @Override
    public List<String> listeNoeud() {
        return ensNom;
    }

    /**
     * @param n
     * @return
     */
<<<<<<< HEAD
    public List<Arc> suivants(String n) throws Exception {
=======
    public List<Arc> suivants(String n) {
>>>>>>> 434745ec2708a93ff1097108758199d11a586590
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
