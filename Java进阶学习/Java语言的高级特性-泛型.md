## 泛型进阶
> 定义：多种数据类型执行相同代码，必须有<>

1. 多个泛型定义写法：<k,v,e>
2. 泛型三种场景：类泛型，接口泛型，方法泛型
3. 泛型限定类型方法： <T extend A>
4. 多个写法<T extend ArrayList&Comapre&C> 类必须写在第一位 
5. 泛型用作方法参数以及通配符?的运用
    
```
class A{}
class B extend A()
class C extend A()

public static fun1(List<A> p1){}
1.只能传 List<A> 的对象
2.不能传 List<B>/List<C>的对象


public static fun2(List<? extend A> p2){}
1.限定方法中泛型参数的上限
2.可以传List<A>/List<B>/List<C>
3.安全读数据

List<? extend A> oA = new ArrayList<>()
oA不支持写数据
oA获取值是A对象


public static fun3(List<? super A> p3){}
1.限定方法中泛型参数的下限
2.只可以传List<A>以及A的父类
3.安全写数据

List<? super A> oA = new ArrayList<>()
oA只能设置A即子类（B,C）
oA获取值是Object对象


```
 6. 虚拟机实现：泛型擦除

    > 单个泛型<T> T会转成Object

    > 多个泛型<T extend A&B> T被转成A，用到B的时候，
    
 7.泛型边界：1.不支持instanceof 操作 2.不能new 泛型数组，可以定义 3.泛型不能extend Exection、Throwable
 
 8. extend -> 派生
