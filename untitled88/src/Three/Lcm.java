package Three;

public class Lcm extends Gcd{// 最小公倍数类，取名自英文各首字母(Lowest Common Multiple)
	
	public int f(int a,int b){ // 方法重写，求最小公倍数
		int m = super.f(a, b);
		int result = a*b/m;
		return result;
	}
}