package javaLearning.base.collections;

import javaLearning.base.commonDesign.MyPair;

import java.util.*;

/**
 * @author zhiwen.qi
 * @description 视图技术在集合中的应用
 * @date 2020/3/21 16:06
 */
public class TestViewInCollection {

    public static void main(String[] args) {
        List<String> sList = new ArrayList<>();
        sList.add("Amy");
        sList.add("Cindy");
        sList.add("Bob");
        sList.add("Micky");
        sList.add("Tom");
        for (String s : sList) {
            System.out.print(s + " ");
        }
        System.out.println();
        //subList is a view of sList, and change of subList will apply to sList
        List<String> subList = sList.subList(1,3);
        for (String s : subList) {
            System.out.print(s + " ");
        }
        System.out.println();
        //this will lead to sList change, sList will only remains Amy
        subList.clear();
        for (String s : sList) {
            System.out.print(s + " ");
        }
        System.out.println();
        //create an immutable view for sList
        List<String> immuList = Collections.unmodifiableList(sList);
        try {
            immuList.add("newbie");
        }catch (Exception e) {
            System.out.println("immuList is immutable");
        }

        sList.add("newbie");
        //immuList is a view, so the change in sList will show off
        for (String s : immuList) {
            System.out.print(s + " ");
        }
        System.out.println();


        //this will new, add, set to immutable for a set contains only given object
//        Set<String> sSet = Collections.singleton("one");
//        try {
//            sSet.add("two");
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
