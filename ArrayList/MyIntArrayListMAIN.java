import java.util.ArrayList;

public class MyIntArrayListMAIN {
    public static void main(String[] args) {
        MyIntArrayList test = new MyIntArrayList();
        test.add(2);
        test.add(3);
        MyIntArrayList test2 = new MyIntArrayList(test);
        test2.addAll(test);
        test2.add(1,13);
        MyIntArrayList test3 = new MyIntArrayList();
        test3.add(50);
        test3.add(39);
        test3.add(21);
        test2.addAll(3, test3);
        System.out.println(test2.size());
        for (int i = 0; i < test2.size(); i++) {
            System.out.println(test2.get(i));
        }
    }
}
