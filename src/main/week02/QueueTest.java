package week02;

import java.util.*;

public class QueueTest {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(4, 5, 1, 6, 2, 7, 3, 8);

        Queue<Integer> q = new PriorityQueue<>(integers);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());

        Queue<Integer> qq = new PriorityQueue<>(8, (o1, o2) -> o1 - o2);


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        integers.sort(comparator);
        for (Integer i : integers) {
            System.out.print(i + "\t");
        }
    }
}
