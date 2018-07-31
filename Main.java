package nqueen.java;

public class Main{
   public static void main(String[] args) {
      NQueen queenObj = new NQueen(8);
      System.out.println(queenObj.getPosition());
      queenObj.next();
      System.out.println("Next Placement: ");
      System.out.println(queenObj.getPosition());
   }
}
