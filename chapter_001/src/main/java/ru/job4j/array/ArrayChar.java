package ru.job4j.array;

/**
 * Слово начинается с ...[#159111]
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class ArrayChar {
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startsWith(String word, String prefix) {
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] != wrd[i]) {
                return false;
            }
        }
        return true;
    }
}
