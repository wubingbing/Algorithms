package com.suanfa;


/**
 * ���ֵݹ����
 * @author dell
 *
 */
public class BinarySearchRecursion {
	
	/**
	 * ���ֲ���
	 * @param args
	 */
	private static final int  zero =0;
	private static final int  one =1;
	//8,9,11,15,18,20,22,26
	
	public static void main(String[] args) {
		
		int[] a={2,9,11,15,18,20,22,26}; //��ʼֵ
		int startIndex = zero;
		int endIndex = a.length-1; 
		int key = 23;  
		binarySearchRecursion(a,startIndex,endIndex,key);
		
	}


	private static void binarySearchRecursion(int[] a, int startIndex, int endIndex, int key) {
	
		int middleIndex=(startIndex + endIndex)/2;  //�м�ָ��
		
		//middleIndex ���ֵ endIndex-1;
		
		if(a[endIndex]==key)
		{
			System.out.println("�ҵ�..��β."+endIndex);
		}
		//middleIndex ���ֵ endIndex-1;
		else if(endIndex-startIndex==1 &&key!=a[middleIndex])  
		{
			System.out.println("...�Ҳ���....");
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
			System.out.println("...�ҵ��˽ű�..."+middleIndex);
		}
		
		
	}


	
	

}
