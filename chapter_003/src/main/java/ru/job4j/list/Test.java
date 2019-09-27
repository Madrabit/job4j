package ru.job4j.list;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //put your code here
        Scanner scn = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scn.hasNextInt()) {
            if (scn.nextInt() % 2 == 0) {
                list.add(scn.nextInt());
            }
        }
        for (int i = list.size(); 0 < list.size() - 1; i--) {
            System.out.print(list.get(i));
        }
    }
}