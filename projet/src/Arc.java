public class Arc {
    /**
     * Attributs
     **/
    private String dest;

    private double cout;


    /**getters
     *
     */
    public String getDest() {
        return this.dest;
    }

    public double getCout() {
        return this.cout;
    }

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

    public String toString(){
        return this.dest+", "+this.cout;
    }

}

