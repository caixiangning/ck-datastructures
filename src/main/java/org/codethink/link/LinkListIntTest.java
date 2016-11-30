package org.codethink.link;

import org.junit.Test;

/**
 * 
 * 链接点实现单链表数据结构
 * 单链表可进行操作：在链表头插入一个数据项、在链表头删除一个数据项、遍历链表显示内容
 * 查找指定数据项的链接点、删除指定数据项的链接点
 * 
 * 单链表的算法复杂度：在链表头插入和删除数据项操作的时间复杂度是O(1)
 * 查找和删除和在指定链接点后面插入数据项的操作的时间复杂度是O(N)
 * @author CaiXiangNing
 * @date 2016年11月28日
 * @email caixiangning@gmail.com
 */
public class LinkListIntTest {
	
	
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
		// 单链表只包含一个链接点，即对链表中的一个链接点的引用
		// 这个链接点是链表唯一需要维护的信息，用来定位其他的链接点，从该链接点出发可以定位到其他链接点
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
		public Link deleteLink(){
			Link firstLink = this.firstLink;
			this.firstLink = firstLink.nextLink;
			return firstLink;
		}
		
		/**
		 * 在链表中查找指定数据项的链接点
		 * 操作：从链表的链表头链接点开始遍历链表直到找到待检索的数据项，
		 * 如果遍历到链表的链表尾仍未找到，则返回null，表明链表中无此数据项。
		 * @param key
		 * @return
		 */
		public Link findKeyLink(int key){
			Link currentLink = this.firstLink;
			while(currentLink.iData != key){
				// 到达链表的链尾
				if(currentLink.nextLink == null){
					return null;
				}
				// 当前链接点指向下一个链接点
				else{
					currentLink = currentLink.nextLink;
				}
			}
			return currentLink;
		}
		
		/**
		 * 在链表中删除指定数据项的链接点(补充)
		 * 从链表的链表头链接点开始遍历链表直到找到待检索的数据项，如果遍历到链表的链表尾仍未找到，则返回null，
		 * 表明链表中无此数据项。如果找到指定数据项则将检索到数据项所在的链接点的上一个链接点的nextLink指向检索到
		 * 的链接点的nextLink指向的链接点即可。
		 * @param key
		 * @return
		 */
		public Link deleteKeyLink(int key){
			// 当前链接点和当前链接点的上一个链接点
			Link currentLink = this.firstLink;
			Link previousLink = this.firstLink;
			while(currentLink.iData != key){
				// 到达链表的链尾
				if(currentLink.nextLink == null){
					return null;
				}
				// 当前链接点指向下一个链接点
				else{
					previousLink = currentLink;
					currentLink = currentLink.nextLink;
				}
			}
			// 执行到这里说明找到了待删除的链接点
			if(currentLink == this.firstLink){
				this.firstLink = this.firstLink.nextLink;
			}
			else{
				previousLink.nextLink = currentLink.nextLink;
			}
			return currentLink;
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
	
	// 单链表的测试方法
	@Test
	public void testLinkList(){
		// 创建空的单链表
		LinkList linkList = new LinkList();
		
		// 链表头执行插入操作
		linkList.insertLink(60);
		linkList.insertLink(80);
		linkList.insertLink(20);
		linkList.insertLink(70);
		linkList.insertLink(50);
		
		// 遍历链表
		linkList.displayLink();
		System.out.println();
		
		// 查找指定数据项的链接点
		int key = 80;
		Link link = linkList.findKeyLink(key);
		if(link == null){
			System.out.println("can't find key: " + key);
		}
		else{
			System.out.println("find Link: " + link.iData);
		}
		
		// 链表头执行删除操作并输出删除的链接点
		while(!linkList.isEmpty()){
			Link deleteLink = linkList.deleteLink();
			System.out.print("Deleted Link: ");
			deleteLink.displayLink();
			System.out.println();
		}
	}
}
