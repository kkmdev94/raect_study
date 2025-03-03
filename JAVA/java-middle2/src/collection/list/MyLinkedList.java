package collection.list;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;
    private int size = 0;

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = newNode;
        }else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node<E> getLastNode() {
        Node<E> x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    // 추가 코드
    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) { // 만약에 파라미터로 들어온 index의 값이 0이라면.
            newNode.next = first; // 기존에 있던 first에다가 나의 next값을 넣어주고
            first = newNode; // 그다음에 이제 first에 newNode를 대입한다.
        } else {
            Node<E> prev = getNode(index - 1); // 파라미터로 받은 index의 -1 값을 찾아서 prev에 대입
            newNode.next = prev.next; // 대입된 prev의 next 노드를 newNode.next의 값에 대입
            prev.next = newNode; // 그리고 기존에 있던 prev의 next 노드는 비어있는 값이 되고 거기에 newNode를 대입한다.
        }
        size++;
    }

    // 추가 코드
    @Override
    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldvalue = x.item;
        x.item = element;
        return oldvalue;
    }

    @Override
    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removeItem = removeNode.item;
        if (index == 0) { // index가 0이라면 removeNode가 첫 번째 노드이므로
            first = removeNode.next; //첫 번째 노드의 다음 값을 first에다가 대입시키는것이다 그러면 removeNode의 다음 노드가 첫 번째 값이 된다.
        } else {
            Node<E> prev = getNode(index - 1); // add와 같다.
            prev.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removeItem;
    }

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.item;
    }

    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public int indexOf(E o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
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

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(); // 루프에서 무나를 더해야 되기 때문에 스트링빌더 사용.
            Node<E> x = this;
            sb.append("[");
            while (x != null) {
                sb.append(x.item);
                if (x.next != null) {
                    sb.append("->");
                }
                x = x.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
