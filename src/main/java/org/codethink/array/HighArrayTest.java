package org.codethink.array;

import org.junit.Test;

/**
 * 
 * 数据结构之数组结构的实现
 * 该类的设计较好，HighArray中接口封装简化了用户操作，封装了查找、删除、插入操作
 * 并且这些操作都不需要元素坐标，至于进行操作时元素坐标的变化都封装在该类中。
 * 
 * 无序数组的算法复杂度
 * 无序数组的查找(线性查找)	O(N)
 * 无序数组的插入	O(1)
 * 无序数组的删除	O(N)
 * 
 * @author CaiXiangNing
 * @date 2016年11月18日
 * @email caixiangning@gmail.com
 */
public class HighArrayTest {
	
	/**
	 * 
	 * 定义数组结构的实现类HighArray
	 * 
	 * @author Cai
	 *
	 */
	class HighArray{
		// 使用long数组来作为自定义数组的存储空间
		private long[] array;
		// 数组元素个数(而非数组的容量)
		private int nElems;
		
		// 构造函数用来初始化数组空间，为数组分配内存
		public HighArray(int maxSize) {
			this.array = new long[maxSize];
			this.nElems = 0;
		}
		
		// 检索指定值的元素
		public boolean searchItem(long searchKey){
			for(int i=0; i<nElems; i++){
				// 遍历过程中找到指定元素则输出指定元素的索引并且终止循环
				if(array[i] == searchKey){
					System.out.println("找到要查找的指定元素"+searchKey+"，其坐标是：" + i);
					break;
				}
				// 如果遍历到数组的末尾还是未找到指定元素则输出未查找到的元素的值
				if(i == nElems-1){
					System.out.println("未查找到指定元素:" + searchKey);
					return false;
				}
			}
			return true;
		}
		
		// 插入指定值的元素
		public void insertItem(long insertKey){
			array[nElems] = insertKey;
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
				// 如果遍历到数组的末尾还是未找到指定元素则输出未查找到的待删除元素的值
				if(i == nElems-1){
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
	 * HighArray数组数据结构的相关操作的测试类
	 */
	@Test
	public void testHighArray(){
		// 定义容量为10的数组
		HighArray highArray = new HighArray(10);
		
		// 在数组中插入数据项
		highArray.insertItem(70);
		highArray.insertItem(50);
		highArray.insertItem(20);
		highArray.insertItem(30);
		highArray.insertItem(80);
		highArray.insertItem(10);
		highArray.insertItem(40);
		highArray.insertItem(90);
		highArray.insertItem(60);
		
		/********************** 输出数组元素 **********************/
		System.out.print("输出原数组中元素：");
		highArray.displayItem();
		
		/********************** 查找指定元素 **********************/
		// 查找指定元素
		int searchKey = 80;
		boolean searchResult = highArray.searchItem(searchKey);
		System.out.println(searchResult);
		
		/********************** 删除指定元素 **********************/
		int deleteKey = 50;
		boolean deleteResult = highArray.deleteItem(deleteKey);
		System.out.println(deleteResult);
		System.out.print("输出删除后数组中元素：");
		highArray.displayItem();
	}
}

