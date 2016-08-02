package com.suanfa;


/**
 * ����TreeNode
 * @author dell
 * ��ҪӦ��β�ݹ�
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
	 * ������������ ���̿����ϰ�����
	 * @param <T>
	 */
	
	 public static <T> int maxDepth(TreeNode<T> node)   
     {   
         if (node == null)   
         {   
             return 0;   
         }   
         else   
         {   
             int leftdepth = maxDepth(node.getLeftNode());//�ݹ�������ӵ����   
             int rightdepth = maxDepth(node.getRightNode());//�ݹ�����Һ��ӵ����  

             if (leftdepth >= rightdepth)   
             {   
                 return leftdepth+1;  //�ȱ���������+1.
             }   
             else   
             {   
                 return rightdepth+1; //+1 �Ǳ�ʾ���ڵ�  
             }   
         }   
     }  


	 /**
	  * ���ݵݹ�ԭ���������������
	  * @param node
	  * @param deep
	  * @return
	  */
	 public static <T> int maxDeepLength(TreeNode<T> node,int deep)   
     {   
         if (node == null)   
         {   
             return deep;   
         }   
         else
         {
        	  deep++;
        	  int leftMax = maxDeepLength(node.getLeftNode(), deep);
        	  int rightMax =maxDeepLength(node.getRightNode(), deep);
        	  
        	  //�ݹ���ɺ�����ж�
        	  
        	  if(leftMax>=rightMax)
        	  {
        		  return leftMax;
        	  }
        	  else
        	  {
        		  return rightMax;
        	  }
            
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
		 System.out.println("maxDepth:"+maxDeepLength(init,0));   
	}
	

}
