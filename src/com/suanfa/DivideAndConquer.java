package com.suanfa;

import java.util.Arrays;

/**
 * 归并排序
 * @author dell
 * 
 */
public class DivideAndConquer {
	
   private static final int  zero =0;
   private static final int  one =1;
   
   public static void main(String[] args) 
   {
	
	    int [] a={2,8,3,0,4,9}; //数组
	    int startIndex =zero;
	    int endIndex = a.length-one;
	    
	    divide(a,startIndex,endIndex);
	    
	    for (int i : a) {
			System.out.println(i);
		}
	    
   }

   private static void divide(int[] a, int startIndex, int endIndex) 
   {
	   if(startIndex<endIndex)
	   {
		   int middleIndex=(endIndex+startIndex)/2;
		   
		   divide(a,startIndex,middleIndex); //左边继续分解
		   divide(a,middleIndex+1,endIndex); //右边继续分解
		   conquer(a,startIndex,middleIndex,endIndex);
		   
	   }
   }

   private static void conquer(int[] a, int startIndex, int middleIndex, int endIndex) {
	   
	   int[] leftArray=Arrays.copyOfRange(a, startIndex, middleIndex+one); //obtain left array
	   
	   int[] rightArray = Arrays.copyOfRange(a, middleIndex+one, endIndex+one);
	     
	   int k=startIndex;
	   
	   int i = 0,j=0;
	   
	   while(i<leftArray.length&&j<rightArray.length)  
	   {
		   if(leftArray[i]<rightArray[j])
			   a[k++]=leftArray[i++];
		   else
			   a[k++]=rightArray[j++];
			   
	   }
	   while(i<leftArray.length)
	   {
		   a[k++]=leftArray[i++];
	   }
	   
	   while(j<rightArray.length)
	   {
		   a[k++] = rightArray[j++];
	   }
	   
	   
   }
   

}
