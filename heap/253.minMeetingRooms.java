class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
        Arrays.sort(intervals, new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        heap.offer(intervals[0][1]);
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
            }
            heap.offer(intervals[i][1]);
        }
        return heap.size();
    }
}