package ru.job4j.oop;

/**
 * @author madrabit on 31.07.2019
 * @version 1$
 * @since 0.1
 */
public class Jukebox {
    /**
     * Играет мелодию в зависимости от позиции
     * @param position Номер мелодии
     */
    public void music(int position) {
        if (position == 1) {
            System.out.println("пусть бегут неуклюжа");
        } else if (position == 2) {
            System.out.println("спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
    }

}
