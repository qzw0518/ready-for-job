package algorithm.datastructure.linkedList;

/**
 * @author zhiwen.qi
 * @description 反转单向链表
 * @date 2020/2/24 9:23
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        //初始化单向链表
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        SinglyLinkedListNode pointer = head;
        for (int i = 1; i < 6; i++) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(i);
            pointer.next = node;
            pointer = pointer.next;
        }
        pointer = head;
        printList(pointer);
        //反转链表
        SinglyLinkedListNode reversedHead = reverse(head);
        pointer = reversedHead;
        printList(pointer);
    }

    /**
     * 反转单向链表
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode pre = null;
        SinglyLinkedListNode latter = null;
        while (head != null) {
            latter = head.next;
            head.next = pre;
            pre = head;
            head = latter;
        }
        return pre;
    }

    public static void printList(SinglyLinkedListNode pointer) {
        while (pointer != null) {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

}
