package org.codethink.link;

import org.junit.Test;

/**
 * 
 * 单链表实现栈数据结构
 * 
 * @author CaiXiangNing
 * @date 2016年11月30日
 * @email caixiangning@gmail.com
 */
public class LinkStackTest {
	
	// 链表中基础数据链接点
	class Link{
		// 存储链接点的数据
		private int iData;
		// 指向下一个链接点
		private Link nextLink;
		
		// 链表点构造方法
		public Link(int iData) {
			// TODO Auto-generated constructor stub
			this.iData = iData;
		}
		
		// 输出链接点的数据项
		public void displayLink(){
			System.out.print(iData);
		}
	}
	
	// 链接点实现单链表数据结构
	class LinkList{
		
		private Link firstLink;
		
		/**
		 * 在链表头插入一个链接点
		 * 操作：创建链接点，然后将新链接点的nextLink字段指向链表的第一个链接点即可。
		 * @param iData
		 */
		public void insertLink(int iData){
			Link newLink = new Link(iData);
			newLink.nextLink = this.firstLink;
			this.firstLink = newLink;
		}
		
		/**
		 * 在链表头删除一个链接点(该方法假定链表不为空)
		 * 操作：将链表头链接点指向链接点的nextLink字段指向的第二个链接点，断开原链表头链接点和链表的连接。
		 */
		public int deleteLink(){
			Link firstLink = this.firstLink;
			this.firstLink = firstLink.nextLink;
			return firstLink.iData;
		}
		
		/**
		 * 遍历单链表中所有数据项(从链表头开始遍历输出链表中所有的链接点)
		 * 
		 */
		public void displayLink(){
			System.out.print("Link(firstLink --> lastLink): ");
			Link currentLink = this.firstLink;
			while(currentLink != null){
				System.out.print(currentLink.iData + " ");
				currentLink = currentLink.nextLink;
			}
		}
		
		// 单链表是否为空
		public boolean isEmpty(){
			return this.firstLink == null;
		}
	}
	
	/**
	 * 单链表实现栈的数据结构
	 * @author Cai
	 *
	 */
	class LinkStack{
		private LinkList linkList;
		
		public LinkStack() {
			// TODO Auto-generated constructor stub
			linkList = new LinkList();
		}
		
		/**
		 * 入栈：栈的入栈操作相当于在链表头插入链接点
		 * @param iData
		 */
		public void push(int iData){
			linkList.insertLink(iData);
		}
		
		/**
		 * 出栈：栈的出栈操作相当于在链表头删除链接点
		 * @return
		 */
		public int pop(){
			return linkList.deleteLink();
		}
		
		/**
		 * 栈是否为空
		 * @return
		 */
		public boolean isEmpty(){
			return linkList.isEmpty();
		}
		
		/**
		 * 遍历并输出栈中所有元素
		 */
		public void displayStack(){
			System.out.println("栈从栈顶到栈底输出所有数据项：");
			linkList.displayLink();
			System.out.println();
		}
	}
	
	// 链表实现栈的数据结构的测试方法
	@Test
	public void testLinkStack(){
		// 创建一个栈
		LinkStack linkStack = new LinkStack();
		
		// 对栈进行入栈操作
		linkStack.push(20);
		linkStack.push(40);
		linkStack.push(60);
		linkStack.push(80);

		// 遍历并输出栈中所有元素
		linkStack.displayStack();
		
		// 对栈进行出栈操作
		linkStack.pop();
		linkStack.pop();
		
		// 遍历并输出栈中所有元素
		linkStack.displayStack();
	}
}
