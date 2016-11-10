package zyr.learn.designPatterns.extendsModel;

/**
 * Created by zhouweitao on 2016/11/10.
 */
public class Role extends MyTemplate {

    /**
     * 2. 继承模板类，实现非公共部分的方法
     * */
    public void doRun() {
        System.out.println("role doRun......");
    }

    public boolean doLogger() {
        return false;
    }
}
