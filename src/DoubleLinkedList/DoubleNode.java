package DoubleLinkedList;

/**
 * DoubleNode class represents a single node in a doubly linked list.
 * Each node contains a value and references to both the next and previous nodes.
 */
public class DoubleNode {
    // The integer value stored in this node
    public int value;
    
    // Reference to the next node in the doubly linked list (null if this is the last node)
    public DoubleNode next;
    
    // Reference to the previous node in the doubly linked list (null if this is the first node)
    public DoubleNode previous;
}