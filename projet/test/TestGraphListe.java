import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestGraphListe {
// créer des test pour les méthodes de la classe GrapheListe en junit

    @Test
    public void TestGraphl(){
        GrapheListe gl = new GrapheListe();
        assertEquals(gl.t,null);
    }
}
