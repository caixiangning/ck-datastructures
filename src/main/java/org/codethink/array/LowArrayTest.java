package org.codethink.array;

import org.junit.Test;

/**
 * 
 * 数据结构之数组结构的实现
 * 该类的设计较差，LowArray中的存储还停留在低层次的构思，接口的封装使用起来不方便
 * 比如存储元素需要知道元素的坐标，检索元素同样也是，而用户对数组进行操作是不需要知道数组下标的
 * 可以将testLowArray中用于检索指定元素以及删除指定元素还有输出元素这些均封装成该数组实现类的接口
 * 
 * @author CaiXiangNing
 * @date 2016年11月18日
 * @email caixiangning@gmail.com
 */
public class LowArrayTest {
	
	/**
	 * 
	 * 定义数组结构的实现类LowArray
	 * 
	 * @author Cai
	 *
	 */
	class LowArray{
		// 使用long数组来作为自定义数组的存储空间
		private long[] array;
		
		// 构造函数用来初始化数组空间，为数组分配内存
		public LowArray(int arraySize) {
			array = new long[arraySize];
		}
		
		// 根据索引和值来存储元素
		public void setItem(int index, long value){
			array[index] = value;
		}
		
		// 根据索引来取出元素
		public long getItem(int index){
			return array[index];
		}
	}
	
	/**
	 * testLowArray类用于创建LowArray类并且执行具体的检索和存储删除过程
	 */
	@Test
	public void testLowArray(){
		// 定义容量为10的数组
		LowArray lowArray = new LowArray(10);
		
		// 在数组中插入数据项
		lowArray.setItem(0, 70);
		lowArray.setItem(1, 50);
		lowArray.setItem(2, 20);
		lowArray.setItem(3, 30);
		lowArray.setItem(4, 80);
		lowArray.setItem(5, 10);
		lowArray.setItem(6, 40);
		lowArray.setItem(7, 90);
		lowArray.setItem(8, 60);
		//lowArray.setItem(9, 60);
		
		/********************** 输出数组元素 **********************/
		// 遍历输出数组中的元素
		System.out.print("输出原数组中元素：");
		for(int i=0; i<lowArray.array.length; i++){
			System.out.print(lowArray.getItem(i) + " ");
		}
		System.out.println();
		
		/********************** 查找指定元素 **********************/
		// 查找指定元素
		int searchKey = 80;
		for(int i=0; i<lowArray.array.length; i++){
			// 遍历过程中找到指定元素则输出指定元素的索引并且终止循环
			if(lowArray.getItem(i) == searchKey){
				System.out.println("找到要查找的指定元素，其坐标是：" + i);
				break;
			}
			// 如果遍历到数组的末尾还是未找到指定元素则输出未查找到的元素的值
			if(i == lowArray.array.length-1){
				System.out.println("未查找到指定元素:" + searchKey);
			}
		}
		
		/********************** 删除指定元素 **********************/
		// 删除指定元素
		int deleteKey = 50;
		for(int i=0; i<lowArray.array.length; i++){
			if(lowArray.getItem(i) == deleteKey){
				// 遍历过程中找到指定删除元素则输出指定元素的索引并且所有之后的元素前移一位，然后终止循环
				System.out.println("找到要删除的指定元素，其坐标是：" + i);
				// 删除指定元素即将该元素之后的元素均往前移一位
				for(int j=i; j<lowArray.array.length-1; j++){
					lowArray.setItem(j, lowArray.getItem(j+1));
				}
				break;
			}
			// 如果遍历到数组的末尾还是未找到指定元素则输出未查找到的待删除元素的值
			if(i == lowArray.array.length-1){
				System.out.println("未找到要删除的指定元素:" + searchKey);
			}
		}
		
		// 遍历输出数组中的元素
		System.out.print("输出删除后数组中元素：");
		for(int i=0; i<lowArray.array.length; i++){
			System.out.print(lowArray.getItem(i) + " ");
		}
		System.out.println();
	}
}

