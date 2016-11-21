package org.codethink.array;

import org.junit.Test;

/**
 * 
 * 数据结构之有序数组结构的实现
 * 有序数组的好处是可以有效提高查找速度(二分查找)，但降低了插入操作的速度
 * 
 * 有序数组的算法复杂度
 * 有序数组的查找(线性查找)	O(N)
 * 有序数组的查找(二分查找)log(N)
 * 有序数组的插入	O(N)
 * 有序数组的删除	O(N)
 *
 * @author CaiXiangNing
 * @date 2016年11月18日
 * @email caixiangning@gmail.com
 */
public class OrderArrayTest {
	
	/**
	 * 
	 * 定义数组结构的实现类OrderArray
	 * 
	 * @author Cai
	 *
	 */
	class OrderArray{
		// 使用long数组来作为自定义数组的存储空间
		private long[] array;
		// 数组元素个数(而非数组的容量)
		private int nElems;
		
		// 构造函数用来初始化数组空间，为数组分配内存
		public OrderArray(int maxSize) {
			this.array = new long[maxSize];
			this.nElems = 0;
		}
		
		// 线性检索指定值的元素
		public boolean searchItem1(long searchKey){
			for(int i=0; i<nElems; i++){
				// 遍历过程中找到指定元素则输出指定元素的索引并且终止循环
				if(array[i] == searchKey){
					System.out.println("找到要查找的指定元素"+searchKey+"，其坐标是：" + i);
					break;
				}
				// 如果遍历到大于指定元素的元素还是未找到则输出未查找到的元素的值
				if(searchKey < array[i]){
					System.out.println("未查找到指定元素:" + searchKey);
					return false;
				}
			}
			return true;
		}
		
		// 二分检索指定值的元素
		public boolean searchItem2(long searchKey){
			// 设置lowerBound和upperBound分别指向数组的第一个和最后一个非空数据项
			int lowerBound = 0;
			int upperBound = nElems-1;
			int curIn;
			
			// 循环每进行一次范围缩小一半
			while(true){
				curIn = (lowerBound+upperBound)/2;
				if(array[curIn] == searchKey){
					System.out.println("找到要查找的指定元素"+searchKey+"，其坐标是：" + curIn);
					return true;
				}
				else if(lowerBound>upperBound){
					System.out.println("未查找到指定元素:" + searchKey);
					return false;
				}
				else{
					// 如果检索的数据项较大，则检索范围应该是当前范围的后半部
					if(array[curIn] < searchKey){
						lowerBound = curIn + 1;
					}
					// 如果检索的数据项较小，则检索范围应该是当前范围的前半部
					else{
						upperBound = curIn - 1;
					}
				}
			}
		}
		
		// 插入指定值的元素
		public void insertItem(long insertKey){
			// 存储元素要插入的位置坐标
			int indexTemp;
			for(indexTemp=0; indexTemp<nElems; indexTemp++){
				if(insertKey < array[indexTemp]){
					break;
				}
			}
			// 要插入的元素位置之后的元素均后移一个位置
			for(int j=nElems; j>indexTemp; j--){
				array[j] = array[j-1];
			}
			// 插入元素到指定位置
			array[indexTemp] = insertKey;
			nElems++;
		}
		
		// 删除指定值的元素
		public boolean deleteItem(long deleteKey){
			for(int i=0; i<nElems; i++){
				if(array[i] == deleteKey){
					// 遍历过程中找到指定删除元素则输出指定元素的索引并且所有之后的元素前移一位，然后终止循环
					System.out.println("找到要删除的指定元素:"+deleteKey+"，其坐标是：" + i);
					// 删除指定元素即将该元素之后的元素均往前移一位
					for(int j=i; j<nElems; j++){
						array[j] = array[j+1];
					}
					nElems--;
					break;
				}
				// 如果遍历到大于指定元素的元素还是未找到则输出未查找到的待删除元素的值
				if(deleteKey < array[i]){
					System.out.println("未找到要删除的指定元素:" + deleteKey);
					return false;
				}
			}
			return true;
		}
		
		// 输出数组中的所有元素
		public void displayItem(){
			for(int i=0; i<nElems; i++){
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * OrderArray数组数据结构的相关操作的测试类
	 */
	@Test
	public void testOrderArray(){
		// 定义容量为10的数组
		OrderArray orderArray = new OrderArray(10);
		
		// 在数组中插入数据项
		orderArray.insertItem(70);
		orderArray.insertItem(50);
		orderArray.insertItem(20);
		orderArray.insertItem(30);
		orderArray.insertItem(80);
		orderArray.insertItem(10);
		orderArray.insertItem(40);
		orderArray.insertItem(90);
		orderArray.insertItem(60);
		
		/********************** 输出数组元素 **********************/
		System.out.print("输出原数组中元素：");
		orderArray.displayItem();
		
		/********************** 线性查找指定元素 **********************/
		// 查找指定元素
		int searchKey1 = 80;
		boolean searchResult1 = orderArray.searchItem1(searchKey1);
		System.out.println(searchResult1);
		
		/********************** 二分查找指定元素 **********************/
		// 查找指定元素
		int searchKey2 = 80;
		boolean searchResult2 = orderArray.searchItem2(searchKey2);
		System.out.println(searchResult2);
		
		/********************** 删除指定元素 **********************/
		int deleteKey = 50;
		boolean deleteResult = orderArray.deleteItem(deleteKey);
		System.out.println(deleteResult);
		System.out.print("输出删除后数组中元素：");
		orderArray.displayItem();
	}
}

