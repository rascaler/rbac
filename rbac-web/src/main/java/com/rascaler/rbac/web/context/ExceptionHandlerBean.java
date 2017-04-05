package com.rascaler.rbac.web.context;

import com.rascaler.rbac.commons.exception.SPIException;
import com.rascaler.rbac.web.bean.OuterResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.MethodNotSupportedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@ControllerAdvice
public class ExceptionHandlerBean implements Ordered {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerBean.class);

	/**
	 * 日期格式处理
	 * 
	 * @param binder
	 */
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * //dateFormat.setLenient(false); //SimpleDateFormat datetimeFormat = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 * //datetimeFormat.setLenient(false); // 自动转换日期类型的字段格式
	 * //binder.registerCustomEditor(Date.class, new
	 * CustomDateEditor(datetimeFormat, true));
	 * //binder.registerCustomEditor(Date.class, new
	 * CustomDateEditor(dateFormat, true));
	 * //binder.registerCustomEditor(java.sql.Timestamp.class, new
	 * CustomTimestampEditor(datetimeFormat, true)); // 转换日期表达式 SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //创建
	 * CustomDateEditor 对象 CustomDateEditor editor = new
	 * CustomDateEditor(dateFormat, true); //注册为日期类型的自定义编辑器
	 * binder.registerCustomEditor(Date.class, editor); }
	 */

	/**
	 * 参数绑定错误
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public OuterResult handleBindException(BindException e) {
		logger.error("request params bind error: " + e.getMessage(), e);
		List<String> errors = new ArrayList<String>();
		for (ObjectError objectError : e.getAllErrors()) {
			errors.add(objectError.getDefaultMessage());
		}
		OuterResult outerResult = new OuterResult(StringUtils.join(errors, "，"));
		return outerResult;
	}

	/**
	 * 参数绑定错误
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public OuterResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		logger.error("request params bind error: " + e.getMessage(), e);
		List<String> errors = new ArrayList<String>();
		for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
			errors.add(objectError.getDefaultMessage());
		}
		OuterResult outerResult = new OuterResult(StringUtils.join(errors, "，"));
		return outerResult;
	}

	/**
	 * 缺少参数
	 * 
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public OuterResult handleMissingServletRequestParameterException(HttpServletRequest req, MissingServletRequestParameterException e) {
		logger.error("miss params: " + e.getMessage(), e);
		OuterResult outerResult = new OuterResult("miss params");
		return outerResult;
	}

	/**
	 * 参数类型不匹配
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public OuterResult handleMethodArgumentTypeMismatchExceptionException(HttpServletRequest req, MethodArgumentTypeMismatchException e) {
		logger.error("Argument Type Mismatch: " + e.getMessage(), e);
		OuterResult outerResult = new OuterResult("Argument Type Mismatch");
		return outerResult;
	}
	
	/**
	 * http消息无法解析
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class )
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public OuterResult handleHttpMessageNotReadableException(HttpServletRequest req, HttpMessageNotReadableException e) {
		logger.error("Http Message Not Readable: " + e.getMessage(), e);
		OuterResult outerResult = new OuterResult("Http Message Not Readable");
		return outerResult;
	}

    /**
     * http 媒体类型不支持
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public OuterResult handleHttpMediaTypeNotSupportedException(HttpServletRequest req, HttpMediaTypeNotSupportedException e) {
        logger.error("Http Media Type Not Supported: " + e.getMessage(), e);
        OuterResult outerResult = new OuterResult("Http Media Type Not Supported");
        return outerResult;
    }

	/**
	 * HTTP方法不支持
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = { MethodNotSupportedException.class, HttpRequestMethodNotSupportedException.class })
	@ResponseBody
	public OuterResult handleMethodException(Exception ex) {
		OuterResult outerResult = new OuterResult("HTTP method不被支持，请联系管理员");
		return outerResult;
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public OuterResult handleThrowAble(HttpServletRequest servletRequest, Throwable ex) {
		OuterResult outerResult;
		if (ex instanceof SPIException) {
			SPIException spiException = (SPIException) ex;
			logger.error("业务出错(" + servletRequest.getRequestURI() + ")" + " ecode:" + spiException.getEcode() + ", msg:" + spiException.getMsg(), spiException);
			outerResult = new OuterResult(spiException.getEcode(), spiException.getMsg());
			return outerResult;
		}
		if (ex instanceof IllegalArgumentException) {
			outerResult = new OuterResult("参数异常，请检查您输入的内容");
			return outerResult;
		}
		logger.error("访问出错(" + servletRequest.getRequestURI() + ")" + ex.getMessage(), ex);
		outerResult = new OuterResult("未知的异常");
		return outerResult;
	}

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}
}
