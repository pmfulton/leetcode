import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    ); 
    
    public void wallsAndGates(int[][] rooms) {
        
        //Build the queue by finding all instances where a position is a gate.
        int m = rooms.length;
        if (m == 0) {return;}
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    q.add(new int[] {i , j});
                } 
            }
        }
        
        while(!q.isEmpty()) {
            
            int[] coord = q.poll();
            int i = coord[0];
            int j = coord[1];
            
            for (int[] move : DIRECTIONS) {
                int row = i + move[0];
                int col = j + move[1];
                
                if (row < 0 || col < 0 || row >= m || col >= n || rooms[row][col] != EMPTY) {
                    continue;
                }
                
                rooms[row][col]  = rooms[i][j] + 1;
                q.add(new int[] {row, col});
            }  
        }
    }
}