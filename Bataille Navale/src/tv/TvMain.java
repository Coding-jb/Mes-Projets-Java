package tv;
/**
 * Main class for TvMain
 */
public class TvMain {

   /**
    * Default constructor for main mehod
    */
   public TvMain(){}
   /**
    * Main method
    * @param args no param
    */
   public static void main(String[] args) {

      Tv tv1 = new Tv("BelEcran");
      System.out.println(tv1.toString());
      System.out.println("--------------------------");
      tv1.on();
      tv1.changeChannel(7);
      tv1.volumeUp();
      System.out.println(tv1); // _tv1_ est remplacé par _tv1.toString()_ à la compilation

   }
}
