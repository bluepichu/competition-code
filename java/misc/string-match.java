public class string-match{
   public static void main(String[] args){
      System.out.println(Arrays.toString(match("abcabcacababcabcabcababcab", "abcab")));
   }
   
   public static int[] stringMatchAll(String toMatch, String target){
      int[] prefixes = new int[target.length()];
      
      int currentPos = 0;
      for(int i = 1; i < target.length; i++){
         if(target.charAt(currentPos) == target.charAt(i))[
            prefixes[i] = currentPos;
            currentPos++;
         } else {
            currentPos = 0;
         }
      }
      
      ArrayList<Integer> matches = new ArrayList<Integer>();
      
      int currentMatch = 0;
      for(int i = 0; i < toMatch.length; i++){
         if(toMatch.charAt(i) == target.charAt(currentMatch)){
            currentMatch++;
            if(currentMatch > target.length){
               matches.add(i+1-target.length());
               currentMatch = prefixes[currentMatch-1];
            }
         } else {
            currentMatch = prefixes[currentMatch];
         }
      }
   }
}