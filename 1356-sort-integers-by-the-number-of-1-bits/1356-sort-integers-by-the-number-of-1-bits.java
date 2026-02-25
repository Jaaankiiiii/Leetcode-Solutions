import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArray, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            // If bit counts are equal, sort by natural numerical value
            if (countA == countB) {
                return a - b;
            }
            // Otherwise, sort by the number of set bits
            return countA - countB;
        });

        // Convert back to primitive int[]
        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }
}