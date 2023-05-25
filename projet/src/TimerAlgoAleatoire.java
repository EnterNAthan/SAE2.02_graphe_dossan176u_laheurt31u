import java.io.File;
import java.io.FileWriter;

public class TimerAlgoAleatoire {
    public static void main (String[] args) {
        try {
            File f = new File("Tableau_timers/Graphes_aleatoires");
            FileWriter monF = new FileWriter("Tableau_timers/Graphes_aleatoires");
            GrapheListe g2 = new GrapheListe();
            g2.genererGraphe(2,1,2);
            System.out.println(g2.toString());
            System.out.println(g2.timerAlgo());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
