package org.codethink.link;

import org.junit.Test;

/**
 * 
 * 双端链表实现队列数据结构
 * @author CaiXiangNing
 * @date 2016年11月29日
 * @email caixiangning@gmail.com
 */
public class LinkQueueTest {
	
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
	
	// 链接点实现双端链表数据结构
	class LinkList{
		
		// 双端链表包含两个链接点，分别是对链表中第一个和最后一个链接点的引用
		private Link firstLink;
		private Link lastLink;
		
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
		public int deleteFirstLink(){
			Link firstLink = this.firstLink;
			// 如果链表中只有一个元素
			if(firstLink.nextLink == null){
				lastLink = null;
			}
			this.firstLink = firstLink.nextLink;
			return firstLink.iData;
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
	
	/**
	 * 双端链表实现队列数据结构
	 * @author Cai
	 *
	 */
	class LinkQueue{
		private LinkList linkList;
		
		public LinkQueue() {
			// TODO Auto-generated constructor stub
			this.linkList = new LinkList();
		}
		
		/**
		 * 插入数据项：队列的插入操作相当于在链表尾插入数据项
		 * @param iData
		 */
		public void insert(int iData){
			linkList.insertLastLink(iData);
		}
		
		/**
		 * 删除数据项：队列的移除操作先当与在链表头删除数据项
		 * @return
		 */
		public int remove(){
			return linkList.deleteFirstLink();
		}
		
		/**
		 * 队列是否为空
		 * @return
		 */
		public boolean isEmpty(){
			return linkList.isEmpty();
		}
		
		/**
		 * 遍历并输出队列中所有元素
		 */
		public void displayQueue(){
			System.out.println("队列从队头到队尾输出所有数据项：");
			linkList.displayLink();
			System.out.println();
		}
	}
	
	// 双端链表实现队列数据结构的测试方法
	@Test
	public void testLinkQueue(){
		// 创建空的队列
		LinkQueue linkQueue = new LinkQueue();
		
		// 在队列中插入数据项
		linkQueue.insert(20);
		linkQueue.insert(40);
		linkQueue.insert(60);
		linkQueue.insert(80);

		// 遍历并输出队列中所有元素
		linkQueue.displayQueue();
			
		// 在队列中移除数据项
		linkQueue.remove();
		linkQueue.remove();
			
		// 遍历并输出栈中所有元素
		linkQueue.displayQueue();
	}
}
