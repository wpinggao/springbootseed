package com.wping.seed.core.aspect;

import com.wping.component.base.enums.ResultCodeEnum;
import com.wping.component.base.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * Title: 全局异常处理切面 Description: 利用 @ControllerAdvice + @ExceptionHandler
 * 组合处理Controller层RuntimeException异常
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("could not read json...", e);
        return Result.fail("could not read json");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<String> handleValidationException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        if (e.getBindingResult() != null) {
            if (!CollectionUtils.isEmpty(e.getBindingResult().getFieldErrors())) {
                for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
                    sb.append("[").append(fieldError.getField()).append("]").append(fieldError.getDefaultMessage()).append(",");
                }
            }
        }
        String message = null;
        if (sb.toString() != null && sb.toString().length() > 0) {
            message = sb.substring(0, sb.length() - 1);
        }

        if (StringUtils.isEmpty(message)) {
            message = "parameter validation exception";
        }

        logger.error("parameter validation exception, message:{}", message);

        return Result.fail(message);
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("request method not supported...", e);
        return Result.fail("request method not supported");
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result<String> handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("content type not supported...", e);
        return Result.fail("content type not supported");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        logger.error("Internal Server Error...", e);
        return Result.fail(ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode(), "Internal Server Error");
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result processException(MaxUploadSizeExceededException ex) {
        logger.error(ex.getMessage(), ex);
        //自定义信息返回给调用端
        return Result.fail("文件过大!");
    }

}
