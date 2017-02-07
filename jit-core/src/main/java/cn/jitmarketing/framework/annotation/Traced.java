package cn.jitmarketing.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/7/12.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Traced {
    String name() default "";// 默认为空
}
