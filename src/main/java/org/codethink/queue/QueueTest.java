package org.codethink.queue;

import java.lang.reflect.Array;

import org.junit.Test;

/**
 * 
 * 数组实现队列的数据结构(泛型)
 * 队列是先进先出FIFO(第一个插入的数据项最先被移除)
 * 队列的算法复杂度：队列的数据项的插入、删除操作的时间复杂度都为常数O(1).
 * 
 * @author CaiXiangNing
 * @date 2016年11月17日
 * @email caixiangning@gmail.com
 * @reference <<Data Structures And Algorithms in Java>>
 */
public class QueueTest {
	
	// 定义队列的数据结构(以泛型为例)
	class Queue<T>{
		private int maxSize; // 队列最大容量
		private T[] queueArray; // 存储队列结构的数组
		private int front; // 队头指针
		private int rear; // 队尾指针
		private int nItems; // 队列中数据项个数
		
		@SuppressWarnings("unchecked")
		public Queue(int maxSize, Class<T> clazz) {
			this.maxSize = maxSize;
			this.queueArray = (T[])Array.newInstance(clazz, maxSize);
			/* 队头指针下标0，队尾指针下标-1，这是因为二者操作是不同的，
			 * 队头移除数据项是先移除再加1，而队尾插入数据项是先加1再插入数据项
			 * 插入第一个元素，队尾指针是0，移除这个元素后，队头指针是1*/ 
			this.front = 0;
			this.rear = -1;
			this.nItems = 0;
		}
		// 向队列中插入一个元素
		public void insert(T item){
			// 考虑队尾指针到达数组边界点
			if(rear == maxSize-1){
				rear = -1;
			}
			// 插入元素则队尾指针加1再插入元素
			queueArray[++rear] = item;
			nItems++ ;
		}
		
		// 在队列中移除一个元素
		public T remove(){
			// 移除元素则移除元素后队头指针加1
			T item =  queueArray[front++];
			// 考虑队头指针到达数组边界点
			if(front == maxSize){
				front = 0;
			}
			nItems--;
			return item;
		}
		
		// 返回队列中队头的与元素
		public T peekFront(){
			return queueArray[front];
		}
		
		// 队列是否为空
		public boolean isEmpty(){
			return (nItems == 0);
		}
		
		// 队列是否已满
		public boolean isFull(){
			return (nItems == maxSize);
		}
		
		public int size(){
			return nItems;
		}
	}
	
	// 数组实现的队列的数据结构的测试方法
	@Test
	public void testQueue(){
		Queue<Float> queue = new Queue<Float>(5, Float.class);
		// 向队列中插入四个数据项：10.5 -> 10.5 20.5 -> 10.5 20.5 30.5 -> 10.5 20.5 30.5 40.5
		queue.insert(10.5f);
		queue.insert(20.5f);
		queue.insert(30.5f);
		queue.insert(40.5f);
		
		// 在队列中移除三个数据项：10.5 20.5 30.5 40.5 -> 20.5 30.5 40.5 -> 30.5 40.5 -> 40.5
		queue.remove();
		queue.remove();
		queue.remove();
		
		// 向队列中插入四个数据项：40.5 -> 40.5 50.5 -> 40.5 50.5 60.5 -> 40.5 50.5 60.5 70.5 -> 40.5 50.5 60.5 70.5 80.5
		queue.insert(50.5f);
		queue.insert(60.5f);
		queue.insert(70.5f);
		queue.insert(80.5f);
		
		// 遍历并输出队列中的所有数据项
		System.out.println("依次移除队列中数据项来输出栈中所有元素:");
		while(!queue.isEmpty()){
			float item = queue.remove();
			System.out.print(item);
			System.out.print(" ");
		}
	}
}
