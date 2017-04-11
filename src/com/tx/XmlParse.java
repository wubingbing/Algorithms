package com.tx;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.tx.Tree.Node;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class XmlParse
{

	private static Logger logger = Logger.getLogger(XmlParse.class);

	@Test
	public void testXml() throws DocumentException
	{

		SAXReader reader = new SAXReader();
		File file = new File("src\\read\\node.xml");
		Document document = reader.read(file);
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		Map<String, Tree> map = new HashMap<String, Tree>();//

		Node<Info> addChild = null;

		for (Element element : childElements)
		{
			if (!element.getText().contains("\\")) // 构造一个多叉树
			{
				Tree tree = new Tree(); // 创建一颗树
				Node<Info> rootElement = tree.getRootElement();
				Info info = new Info(element.getText().toString(), element.attributeValue("type").toString());
				rootElement.setValue(info);
				map.put(element.getText(), tree);
			} else
			{
				String[] str = element.getText().split("\\\\");

				if (map.containsKey(str[0]))
				{
					Tree tree = map.get(str[0]); // 得到树对象

					Node<Info> rootElement = tree.getRootElement();// 得到根路径

					int length = str.length;

					for (int i = 1; i < length; i++)
					{
						Info info = null;
						if (i == length - 1)
						{
							info = new Info(str[i], element.attributeValue("type").toString());
						} else
						{
							info = new Info(str[i], "dir");
						}

						if (i == 1)
						{
							addChild = rootElement.addChild(info); 
						} else
						{
							Node<Info> newNode = addChild.addChild(info);
							addChild = null; // 清空
							addChild = newNode;
						}

					}

				}

			}

		}

		Set<String> keySet = map.keySet();
		
		if(!keySet.isEmpty())
		{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", "ProjectName");
			jsonObj.put("type", "dir");
			jsonObj.put("level", 1);
			
			JSONArray jsonArray = new JSONArray();
			
			for (String str : keySet)
			{

				System.out.println("key $$ :" + str);

				Tree tree = map.get(str);

				JSONObject jsonObjTwo = new JSONObject();
				
				Node<Info> rootElement = tree.getRootElement();

				Info value = rootElement.getValue();
				
				JSONObject jsonNodes = tree.traversalNodes(rootElement, 2,jsonObjTwo);
				jsonArray.add(jsonNodes);
			
			}
			
			jsonObj.put("child", jsonArray);
			
			System.out.println(jsonObj.toString());
			
		}
		
		
		

	}

}
