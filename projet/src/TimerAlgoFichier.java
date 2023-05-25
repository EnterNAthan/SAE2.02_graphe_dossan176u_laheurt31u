import java.io.File;
import java.io.FileWriter;

/**
 * la methode plante mais cela semble etre du a un depassement de la memoire que je ne sais pas regler.
 * cependant le tableau est assez rempli pour constater que Dijkstra est bien plus rapide dans tous les cas
 */
public class TimerAlgoFichier {
    public static void main(String[] args) throws Exception {
        // setup
        File f = new File("Tableau_timers/tableau.xls");
        FileWriter monF = new FileWriter("Tableau_timers/tableau.xls");
        String lecture;
        GrapheListe gl;
        int ajout = 1;
        int unite = 1, dizaine = 0;
        boolean fin = false;
        monF.write("time;BellmanFord;Dijkstra\n");

        while (!fin) {
            if (dizaine == 90 && unite == 4) fin = true;
            if (dizaine == 0) {
                lecture = "Graphes/Graphe" + unite + ".txt";
            } else
                lecture = "Graphes/Graphe" + dizaine + unite + ".txt";
            gl = new GrapheListe(lecture);

            monF.write(lecture +";"+ gl.timerAlgo());


            unite += 1;
            if (dizaine == 10)
                ajout = 10;

            if (unite == 5) {
                unite = 1;
                dizaine += ajout;
            }
        }
        monF.close();
        System.out.println("fin du remplissage");

    }



}
