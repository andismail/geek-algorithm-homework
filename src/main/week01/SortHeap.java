package week01;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortHeap {
    public int[] foo(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
        }
        int[] res = new int[nums.length];
        int i = 0;
        while (!q.isEmpty()) {
            res[i] = q.poll();
            i++;
        }
        return res;
    }

}
