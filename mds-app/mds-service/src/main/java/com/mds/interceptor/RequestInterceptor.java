package com.mds.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info(
				"\n End Point " + request.getRequestURI() + " invoked at STARTTIME : " + System.currentTimeMillis());
		request.setAttribute("STARTTIME", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setHeader("transactionId", request.getHeader("transactionId"));
		logger.info("\n " + request.getMethod() + " request executed at ENDTIME : " + System.currentTimeMillis());
		request.setAttribute("ENDTIME", System.currentTimeMillis());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long totalTime = ((Long) request.getAttribute("ENDTIME") - (Long) request.getAttribute("STARTTIME"));
		logger.info("\n Total Time Took for completion : " + totalTime + " ms");
	}

}
