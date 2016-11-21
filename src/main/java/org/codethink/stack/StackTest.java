package org.codethink.stack;

import java.lang.reflect.Array;

import org.junit.Test;

/**
 * 
 * 数组实现栈的数据结构(long类型)
 * 
 * @author CaiXiangNing
 * @date 2016年11月21日
 * @email caixiangning@gmail.com
 * @reference <<Data Structures And Algorithms in Java>>
 */
public class StackTest {
	
	// 定义栈的数据结构(以存储泛型数据为例)
	class Stack<T>{
		// 定义栈的容量、存储栈的数组以及栈顶坐标
		private int maxSize;
		private T[] stackArray;
		private int topIndex;
		
		// 构造器通过传入栈的容量来初始化栈的结构并定义栈顶坐标为-1(栈为空)
		@SuppressWarnings("unchecked")
		public Stack(int maxSize, Class<T> clazz) {
			this.maxSize = maxSize;
			this.stackArray = (T[])Array.newInstance(clazz, maxSize);
			topIndex = -1;
		}
		
		// 入栈操作(栈顶指针先加1然后进行赋值操作)
		public void push(T item){
			stackArray[++topIndex] = item;
		}
		
		// 出栈操作(先返回栈顶指针所在的元素然后栈顶指针减1)
		public T pop(){
			return stackArray[topIndex--];
		}
		
		// 获取栈顶元素的值
		public T peek(){
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
	
	@Test
	public void testStack(){
		// 创建一个最大容量为10的栈数据结构(这里我们使用float类型来测试泛型)
		Stack<Float> stack = new Stack<Float>(10,Float.class);
		
		// 对栈进行入栈操作
		stack.push(10.5f);
		stack.push(50.5f);
		stack.push(30.5f);
		stack.push(40.5f);
		stack.push(20.5f);
		stack.push(70.5f);
		stack.push(60.5f);
		stack.push(80.5f);
		
		System.out.println("依次对栈进行出栈操作来输出栈中所有元素：");
		// 对栈进行出栈操作
		while(!stack.isEmpty()){
			float item = stack.pop();
			System.out.print(item);
			System.out.print(" ");
		}
	}
}
