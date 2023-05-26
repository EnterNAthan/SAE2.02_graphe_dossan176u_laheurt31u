/**
 * The type Main bellman ford.
 */
public class MainBellmanFord {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        GrapheListe gl = new GrapheListe("Graphes/Graphe_boucle.txt");
        Valeur v2 = BellmanFord.resoudre(gl,"A");
        System.out.println(v2);
        System.out.println(v2.calculerChemin("E"));
    }
}
