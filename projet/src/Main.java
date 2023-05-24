import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("E", "D", 43);
        gl.ajouterArc("B", "E", 11);
        System.out.println(BellmanFord.resoudre(gl,"A"));
        Valeur v = BellmanFord.resoudre(gl,"A");
        Valeur v2 = Dijkstra.resoudre(gl,"A");
        System.out.println(v2);
//        List<String> l = v.calculerChemin("C");
//        for (String s : l){
//            System.out.println(s);
//        }

    }
}
