package com.tx;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Tree
{

	private final Node<Info> rootElement; // 根节点 <一棵树一定要有根节点>

	/**
	 * tree 构造函数
	 */

	public Tree() // 构造一个带有根节点树
	{
		this.rootElement = new Node<Info>(null, null);
	}

	/**
	 * 遍历树节点 @Title: TraversalTree @Description: TODO(这里用一句话描述这个方法的作用) @param
	 * 参数 @return void 返回类型 @throws
	 */

	public int allNode(Node<Info> rootNode, int count)
	{
		int rootSize = rootNode.getChildren().size();
		rootSize += count;
		if (rootNode.children.size() > 0)
		{
			for (Node<Info> subNode : rootNode.children)
			{
				rootSize = allNode(subNode, rootSize);
			}
		}

		return rootSize;

	}

	public JSONObject traversalNodes(Node<Info> rootNode, int depath, JSONObject jsonObj)
	{
	
		jsonObj.put("name", rootNode.getValue().getFileName());
		jsonObj.put("type", rootNode.getValue().getType());
		jsonObj.put("level", depath);
		depath++;
		JSONArray jsonArray = new JSONArray();
		if (rootNode.children.size() > 0)
		{

			for (Node<Info> subNode : rootNode.children)
			{
				JSONObject obj = new JSONObject();

				JSONObject result = traversalNodes(subNode, depath, obj);

				jsonArray.add(result);
				
				jsonObj.put("child", jsonArray);
			}
			

		} else
		{
		    if(rootNode.getValue().getType().equals("dir"))
		    {
		    	jsonObj.put("child", jsonArray);
		    }
		    

		}

		return jsonObj;

	}

	public Node<Info> getRootElement()
	{
		return rootElement;
	}

	public static class Node<Info>
	{

		private Set<Node<Info>> children; // 子节点

		private Node<Info> parent; // 父节点

		private Info value; // 节点<数据对象>

		@SuppressWarnings("unchecked")
		Node(Info value, Node<Info> parent)
		{
			this.value = value;
			this.parent = parent;
			this.children = new LinkedHashSet<Node<Info>>(); // 子节点
		}

		public List<Node<Info>> getChildren()
		{
			return new ArrayList<Node<Info>>(this.children);
		}

		public Node<Info> getParent()
		{
			return parent;
		}

		public Info getValue()
		{
			return value;
		}

		public void setValue(final Info value)
		{
			this.value = value;
		}

		public Node<Info> addChild(final Info value)
		{

			Node<Info> node = new Node<Info>(value, this); // 添加一个节点

			if (this.children.add(node))
			{
				return node;
			} else
			{
				Node<Info> self = this; // 得到父亲节点
				List<Node<Info>> childrens = self.getChildren(); // 得到所有的子节点
				Node<Info> tmp = null;
				for (Node<Info> node2 : childrens)
				{
					if (node.equals(node2))
					{
						tmp = node2;
						break;
					}
				}

				return tmp;

			}

		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (value == null)
			{
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

	}

}
