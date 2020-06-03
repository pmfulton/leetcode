import java.util.Arrays;
import java.util.Comparator;

class CitySchedulingSolution {
    
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        

        int sum = 0;
        int count = costs.length/2;
        
        for (int i = 0; i < costs.length; i++) {
            if (count > 0) {
                sum += costs[i][0];
                count--;
            } else {
                sum += costs[i][1];
            }
            
        }
        return sum;
    }
}