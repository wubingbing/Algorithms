package com.suanfa;

public class InserSort {
	
	
	public static void main(String[] args) {
		
		int a[]={4,5,1,3,9,2,0};
		
		int[] sortArray = insertSort(a);
		for (int i = 0; i < sortArray.length; i++) {
			
			System.out.println(sortArray[i]);
		}
	}

	private static int[] insertSort(int[] a) {
		
		for(int j=1;j<a.length;j++)
		{
			int key =a[j];  //第二个数
			int i =j-1; //第一个数
			while(i>=0 && a[i]>key)
			{
				a[i+1] =a[i];
				i=i-1;
			}
			
			a[i+1]=key;
			
		}
		return a;
		
	}
	

}
