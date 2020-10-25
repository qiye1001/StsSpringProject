package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * set�ӿ�
 * 1������ģ�����֤˳��
 * 2���������ظ�Ԫ��
 * HashSet��TreeSet��LinkedHashSet
 * 
 * 	���Ҫ����ѡ��TreeSet
 * 	�����Ҫ����Ҳ��Ҫ��֤˳��ѡ��hashSet
 * 	��Ҫ����Ҫ��֤˳��ѡ��LinkedHashSet
 */

public class setDemo {
	
	public static void linkedHashSet() {
		LinkedHashSet<Cat> linkedHashSet = new LinkedHashSet<>();
		Cat cat1 = new Cat("����", 2, 3);
		Cat cat2 = new Cat("����", 1, 1);
		Cat cat3 = new Cat("���ɶ", 4, 3);
		Cat cat4 = new Cat("���ɶ", 4, 3);
		
		linkedHashSet.add(cat1);
		linkedHashSet.add(cat2);
		linkedHashSet.add(cat3);
		linkedHashSet.add(cat4);
		
		for(Cat c : linkedHashSet) {
			System.out.println(c);
		}
	}
	
	/** TreeSet
	 * 	����ģ� ����TreeMap(���������ݽṹ)��������Ҫ�Ƚϴ�С��ͨ������Ƚ���ʵ��
	 *	����Ƚ���������ȥ���ظ�Ԫ�أ�����Զ���������࣬û��ʵ�ֱȽ����ӿڣ����޷���ӵ�TreeSet������
	 */
	public static void treeSet() {
		TreeSet<Cat> tree = new TreeSet<>((o1, o2) -> o1.getId() - o2.getId());
		Cat cat1 = new Cat("����", 2, 3);
		Cat cat2 = new Cat("����", 1, 1);
		Cat cat3 = new Cat("���ɶ", 4, 3);
		Cat cat4 = new Cat("���ɶ", 4, 3);
		
		tree.add(cat1);
		tree.add(cat2);
		tree.add(cat3);
		tree.add(cat4);
		
		for(Cat c : tree) {
			System.out.println(c);
		}
	}
	
	/**
	 * hashSet
	 * 1��ʵ��ԭ�����ڹ�ϣ��hashMap��ʵ��
	 * 2���������ظ���������һ��nullԪ��
	 * 3����֤˳���ò���
	 * 4�����Ԫ��ʱ����Ԫ����ΪhaspMap��keyֵ�� hashMap��valueʹ�õ���һ���̶���object����
	 * 5���ų��ظ�Ԫ����ʹ��equals������Ƿ���ͬ
	 * 6���ж����������Ƿ���ͬ�����ж����������hashcode�Ƿ���ͬ����������������hashcode��ͬ����������һ����ȣ������ͬ����һ������ȣ���
	 * 	�����ͬ����Ҫ����equals�Ƚϣ������ͬ������ͬһ�����󣬷�����ͬһ������
	 * 7���Զ������Ҫ��Ϊ����ֵ����ͬһ����������������ʱ����ô����Ҫ��дhashcode��equals����
	 * 
	 *	С��
	 *	��1����ϣ��Ĵ洢�ṹ������+���� �������ÿһ��Ԫ�����������ʽ�洢
	 *	��2����ΰѶ�������ϣ���У��ȼ�������hashcodeֵ���ڶ�����ĳ���ȡ�࣬������������Ҫ�洢��������Ǹ�λ��
	 * 	��3�����hashcode��ȥ�����⣬�ο�������
	 * 
	 */
	public static void hashSet() {
		Set<Cat> cats = new HashSet<>();
		Cat cat1 = new Cat("����", 2, 3);
		Cat cat2 = new Cat("����", 1, 1);
		Cat cat3 = new Cat("���ɶ", 4, 3);
		Cat cat4 = new Cat("���ɶ", 4, 3);
		
		cats.add(cat1);
		cats.add(cat2);
		cats.add(cat3);
		cats.add(cat4);
		
 		for(Cat c : cats) {
			System.out.println(c);
		}

 		System.out.println("c1 = " + cat1.hashCode()%16);
 		System.out.println("c2 = " + cat2.hashCode()%16);
 		System.out.println("c3 = " + cat3.hashCode()%16);
 		System.out.println("c4 = " + cat4.hashCode()%16);
	}
	
	public static void main(String[] args) {
//		treeSet();
		linkedHashSet();
	}
}
