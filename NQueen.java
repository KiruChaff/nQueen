package nqueen.java;

public class NQueen{

   private int[][] position;
   private int n;
   private int curQueen;

   public NQueen(int n){
      this.n = n;
      position=new int[n][2];
      putQueens(0, 0, 0);
   }
   private void putQueens(int x, int y, int queen){
      position[queen][0]=x;
      position[queen][1]=y;
      queen++;
      curQueen = queen;
      check(0, y+1, queen);
   }
   private void check(int x, int y, int queen){
      int[] result = isSafe(x, y, true);
      if (queen==n){
         return;
      } if (result[0]>-1){
         x = result[0];
         y = result[1];
         putQueens(x, y, queen);
      } else {
         int prevQueen = queen - 1;
         curQueen = prevQueen;
         int prevX = position[prevQueen][0];
         int prevY = position[prevQueen][1];
         check(prevX+1, prevY, prevQueen);
      }
   }
   private int[] isSafe(int x, int y, boolean safe){
      if (x >= n){
         int[] arr = {-1, -1};
         return arr;
      } else {
         for (int i=0; i < curQueen; i++){
            int posX = position[i][0];
            int posY = position[i][1];
            if (x==posX || Math.abs(y-posY)==Math.abs(x-posX)){
               return isSafe(x + 1, y, true);
            }
         }
      }
      int[] arr = {x, y};
      return arr;
   }
   public void next(){
      int x = position[n-1][0]+1;
      int y = position[n-1][1];
      curQueen--;
      check(x, y, n-1);
   }
   public String getN(){
      return String.format("%d", n);
   }
   public String getPosition(){
      String result=n+" Queens:\nx   y\n";
      for (int i=0; i < position.length; i++){
         result+=Integer.toString(position[i][0])+" | "+Integer.toString(position[i][1])+"\n";
      }
      return result;
   }
}
