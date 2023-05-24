import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TempsAlgo {
    public static void main(String[] args) throws Exception {
        // setup
        File f = new File("Tableau_timers/tableau.xls");
        FileWriter monF = new FileWriter("Tableau_timers/tableau.xls");
        StringBuffer st = new StringBuffer();
        String lecture;
        GrapheListe gl;
        Valeur v1, v2;
        int ajout = 1;
        int unite = 1, dizaine = 0;
        long start1, start2, end1, end2, temps1, temps2;
        boolean fin = false;
        monF.write("time;BellmanFord;Dijkstra\n");

        while (!fin) {
            if (dizaine == 90 && unite == 5) fin = true;
            if (dizaine == 0) {
                lecture = "Graphes/Graphe" + unite + ".txt";
            } else
                lecture = "Graphes/Graphe" + dizaine + unite + ".txt";
            gl = new GrapheListe(lecture);
            start1 = System.nanoTime();
            v1 = BellmanFord.resoudre(gl, "1");
            end1 = System.nanoTime();
            temps1 = end1 - start1;

            start2 = System.nanoTime();
            v2 = Dijkstra.resoudre(gl, "1");
            end2 = System.nanoTime();
            temps2 = end2 - start2;

            monF.write(lecture + ";" + temps1 + ";" + temps2 + "\n");


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
