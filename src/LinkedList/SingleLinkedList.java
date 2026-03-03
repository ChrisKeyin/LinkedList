package LinkedList;

/**
 * SingleLinkedList class implements a singly linked list data structure.
 * It provides basic operations such as insertion, deletion, traversal, and search.
 */
public class SingleLinkedList {
    // Reference to the first node in the linked list
    public Node head;
    
    // Reference to the last node in the linked list
    public Node tail;
    
    // Current number of nodes in the linked list
    public int size;

    /**
     * Creates a new single linked list with a single node.
     * Initializes head, tail, and size.
     * 
     * @param nodeValue the value to store in the node
     * @return the head node of the new list
     */
    public Node createSingleLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
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
     * 
     * @param nodeValue the value to store in the new node
     * @param location the index where the node should be inserted
     */
    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        // If list is empty, create a new list
        if (head == null) {
            createSingleLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            // Insert at the beginning
            node.next = head;
            head = node;
        } else if (location >= size) {
            // Insert at the end
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            // Insert at the specified location
            Node tempNode = head;
            int index = 0;
            // Traverse to the node before the insertion point
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            // Insert the new node
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    /**
     * Traverses and prints all values in the linked list from head to tail.
     * Displays values separated by " -> " for visual representation.
     */
    public void traverseLinkedList() {
        // Check if list is empty
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            // Traverse from head to tail and print each value
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                // Add arrow separator between values, except after the last value
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
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
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.value == value) return true;
            tempNode = tempNode.next;
        }
        return false;
    }

    /**
     * Deletes the node at the specified location from the linked list.
     * Updates head and tail pointers accordingly.
     * 
     * @param location the index of the node to delete
     */
    public void delete(int location) {
        // Check if list is empty
        if (head == null) {
            System.out.println("Linked list does not exist");
            return;
        }

        // Validate the location
        if (location < 0 || location >= size) {
            System.out.println("Invalid location");
            return;
        }

        // Delete from the beginning
        if (location == 0) {
            head = head.next;
            size--;

            // If list becomes empty, set tail to null
            if (size == 0) {
                tail = null;
            }
            return;
        }

        // Delete from the middle or end
        Node tempNode = head;
        int index = 0;

        // Traverse to the node before the deletion point
        while (index < location - 1) {
            tempNode = tempNode.next;
            index++;
        }

        // Remove the node by updating the next pointer
        tempNode.next = tempNode.next.next;
        size--;

        // Update tail if we deleted the last node
        if (location == size) {
            tail = tempNode;
        }
    }
}