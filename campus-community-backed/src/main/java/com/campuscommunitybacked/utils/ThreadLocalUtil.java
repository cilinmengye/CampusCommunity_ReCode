package com.campuscommunitybacked.utils;

public class ThreadLocalUtil {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    //防止内存泄漏
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
