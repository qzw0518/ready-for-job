package javaLearning.base.collections;

import java.util.*;

/**
 * @author zhiwen.qi
 * @description Java集合框架
 * 集合顶层接口Collection,包含add, remove, size, contains(覆写equals和hashCode), iterator(返回迭代器的方法，迭代器需要实现Iterator接口, next, hasNext, add, remove)
 * Linked开头的是链表实现如LinkedList, LinkedHashSet, LinkedHashMap
 * Array开头数组实现如ArrayList,ArrayDeque
 * Tree开头对元素进行了排序如TreeSet, TreeMap
 * HashSet, HashMap, PriorityQueue
 * @date 2020/3/21 14:05
 */
public class TestAllCollectios {

    public static void main(String[] args) {
        //LinkedList。链表实现的列表，高效插入删除
        List<String> ll = new LinkedList<>();
        ll.add("Bob");
        ll.add("Amy");
        ll.add("Cindy");
        Iterator<String> llIter = ll.iterator();
        //获取下一个元素(Amy)
        llIter.next();
        //删除iter获取到的元素(Amy)
        llIter.remove();
        System.out.print("LinkedList---");
        //for each will use iterator to operate collection
        for (String s : ll) {
            //输出剩余元素(Bob Cindy)
            System.out.print(s + " ");
        }
        System.out.println();

        //TreeSet。红黑树实现的Set，元素被排序，其中的元素需要实现Comparable接口，覆写compareTo方法。
        Set<String> ts = new TreeSet<>();
        ts.add("Cindy");
        ts.add("Amy");
        ts.add("Bob");
        System.out.print("TeeSet---");
        for (String s : ts) {
            //will print Amy Bob Cindy
            System.out.print(s + " ");
        }
        System.out.println();
    }


}
