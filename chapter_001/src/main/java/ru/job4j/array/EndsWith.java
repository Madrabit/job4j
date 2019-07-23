package ru.job4j.array;

/**
 * Слово заканчивается с ...[#159118]
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class EndsWith {
    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();

        for (int i = 0; i < pst.length; i++) {
            if (pst[pst.length - (1 + i)] != wrd[wrd.length - (1 + i)]) {
                return false;
            }
        }
        return true;
    }
}
