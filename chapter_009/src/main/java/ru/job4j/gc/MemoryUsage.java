package ru.job4j.gc;

import java.lang.instrument.Instrumentation;
import java.lang.ref.SoftReference;

/**
 * @author madrabit
 */
public class MemoryUsage {


    public static class User {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }

    public static class UserNoFields {

        public UserNoFields() {
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }


    public static void main(String[] args) {
        System.out.println("start");
        info();
        for (int i = 0; i < 25000; i++) {
            SoftReference user = new SoftReference<>(new User("test"));
//            SoftReference<UserNoFields> user = new SoftReference<> (new UserNoFields());
            user = null;

        }
        System.gc();
        System.out.println("finish");
        info();
    }

    public static void info() {
        int mb = 1024 * 1024;

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Used Memory:"
                + ((runtime.totalMemory() - runtime.freeMemory()) / mb));

        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);

        System.out.println("Total Memory:"
                + runtime.totalMemory() / mb);

        System.out.println("Max Memory:"
                + runtime.maxMemory() / mb);

        System.out.println("One object size:"
                + ((runtime.totalMemory() - runtime.freeMemory()) / 25));

    }
}
