package collection.deque.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {

    private Deque<String> stack = new ArrayDeque<>();
    private String currentPage = null; // 현재 페이지를 담을 곳.


    public void visitPage(String link) {
        if (currentPage != null) { // 현재 페이지가 널이 아니면 -> 즉 매개변수로 받은 link가 if문 밑에서 currentPage로 들어가고 그 뒤에 새로운 페이지가 다시 매개변수로 들어오니
                                   // stack에 현재 페이지를 넣는 것이다.
            stack.push(currentPage);
        }
        currentPage = link;
        System.out.println("방문 : " + link);
    }

    public String goBack() {
        if (!stack.isEmpty()) {
            currentPage = stack.pop();
            System.out.println("뒤로 가기 : " + currentPage);
            return currentPage;
        }
        return null;
    }
}
