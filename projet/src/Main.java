public class Main {
    public static void main(String[] args) throws Exception {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("A", "B", 12);
        gl.ajouterArc("C", "A", 19);
        gl.ajouterArc("A", "D", 87);
        gl.ajouterArc("D", "B", 23);
        gl.ajouterArc("D", "C", 10);
        gl.ajouterArc("E", "D", 43);
        gl.ajouterArc("B", "E", 11);
        System.out.println(gl);
        System.out.println(gl.listeNoeud());
        System.out.println(gl.suivant("A"));
        System.out.println(gl.suivant("B"));
        System.out.println(gl.suivant("C"));
        System.out.println(gl.suivant("D"));
        System.out.println(gl.suivant("E"));
        System.out.println(gl.suivant("F"));
    }
}
