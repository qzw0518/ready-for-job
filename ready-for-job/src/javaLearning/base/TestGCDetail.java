package javaLearning.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/28
 */
public class TestGCDetail {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.gc();
    }
}
