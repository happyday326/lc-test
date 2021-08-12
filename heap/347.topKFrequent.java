class Solution {

    private class Point {
        int x;
        int y;
        Point(){}
        Point(int x, int y) {
            this.x=x; this.y=y;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer>map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
            }
        }
        PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> a.y-b.y);
        for (int key: map.keySet()) {
            heap.offer(new Point(key, map.get(key)));
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            Point point = heap.poll();
            res[i] = point.x;
            i++;
        }
        return res;
    }
}