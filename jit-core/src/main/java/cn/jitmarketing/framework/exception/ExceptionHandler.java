package cn.jitmarketing.framework.exception;

import cn.jitmarketing.util.JsonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;


public class ExceptionHandler implements HandlerExceptionResolver {
	Log logger = LogFactory.getLog(this.getClass());


	/*@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		arg3.printStackTrace();
		logger.error(arg3.getMessage());
		ModelAndView modelAndView = new ModelAndView("errorPages/exception");
		modelAndView.addObject("message", arg3.getMessage());
		modelAndView.addObject("cause", arg3.getCause());
		return modelAndView;
	}*/


	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
										 Exception arg3) {
		arg3.printStackTrace();
		logger.error(arg3.getMessage());
		HashMap<String,String> errorMap = new HashMap<>();
		errorMap.put("error",arg3.getMessage());
		printWriterStrWithJson(errorMap,arg1);
		return null;
	}

	public   void printWriterStrWithJson(Object object, HttpServletResponse httpServletResponse) {
		httpServletResponse.setHeader("Cache-Control", "no-cache");
		httpServletResponse.setContentType("text/json;charset=UTF-8");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = httpServletResponse.getWriter();
			out.write(JsonUtil.objectToStr(object));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
				} finally {
					out = null;
				}
			}
		}
	}


}
