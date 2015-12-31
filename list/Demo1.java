package list;
/**
 * stack
 */

import java.util.Stack;

import main.Demo;
/**
 * stack
 * @author h154651
 *
 */
public class Demo1 implements Demo {
	@Override
	public void start() {
		// 声明Stack并实例化
		Stack<String> al = new Stack<String>();
		// 使用push（）方法添加元素
		al.push("a");
		al.push("b");
		al.push("c");
		al.push("d");
		al.push("f");
		// 使用Iterator迭代器遍历出集合的元素并打印
		while(!al.isEmpty()) {
			System.out.println(al.pop());
		}
	}
}
