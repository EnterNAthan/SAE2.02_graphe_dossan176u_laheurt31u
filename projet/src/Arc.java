/**
 * The type Arc.
 */
public class Arc {
    /**
     * Attributs
     **/
    private String dest;

    private double cout;


    /**
     * getters
     *
     * @return the dest
     */
    public String getDest() {
        return this.dest;
    }

    /**
     * Gets cout.
     *
     * @return the cout
     */
    public double getCout() {
        return this.cout;
    }

    /**
     * Constructeur qui récupere le noeud et son cout
     *
     * @param n the n
     * @param c the c
     * @throws Exception the exception
     */
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

