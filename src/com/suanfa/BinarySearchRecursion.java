package com.suanfa;


/**
 * 二分递归查找
 * @author dell
 *
 */
public class BinarySearchRecursion {
	
	/**
	 * 二分查找
	 * @param args
	 */
	private static final int  zero =0;
	private static final int  one =1;
	//8,9,11,15,18,20,22,26
	
	public static void main(String[] args) {
		
		int[] a={2,9,11,15,18,20,22,26}; //初始值
		int startIndex = zero;
		int endIndex = a.length-1; 
		int key = 23;  
		binarySearchRecursion(a,startIndex,endIndex,key);
		
	}


	private static void binarySearchRecursion(int[] a, int startIndex, int endIndex, int key) {
	
		int middleIndex=(startIndex + endIndex)/2;  //中间指针
		
		//middleIndex 最大值 endIndex-1;
		
		if(a[endIndex]==key)
		{
			System.out.println("找到..结尾."+endIndex);
		}
		//middleIndex 最大值 endIndex-1;
		else if(endIndex-startIndex==1 &&key!=a[middleIndex])  
		{
			System.out.println("...找不到....");
		}
		
		else if(key>a[middleIndex])
		{
			binarySearchRecursion(a,middleIndex,endIndex, key);
			
		}
		
		else if(key<a[middleIndex])
		{
			binarySearchRecursion(a,startIndex,middleIndex, key);
		}
		
		else if(key==a[middleIndex])
		{
			System.out.println("...找到了脚标..."+middleIndex);
		}
		
		
	}


	
	

}
