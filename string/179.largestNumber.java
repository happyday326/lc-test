class Solution {
    public String largestNumber(int[] nums) {
        //把integer改成string
        String[] asStrs = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        //使用新定义的比较方法给array排序
        Arrays.sort(asStrs, new LargerNumberComparator());
        if (asStrs[0].equals("0")) {return "0";}

        String largestNumberStr = new String();
        for (String numStr: asStrs) {
            largestNumberStr += numStr;
        }
        return largestNumberStr;
    }

    public class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        }
    }

}