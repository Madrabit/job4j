package ru.job4j.loop;

/**
 * Протеиновая диета.
 * @author madrabit
 * @version $id$
 * @since 1
 */
public class Fitness {
    /**
     * Метод вычисление количества месяцев, чтобы догнать "Николая".
     * @param ivan Жив Ивана
     * @param nik Жив Николая
     * @return Сколько месяцев нужно, чтобы Ивану догнать Николая.
     */
    public int calc(int ivan, int nik) {
        int month = 0;
        while (ivan < nik) {
            ivan *= 3;
            nik *= 2;
            month++;
        }
        return month;
    }
}
