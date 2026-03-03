package LinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createSingleLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        }
    }

    public boolean search(int value) {
        if (head == null) return false;

        Node tempNode = head;
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
            head = head.next;
            size--;

            if (size == 0) {
                tail = null;
            }
            return;
        }

        Node tempNode = head;
        int index = 0;

        while (index < location - 1) {
            tempNode = tempNode.next;
            index++;
        }

        tempNode.next = tempNode.next.next;
        size--;


        if (location == size) {
            tail = tempNode;
        }
    }
}