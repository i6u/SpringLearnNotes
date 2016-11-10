package zyr.learn.designPatterns.compositeModel;

/**
 * Created by zhouweitao on 2016/11/10.
 */
public class MyTemplate {
    private void beginConnection() {
        System.out.println("begin connection...");
    }

    private void endConnection() {
        System.out.println("end connection...");
    }

    public void execute(MyCallback call) {
        beginConnection();
        call.doinTemplate();
        endConnection();
    }

    public void add(final Object object) {
        execute(new MyCallback() {
            @Override
            public void doinTemplate() {
                System.out.println("add execute:"+object.toString());
            }
        });
    }

    public void del(final Object object) {
        execute(new MyCallback() {
            @Override
            public void doinTemplate() {
                System.out.println("delete execute:"+object.toString());
            }
        });
    }
}
