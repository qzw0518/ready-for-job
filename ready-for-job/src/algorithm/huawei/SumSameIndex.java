package algorithm.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zhiwen.qi
 * @description
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 * @date 2020/2/6 13:36
 */
public class SumSameIndex {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int size = sc.nextInt();
        while (sc.hasNext()) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            if (treeMap.containsKey(index)) {
                treeMap.put(index, treeMap.get(index) + value);
            }else {
                treeMap.put(index, value);
            }
        }
        sc.close();
        for (Integer key : treeMap.keySet()) {
            System.out.println(key + " " + treeMap.get(key));
        }
    }



}
