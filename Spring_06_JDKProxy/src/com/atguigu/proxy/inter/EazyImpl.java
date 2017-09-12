package com.atguigu.proxy.inter;
import com.atguigu.proxy.inter.MathCalculator;
public class EazyImpl implements MathCalculator{

	@Override
	public int add(int i, int j) {
		int result = i + j;
		System.out.println("方法内部打印：result="+result);
		return result; 
	}

	@Override
	public int sub(int i, int j) {
		int result = i - j;
		System.out.println("方法内部打印：result="+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i * j;
		System.out.println("方法内部打印：result="+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result = i / j;
		System.out.println("方法内部打印：result="+result);
		return result;
	}
}