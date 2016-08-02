package com.suanfa;


/**
 * ����TreeNode
 * @author dell
 *
 */


public class TraversalTreeNode {
	
	/**
	 *  ������
	 * @return
	 */
	
	static int nodeDeep =0;  //·�������
	
	
	static int rightDeep =0;  //������·��
	
	public static TreeNode<String> init() 
	{  
        TreeNode<String> D = new TreeNode<String>("D", null, null);  
        TreeNode<String> H = new TreeNode<String>("H", null, null);  
        TreeNode<String> I = new TreeNode<String>("I", null, null);  
        TreeNode<String> J = new TreeNode<String>("J", null, null);  
        TreeNode<String> P = new TreeNode<String>("P", null, null);  
        TreeNode<String> G = new TreeNode<String>("G", P, null);  
        TreeNode<String> F = new TreeNode<String>("F", null, J);  
        TreeNode<String> E = new TreeNode<String>("E", H, I);  
        TreeNode<String> B = new TreeNode<String>("B", D, E);  
        TreeNode<String> C = new TreeNode<String>("C", F, G);  
        TreeNode<String> A = new TreeNode<String>("A", B, C);  
        return A;  
    }  
	
	
	/**
	 * �ݹ�Ҫ�㣺����һ���Ǿֲ�������֮ǰ��ȫ�ֱ�������
	 * @param node
	 * @param depth
	 */
	public static <T> void preorder_visit_depth( TreeNode<T> node,int depth)   
    {   
		
		 visitRootNode(node,depth);
         depth++; 
         if (node.getLeftNode()!=null)   
         {   
             preorder_visit_depth(node.getLeftNode(), depth);   
         }  

         if (node.getRightNode()!=null)   
         {   
             preorder_visit_depth(node.getRightNode(), depth);     
         }  

        
     }   
	
	
	/**
	 * 
	 * @param <T>
	 * @param node
	 */
	public static <T> void visitRootNode(TreeNode<T> node,int deep)
	{
		     String mark="->";
	    	 T data = node.getData();
	    	 String markPoint="";
	    	 for(int i=0;i<=deep;i++)
	    	 {
	    		 markPoint+=mark;
	    	 }
	    	 System.out.println(markPoint+data.toString());
	}
	
	public static void main(String[] args) {
		
		 TreeNode<String> init = init();  //�õ����ĸ��ڵ�
		 preorder_visit_depth(init,0);
		
	}
	

}
