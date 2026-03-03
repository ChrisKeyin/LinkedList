package DoubleLinkedList;

public class DoubleLinkedList {
    public DoubleNode head;
    public DoubleNode tail;
    public int size;

    public DoubleNode createLinkedList(int nodeValue) {
        DoubleNode node = new DoubleNode();
        node.next = null;
        node.previous = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertLinkedList(int nodeValue, int location) {
        DoubleNode node = new DoubleNode();
        node.value = nodeValue;

        if (head == null) {
            createLinkedList(nodeValue);
            return;

        } else if (location == 0) {
            node.previous = null;
            node.next = head;
            head.previous = node;
            head = node;

        } else if (location >= size) {
            node.next = null;
            node.previous = tail;
            tail.next = node;
            tail = node;

        } else {
            DoubleNode tempNode = head;
            int index = 0;

            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }

            DoubleNode nextNode = tempNode.next;

            node.previous = tempNode;
            node.next = nextNode;

            tempNode.next = node;
            nextNode.previous = node;
        }

        size++;
    }

    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        }
    }

    public void reverseTraverseLinkedList() {
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            DoubleNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.previous;
            }
            System.out.println("\n");
        }
    }

    public boolean search(int value) {
        if (head == null) return false;

        DoubleNode tempNode = head;
        while (tempNode != null) {
            if (tempNode.value == value) return true;
            tempNode = tempNode.next;
        }
        return false;
    }

    public void delete(int location) {
        if (head == null) {
            System.out.println("Linked list does not exist");
            return;
        }

        if (location < 0 || location >= size) {
            System.out.println("Invalid location");
            return;
        }

        if (location == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return;
            }
            head = head.next;
            head.previous = null;
            size--;
            return;
        }


        if (location == size - 1) {
            tail = tail.previous;
            tail.next = null;
            size--;
            return;
        }

        DoubleNode tempNode = head;
        int index = 0;
        while (index < location) {
            tempNode = tempNode.next;
            index++;
        }

        tempNode.previous.next = tempNode.next;
        tempNode.next.previous = tempNode.previous;
        size--;
    }
}