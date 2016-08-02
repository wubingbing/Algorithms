package com.suanfa;

/**
 * ջ����  �� ջ���ݽṹ���Ƚ����. Ϊʲô���������װ�ؽڵ㣿������Ϊ������Զ�̬�滮ջ������
 * @author dell
 * 
 * 1.��ջ  ��i=0 ʱ, next �ڵ�ָ��Ϊnull
 * 
 * 2.��ջ ��i=1...n. next �ڵ�ָ��ָ��ǰһ���ڵ�
 *
 */

public class LinkStack {
	
	
	private Node top;   //ָ�򶥵�ָ��
	
	private int size;    //ջ����
	
	public  <T>  void push(T data)  //��ջ���ݽڵ�
	{
		 top = new Node(data,top);
		 size ++;
	}
	
    //��ջ
	public  void pop()
	{
		Node old = top;  //��ջ�Ľڵ�
		top = old.next;
	    old.next = null;  //�����ϵ
	    size--;
	}
	
	//����
	public int container()
	{
		return size;
	}
	
	
	//��ȡ��������
	public void getTopData()
	{
		System.out.println(top.getData().toString());
	}
	
	
	//�õ����е�����
	public void getAllData()
	{
		Node current = top;  //�õ���ǰ�ڵ�
		if(current !=null)
		{
			while(current!=null)  //�������еĽڵ�
			{
				System.out.println(current.data.toString());
				current=current.next;
			}
		}
		
	}
	
	

	/**
	 * ���Դ���
	 * @param args
	 */
    public static void main(String[] args) {
    	
    	LinkStack link= new LinkStack();
    	int a =1;
    	int b=2;
    	int c=3;
    	int d=4;
    	int e=5;
    	link.push(a);
    	link.push(b);
    	link.push(c);
    	link.push(d);
    	link.push(e);
    	link.pop();
    	
    	int container = link.container();
    	//System.out.println("....����..."+container);
    	link.getAllData();
    	link.getTopData();
		
	}
	

}
