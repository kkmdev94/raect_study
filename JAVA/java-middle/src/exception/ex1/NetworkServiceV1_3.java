package exception.ex1;

public class NetworkServiceV1_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); // 추가

        String connectResult = client.connect();
        //결과가 성공이 아니다 -> 오류다. / 말이 이상하다.!connectResult.equals("success") -> 이거를  ctrl + alt + m을 통해 아래의 if문으로 전환.
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드 : " + connectResult);
        } else {
            String sendResult = client.send(data);
            if (isError(sendResult)) {
                System.out.println("[데이터 전송 오류 발생] 오류 코드 : " + sendResult);
            }
        }
        client.disconnect();
    }

    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
