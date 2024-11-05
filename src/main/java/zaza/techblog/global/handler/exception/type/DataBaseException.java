package zaza.techblog.global.handler.exception.type;

import zaza.techblog.global.common.code.ResponseCode;

public class DataBaseException extends CustomException {

    public DataBaseException(ResponseCode responseCode, String message) {
        super(responseCode, message);
    }
}
