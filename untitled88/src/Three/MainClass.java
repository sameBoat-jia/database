package Three;
/**
 * @author Kun Sun
 * @Date： 2013.10.15
 */
public class MainClass { // 用于测试最大公约数类和最小公倍数类
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gcd gcd = new Gcd();
		int result1 = gcd.f(12,24);
		System.out.println(result1);
		
		Lcm lcm = new Lcm();
		int result2 = lcm.f(12,24);
		System.out.println(result2);
	}
 
}