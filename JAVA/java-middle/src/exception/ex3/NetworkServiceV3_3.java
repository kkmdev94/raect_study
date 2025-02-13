package exception.ex3;


import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.NetworkClientExceptionV3;
import exception.ex3.exception.SendExceptionV3;

public class NetworkServiceV3_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data); // 추가


        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 | SendExceptionV3 e) { // 공통 부모가 가진 것만 사용 가능 getAddress와 getSendData를 호출 할 수 없다.
            System.out.println("[연결 또는 전송 오류]  메시지 : " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}
