package ru.job4j.calculate;

    /**
    * Class Класс, который выводит  Хелоу.
    * @author madrabit
    * @since 15.07.2019
    * @version 1
    */

public class Calculate {
    /** 
    * Main
    * @params args - аргументы консоли.
    */
    public static void main(String[] args) {
       System.out.println("Hello, Job4j.");
   }
    /**
     * Method echo.
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
