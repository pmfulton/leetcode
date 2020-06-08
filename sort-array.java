
// Given an array of integers nums, sort the array in ascending order.


import java.util.Arrays;

class sortArray {
    public int[] sortArray(int[] nums) { 
        
        if (nums.length <= 1) return nums;
        
        int split = nums.length/2;
        
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, split)); 
        int[] right = sortArray(Arrays.copyOfRange(nums, split, nums.length));
        
        return merge(left, right);
    }
    
    
    
    
    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int pr = 0, pl = 0, pres = 0;
        
        while (pr < right.length && pl < left.length) {
            
            if (left[pl] < right[pr]) {
                res[pres++] = left[pl++];
            } else {
                res[pres++] = right[pr++];
            }
        }
        
        
        
        while (pl < left.length) {
            res[pres++] = left[pl++];
        }
        
        while (pr < right.length) {
            res[pres++] = right[pr++];
        }
        
        
        
        return res;
    }
    
}
