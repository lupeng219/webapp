package com.baibao.web.p2p.utils;

public class Test {

	
	public static int a(int a, int b)
	{
		if (a%b == 0)
		{
			return a;
		}else
			return a(b, a%b);
		
	}
	public static void main(String[] args)
	{
		System.out.println(a(2016, 2102));
	}
}
