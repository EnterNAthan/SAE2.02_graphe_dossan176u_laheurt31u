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
        assertEquals("[A, B, C]", gl.listeNoeud().toString());
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
}
