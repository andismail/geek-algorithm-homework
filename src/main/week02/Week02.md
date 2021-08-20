Homework
242.有效的字母异位词
49.异位词分组
94.二叉树的中序遍历
144.二叉树的前序遍历
589.N叉树的前序遍历
590.N叉树的后序遍历
N叉树的层序遍历
*40.最小的k个数
https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
*239.滑动窗口最大值
https://leetcode-cn.com/problems/sliding-window-maximum/
*347.前K个高频元素
https://leetcode-cn.com/problems/top-k-frequent-elements/

1.key-value结构工具类，key不能重复，线程不安全，访问的时间复杂度为O(1)
2.准许key和value为null，当key为null时其hash值为0，
3.jdk1.8前对于处理哈希冲突的方案是链表，1.8后当链表长度达到阈值时后换成使用红黑树
4.jdk1.8后hash算法(key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);较之前hash算法性能有所提升
5.默认初始大小为16，之后每次扩容变成原来的两倍。并且总是使用2的幂作为其大小
