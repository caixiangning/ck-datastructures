package org.codethink.stack;

import org.junit.Test;

/**
 * 
 * 数组实现栈的数据结构(long类型)
 * 栈是后进先出FIFO(最后插入的数据项最先被移除)
 * 栈的算法复杂度：栈的数据项的入栈和出栈的时间复杂度都为常数O(1).
 * 也就是说栈操作所消耗时间不依赖于栈中数据项的个数，因此操作时间很短。栈不需要比较和移动操作。
 * 
 * @author CaiXiangNing
 * @date 2016年11月21日
 * @email caixiangning@gmail.com
 * @reference <<Data Structures And Algorithms in Java>>
 */
public class StackArrayTest {
	
	// 定义栈的数据结构(以存储long类型数据为例)
	class Stack{
		// 定义栈的容量、存储栈的数组以及栈顶坐标
		private int maxSize;
		private long[] stackArray;
		private int topIndex;
		
		// 构造器通过传入栈的容量来初始化栈的结构并定义栈顶坐标为-1(栈为空)
		public Stack(int maxSize) {
			this.maxSize = maxSize;
			this.stackArray = new long[maxSize];
			topIndex = -1;
		}
		
		// 入栈操作(栈顶指针先加1然后进行赋值操作)
		public void push(long item){
			stackArray[++topIndex] = item;
		}
		
		// 出栈操作(先返回栈顶指针所在的元素然后栈顶指针减1)
		public long pop(){
			return stackArray[topIndex--];
		}
		
		// 获取栈顶元素的值
		public long peek(){
			return stackArray[topIndex];
		}
		
		// 栈是否为空
		public boolean isEmpty(){
			return (topIndex == -1);
		}
		
		// 栈是否已满
		public boolean isFull(){
			return (topIndex == maxSize-1);
		}
	}
	
	// 数组实现的栈的数据结构的测试方法
	@Test
	public void testStack(){
		// 创建一个最大容量为10的栈数据结构
		Stack stack = new Stack(10);
		
		// 对栈进行入栈操作
		stack.push(10);
		stack.push(50);
		stack.push(30);
		stack.push(40);
		stack.push(20);
		stack.push(70);
		stack.push(60);
		stack.push(80);
		
		// 对栈进行出栈操作
		System.out.println("依次对栈进行出栈操作来输出栈中所有元素：");
		while(!stack.isEmpty()){
			long item = stack.pop();
			System.out.print(item);
			System.out.print(" ");
		}
	}
}
