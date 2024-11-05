package zaza.techblog.global.handler.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zaza.techblog.global.common.code.ResponseCode;
import zaza.techblog.global.common.response.BaseResponse;
import zaza.techblog.global.handler.exception.type.BusinessException;
import zaza.techblog.global.handler.exception.type.DataBaseException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse exceptionHandler(Exception exception) {

        log.error(exception.getMessage(), exception);

        return BaseResponse.ofError(ResponseCode.SERVER_ERROR);
    }

    // 입력 파라미터 예외 처리
    @ExceptionHandler(BindException.class)
    public BaseResponse bindExceptionHandler(BindException exception) {

        log.error(exception.getMessage(), exception);
        String detailMessage = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        return BaseResponse.ofError(ResponseCode.INPUT_ERROR, detailMessage);
    }

    // 비즈니스 예외 처리
    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException exception) {

        log.error(exception.getMessage(), exception);

        return BaseResponse.ofError(ResponseCode.SERVER_ERROR);
    }

    // 데이터 관련 예외 처리
    @ExceptionHandler(DataBaseException.class)
    public BaseResponse dataBaseExceptionHandler(DataBaseException exception) {

        log.error(exception.getMessage(), exception);

        return BaseResponse.ofError(ResponseCode.SERVER_ERROR);
    }
}
