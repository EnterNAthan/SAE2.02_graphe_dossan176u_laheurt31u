
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * The type Graphe liste.
 */
public class GrapheListe implements Graphe {
    /**
     * The Ens noeuds.
     */
    List<Noeud> ensNoeuds;

    /**
     * The Ens nom.
     */
    List<String> ensNom;


    /**
     * Instantiates a new Graphe liste.
     *
     * @return
     */
    public GrapheListe(){
        this.ensNoeuds = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();
    }


    /**
     * Instantiates a new Graphe liste.
     *
     * @param f the f
     * @throws Exception the exception
     */
    public GrapheListe(String f) throws Exception {
        this.ensNoeuds = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();
        String ligne;
        String tab[];
        BufferedReader fichier = new BufferedReader(new FileReader(f));
        ligne = fichier.readLine();
        while (ligne!=null){
            tab = ligne.split("\t");
            this.ajouterArc(tab[0],tab[1],Double.parseDouble(tab[2]));
            ligne = fichier.readLine();
        }

    }

    /**
     * Instantiates a new Graphe liste.
     *
     * @param taille  the taille
     * @param debut   the debut
     * @param arrivee the arrivee
     * @throws Exception the exception
     */
    public GrapheListe(int taille, int debut, int arrivee) throws Exception {
        this.ensNoeuds = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();

        this.genererGraphe(taille, debut, arrivee);
    }

    @Override
    public List<String> listeNoeuds() {
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


    /**
     * Ajouter arc.
     *
     * @param depart      the depart
     * @param destination the destination
     * @param cout        the cout
     * @throws Exception the exception
     */
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

    /**
     * Ajouter arc lab.
     *
     * @param depart      the depart
     * @param destination the destination
     */
    public void ajouterArcLab(String depart, String destination) {
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
                noeud.ajouterArcLab(destination);
            }
        }
    }

    /**
     * Timer algo string.
     *
     * @return the string
     */
    public String timerAlgo(){
        Valeur v1, v2;
        long start1, start2, end1, end2, temps1, temps2;
        start1 = System.nanoTime();
        v1 = BellmanFord.resoudre(this, "1");
        end1 = System.nanoTime();
        temps1 = end1 - start1;

        start2 = System.nanoTime();
        v2 = Dijkstra.resoudre(this, "1");
        end2 = System.nanoTime();
        temps2 = end2 - start2;
        return (temps1 + ";" + temps2 + "\n");
    }

    /**
     * To graph viz string.
     *
     * @return the string
     */
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


    /**
     * ecrireFichier methode
     * Write a graph in a file by a matrice of elements
     * @param file String Name of the file of the matrice
     * @throws IOException
     */
    public static void ecrireFichier(String file) throws IOException {

        //test sur le fichier
        if (file == null) {
            throw new FileNotFoundException("Il n'y a pas de Fichier");
        }

        //lecture du fichier pour recuperer les caracteres
        BufferedReader f = new BufferedReader(new FileReader(file));

        //création du fichier  d'ecriture
        BufferedWriter fichier = new BufferedWriter(new FileWriter(""));

        //lecture de la première ligne du fichier
        String ligne = f.readLine();
        String[] tabLigne = ligne.split("\t");

        ligne = f.readLine();

        fichier.write("digraph G {\n");

        while (ligne != null) {

            //création de colonnes sur la 2e ligne du fichier
            String[] colonne = ligne.split("\t");

            //création du fichier contenant une liste d'arc
            for (int i = 1; i < colonne.length; i++) {
                //ajoute seulement les éléments ayant un arc entre (0. = cout nul -> pas d'arc)
                if (!colonne[i].equals("0."))
                    //ajout des éléments au fichier
                    fichier.write(colonne[0] + " -> " + tabLigne[i] + " [label = " + colonne[i] + "]");
                fichier.newLine();
            }
            ligne = f.readLine();
        }
        //fin du fichier
        fichier.write("}");

        //fermeture des 2 fichiers
        f.close();
        fichier.close();
    }

    /**
     * Gets ens noeuds.
     *
     * @return the ens noeuds
     */
    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }

    /**
     * genererGraphe methode
     * Build a random graph
     *
     * @param taille  int Size of the node's list
     * @param depart  int Name of the first node
     * @param arrivee int Name of the last node
     * @throws Exception throw Exception if one of the number is equal to 0
     */
    public void genererGraphe(int taille, int depart, int arrivee) throws Exception {

        //teste si les paramètres sont négatifs
        if (taille <= 1 || depart <= 0 || arrivee <= 0 || depart == arrivee || depart > arrivee || taille > arrivee)
            throw new Exception("Les paramètes passés sont incorrects");

        //crée un tableau qui contiendra les noeuds
        int[] noeuds = new int[taille];
        //creation variables random (qui generera nombres aléatoires)
        //                   arc (qui generera des arcs de taille aléatoire)
        int random;
        int arc;
        //attribue la valeur de depart en tant que premier noeud
        noeuds[0] = depart;
        this.ensNom.add(valueOf(noeuds[0]));
        this.ensNoeuds.add(new Noeud(valueOf(noeuds[0])));
        //attribue la valeur d'arrivee en tant que dernier noeud
        noeuds[taille - 1] = arrivee;

        if (taille > 2) {

            //ajoute les noeuds dans l'attribut ensNoeud
            for (int i = 1; i < taille; i++) {

                if (i + 1 != arrivee) {
                    noeuds[i] = i + depart;
                    this.ensNom.add(valueOf(noeuds[i]));
                    this.ensNoeuds.add(new Noeud(valueOf(noeuds[i])));
                } else {
                    this.ensNom.add(valueOf(noeuds[i]));
                    this.ensNoeuds.add(new Noeud(valueOf(noeuds[i])));
                }
            }

            // boucle sur le nombre de noeuds
            for (int i = 0; i < ensNoeuds.size(); i++) {
                // cree un nombre d'arcs aleatoire
                int nbArcs = (int) (Math.random() * taille);
                // boucle sur le nombre d'arcs
                for (int y = 0; y < nbArcs; y++) {

                    random = (int) (Math.random() * (taille - 1) + 1);
                    arc = (int) (Math.random() * 100);
                    // ajoute des arcs entre les noeuds
                    this.ajouterArc(ensNoeuds.get(i).getNom(), ensNoeuds.get(random).getNom(), arc);
                }
            }
        } else {

            this.ensNom.add(valueOf(arrivee));
            this.ensNoeuds.add(new Noeud(valueOf(arrivee)));

            arc = (int) (Math.random() * 100);

            this.ajouterArc(ensNoeuds.get(0).getNom(), ensNoeuds.get(1).getNom(), arc);
        }

    }
}
