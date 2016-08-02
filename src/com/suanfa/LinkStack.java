package com.suanfa;

/**
 * 栈链表  ： 栈数据结构是先进后出. 为什么用链表进行装载节点？？？因为链表可以动态规划栈的容量
 * @author dell
 * 
 * 1.入栈  当i=0 时, next 节点指针为null
 * 
 * 2.入栈 当i=1...n. next 节点指针指向前一个节点
 *
 */

public class LinkStack {
	
	
	private Node top;   //指向顶点指针
	
	private int size;    //栈容量
	
	public  <T>  void push(T data)  //入栈数据节点
	{
		 top = new Node(data,top);
		 size ++;
	}
	
    //出栈
	public  void pop()
	{
		Node old = top;  //出栈的节点
		top = old.next;
	    old.next = null;  //解除关系
	    size--;
	}
	
	//容量
	public int container()
	{
		return size;
	}
	
	
	//获取顶点数据
	public void getTopData()
	{
		System.out.println(top.getData().toString());
	}
	
	
	//得到所有的数据
	public void getAllData()
	{
		Node current = top;  //得到当前节点
		if(current !=null)
		{
			while(current!=null)  //遍历所有的节点
			{
				System.out.println(current.data.toString());
				current=current.next;
			}
		}
		
	}
	
	

	/**
	 * 测试代码
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
    	//System.out.println("....数量..."+container);
    	link.getAllData();
    	link.getTopData();
		
	}
	

}
