class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vList1 = version1.split("\\.");
        String[] vList2 = version2.split("\\.");
        Integer now1 = 0;
        Integer now2 = 0;
        for (int i=0; i<Math.max(vList1.length, vList2.length); i++) {
            now1 = (i < vList1.length) ? removeZero(vList1[i]):0;
            now2 = (i < vList2.length) ? removeZero(vList2[i]):0;
            if (now1 > now2) return 1;
            if (now1 < now2) return -1;
        }
        return 0;
    }

    // 001 -> 1
    private Integer removeZero(String numStr) {
        int num = Integer.parseInt(numStr);
        return num;
    }
}


