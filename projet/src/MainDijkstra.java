public class MainDijkstra {
    public static void main(String[] args) throws Exception {
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        Valeur v2 = Dijkstra.resoudre(gl,"A");
        System.out.println(v2);
        System.out.println(v2.calculerChemin("E"));
    }
}
