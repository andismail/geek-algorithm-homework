package week02;

public class JavaHashMap {

    private int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        // 这么处理是因为当求某个key在数组中的位置时用的是hash值&数组长度
        // 当数组长度比较小时实际上只使用到了这个hash值的低位，导致计算结果只与低位有关
        // 所以此处使用了当前hash值再异或其高16位的处理，使其高位也加入到计算，增加低位的随机性
        // 同时增加hash值的复杂度尽量减少hash冲突，
        return h ^ h >>> 16;
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 这个方法记住得了，就是在求大于等于cap的最小的2的n次方
    // 这么处理的目标是为了在计算某一key在数组中的位置时可以用异或运算快速求余数
    private int tableSize(int cap) {
        int n = cap - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private int local(Object key, int tableSize) {
        // tableSize为数组长度，因为tableSize()计算出来值总是2的n次方
        // 所以下方运算实际相当于求余数，也就是余数就是这个key所在的数组的下标
        return hash(key) & (tableSize - 1);
    }

    public static void main(String[] args) {
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(1 << 29);
        System.out.println(1 << 30);
        System.out.println(1 << 31);
        System.out.println(Integer.MAX_VALUE);
    }
}
