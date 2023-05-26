import java.util.List;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        /*GrapheListe gl = new GrapheListe("Graphes/Graphe_boucle.txt");
        Valeur v = BellmanFord.resoudre(gl,"A");
        Valeur v2 = Dijkstra.resoudre(gl,"A");
        System.out.println(v);
        System.out.println(v2);
        /**
         * 22) BellmanFord attribue les valeurs 20 au noeud B et 30 a G avant de les mettre a jour en parcourant le chemin depuis C
         * tandis que Dijkstra n'attribue jamais de valeur fausse pendant l'algoithme puisqu'il développe toujours l'arc au cout
         * le plus faible.
         *
         * Il semble que l'algorithme Dijkstra soit plus rapide que Bellman-Ford puisqu'il efectue toutes les actions du premier coup
         * sans boucler un grand nombre de fois. La complexite de Dijkstra semble aussi moins elevee a l'oeil.
         */
//        List<String> l = v.calculerChemin("C");
//        for (String s : l){
//            System.out.println(s);
//        }


        // Génération d'un graphe aléatoire avec le 3e constructeur
        GrapheListe g3 = new GrapheListe(10, 1, 10);

        System.out.println(g3.toGraphViz());

    }
}
