package com.suanfa;


//二叉树节点
public class TreeNode<T> {
	
	
	 private T data;    //数据
     private TreeNode<T> leftNode;  //左子树  
     private TreeNode<T> rightNode;  //右子树
	
     public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {  
         this.data = data;  
         this.leftNode = leftNode;  
         this.rightNode = rightNode;  
     }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}  
     
     

}
