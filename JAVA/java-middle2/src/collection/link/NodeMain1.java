package collection.link;

import java.util.Arrays;

public class NodeMain1 {

    public static void main(String[] args) {
        // 노드 생성하고 연결하기 : A -> B -> C
        Node firts = new Node("A");
        firts.next = new Node("B");
        firts.next.next = new Node("C");

        System.out.println("모든 노드 탐색하기");
//        System.out.println("firts.item = " + firts.item);
//        System.out.println("firts.next.item = " + firts.next.item);
//        System.out.println("firts.next.next.item = " + firts.next.next.item);
        Node x = firts;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }
}
