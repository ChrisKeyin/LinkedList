package DoubleLinkedList;

/**
 * DoubleLinkedList class implements a doubly linked list data structure.
 * It provides basic operations such as insertion, deletion, traversal (forward and reverse), and search.
 * Each node contains references to both the next and previous nodes, allowing bidirectional traversal.
 */
public class DoubleLinkedList {
    // Reference to the first node in the linked list
    public DoubleNode head;
    
    // Reference to the last node in the linked list
    public DoubleNode tail;
    
    // Current number of nodes in the linked list
    public int size;

    /**
     * Creates a new doubly linked list with a single node.
     * Initializes head, tail, and size.
     * 
     * @param nodeValue the value to store in the node
     * @return the head node of the new list
     */
    public DoubleNode createLinkedList(int nodeValue) {
        DoubleNode node = new DoubleNode();
        node.next = null;
        node.previous = null;
        node.value = nodeValue;
        // Set head and tail to the new node, as it's the only node
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    /**
     * Inserts a new node with the given value at the specified location.
     * If the list is empty, creates a new list.
     * Location 0 inserts at the beginning, location >= size inserts at the end.
     * Updates both next and previous pointers to maintain bidirectional links.
     * 
     * @param nodeValue the value to store in the new node
     * @param location the index where the node should be inserted
     */
    public void insertLinkedList(int nodeValue, int location) {
        DoubleNode node = new DoubleNode();
        node.value = nodeValue;

        // If list is empty, create a new list
        if (head == null) {
            createLinkedList(nodeValue);
            return;

        } else if (location == 0) {
            // Insert at the beginning
            node.previous = null;
            node.next = head;
            head.previous = node;
            head = node;

        } else if (location >= size) {
            // Insert at the end
            node.next = null;
            node.previous = tail;
            tail.next = node;
            tail = node;

        } else {
            // Insert at the specified location
            DoubleNode tempNode = head;
            int index = 0;

            // Traverse to the node before the insertion point
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }

            DoubleNode nextNode = tempNode.next;

            // Update pointers for the new node
            node.previous = tempNode;
            node.next = nextNode;

            // Update pointers for surrounding nodes
            tempNode.next = node;
            nextNode.previous = node;
        }

        size++;
    }

    /**
     * Traverses and prints all values in the linked list from head to tail.
     * Displays values separated by " <-> " for visual representation of bidirectional links.
     */
    public void traverseLinkedList() {
        // Check if list is empty
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            // Traverse from head to tail and print each value
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                // Add bidirectional separator between values, except after the last value
                if (i != size - 1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        }
    }

    /**
     * Traverses and prints all values in the linked list from tail to head (reverse order).
     * This demonstrates the advantage of a doubly linked list - efficient reverse traversal.
     */
    public void reverseTraverseLinkedList() {
        // Check if list is empty
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            // Traverse from tail to head (in reverse) and print each value
            DoubleNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                // Add arrow separator between values, except after the last value
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.previous;
            }
            System.out.println("\n");
        }
    }

    /**
     * Searches for a node with the specified value in the linked list.
     * 
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean search(int value) {
        // Return false if list is empty
        if (head == null) return false;

        // Traverse the list and search for the value
        DoubleNode tempNode = head;
        while (tempNode != null) {
            if (tempNode.value == value) return true;
            tempNode = tempNode.next;
        }
        return false;
    }

    /**
     * Deletes the node at the specified location from the linked list.
     * Updates both next and previous pointers to maintain list integrity.
     * Handles special cases for deletion at the beginning, end, and middle of the list.
     * 
     * @param location the index of the node to delete
     */
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