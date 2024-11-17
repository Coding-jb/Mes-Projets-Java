package tv;
/**
 * class for TvMain3
 */
public class TvMain3 {

   /**
    * Default contructor
    */
    public TvMain3(){}
   /**
    * Methode usage
    */
   public static void usage() {
      System.out.println("Usage : java TvMain3 <uneMarque>");
      System.out.println("  où  <uneMarque> correspond à la marque de la télé créée.");
      System.exit(0);
   }

   /**
    * Main method
    * @param args no param
    */
   public static void main(String[] args) {

      if (args.length < 1) {
         TvMain3.usage();
      }

      Tv tv1 = new Tv(args[0]);
      System.out.println(tv1.toString());
      System.out.println("--------------------------");
      tv1.on();
      tv1.changeChannel(7);
      tv1.volumeUp();
      System.out.println(tv1); // _tv1_ est remplacé par _tv1.toString()_ à la compilation

   }
}
