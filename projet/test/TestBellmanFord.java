
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBellmanFord {
    @Test
    public void TestBellmanFord() throws Exception {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("E", "D", 43);
        gl.ajouterArc("B", "E", 11);
        Valeur v = BellmanFord.resoudre(gl,"A");
        assertEquals("A ->  V:0.0 p:null\nB ->  V:12.0 p:A\nC ->  V:76.0 p:D\nD ->  V:66.0 p:E\nE ->  V:23.0 p:B\n", v.toString());
    }
}
