package LinkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class BigNumbersLinkedList {
    public LinkedList<Integer> sum(LinkedList<Integer> op1, LinkedList<Integer> op2) {
        LinkedList<Integer> sum = new LinkedList<>();
        ListIterator<Integer> i = op1.listIterator(op1.size());
        ListIterator<Integer> j = op2.listIterator(op2.size());
        int result = 0;

        while (i.hasPrevious() && j.hasPrevious()) {
            result += i.previous() + j.previous();
            if (result > 9) {
                sum.add(result % 10);
                result /= 10;
            } else {
                sum.add(result);
                result = 0;
            }

        }

        if (i.hasPrevious()) {
            while (i.hasPrevious()) {
                result += i.previous();
                if (result > 9) {
                    sum.add(result % 10);
                    result /= 10;
                } else {
                    sum.add(result);
                    result = 0;
                }
            }
        } else if (j.hasPrevious()) {
            while (j.hasPrevious()) {
                result += j.previous();
                if (result > 9) {
                    sum.add(result % 10);
                    result /= 10;
                } else {
                    sum.add(result);
                    result = 0;
                }
            }
        }

        Collections.reverse(sum);
        return sum;
    }

    public static void main(String[] args) {
        BigNumbersLinkedList bn = new BigNumbersLinkedList();
        LinkedList<Integer> op1 = new LinkedList<>();
        LinkedList<Integer> op2 = new LinkedList<>();
        //op1.add(2);
        //op1.add(1);
        //op1.add(7);
        op1.add(8);
        op2.add(5);
        op2.add(9);
        op2.add(6);

        System.out.println(bn.sum(op1,op2));
    }
}
