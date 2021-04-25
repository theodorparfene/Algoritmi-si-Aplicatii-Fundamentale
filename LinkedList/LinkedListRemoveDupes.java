package LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.ListIterator;

public class LinkedListRemoveDupes {

    public static void removeDuplicates(List<Integer> list) {
        List<Integer> uniques = new LinkedList<>();
        ListIterator<Integer> i = list.listIterator();
        while (i.hasNext()) {
            int currentElem = i.next();
            if (!uniques.contains(currentElem)) {
                uniques.add(currentElem);
            } else {
                i.remove();
            }
        }
    }

    public static void removeDuplicates2(List<Integer> list) {
        List<Integer> uniques = new LinkedList<>();
        ListIterator<Integer> i = list.listIterator();
        while (i.hasNext()) {
            int currentElem = i.next();
            if (!uniques.contains(currentElem)) {
                uniques.add(currentElem);
            } else {
                i.remove();
                if (i.hasPrevious()) {
                    i.previous();
                    i.remove();
                }
            }
        }
    }

    public static void addElements(List<Integer> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements would you like to add?");
        int nrElem = sc.nextInt();

        for (int i = 0; i < nrElem; i++) {
            System.out.println("Please add your next element:");
            list.add(sc.nextInt());
        }

        sc.close();
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        addElements(list);
        list.sort(Comparator.naturalOrder());
        removeDuplicates2(list);

        for (int e : list) {
            System.out.print(e + " ");
        }
    }
}
