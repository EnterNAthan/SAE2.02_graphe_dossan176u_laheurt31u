import java.util.ArrayList;
import java.util.List;

public class GrapheLabyrinthe implements Graphe {
    private Labyrinthe laby;

    public GrapheLabyrinthe(Labyrinthe l) {
        this.laby = l;
    }

    public List<String> listeNoeuds() {
        ArrayList<String> l = new ArrayList<String>();
        boolean [][] murs = this.laby.getMurs();
        for (int i = 0;i<murs.length;i++){
            for (int j = 0;j<murs[i].length;j++){
                if (!murs[i][j]){
                    l.add("("+i+", "+j+")");
                }
            }
        }
        return l;
    }

    public List<Arc> suivants(String n) {
            ArrayList<Arc> l = new ArrayList<Arc>();
            boolean[][] murs = this.laby.getMurs();
            for (int i = 0; i < murs.length; i++) {
                for (int j = 0; j < murs[i].length; j++) {
                    if (n.equals("(" + i + ", " + j + ")") && !murs[i][j]) {
                        try {
                            ajouterArc(i, j, l, murs);
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                    }
                }
        }
        return l;
    }

    public void ajouterArc(int i, int j, ArrayList<Arc> l, boolean[][] murs) throws Exception {
        int[] coor = Labyrinthe.getSuivant(i, j, Labyrinthe.HAUT);
        TESTACTION(i, l, murs, coor);
        coor = Labyrinthe.getSuivant(i, j, Labyrinthe.BAS);
        TESTACTION(i, l, murs, coor);
        coor = Labyrinthe.getSuivant(i, j, Labyrinthe.GAUCHE);
        TESTACTION(i, l, murs, coor);
        coor = Labyrinthe.getSuivant(i, j, Labyrinthe.DROITE);
        TESTACTION(i, l, murs, coor);
    }

    private void TESTACTION(int i, ArrayList<Arc> l, boolean[][] murs, int[] coor) throws Exception {
        if (coor[0] >= 0 && coor[0] < murs.length && coor[1] >= 0 && coor[1] < murs[i].length
                && !murs[coor[0]][coor[1]]) {
            l.add(new Arc("(" + coor[0] + ", " + coor[1] + ")", 0));
        }
    }

    public static void main(String[] args) throws Exception {
        GrapheLabyrinthe gl = new GrapheLabyrinthe(new Labyrinthe("labySimple/laby0.txt"));
        List<String> ls= gl.listeNoeuds();
        List<Arc> la = gl.suivants("(2, 2)");
        for (String s : ls){
            System.out.println(s);
        }
        for (Arc a : la) {
            System.out.println(a);
        }

    }
}
