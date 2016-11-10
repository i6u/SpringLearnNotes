package zyr.learn.designPatterns.compositeModel;

/**
 * Created by zhouweitao on 2016/11/10.
 */
public class Role implements IRole{
    private MyTemplate mt = new MyTemplate();

    public void add(Object obj) {
        mt.add(obj);
    }
    public void del(Object obj) {
        mt.del(obj);
    }
}
