package com.suanfa;

/**
 * 
 * @author dell
 * ½Úµã Node
 *
 */

public class Node<T> {
	
	public Node next;
	
	public T data;
	
	public Node(T data,Node next)
	{
		this.next = next;
		this.data =data;
	
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
