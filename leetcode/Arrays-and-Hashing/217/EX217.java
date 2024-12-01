import java.util.HashSet;

class EX217 {
	public static void main(String[] args){
		int[] nums = {2,14,18, 22, 22};

		System.out.println(containsDuplicate(nums));
	}


	static boolean containsDuplicate(int[] nums) {
        int[] n = nums;

        /*
        // Brute force solution
        for(int i=0; i<n.length; i++){
        	for(int j=i+1; j<n.length; j++){
        		if(n[j] == n[i]) return true;
        	}
        }
        return false;
        */
        /*
        // Solution with a boolean array
        // Error if there is a negative elem in the array
        // Get the biggest elem
        int max = getMax(n) + 1;
        boolean[] boolArray = new boolean[max];
        for(int i = 0; i<nums.length; i++){

        	if(boolArray[n[i]]) return true;
        	boolArray[n[i]] = true;
        }
        return false;
        */
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i<n.length; i++){
        	set.add(n[i]);
        }

        return set.size() > n.length;
	    
    }

    static int getMax(int[] nums){
    	int maxSoFar = nums[0];
    	for(int i=1; i<nums.length; i++){
    		if(nums[i] > maxSoFar) maxSoFar = nums[i];
    	}
    	return maxSoFar;
    }
}
