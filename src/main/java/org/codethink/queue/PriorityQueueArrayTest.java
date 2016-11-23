package org.codethink.queue;

import org.junit.Test;

/**
 * 
 * 数组实现优先级队列的数据结构(long类型)
 * 优先级队列中，数据项是有序的，最小的数据项在队头，而最大的数据项在队尾(我们假定最小的数据项具有最高的优先级)
 * 队列的算法复杂度：队列的数据项的插入操作的时间复杂度是O(N)、删除操作的时间复杂度为常数O(1).
 * 
 * @author CaiXiangNing
 * @date 2016年11月23日
 * @email caixiangning@gmail.com
 * @reference <<Data Structures And Algorithms in Java>>
 */
public class PriorityQueueArrayTest {
	
	// 定义优先级队列的数据结构(以存储long类型数据为例)
	class PriorityQueue{
		private int maxSize; // 优先级队列最大长度
		private long[] queArray; // 存储优先级队列的数组
		private int nItems; // 优先级队列数据项个数
		
		// 使用数组创建优先级队列结构
		public PriorityQueue(int maxSize) {
			this.maxSize = maxSize;
			queArray = new long[maxSize];
			nItems = 0;
		}
		// 在优先级队列中插入数据项
		public void insert(long item){
			int insertIndex = 0; // 记录待插入的数据项应该插入位置的坐标
			// 插入第一个数据项
			if(nItems == 0){
				queArray[nItems++] = item;
			}
			else{
				// 这里的操作有点类似于降序的有序数组的插入，我们前面讨论的有序数组是升序的
				for(int j=nItems-1; j>=0; j--){
					// 如果待插入的数据项比遍历的位置的数据项大则遍历到的这个元素后移
					// 这就是从后往前遍历的好处，可以边遍历边后移，而如果从前遍历则找到后需要循环后移后面的元素
					if(item > queArray[j]){
						insertIndex = j;
						queArray[j+1] = queArray[j];
					}
					// 如果待插入的数据项比遍历的位置的数据项小则说明该数据项应该插入到该数据项之后
					else{
						insertIndex = j+1;
						break;
					}
				}
				queArray[insertIndex] = item;
				nItems++; // 插入元素则数据项个数+1
			}
		}
		
		// 在优先级队列中删除数据项
		public long remove(){
			return queArray[--nItems];
		}
		
		// 在优先级队列中获取数据项
		public long peekMin(){
			return queArray[nItems-1];
		}
		
		// 判断优先级队列是否为空
		public boolean isEmpty(){
			return (nItems == 0);
		}
		
		// 判断优先级队列是否已满
		public boolean isFull(){
			return (nItems == maxSize);
		}
		
	}
	
	//数组实现的队列的数据结构的测试方法
	@Test
	public void testPriorityQueue(){
		PriorityQueue priorityQueue = new PriorityQueue(5);
		// 向队列中插入四个数据项：60 -> 40 60 -> 30 40 60 -> 30 40 60 70
		priorityQueue.insert(60);
		priorityQueue.insert(40);
		priorityQueue.insert(30);
		priorityQueue.insert(70);
		
		// 在队列中移除三个数据项：30 40 60 70 -> 40 60 70 -> 60 70
		priorityQueue.remove();
		priorityQueue.remove();
		
		// 向队列中插入四个数据项：60 70 -> 20 60 70 -> 20 50 60 70
		priorityQueue.insert(20);
		priorityQueue.insert(50);
		
		// 遍历并输出队列中的所有数据项
		System.out.println("依次移除优先级队列中数据项来输出栈中所有元素:");
		while(!priorityQueue.isEmpty()){
			long item = priorityQueue.remove();
			System.out.print(item);
			System.out.print(" ");
		}
	}
}
