package zyr.learn.designPatterns.extendsModel;

/**
 * Created by zhouweitao on 2016/11/10.
 */
public class Message extends MyTemplate {
    public void doRun() {
        System.out.println("message doRun ......");
    }

    public boolean doLogger() {
        return true;
    }
}
