package collection.link;

public class MyLinkedListV2 {

    private Node first;
    private int size = 0;

    public void add(Object e) {
        Node newNode = new Node(e);
        if (first == null) {
            first = newNode;
        }else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node getLastNode() {
        Node x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    // 추가 코드
    public void add(int index, Object e) {
        Node newNode = new Node(e);
        if (index == 0) { // 만약에 파라미터로 들어온 index의 값이 0이라면.
            newNode.next = first; // 기존에 있던 first에다가 나의 next값을 넣어주고
            first = newNode; // 그다음에 이제 first에 newNode를 대입한다.
        } else {
            Node prev = getNode(index - 1); // 파라미터로 받은 index의 -1 값을 찾아서 prev에 대입
            newNode.next = prev.next; // 대입된 prev의 next 노드를 newNode.next의 값에 대입
            prev.next = newNode; // 그리고 기존에 있던 prev의 next 노드는 비어있는 값이 되고 거기에 newNode를 대입한다.
        }
        size++;
    }

    // 추가 코드
    public Object remove(int index) {
        Node removeNode = getNode(index);
        Object removeItem = removeNode.item;
        if (index == 0) { // index가 0이라면 removeNode가 첫 번째 노드이므로
            first = removeNode.next; //첫 번째 노드의 다음 값을 first에다가 대입시키는것이다 그러면 removeNode의 다음 노드가 첫 번째 값이 된다.
        } else {
            Node prev = getNode(index - 1); // add와 같다.
            prev.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removeItem;
    }

    public Object set(int index, Object element) {
        Node x = getNode(index);
        Object oldvalue = x.item;
        x.item = element;
        return oldvalue;
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node.item;
    }

    private Node getNode(int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexof(Object o) {
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV2{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
