package exception.ex4;

public class NetworkServiceV5 {

    public void sendMessage(String data) {
        String address = "http://example.com";

        // NetworkClientV5에서 AutoCloseable 상속받았기에 위에서 선언이 아닌 try에서 선언해주고
        // 자동으로 연결을 해제해 주기에 final을 안써도 된다.
        // 이 방법을 try with resources 구문이라고 한다.
        // try 괄호 안에 사용할 자원을 명시 후 try블럭이 끝나면 선언한 새로운 인스턴스 안에 있는 AutoCloseable.close를 호출하여 자원을 해제한다.
        // catch가 없어도 상관 없다.
        try (NetworkClientV5 client = new NetworkClientV5(address)) {
            client.initError(data);
            client.connect();
            client.send(data);
        } catch (Exception e){
            System.out.println("[예외 확인] : " + e.getMessage());
            throw e;
        }
    }
}
