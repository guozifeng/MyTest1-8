package com.guo.offer.pecs;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符
 * 
 * 在本文的前面的部分里已经说过了泛型类型的子类型的不相关性。但有些时候，我们希望能够像使用普通类型那样使用泛型类型：
 * 
 * 向上造型一个泛型对象的引用 向下造型一个泛型对象的引用 向上造型一个泛型对象的引用
 * 
 * 例如，假设我们有很多箱子，每个箱子里都装有不同的水果，我们需要找到一种方法能够通用的处理任何一箱水果。更通俗的说法，A是B的子类型，
 * 我们需要找到一种方法能够将C<A>类型的实例赋给一个C<B>类型的声明。
 * 
 * 为了完成这种操作，我们需要使用带有通配符的扩展声明，就像下面的例子里那样：
 * 
 * 1 2 List<Apple> apples = new ArrayList<Apple>(); List<? extends Fruit> fruits
 * = apples; “? extends”是泛型类型的子类型相关性成为现实：Apple是Fruit的子类型，List<Apple> 是 List<?
 * extends Fruit> 的子类型。
 * 
 * 向下造型一个泛型对象的引用
 * 
 * 现在我来介绍另外一种通配符：? super。如果类型B是类型A的超类型(父类型)，那么C<B> 是 C<? super A> 的子类型：
 * 
 * 1 2 List<Fruit> fruits = new ArrayList<Fruit>(); List<? super Apple> =
 * fruits; 为什么使用通配符标记能行得通？
 * 
 * 原理现在已经很明白：我们如何利用这种新的语法结构？
 * 
 * ? extends
 * 
 * 让我们重新看看这第二部分使用的一个例子，其中谈到了Java数组的子类型相关性：
 * 
 * 1 2 3 Apple[] apples = new Apple[1]; Fruit[] fruits = apples; fruits[0] = new
 * Strawberry();
 * 就像我们看到的，当你往一个声明为Fruit数组的Apple对象数组里加入Strawberry对象后，代码可以编译，但在运行时抛出异常。
 * 
 * 现在我们可以使用通配符把相关的代码转换成泛型：因为Apple是Fruit的一个子类，我们使用? extends 通配符，这样就能将一个List
 * <Apple>对象的定义赋到一个List<? extends Fruit>的声明上：
 * 
 * 1 2 3 List<Apple> apples = new ArrayList<Apple>(); List<? extends Fruit>
 * fruits = apples; fruits.add(new Strawberry());
 * 这次，代码就编译不过去了！Java编译器会阻止你往一个Fruit
 * list里加入strawberry。在编译时我们就能检测到错误，在运行时就不需要进行检查来确保往列表里加入不兼容的类型了。
 * 即使你往list里加入Fruit对象也不行：
 * 
 * 1 fruits.add(new Fruit()); 你没有办法做到这些。事实上你不能够往一个使用了? extends的数据结构里写入任何的值。
 * 
 * 原因非常的简单，你可以这样想：这个? extends T
 * 通配符告诉编译器我们在处理一个类型T的子类型，但我们不知道这个子类型究竟是什么。因为没法确定，为了保证类型安全，我们就不允许往里面加入任何这种类型的数据。
 * 另一方面，因为我们知道，不论它是什么类型，它总是类型T的子类型，当我们在读取数据时，能确保得到的数据是一个T类型的实例：
 * 
 * 1 Fruit get = fruits.get(0); ? super
 * 
 * 使用 ? super 通配符一般是什么情况？让我们先看看这个：
 * 
 * 1 2 List<Fruit> fruits = new ArrayList<Fruit>(); List<? super Apple> =
 * fruits; 我们看到fruits指向的是一个装有Apple的某种超类(supertype)的List。同样的，我们不知道究竟是什么超类，
 * 但我们知道Apple和任何Apple的子类都跟它的类型兼容。既然这个未知的类型即是Apple，也是GreenApple的超类，我们就可以写入：
 * 
 * 1 2 fruits.add(new Apple()); fruits.add(new GreenApple());
 * 如果我们想往里面加入Apple的超类，编译器就会警告你：
 * 
 * 1 2 fruits.add(new Fruit()); fruits.add(new Object());
 * 因为我们不知道它是怎样的超类，所有这样的实例就不允许加入。
 * 
 * 从这种形式的类型里获取数据又是怎么样的呢？结果表明，你只能取出Object实例：因为我们不知道超类究竟是什么，编译器唯一能保证的只是它是个Object，
 * 因为Object是任何Java类型的超类。
 * 
 * 存取原则和PECS法则
 * 
 * 总结 ? extends 和 the ? super 通配符的特征，我们可以得出以下结论：
 * 
 * 如果你想从一个数据类型里获取数据，使用 ? extends 通配符 如果你想把对象写入一个数据结构里，使用 ? super 通配符
 * 如果你既想存，又想取，那就别用通配符。
 * 
 * @author Administrator
 *
 */
public class test {

	public static void main(String[] args) {
		Apple apple = new Apple();
		apple.setI(11);
		Fruit fruit = new Fruit();
		fruit.setA(12);
		GreenApple greenapple = new GreenApple();
		greenapple.setB(220);
		Strawberry strawberry = new Strawberry();
		strawberry.setC(23);
		Apple[] apples1 = new Apple[1];
		apples1[0] = apple;
		Fruit[] fruits = apples1;
		fruits[0] = new GreenApple();
		System.out.println(fruits[0]);

		List<Apple> apples = new ArrayList<Apple>();
		apples.add(apple);
		apples.add(greenapple);
		List<? extends Fruit> fruits1 = apples;
		fruits1.add(null);
		System.out.println("+++++++fruits1.size()++++++++" + fruits1.size());
		for (int j = 0; j < fruits1.size(); j++) {
			Apple get = (Apple) fruits1.get(j);
			System.out.println(get);
		}

		List<Fruit> fruits2 = new ArrayList<Fruit>();
		// fruits2.add(fruit);
		fruits2.add(apple);
		// fruits2.add(strawberry);
		List<? super Apple> a = fruits2;
		a.add(new GreenApple());
		a.add(new Apple());

		// a.add(new Strawberry());
		System.out.println("+++++++a.size()++++++++" + a.size());
		for (int i = 0; i < a.size(); i++) {
			Apple aaa = (Apple) a.get(i);
			System.out.println(aaa);
		}

	}

}
