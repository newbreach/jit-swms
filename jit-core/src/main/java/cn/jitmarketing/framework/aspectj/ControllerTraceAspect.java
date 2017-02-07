package cn.jitmarketing.framework.aspectj;



import cn.jitmarketing.framework.annotation.Traced;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/12.
 */
@Aspect
public class ControllerTraceAspect {
    private Logger logger = LogManager.getLogger(ControllerTraceAspect.class.getName());

    /**
     * 只对Controller进行pointcut,进行切面编程
     */
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controllerPointcut() {

    }

    /**
     * 对有@Traced标记的方法,进行切面编程
     */
    @Pointcut("@annotation(cn.jitmarketing.framework.annotation.Traced)")
    public void tracedMethodPointcut() {
    }

    /**
     * 对有@Traced标记的方法,进行切面编程,附带参数
     */
    @Pointcut(value = "@annotation(traced)", argNames = "traced")
    public void tracedMethodAfterPointcut(cn.jitmarketing.framework.annotation.Traced traced) {

    }

    /**
     * 对有com.dms.web.SysUserController类下面list开头的的方法,进行切面编程
     */
    @Pointcut("execution(* cn.jitmarketing.web.*.list(..)) ")
    public void listMethodPointcut() {
    }

    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //*********************************************************************************************************************************
    //****************************************** 以下为具体的拦截的切面的实现**********************************************************


   /* @Around("listMethodPointcut()")
    public Object searchAground(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("进入list方法。。。。。。");
        return pjp.proceed();
    }
*/

/*    // 使用Around 注解，在进入目标切面前与退出目标切面方法后都会进入该方法
    @Around("tracedMethodPointcut()")
    public Object traceAround(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();
        Class[] argsClazz = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argsClazz[i] = args[i].getClass();
        }
        Traced tracedAnnotation = AnnotationUtils.findAnnotation(point.getTarget().getClass().getDeclaredMethod(methodName, argsClazz), Traced.class);
        String traceName = tracedAnnotation.name();
        logger.debug("==========================已经进入使用Traced Around 注解过的方法，注解值为: " + traceName + "==========================");
        return point.proceed();
    }*/

/*    // 使用After 注解，在退出目标切面方法后会进入该方法
    @After("tracedMethodAfterPointcut(traced)")
    public void traceAround(JoinPoint point, Traced traced) throws Throwable {
        logger.debug("==========================已经进入使用Traced After 注解过的方法，注解值为: " + traced.name());
    }*/


    //对所有controller类的进行切面编程
    @Around("controllerPointcut()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        logger.debug("目标方法为:{}", point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        logger.info("输入参数:{}", Arrays.toString(args));
        Object result = point.proceed();
        logger.info("返回值:{}", result);
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>请求结束<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n");
        return result;
    }
}
