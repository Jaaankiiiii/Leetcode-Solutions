import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // TreeSet keeps sums unique and sorted
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Radius 0: Just the single cell
                addSum(set, grid[i][j]);

                // Radius k: Expand outwards
                for (int k = 1; ; k++) {
                    // Check if all four corners are within grid boundaries
                    if (i - k < 0 || i + k >= rows || j - k < 0 || j + k >= cols) break;

                    int sum = 0;
                    // Move from top corner clockwise
                    for (int x = 0; x < k; x++) {
                        sum += grid[i - k + x][j + x]; // Top to Right
                        sum += grid[i + x][j + k - x]; // Right to Bottom
                        sum += grid[i + k - x][j - x]; // Bottom to Left
                        sum += grid[i - x][j - k + x]; // Left to Top
                    }
                    addSum(set, sum);
                }
            }
        }

        // Convert TreeSet to the required descending array format
        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollLast(); // pollLast() gives the largest
        }
        return result;
    }

    private void addSum(TreeSet<Integer> set, int sum) {
        set.add(sum);
        // We only need to track the top 3 largest sums
        if (set.size() > 3) set.pollFirst(); // Remove the smallest
    }
}