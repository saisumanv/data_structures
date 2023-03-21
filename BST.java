/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    public int data;
    public Node left,right;
    public Node(int d){
        data = d;
        left = null;
        right = null;
    }
}


/* Name of the class has to be "Main" only if the class is public. */
class BST
{
    public static int size=0;
    public static Node root = null;
    public static boolean nextLevel = false;
    public static int level=0;
    //constructor
    public BST(int d){
        root = new Node(d);
        size++;
    }
    
    
    public void insert(int d){
        
        if(size==0){
            new BST(d);
            return;
        }
        Node newNode = new Node(d);
        Node current = root;
        while(current!=null){
        if(current.data < newNode.data){
            if(current.right == null){
                current.right = newNode;
                size++;
                return;
            }
            if(current.right!=null){
                current = current.right;
            }
        }
        if(current.data > newNode.data){
            if(current.left == null){
                current.left = newNode;
                size++;
                return;
            }
            if(current.left!=null){
                current = current.left;
            }
        }
        }
        
    }
    public void delete(int d){
        Node leftParent = null;
        Node rightParent =null;
        Node current= root;
        while(current!=null){
            //System.out.println(current.data);
            
        if(current.data==d){
          
            //node with no children
            if(current.left==null&&current.right==null){
            //current=null; //doesnt work
            if(leftParent!=null){
            leftParent.left=null;
            }
            if(rightParent!=null){
                rightParent.right=null;
            }
             
            return;
            }
            //node has only one child in left subtree
            if(current.left!=null&&current.right==null){
                 
                leftParent.left = null;
                leftParent.left = current.left;
                return;
            }
            //node has only one child in right subtree
            if(current.right!=null&&current.left==null){
               
                rightParent.right = null;
                rightParent.right = current.right;
                return;
            }
            //node has two children
            if(current.left !=null&&current.right!=null){
                  //find min element in right subtree
                
                Node min = current.right;
                //if minimum element found
                
                min = findMin(min);
               
                current.data = min.data;
                min = null;
               return;
                
            }
            
        }
        if(current.data < d){
            
           
            if(current.right!=null){
            rightParent=current;
            
            current = current.right;
            }
            else{
            System.out.println("Not found");
            return;
            }
        }
        else{
            if(current.left!=null){
            leftParent=current;
            
            current= current.left;
           
            }
            else{
            System.out.println("Not found");
            return;
            }
        }
        
        }//end while
       
    }
    public Node findMin(Node min){
        
        if(min==null)
        return null;
        if(min.left!=null)
        findMin(min.left);
        return min;
        
    }
    public void printBST(Node node){
        if(node==null)
        return;
       
        System.out.print(node.data+" ");
       
        
        printBST(node.left);
        printBST(node.right);
        
    }
    public void breadthFirst(){
        Queue<Node> queue = new LinkedList() ;
       if (root == null)
        return;
        
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.data+" ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            
        }
   
       
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BST tree = new BST(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		tree.insert(0);
		
	    //tree.delete(4);
	   
	    tree.printBST(root);
		System.out.println();
		tree.breadthFirst();

		
	}
}
