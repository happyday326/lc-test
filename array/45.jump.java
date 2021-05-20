class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n==1) {return 0;}
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            if (i == 0) {
                map.put(i, 0);
            } else {
                map.put(i, -1);
            }
            int minStep = i;
            for (int j=0; j<i; j++) {
                if (j == 0) {
                    if (nums[j] >= (i-j)) {
                        if (minStep > map.get(j)+1) {minStep = map.get(j)+1;}
                    }
                } else {
                    if (map.get(j)>0 && nums[j] >= (i-j)) {
                        if (minStep > map.get(j)+1) {minStep = map.get(j)+1;}
                    }
                }
            }
            map.put(i, minStep);
        }
        return map.get(n-1);
    }
}

//[2,3,1,1,4]
//output = 2

//[3,2,1]