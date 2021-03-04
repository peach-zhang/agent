package com.peach.Aop;

import java.lang.annotation.*;

/**
 * @author zhangtao
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String tag() default "";

}
