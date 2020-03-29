package ru.job4j.gc;

import java.lang.ref.SoftReference;

/**
 * @author madrabit
 */
public class MemoryUsage {


    public static class User {
        public final String name;

        @SuppressWarnings("unused")
        public User(String name) {
            this.name = name;
        }

        @SuppressWarnings("deprecation")
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }

    public static class UserNoFields {

        public UserNoFields() {
        }

        @SuppressWarnings("deprecation")
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }


    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println("start");
        info();
        for (int i = 0; i < 2500000; i++) {
//            SoftReference user = new SoftReference<>(new User("test"));
            SoftReference<UserNoFields> user = new SoftReference<>(new UserNoFields());
            //noinspection UnusedAssignment
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

    }
}
