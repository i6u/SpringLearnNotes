package zyr.manager.user.util;

/**
 * Created by zhouweitao on 2016/11/16.
 *
 */
public class SystemContext {
    private static  ThreadLocal<Integer> pageOffset = new ThreadLocal<>();
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();

    public static int getPageOffset() {
        return pageOffset.get();
    }

    public static void setPageOffset(int _pageOffset) {
        pageOffset.set(_pageOffset);
    }

    public static int getPageSize() {
        return pageSize.get();
    }

    public static void setPageSize(int _pageSize) {
        pageSize.set(_pageSize);
    }

    public static void removePageOffset() {
        pageOffset.remove();
    }
    public static void removePageSize() {
        pageSize.remove();
    }
}
