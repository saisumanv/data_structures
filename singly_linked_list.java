/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    public int data;
    public Node next;
    //why need a constructor? Because we have to initialise the data value right? that's why!
    public Node(int d){
        this.data = d;
    }
}



/* Name of the class has to be "Main" only if the class is public. */
class Linkedlist
{
    //initialise a head node first
    Node head;
    int size;
    public Linkedlist(int d){//initialising a single node linked list and 'head'
       head = new Node( d);
    }
    
    public void insertAtEnd(int d){
        Node newNode = new Node(d);
        Node current = head;
       
        while(current.next!=null){
            current = current.next;
            
        }
        current.next = newNode;
        //current = current.next;
        newNode.next = null;
        
    }
    
    public void delete(int d){
        Node current;
        current=head;
        Node temp= null;
        while(current.next!=null){
            
            if(current.data==d){
                //delete the node by de-referencing
                temp.next = current.next;//derefernece it's link from lower order node
                current.next = null;//dereference it's next link
                break;//break out of while
            }
            temp= current;//store the current to use in next ieration while dereferecning
            current = current.next;
        }
        
    }
    
    public void push(int d){
        Node current = new Node(d);//create the current node(new node)
       
        Node temp = head;//place head in temp
        current.next = temp;//link current before temp
        head= current;//now make current as head of the list
        
    }
    
    public void pop(){
        //traverse the list until last node
        Node current = head;
        Node lastButOne =null ;
        while(current.next != null){
            Node temp;
            temp = current;
            current = current.next;
            if(current.next==null){
                lastButOne = temp;
            }
        }
        //reached the last node in the list
        lastButOne.next = null;
    }
    
    public void enqueue(int d){
        Node current = new Node(d);//create the current node(new node)
       
        Node temp = head;//place head in temp
        current.next = temp;//link current before temp
        head= current;//now make current as head of the list
        
    }
    
    public void dequeue(){
        Node current = head;
        Node temp = null;
        while(current.next!=null){
            temp = current;
            current=current.next;
        }
        temp.next = null;
        
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
		Linkedlist list = new Linkedlist(5);
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(7);
		list.delete(2);
		System.out.print("Printing linkedlist elements: ");
		list.printList();
		//stack operations
		Linkedlist stack = new Linkedlist(5);
		
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		stack.pop();
	    stack.pop();
		System.out.print("Printing stack elements: ");
		stack.printList();
		//queue operations
		Linkedlist queue = new Linkedlist(6);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		queue.dequeue();
		System.out.print("Printing queue elements: ");
		queue.printList();
	}
}
