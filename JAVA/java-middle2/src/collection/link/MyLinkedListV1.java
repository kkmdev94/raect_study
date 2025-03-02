package collection.link;

public class MyLinkedListV1 {

    private Node first;
    private int size = 0;

    public void add(Object e) {
        Node newNode = new Node(e);
        if (first == null) { // 첫 노드가 없다면 새로운 노드를 만들고 first에 연결해서 넣는다
            first = newNode;
        }else { // 첫번째의 값이 있다면 그 이후로는 마지막 노드를 찾고 그 뒤에 새로운 노드를 생성하여 마지막 노드에 연결 / 효율적으로 마지막 노드를 찾아서 추가를 해야된다(O(n) 소요)
            Node lastNode = getLastNode();
            lastNode.next = newNode; // 하지만 추가하는데는 해당 노드의 빈값이 마지막노드의 바로 다음이므로 바로 찾을 수 있어서 O(1)이다.
        } // 따라서 효율은 O(n) + O(1) = O(n)이다.
        size++;
    }

    private Node getLastNode() { // 마지막 노드를 찾기위한 메서드
        Node x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    public Object set(int index, Object element) { // 동일하게 특정 위치를 찾기 위해 for문을 돌려야 하기에 O(n)이다.
        Node x = getNode(index);
        Object oldvalue = x.item;
        x.item = element;
        return oldvalue;
    }

    public Object get(int index) {
        Node node = getNode(index); // 겟노드 메서드를 통해 해당 노드를 찾는다
        return node.item;
    }

    private Node getNode(int index) {
        Node x = first;
        for (int i = 0; i < index; i++) { // 해당 노드를 찾을떄의 단점 / for문을 돌아야하기에 내가 원하는 노드를 찾을때까지 쭉 for문을 돌려야 한다 O(n)으로 효율이 그리 좋지 않다.
            x = x.next;
        }
        return x;
    }

    public int indexof(Object o) { // 특정 위치 데이터 반환 / get과 동일하게 for문을 돌려 모든 노드를 순회하면서 equals()를 사용하여 같은 데이터를 찾는다.
        int index = 0;
        for (Node x = first; x != null; x = x.next) { // for문의 조건식에 first를 Node의 x에 대입 후, x 가 null이 아닐 때, x에 x.netx값을 넣어서 계속 돌린다. null이 나올때까지
            if (o.equals(x.item)) { // 단 여기서 x.item의 값이 파라미터로 넘어온 o의 값과 같다면 그 값을 반환해 준다.
                return index;
            }
            index++; // 그게 아니라면 index의 값을 증가시킨다.
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
