public class Arc {
    /**
     * Attributs
     **/
    private String dest;

    private double cout;


    /**
     * Constructeur qui récupere le noeud et son cout
     **/

    public Arc(String n, double c) throws Exception{
        this.dest = n;
        if (cout >= 0) {
            this.cout = c;
        }
        else throw new Exception("cout négatif");
    }
}

