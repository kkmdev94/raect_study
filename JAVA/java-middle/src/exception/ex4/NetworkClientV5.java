package exception.ex4;

import exception.ex4.exception.ConnectExceptionV4;
import exception.ex4.exception.SendExceptionV4;

public class NetworkClientV5 implements AutoCloseable{

    private final String address;
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV5(String address) {
        this.address = address;
    }

    public void connect()  {
        if (connectError) {
            throw new ConnectExceptionV4(address, address + " 서버 연결 실패");
        }
        //연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    public void send(String data)  {
        if (sendError) {
            throw new SendExceptionV4(data, address + " 서버 데이터 전송 실패 : " + data);
            // 만약에 우리가 모르는 에러가 중간에 발생한다면?
//            throw new RuntimeException("ex");
        }
        //전송 성공
        System.out.println(address + " 서버에 데이터 전송 : " + data);
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }

    @Override
    public void close() {
        System.out.println("NetworkClientV5.close");
        disconnect();
        // AutoClosealbe(자바에서 지원하는 인터페이스)을 상속 받은 후 인터페이스가 제공하는 close 메서드를 이용하여
        // try가 끝나면 자동으로 disconnect가 호출 될 수 있게 하였다. 참고로 이 close 메서드에서 예외를 던지지 않으므로 throws Exception은 자체적으로 제거하였다.
    }
}
