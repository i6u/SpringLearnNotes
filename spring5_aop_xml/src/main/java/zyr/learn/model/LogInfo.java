package zyr.learn.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zhouweitao on 2016/11/4.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LogInfo {
    public String value() default "";
}
