package enumeration.test.http;

public enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERANL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 선생님 로직
//    public static HttpStatus findByCode(int code) {
//        for (HttpStatus status : values()) {
//            if (status.getCode() == code) {
//                return status;
//            }
//        }
//        return null;
    
//    }
    public static HttpStatus findByCode(int httpCodeInput) {
        HttpStatus status = null;
        HttpStatus[] values = HttpStatus.values();
        for (HttpStatus value : values) {
            if (httpCodeInput == value.getCode()) {
                status = value;
                break;
            }
        }
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return code >= 200 && code <= 299;
    }
}
