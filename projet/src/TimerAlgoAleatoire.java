public class TimerAlgoAleatoire {
    public static void main (String[] args) {
        try {

            GrapheListe g2 = new GrapheListe();
            g2.genererGraphe(2,2,2);
            System.out.println(g2.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
