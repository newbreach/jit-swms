package cn.jitmarketing.framework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @ClassName: BeanTools
 * @Description: Bean工具类，用来获取上下文环境以及bean实例
 * @author liukai
 * @date 2015年2月27日 上午9:51:07
 * 
 */
public class BeanTools implements ApplicationContextAware
{
	Log logger = LogFactory.getLog(this.getClass());
	public static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException
	{
		logger.info("Spring bean 初始化: " + arg0);
		this.ctx = arg0;
	}

	/**
	 * 
	 * @Title: getBean
	 * @author dengwenbing
	 * @Description: 通过上下文环境获取bean实例
	 * 
	 * @param beanname
	 * @return
	 */
	public static Object getBean(String beanname)
	{
		return ctx.getBean(beanname);
	}

}
