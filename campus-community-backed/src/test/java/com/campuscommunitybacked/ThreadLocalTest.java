package com.campuscommunitybacked;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalGetAndSet() {
        ThreadLocal t1 = new ThreadLocal();
        new Thread(()->{
            t1.set("ThreadLocal 1");
        }, "t1").start();
    }
}
