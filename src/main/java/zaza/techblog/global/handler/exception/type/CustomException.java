package zaza.techblog.global.handler.exception.type;

import zaza.techblog.global.common.code.ResponseCode;

public class CustomException extends RuntimeException {

    ResponseCode responseCode;

    public CustomException(ResponseCode responseCode, String message) {

        super(message);
        this.responseCode = responseCode;
    }
}
