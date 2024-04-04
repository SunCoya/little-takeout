package com.sky.context;

//在获取到token时顺便在线程中存储id时使用
public class BaseContext {
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }
    public static Long getCurrentId() {
        return threadLocal.get();
    }
    public static void removeCurrentId() {
        threadLocal.remove();
    }

}
