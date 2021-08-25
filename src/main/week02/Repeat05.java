package week02;

import java.util.*;

public class Repeat05 {

    public int[] _40_1(int[] nums, int k) {
        Arrays.sort(nums);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public int[] _40_2(int[] nums, int k) {
        if (nums == null || k == 0) {
            return nums;
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            if (q.size() < k) {
                q.add(num);
                continue;
            }

            if (q.size() == k) {
                if (num > q.peek()) {
                    continue;
                }
                q.add(num);
                q.remove();
            }

        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    // 单调递减 双端队列
    public int[] _239(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.removeLast();
            }

            q.addLast(i);

            if (i - q.peekFirst() == k) {
                q.removeFirst();
            }

            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return res;
    }

    public int[] _347(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o1) - counter.get(o2));
        for (Integer num : counter.keySet()) {
            if (q.size() < k) {
                q.add(num);
                continue;
            }

            if (q.size() == k) {
                if (counter.get(num) < counter.get(q.peek())) {
                    continue;
                }
                q.add(num);
                q.remove();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    public List<List<Integer>> _77(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.add(i);
            dfs(n, k, i - 1, path, res);
            path.removeLast();
        }
    }
}