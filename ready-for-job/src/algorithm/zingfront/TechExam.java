package algorithm.zingfront;

/**
 * @author zhiwen.qi
 * @description
 * @date 2020/2/18 18:47
 */
public class TechExam {

    public static void main(String[] args) {
        //部门优化
        System.out.println("部门优化");
        getGroupStatus(10 * 12);

        //邀请码检测
        System.out.println("邀请码检测");
        isValidInviteCode("0123456789abcdhf");

        //游戏币组合
        System.out.println("游戏币组合");
        System.out.println(coinCombine(4,4));

        //有趣的两位数
        System.out.println("有趣的两位数");
        getFunPair();

        //计算最大差值
        System.out.println("计算最大差值");
        int[] a1 = {5, 7, 4, 9};
        int[] a2 = {1, 2, 3, 4};

        //单链表处理
        System.out.println("单链表处理");
        Node head = new Node(0);
        Node node = head;
        for (int i = 1; i < 6; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        printLinkedList(head);
        Node head2 = reverseNode(head);
        printLinkedList(head2);

        //系统设计题
        //参考[美团分布式唯一ID生成]https://tech.meituan.com/2017/04/21/mt-leaf.html
    }


    /**
     * 部门优化
     * 输入month月后的情况。A,B,C,D四组以4个月为周期循环
     * @param month 几个月后
     */
    public static void getGroupStatus(int month) {
        if (month < 1) {
            return;
        }
        if (month % 4 == 1) {
            System.out.println("A:7, B:8, C:6, D:5");
        }else if (month % 4 == 2) {
            System.out.println("A:8, B:5, C:7, D:6");
        }else if (month % 4 == 3) {
            System.out.println("A:5, B:6, C:8, D:7");
        }else {
            System.out.println("A:6, B:7, C:5, D:8");
        }
    }


    /**
     * 邀请码检测
     * @param code 邀请码
     */
    public static void isValidInviteCode(String code) {
        if (code == null || code.length() != 16) {
            System.out.println("error");
        }
        if (code.matches("[a-z0-9]{16}")) { //正则判断由小写字母和数字组成
            int oddSum = 0;
            int evenSum = 0;
            for (int i = code.length() - 1; i >= 0 ; i--) {
                char c = code.charAt(i);
                int num = 0;
                if (c <= '9' && c >= '0') { //判断是否为数字
                    num = c - '0';
                }else { //为小写字母
                    num = (c - 'a') % 9 + 1;
                }
                if ((i + 1) % 2 == 0) {   //偶数位
                    num = num * 2 > 9 ? num * 2 - 9 : num * 2;
                    evenSum += num;
                }else { //奇数位
                    oddSum += num;
                }
            }
            if ((oddSum + evenSum) % 10 == 0) {
                System.out.println("ok");
            }else {
                System.out.println("error");
            }
        }else {
            System.out.println("error");
        }
    }


    /**
     * 游戏币组合。游戏币面值1,2,5,10。
     * @param n 游戏币数量
     * @param m 游戏币总面值
     * @return 可能的组合方式个数。没有就返回0
     */
    public static int coinCombine(int n, int m) {
        int count = 0;
        for (int a1 = 0; a1 <= n; a1++) {
            for (int a2 = 0; a2 <= n / 2; a2++) {
                for (int a5 = 0; a5 <= n / 5; a5++) {
                    for (int a10 = 0; a10 <= n / 10; a10++) {
                        if (a1 + 2 * a2 + 5 * a5 + 10 * a10 == m && a1 + a2 + a5 + a10 == n) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }


    /**
     * 有趣的两位数
     * 设第一个数十位为a,个位为b;设第二个数十位为c,个位为d. a,b,c,d <- [1,9]
     * 有(10a+b)*(10c+d) = (10b+a)*(10d+c)=>推导可得a*c=b*d
     */
    public static void getFunPair() {
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <=9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        if (a * c == b * d) {
                            System.out.println( a + "" + b + "*" + c + "" + d);
                        }
                    }
                }
            }
        }
    }


    /**
     * 计算最大差值
     * 有两组数，第一组数顺序固定，请编程实现让第二组数
     * 相邻数字间的大⼩小关系和第一组数相同，且第二组相邻数字间的差值之和最大
     * @return 最大差值（相邻两数差取绝对值后之和）
     */
    public static int getMaxDiff(int[] a1, int[] a2) {
        if (a1 == null || a1.length < 2 || a2 == null || a2.length < 2 || a1.length != a2.length) {
            return -1;
        }
        //记录两数之间关系的数组。如果第一个比第二个大，第一个数下标在该数组中对应的值为1，等于为0小于为-1
        int[] larger = new int[a1.length - 1];
        for (int i = 1; i < a1.length; i++) {
            if (a1[i - 1] > a1[i]) {
                larger[i - 1] = 1;
            }else if (a1[i - 1] == a1[i]) {
                larger[i - 1] = 0;
            }else {
                larger[i - 1] = -1;
            }
        }
        //第二个数组可能出现调整顺序无解的情况。比如第一个数组有相等元素，第二个数组没有，题目不严谨。
        return -1;

    }


    /**
     * 单链表处理
     * @param head 链表头节点
     * @return 处理后的链表头节点
     */
    public static Node reverseNode(Node head) {
        Node pre = null;
        Node latter = null;
        Node node = head.next;
        while (node != null) {
            latter = node.next;
            node.next = pre;
            pre = node;
            node = latter;
        }
        head.next = pre;
        return head;
    }

    /**
     * 输出链表
     * @param node 链表节点
     */
    private static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }





}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
