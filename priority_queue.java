/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.*;





/* Name of the class has to be "Main" only if the class is public. */
class Heap
{	public static int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 17};
    
    public static void maxHeapify(int i){
        
        //find the children
        int left = 2 *i +1;
        int right = 2 * i + 2;
        int greatestChild;
        
        if(left>array.length){
            return;
        }
        if(right<array.length){
        //find the greateschild
        if(array[left]>array[right]){
        
        greatestChild = left;
        
        }    
        else {
            greatestChild = right;
        }
        
        }
        else{
            greatestChild = left;
        }
        //now compare if graetest child is greater than parent i
        if(array[greatestChild]>array[i]){
            //greatest child  of element at i is greater than it
            //so switch the parent-child
            int temp = array[i];
            array[i] = array[greatestChild];
            array[greatestChild]= temp;
        }
        else{
            return;
        }
        //cheapify the new sub tree having new root 
        maxHeapify(greatestChild);
    }
   public static void minHeapify(int i){
       int left = 2 * i +1;
       int right = 2 * i + 2;
       int smallestChild;
       
       if(left>array.length){
           return;
       }
       if(right<array.length){
           if(array[left]>array[right]){
               smallestChild = right;
           }
           else{
               smallestChild = left;
           }
       }
       else{
           //left is the only child
           smallestChild = left;
       }
       //if left child is smaller than parent at i then swap them
       if(array[smallestChild]<array[i]){
           
           int temp = array[i];
           array[i]= array[smallestChild];
           array[smallestChild]=temp;
       }
       else{
           return;
       }
       //heapify the new tree from new smallest child
       minHeapify(smallestChild);
       
   }
   public static void checkMin(int index){
       
      
       int parent = (index-1)/2;
      
       if( parent < 0 || index == 0){
           return;
       }
        //check if the parent is larger than the number
       if(array[parent]>array[index]){
           //swap them
           int temp = array[parent];
           array[parent] = array[index];
           array[index] = temp;
       }
       
       checkMin(parent);
       
       
   }
   public static void minInsert(int d){
       int[] tempArray = new int[array.length +1];
       
       for(int i =0;i<array.length;i++){
           tempArray[i] = array[i];
       }
       //insert the new element at the end of the array to preserve the shape
       tempArray[tempArray.length-1] = d;
       array = tempArray;
       
       checkMin(array.length-1);
      
       
   }
   
   
   public static void maxInsert(int d){
       int[] tempArray = new int[array.length +1];
       
       for(int i =0;i<array.length;i++){
           tempArray[i] = array[i];
       }
       //insert the new element at the end of the array to preserve the shape
       tempArray[tempArray.length-1] = d;
       array = tempArray;
       
       checkMax(array.length-1);
       
   }
   public static void checkMax(int index){
       
       int parent = (index-1)/2;
       
       if( parent < 0 || index == 0){
           return;
       }
        //check if the parent is larger than the number
       if(array[parent]<array[index]){
           //swap them
           int temp = array[parent];
           array[parent] = array[index];
           array[index] = temp;
       }
      
       checkMax(parent);
   }
   public static void removeMax(){
       //replace the last element with root
       array[0]= array[array.length-1];
       
       int[] tempArray = new int[array.length-1];
       tempArray = array;
       array = tempArray;
       //heapify from top 
       maxHeapify(0);
   }
   public static void removeMin(){
       //replace the root with last element
       array[0]= array[array.length-1];
       
       int[] tempArray = new int[array.length-1];
       
       
      for(int i=0;i<tempArray.length;i++){
          tempArray[i]=array[i];
           
      }
      
       array = tempArray;
       //heapfy from top
       minHeapify(0);
   }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	
		
	    int mid = (array.length-1)/2;
		//System.out.println("mid : "+mid);
		for(int i=mid;i>=0;i--){
		    //	System.out.println("i : "+i);
		    maxHeapify(i);
		    
		}
		/*
		//max heap starts here
		System.out.print("After max-heapifying : ");
		for(int i =0;i<array.length;i++){
		System.out.print(array[i] + " ");
		}
		
		System.out.println();	
	    maxInsert(15);
	    System.out.println("After a new element in maxHeap : ");
	    for(int i =0;i<array.length;i++){
		System.out.print(array[i] + " ");
		}
		System.out.println();
		removeMax();
		System.out.println("After removing max element : ");
	    for(int i =0;i<array.length;i++){
		System.out.print(array[i] + " ");
		}
		*/
		
		//min heap starts here
		for(int i=mid;i>=0;i--){
		    //	System.out.println("i : "+i);
		    minHeapify(i);
		    
		}
		System.out.println();
		System.out.print("After min-heapifying : ");
		for(int i =0;i<array.length;i++){
		System.out.print(array[i] + " ");
		}
	    System.out.println();	
	    minInsert(12);
	    System.out.println("After a new element in minHeap : ");
	    for(int i =0;i<array.length;i++){
		System.out.print(array[i] + " ");
		}
 		System.out.println();
 		removeMin();
 		System.out.println("After removing min element : ");
 	    for(int i =0;i<array.length;i++){
 		System.out.print(array[i] + " ");
 		}
		
	}
}
