package LinkedList;

import DoubleLinkedList.DoubleLinkedList;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList sll = new SingleLinkedList();
        sll.insertLinkedList(1, 0);sll.insertLinkedList(2, 1);
        sll.insertLinkedList(3, 2);
        sll.insertLinkedList(4, 3);

        System.out.println("Single list:");
        sll.traverseLinkedList();

        System.out.println("Search 3 (expect true): " + sll.search(3));
        System.out.println("Search 99 (expect false): " + sll.search(99));

        System.out.println("Delete index 2 (removes value 3):");
        sll.delete(2);
        sll.traverseLinkedList();



        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertLinkedList(10, 0);
        dll.insertLinkedList(20, 1);
        dll.insertLinkedList(30, 2);
        dll.insertLinkedList(40, 3);

        System.out.println("Double list:");
        dll.traverseLinkedList();

        System.out.println("Reverse traverse:");
        dll.reverseTraverseLinkedList();

        System.out.println("Search 30 (expect true): " + dll.search(30));
        System.out.println("Search 999 (expect false): " + dll.search(999));

        System.out.println("Delete index 1 (removes value 20):");
        dll.delete(1);
        dll.traverseLinkedList();
    }
}