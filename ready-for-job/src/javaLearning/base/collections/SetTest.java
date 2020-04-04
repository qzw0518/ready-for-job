package javaLearning.base.collections;

import java.util.TreeSet;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/2/17 18:57
 */
public class SetTest {
    public static void main(String[] args) {
        TreeSet<TestEmum> treeSet = new TreeSet<>();
        treeSet.add(TestEmum.T1);
        treeSet.add(TestEmum.T1);
        treeSet.add(TestEmum.T2);
        System.out.println(treeSet.size() + treeSet.last().toString());
    }
}
