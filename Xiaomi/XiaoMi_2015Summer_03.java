
import java.util.*;

public class XiaoMi_2015Summer_03 {


    public static void main(String[] args) {


        String[] ma = {"00100","00100","11011","00100","00100"};

        System.out.println(getSplitNode(ma,4,1));
    }

    public static int getSplitNode(String[] matrix, int indexA, int indexB) {


        if (indexA == indexB) return indexA;
        int len = matrix.length;
        // 构造一个father数组，存放每个节点的父节点
        int[] father = new int[len];
        // 标志数组
        int[] flag = new int[len];
        // 根节点的父节点为-1
        father[0] = -1;
        // 根节点 已经访问过
        flag[0] = 1;
        Queue<Integer> children = new ArrayDeque<>();
        children.offer(0);

        // 构造father数组，从根节点0开始
        while (!children.isEmpty()) {
            int parent = children.poll();
            char[] chars = matrix[parent].toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (flag[i] != 1 && chars[i] == '1') {
                    // 设置父节点
                    father[i] = parent;
                    // 将其加入孩子队列
                    children.offer(i);
                    // 标记为 访问过
                    flag[i] = 1;
                }
            }
        }

        int ia = indexA;
        int ib = indexB;
        // 记录从根节点到本节点的路径
        Deque<Integer> queueA = new ArrayDeque<>();
        Deque<Integer> queueB = new ArrayDeque<>();
        while (ia != -1) {
            queueA.addFirst(ia);
            ia = father[ia];
        }
        while (ib != -1) {
            queueB.addFirst(ib);
            ib = father[ib];
        }

        // 找到公共父节点
        int commonParent = 0;
        while (queueA.peekFirst() == queueB.peekFirst()) {
            commonParent = queueA.peekFirst();
            queueA.pollFirst();
            queueB.pollFirst();
        }
        return commonParent;



    }
}
