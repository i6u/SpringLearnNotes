package zyr.learn.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by zhouweitao on 2016/11/4.
 */

@Component("logAspect")
@Aspect
public class LogAspect {

    @Before("execution(* zyr.learn.dao.*.add*(..))")
    public void logStart(JoinPoint jp) {
        System.out.println("执行的对象："+jp.getTarget().getClass());
        System.out.println("执行的方法："+jp.getSignature().getName());
        Logger.info("加入日志");
    }

    @After("execution(* zyr.learn.dao.*.add*(..))")
    public void logEnd() {
        Logger.info("方法调用结束加入日志");
    }

    @Around("execution(* zyr.learn.dao.*.add*(..))")
    public void logAround(ProceedingJoinPoint pjp) throws Throwable {
        Logger.info("开始在Around中加入日志");
        pjp.proceed(); //执行程序
        //Logger.info(pjp.toLongString());
        Logger.info("结束Around");
    }
}
