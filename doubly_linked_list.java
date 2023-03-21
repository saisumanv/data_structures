/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    public int data;
    public Node next,prev;
    //why need a constructor? Because we have to initialise the data value right? that's why!
    public Node(int d){
        this.data = d;
    }
}



/* Name of the class has to be "Main" only if the class is public. */
class Linkedlist
{
    //initialise a head node first
    Node head,tail;
    int size;
    public Linkedlist(int d){//initialising a single node linked list and 'head'
       head = new Node( d);
       tail = head;
    }
    
    public void insertAtEnd(int d){
       
        Node current = new Node(d);
        Node temp = tail;
        temp.next = current;
        current.prev = temp;
        tail = current;
        tail.next = null;
        
    }
    
    public void delete(int d){
       Node current = head;
       Node left = null;
       Node right = null;
      
       while(current.next!=null){
           right = current.next;
           if(current.data == d){
               current.next = null;
               current.prev = null;
               left.next = right;
               right.prev = left;
               break;//put a break otherwise we will have nullpointerexception because we just made current.next =null above
           }
           left = current;
           current = current.next;
           
       }
        
    }
    
    public void push(int d){
       Node temp;
       Node current = new Node(d);
       temp = head;
       temp.prev = current;
       current.next = temp;
       head = current;
    }
    
    public void pop(){
       
       Node current = head.next;
       head.next = null;
       current.prev = null;
       head = current;
       
       
    }
    
    public void enqueue(int d){
       Node temp;
       Node current = new Node(d);
       temp = head;
       temp.prev = current;
       current.next = temp;
       head = current;
    }
    
    public void dequeue(){
        Node temp = tail;
        Node current = tail.prev;
        current.next = null;
        tail.prev = null;
        tail = current;
    }
    
    public void printList(){
        
        Node current = head;
        while(current.next != null){
            System.out.print(current.data + " ");
            current=current.next;
        }
        System.out.println(current.data + " ");//print the last elemtn
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// normal linked list operations
		Linkedlist list = new Linkedlist(4);
		list.insertAtEnd(2);
		list.insertAtEnd(0);
		list.insertAtEnd(5);
	    list.delete(0);
		list.printList();
	
	    //stack operations
	    Linkedlist stack = new Linkedlist(4);
	    stack.push(5);
	    stack.push(8);
	    stack.push(7);
	    stack.pop();
	    stack.push(77);
	    stack.printList();
	    
	    //queue operations
	    Linkedlist queue = new Linkedlist(3);
	    queue.enqueue(8);
	    queue.enqueue(8);
	    queue.enqueue(7);
	    queue.dequeue();
	    queue.enqueue(9);
	    queue.dequeue();
	    queue.printList();
	}
}
