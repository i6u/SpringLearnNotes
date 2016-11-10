package zyr.learn.designPatterns.extendsModel;

/**
 * Created by zhouweitao on 2016/11/10.
 */
public abstract class MyTemplate {
    /**
     * 1. 创建模板类，在模板类中完成公共部分的方法，把非公共部分的方法抽象
     *
     * */
    private void beginConnection() {
        System.out.println("begin connection...");
    }

    private void endConnection() {
        System.out.println("end connection...");
    }

    /**
     *
     * 钩子方法的名字应当以do开始
     * */
    public abstract void doRun();

    public abstract boolean doLogger();

    public void execute() {
        beginConnection();
        if (doLogger()) System.out.println("doLogger doRun...");
        doRun();
        endConnection();
    }
}
