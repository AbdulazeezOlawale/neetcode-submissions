class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashFreq = new HashMap<>();

        for (int num : nums) {
            hashFreq.put(num, hashFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : hashFreq.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    // public int[] topKFrequent(int[] nums, int k) {
    //     // Step 1: Count frequencies
    //     HashMap<Integer, Integer> hashFreq = new HashMap<>();
    //     for (int num : nums) {
    //         hashFreq.put(num, hashFreq.getOrDefault(num, 0) + 1);
    //     }

    //     // Step 2: Use a min-heap to track top k frequent elements
    //     PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
    //         (a, b) -> a.getValue() - b.getValue()
    //     );

    //     for (Map.Entry<Integer, Integer> entry : hashFreq.entrySet()) {
    //         minHeap.offer(entry);
    //         if (minHeap.size() > k) {
    //             minHeap.poll();
    //         }
    //     }

    //     // Step 3: Extract the top k elements
    //     int[] result = new int[k];
    //     for (int i = 0; i < k; i++) {
    //         result[i] = minHeap.poll().getKey();
    //     }

    //     return result;
    // }
}
