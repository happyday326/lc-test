class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    continue;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            maxDepth++;
        }

        queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * (maxDepth-depth+1);
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }
}