
public class NQueen{
   
   private int[][] position; //containing x,y-coordinates for each position
   private int n; //number of queens to be placed
   private int curQueen;

   /*CONSTRUCTOR*/
   public NQueen(int n){
      this.n = n;
      position=new int[n][2];
      putQueens(0, 0, 0); //first putting the 0th queen on position 0, 0
   }
   
   /*METHOD TO HANDLE PLACEMENT*/
   private void putQueens(int x, int y, int queen){
      /*UPDATING LOCATION OF QUEEN*/
      position[queen][0]=x;
      position[queen][1]=y;
      queen++;
      curQueen = queen;
      check(0, y+1, queen);
   }
   /*CHECKS WETHER POSITION IS VALID*/
   private void check(int x, int y, int queen){
      int[] result = isSafe(x, y, true); //returns coordinates if no contradictions else -1
      if (queen==n) //BASE CASE
         return; 
      /*RECURSIVE CALL TO UPDATE PLACEMENT*/
      if (result[0]>-1){ 
         x = result[0];
         y = result[1];
         putQueens(x, y, queen);
      } else { /*IN CASE QUEEN COULD NOT BE PLACED IN ROW--BACKTRACKING*/
         int prevQueen = queen - 1;
         curQueen = prevQueen;
         int prevX = position[prevQueen][0];
         int prevY = position[prevQueen][1];
         check(prevX+1, prevY, prevQueen); //Setting x coordinate one further and repeating process
      }
   }
   private int[] isSafe(int x, int y, boolean safe){
      int[] checked;
      /*IF X IS BEYOND BOUNDRY*/
      if (x >= n){
         checked = {-1, -1};
         return checked;
      } else {
         /*PERFORM CHECK FOR CONTRADICTIONS WITH EACH SET QUEEN*/
         for (int i=0; i < curQueen; i++){
            int posX = position[i][0];
            int posY = position[i][1];
            //compares if x positions intersect -- second comparison retruns true if positions contradict diagonaly
            if (x==posX || Math.abs(y-posY)==Math.abs(x-posX)){
               return isSafe(x + 1, y, true); //tries again with incremented x coordinate
            }
         }
      }
      /*CHECK WENT FRICTIONLESS*/
      checked = {x, y};
      return checked;
   }
   /*OPTIONAL METHOD--RETURNS NEXT POSSIBLE OUTCOME*/
   public void next(){
      /*INCREMENT LAST X COORDINATE BY ONE AND PERFOMRE EXECUTION AGIAN*/
      int x = position[n-1][0]+1;
      int y = position[n-1][1];
      curQueen--;
      check(x, y, n-1);
   }
   public String getN(){
      return String.format("%d", n);
   }
   /*RETURNS VALID POSITIONS AS STRING*/
   public String getPosition(){
      String result=n+" Queens:\nx   y\n";
      for (int i=0; i < position.length; i++){
         result+=Integer.toString(position[i][0])+" | "+Integer.toString(position[i][1])+"\n";
      }
      return result;
   }
}
