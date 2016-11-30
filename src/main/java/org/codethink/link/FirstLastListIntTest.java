package org.codethink.link;

import org.junit.Test;

/**
 * 
 * 链接点实现双端链表数据结构
 * 
 * 双端链表特殊的地方(实现结构时要着重考虑)是含有两个链接点，分别是链表头和链表尾链接点，
 * 如果链表中只有一个链接点则表头表尾都指向这个链接点，如果没有链接点，则表头表尾链接点都是null。
 * 
 * 双端链表的算法复杂度：在链表头插入、链表头删除、链表尾插入数据项操作的时间复杂度是O(1)
 * 链表尾删除数据项操作、查找和删除和在指定链接点后面插入数据项的操作的时间复杂度是O(N)
 * @author CaiXiangNing
 * @date 2016年11月29日
 * @email caixiangning@gmail.com
 */
public class FirstLastListIntTest {
	
	//链表中基础数据链接点
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
	
	//链接点实现双端链表数据结构
	class LinkList{
		
		// 双端链表包含两个链接点，分别是对链表中第一个和最后一个链接点的引用
		private Link firstLink;
		private Link lastLink;
		
		/**
		 * 在链表头插入一个链接点(需要考虑链表为空的情况)
		 * 操作：创建一个新链接点，将新链接点的nextLink指向原链表头的链接点，
		 * 然后更新链表头的链接点为新创建的链接点即可。
		 * @param iData
		 */
		public void insertFirstLink(int iData){
			Link newLink = new Link(iData);
			if(this.isEmpty()){
				this.lastLink = newLink;
			}
			else{
				newLink.nextLink = this.firstLink;
			}
			this.firstLink = newLink;
		}
		
		/**
		 * 在链表尾插入一个链接点(需要考虑链表为空的情况)
		 * 操作：创建一个新链接点，将原链表的链尾链接点的nextLink指向新的链接点，
		 * 然后更新链表尾的链接点为新创建的链接点即可。
		 * @param iData
		 */
		public void insertLastLink(int iData){
			Link newLink = new Link(iData);
			if(this.isEmpty()){
				this.firstLink = newLink;
			}
			else{
				lastLink.nextLink = newLink;
			}
			this.lastLink = newLink;
		}
		
		/**
		 * 在链表头删除一个链接点(需要考虑链表中只有一个元素的情况)
		 * 操作：将链表头的链接点指向链表头链接点的nextLink指向的第二个链接点即可。
		 */
		public Link deleteFirstLink(){
			Link firstLink = this.firstLink;
			// 如果链表中只有一个元素
			if(firstLink.nextLink == null){
				lastLink = null;
			}
			this.firstLink = firstLink.nextLink;
			return firstLink;
		}
		
		/**
		 * 遍历双端链表中所有数据项(从链表头开始遍历输出链表中所有的链接点)
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
		
		// 双端链表是否为空
		public boolean isEmpty(){
			return this.firstLink == null;
		}
	}
	
	// 双端链表的测试方法
	@Test
	public void testLinkList(){
		// 创建空的单链表
		LinkList linkList = new LinkList();
		
		// 在链表头插入链接点
		linkList.insertFirstLink(60);
		linkList.insertFirstLink(80);
		linkList.insertFirstLink(20);
		
		// 在链表尾插入链接点
		linkList.insertLastLink(70);
		linkList.insertLastLink(50);
		linkList.insertLastLink(90);
		
		// 遍历链表
		linkList.displayLink();
		System.out.println();
		
		// 链表头执行删除操作并输出删除的链接点
		while(!linkList.isEmpty()){
			Link deleteLink = linkList.deleteFirstLink();
			System.out.print("Deleted Link: ");
			deleteLink.displayLink();
			System.out.println();
		}
	}
}
