package zaza.techblog.global.handler.exception.type;

import zaza.techblog.global.common.code.ResponseCode;

public class BusinessException extends CustomException{

    public BusinessException(ResponseCode responseCode, String message) {
        super(responseCode, message);
    }
}
