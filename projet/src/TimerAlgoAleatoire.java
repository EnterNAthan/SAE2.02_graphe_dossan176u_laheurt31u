import java.io.File;
import java.io.FileWriter;

public class TimerAlgoAleatoire {
    public static void main (String[] args) {
        try {
            File f = new File("Tableau_timers/Graphes_aleatoires.xls");
            FileWriter monF = new FileWriter("Tableau_timers/Graphes_aleatoires.xls");
            monF.write("Graphes;BellmanFord;Dijkstra\n");
            GrapheListe g1 = new GrapheListe();
            g1.genererGraphe(2,1,2);
            monF.write("Graphe a 2 noeud;"+g1.timerAlgo());
            GrapheListe g2 = new GrapheListe();
            g2.genererGraphe(10,1,10);
            monF.write("Graphe a 10 noeuds;"+g2.timerAlgo());
            GrapheListe g3 = new GrapheListe();
            g3.genererGraphe(100,1,100);
            monF.write("Graphe a 100 noeuds;"+g3.timerAlgo());
            GrapheListe g4 = new GrapheListe();
            g4.genererGraphe(150,1,150);
            monF.write("Graphe a 150 noeuds;"+g4.timerAlgo());
            monF.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
