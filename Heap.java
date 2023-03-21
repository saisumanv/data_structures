/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;






/* Name of the class has to be "Main" only if the class is public. */
class Heap
{	public static int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    
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
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	
		
	    int mid = (array.length-1)/2;
		//System.out.println("mid : "+mid);
		for(int i=mid;i>=0;i--){
		    //	System.out.println("i : "+i);
		    maxHeapify(i);
		    
		}
		System.out.print("After max-heapifying : ");
		for(int i =0;i<array.length;i++){
		System.out.print(array[i] + " ");
		}
		for(int i=mid;i>=0;i--){
		    //	System.out.println("i : "+i);
		    minHeapify(i);
		    
		}
		System.out.println();
		System.out.print("After min-heapifying : ");
		for(int i =0;i<array.length;i++){
		System.out.print(array[i] + " ");
		}
		
	}
}
