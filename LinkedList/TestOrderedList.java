package LinkedList;

public class TestOrderedList {
    public static void main(String[] args) {
        OrderedList<Town> orderedTownList = new OrderedList<Town>();
        Town t1 = new Town("Timisoara", 100);
        Town t2 = new Town("Arad", 150);
        Town t3 = new Town("Bucuresti", 0);
        Town t4 = new Town("Ploiesti", 30);

        orderedTownList.addInOrderedList(t1);
        orderedTownList.addInOrderedList(t2);
        orderedTownList.addInOrderedList(t3);
        orderedTownList.addInOrderedList(t4);

        System.out.println(orderedTownList);

    }
}
