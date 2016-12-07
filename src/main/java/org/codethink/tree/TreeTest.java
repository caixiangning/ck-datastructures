package org.codethink.tree;

import org.junit.Test;

/**
 * 
 * 二叉树数据结构泛型实现(节点最多只有两个的树叫做二叉树)
 * 
 * @author CaiXiangNing
 * @date 2016年12月6日
 * @email caixiangning@gmail.com
 */
public class TreeTest {
	
	/**
	 * 二叉树的节点类
	 * @author Cai
	 * @param <T>
	 *
	 */
	class Node<T extends Number>{
		T iData; // 节点数据项
		Node<T> leftNode; // 左子节点
		Node<T> rightNode; // 右子节点
		
		public Node(T iData) {
			super();
			this.iData = iData;
		}
		
		// 输出节点
		public void displayNode(){
			System.out.println(iData);
		}
	}
	
	/**
	 * 二叉搜索树的实现类
	 * 二叉搜索树：节点的左字节点小于该节点，节点的右子节点大于等于该节点，则这样的二叉树是二叉搜索树
	 * @author Cai
	 * @param <T>
	 *
	 */
	class Tree<T extends Number>{
		
		private Node<T> rootNode; // 根节点

		/**
		 * 查找节点
		 * 操作：从根节点开始遍历树所有节点，如果待查找数据项小于当前节点则遍历左子节点，否则遍历右子节点
		 * 时间复杂度：O(logN)，准确来说是以2为底。查找节点的时间取决于节点所在的层数
		 * @param key
		 * @return
		 */
		public Node<T> find(T key){
			Node<T> currentNode = this.rootNode;
			while(currentNode.iData != key){
				// 如果数据项小于当前节点则遍历左子节点
				if(key.doubleValue() < currentNode.iData.doubleValue()){
					currentNode = currentNode.leftNode;
				}
				// 如果数据项大于等于当前节点则遍历右子节点
				else{
					currentNode = currentNode.rightNode;
				}
				// 如果当前节点为空，即遍历了所有节点则返回null
				if(currentNode == null){
					return null;
				}
			}
			return currentNode;
		}
		
		/**
		 * 插入节点
		 * 操作：从根节点开始遍历树所有节点，如果待查找数据项小于当前节点则遍历左子节点，否则遍历右子节点。
		 * 插入节点类似于查找节点，需要找到插入节点的位置，或者说是找到其父节点的位置然后判断具体是插入在左子节点还是右子节点
		 * 时间复杂度：O(logN)，准确来说是以2为底。查找节点的时间取决于节点所在的层数
		 * @param iData
		 */
		public void insert(T iData){
			Node<T> newNode = new Node<T>(iData);
			Node<T> currentNode = this.rootNode;
			Node<T> parentNode = this.rootNode;
			// 如果根节点为空则插入节点是根节点
			if(this.rootNode == null){
				this.rootNode = newNode;
			}
			else{
				// 遍历找到待插入节点的位置，循环结束后currentNode就是节点插入位置，parentNode是节点插入位置的父节点
				while(currentNode!=null){
					parentNode = currentNode;
					// 如果数据项小于当前节点则遍历左子节点
					if(iData.doubleValue() < currentNode.iData.doubleValue()){
						currentNode = currentNode.leftNode;
					}
					// 如果数据项大于等于当前节点则遍历右子节点
					else{
						currentNode = currentNode.rightNode;
					}
				}
				// 进一步判断节点插入到左子节点还是右子节点
				if(iData.doubleValue() < parentNode.iData.doubleValue()){
					parentNode.leftNode = newNode;
				}
				else{
					parentNode.rightNode = newNode;
				}
			}
		}
		
		/**
		 * 遍历树：中序遍历
		 * 操作：递归遍历节点的左子树、访问这个节点、递归遍历节点的右子树
		 * @param localRoot
		 */
		public void inOrder(Node<T> localRoot){
			if(localRoot != null){
				inOrder(localRoot.leftNode);
				System.out.print(localRoot.iData + " ");
				inOrder(localRoot.rightNode);
			}
		}
		
		/**
		 * 遍历树：前序遍历
		 * 操作：访问这个节点、递归遍历节点的左子树、递归遍历节点的右子树
		 * @param localRoot
		 */
		public void preOrder(Node<T> localRoot){
			if(localRoot != null){
				System.out.print(localRoot.iData + " ");
				inOrder(localRoot.leftNode);
				inOrder(localRoot.rightNode);
			}
		}
		
		/**
		 * 遍历树：后序遍历
		 * 操作：递归遍历节点的左子树、递归遍历节点的右子树、访问这个节点
		 * @param localRoot
		 */
		public void postOrder(Node<T> localRoot){
			if(localRoot != null){
				inOrder(localRoot.leftNode);
				inOrder(localRoot.rightNode);
				System.out.print(localRoot.iData + " ");
			}
		}
		
		/**
		 * 查询树中最小节点
		 * 操作：从根节点的左子节点开始遍历所有的左子节点，直到找到没有左子节点的节点，即是最小值的节点
		 * 时间复杂度：O(logN)，准确来说是以2为底。查找节点的时间取决于节点所在的层数
		 * @return
		 */
		public Node<T> findMinNode(){
			Node<T> currentNode = this.rootNode;
			Node<T> lastNode = null; // 记录结果节点(空节点的父节点)
			while(currentNode != null){
				lastNode = currentNode;
				currentNode = currentNode.leftNode;
			}
			return lastNode;
		}
		
		/**
		 * 查询树中最大节点
		 * 操作：从根节点的右子节点开始遍历所有的右子节点，直到找到没有右子节点的节点，即是最大值的节点
		 * 时间复杂度：O(logN)，准确来说是以2为底。查找节点的时间取决于节点所在的层数
		 * @return
		 */
		public Node<T> findMaxNode(){
			Node<T> currentNode = this.rootNode;
			Node<T> lastNode = null; // 记录结果节点(空节点的父节点)
			while(currentNode != null){
				lastNode = currentNode;
				currentNode = currentNode.rightNode;
			}
			return lastNode;
		}
	}
	
	/**
	 * 二叉搜索树测试方法
	 */
	@Test
	public void testTree(){
		Tree<Integer> tree = new Tree<Integer>();
		
		// 在二叉搜索树中插入节点
		tree.insert(20);
		tree.insert(60);
		tree.insert(40);
		tree.insert(30);
		tree.insert(80);
		tree.insert(70);
		tree.insert(10);
		tree.insert(50);
		
		// 在二叉搜索树中查找节点
		Node<Integer> keyNode = tree.find(20);
		if(keyNode != null){
			System.out.println("在二叉搜索树中找到指定节点!");
		}
		else{
			System.out.println("在二叉搜索树中未找到指定节点!");
		}
		
		// 在二叉搜索树中查找最小节点
		Node<Integer> minNode = tree.findMinNode();
		System.out.println("二叉搜索树中最小节点：");
		minNode.displayNode();
		
		// 在二叉搜索树中查找最大节点
		Node<Integer> maxNode = tree.findMaxNode();
		System.out.println("二叉搜索树中最大节点：");
		maxNode.displayNode();
		
		// 中序遍历二叉搜索树
		System.out.println("中序遍历二叉搜索树:");
		tree.inOrder(tree.rootNode);
		System.out.println();
		
		// 前序遍历二叉搜索树
		System.out.println("前序遍历二叉搜索树:");
		tree.preOrder(tree.rootNode);
		System.out.println();
				
		// 后序遍历二叉搜索树
		System.out.println("后序遍历二叉搜索树:");
		tree.postOrder(tree.rootNode);
		System.out.println();
	}
}

