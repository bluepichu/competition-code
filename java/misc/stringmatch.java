// An implementation of the Knuth-Morris-Pratt algorithm
// Finds the indices of the first character of all instances of target in toMatch

// Complexity: O(n)
//   n is the length of toMatch

// Arguments:
//   String toMatch - the string in which to search for instances of target
//   String target  - the string for which to search in toMatch

// Returns:
//   Integer[]      - the indices of the first characters for all instances of target in toMatch
public static Integer[] stringMatchAll(String toMatch, String target){
   int[] prefixes = new int[target.length()];
   
   int currentPos = 0;
   for(int i = 1; i < target.length(); i++){
      if(target.charAt(currentPos) == target.charAt(i)){
         currentPos++;
         prefixes[i] = currentPos;
      } else {
         currentPos = 0;
      }
   }
   
   ArrayList<Integer> matches = new ArrayList<Integer>();
   
   int currentMatch = 0;
   for(int i = 0; i < toMatch.length(); i++){
      if(toMatch.charAt(i) == target.charAt(currentMatch)){
         currentMatch++;
         if(currentMatch == target.length()){
            matches.add(i+1-target.length());
            currentMatch = prefixes[currentMatch-1];
         }
      } else {
         currentMatch = prefixes[currentMatch];
         i--;
         continue;
      }
   }
   
   return matches.toArray(new Integer[0]);
}

// An implementation of the Knuth-Morris-Pratt algorithm
// Finds the index of the first character of the first instance of target in toMatch

// Complexity: O(n)
//   n is the length of toMatch

// Arguments:
//   String toMatch - the string in which to search for instances of target
//   String target  - the string for which to search in toMatch

// Returns:
//   int            - the index of the first character of the first instance of target in toMatch
public static int stringMatchFirst(String toMatch, String target){
   int[] prefixes = new int[target.length()];
   
   int currentPos = 0;
   for(int i = 1; i < target.length(); i++){
      if(target.charAt(currentPos) == target.charAt(i)){
         currentPos++;
         prefixes[i] = currentPos;
      } else {
         currentPos = 0;
      }
   }
   
   int currentMatch = 0;
   for(int i = 0; i < toMatch.length(); i++){
      if(toMatch.charAt(i) == target.charAt(currentMatch)){
         currentMatch++;
         if(currentMatch == target.length()){
            return i+1-target.length();
         }
      } else {
         currentMatch = prefixes[currentMatch];
         i--;
         continue;
      }
   }
   
   return matches.toArray(new Integer[0]);
}