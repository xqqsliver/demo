package com.example.demo.hashmap;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/**
 * 继承abstractmap
 * 实现map,cloneable,serializable
 * @author xuqq
 *
 * @param <K>
 * @param <V>
 */
public class HashMapDemo<K,V> extends AbstractMap<K,V>
implements Map<K,V>, Cloneable, Serializable {
	//默认容量 16
	 static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	 //最大容量 2的30次方
	 static final int MAXIMUM_CAPACITY = 1 << 30;
	 //负载因子0.75
	 static final float DEFAULT_LOAD_FACTOR = 0.75f;
	 //当链表超过8 时转成红黑树
	 static final int TREEIFY_THRESHOLD = 8;
	 //小于6 ,由树转成链表
	 static final int UNTREEIFY_THRESHOLD = 6;
	 //当桶中的bin被树化时最小的hash表容量。
	 //（如果没有达到这个阈值，即hash表容量小于MIN_TREEIFY_CAPACITY，
	 //当桶中bin的数量太多时会执行resize扩容操作）
	 //这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍。
	 static final int MIN_TREEIFY_CAPACITY = 64;
	 //静态内部类Node
	 static class Node<K,V>  implements Map.Entry<K,V> {
		 //如果变量没有final的话系统会默认int为0。但是有final的话必须赋值
		 //final修饰变量
		 //变量一旦被初始化便不可改变（对于基本类型，指的是值不变；对于对象类型，指的是引用不变），
		 //初始化只可能在两个地方：定义处和构造函数。final int hash=0;或者如下在构造函数的地方
		 final int hash;
		 final K key;
		 V value;
		 Node<K,V> next;
		 Node(int hash, K key, V value, Node<K,V> next) {
	            this.hash = hash;
	            this.key = key;
	            this.value = value;
	            this.next = next;
	        }
		@Override
		public K getKey() {
			return key;
		}
		@Override
		public V getValue() {
			return value;
		}

		@Override
		public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
		//Object类里面hashcode是变量或者对象的内存地址
		//Object类 equals方法比较的是两个对象之间的内存地址是否相同
		public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
		 public final boolean equals(Object o) {
	            if (o == this)
	                return true;
	            if (o instanceof Map.Entry) {
	                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
	                if (Objects.equals(key, e.getKey()) &&
	                    Objects.equals(value, e.getValue()))
	                    return true;
	            }
	            return false;
	        }
		 
	 }
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String args[]){
		HashMapDemo<Object,Object> ll=new HashMapDemo<Object,Object>();
		Object o="ll";
		o.equals(o);
	}

}
