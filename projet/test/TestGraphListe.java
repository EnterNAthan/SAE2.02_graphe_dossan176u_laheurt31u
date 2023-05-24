import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestGraphListe {
// créer des test pour les méthodes de la classe GrapheListe en junit

    @Test
    public void toGraphViz() throws Exception {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("E", "D", 43);
        gl.ajouterArc("B", "E", 11);
        assertEquals("digraph G{\n" +
                "A -> B [label = 12]\n" +
                "A -> D [label = 87]\n" +
                "B -> E [label = 11]\n" +
                "C -> A [label = 19]\n" +
                "D -> B [label = 23]\n" +
                "D -> C [label = 10]\n" +
                "E -> D [label = 43]\n" +
                "}", gl.toGraphViz());
    }

    @Test
    public void TestListe() throws Exception {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("C", "A", 19);
        assertEquals("[A, B, C]", gl.listeNoeuds().toString());
    }

    @Test
    public void testSuivants()throws Exception{
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("E", "D", 43);
        gl.ajouterArc("B", "E", 11);
        List<Arc> arcs = new ArrayList<Arc>();
        arcs.add(new Arc("B", 12));
        arcs.add(new Arc("D", 87));
        assertEquals(arcs.toString(), gl.suivants("A").toString());
    }

    @Test
    public void TestConstructeur() throws Exception {
        GrapheListe gl = new GrapheListe("Graphes/Graphe1.txt");
        assertEquals("digraph G{\n" +
                "1 -> 2 [label = 4]\n" +
                "1 -> 4 [label = 15]\n" +
                "2 -> 1 [label = 1]\n" +
                "2 -> 3 [label = 9]\n" +
                "2 -> 4 [label = 12]\n" +
                "2 -> 5 [label = 8]\n" +
                "4 -> 1 [label = 7]\n" +
                "4 -> 2 [label = 17]\n" +
                "4 -> 3 [label = 4]\n" +
                "4 -> 5 [label = 11]\n" +
                "4 -> 7 [label = 5]\n" +
                "3 -> 1 [label = 8]\n" +
                "3 -> 2 [label = 20]\n" +
                "3 -> 4 [label = 36]\n" +
                "3 -> 7 [label = 19]\n" +
                "3 -> 8 [label = 8]\n" +
                "3 -> 9 [label = 3]\n" +
                "3 -> 10 [label = 11]\n" +
                "5 -> 4 [label = 16]\n" +
                "5 -> 6 [label = 13]\n" +
                "5 -> 7 [label = 10]\n" +
                "5 -> 10 [label = 9]\n" +
                "7 -> 6 [label = 16]\n" +
                "7 -> 8 [label = 11]\n" +
                "7 -> 9 [label = 5]\n" +
                "8 -> 5 [label = 12]\n" +
                "8 -> 7 [label = 20]\n" +
                "8 -> 9 [label = 18]\n" +
                "9 -> 3 [label = 13]\n" +
                "9 -> 5 [label = 3]\n" +
                "9 -> 6 [label = 8]\n" +
                "9 -> 8 [label = 2]\n" +
                "9 -> 10 [label = 11]\n" +
                "10 -> 9 [label = 18]\n" +
                "6 -> 2 [label = 18]\n" +
                "6 -> 5 [label = 2]\n" +
                "6 -> 7 [label = 24]\n" +
                "6 -> 8 [label = 10]\n" +
                "6 -> 10 [label = 1]\n" +
                "}", gl.toGraphViz());
    }
}
