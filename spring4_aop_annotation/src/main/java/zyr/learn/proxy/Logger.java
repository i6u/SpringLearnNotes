package zyr.learn.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhouweitao on 2016/11/4.
 */
public class Logger {
    public static void info(String info) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(new Date())+"--:"+info);
    }
}
