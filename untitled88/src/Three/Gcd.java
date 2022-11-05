package Three;
/** 
 * @author Kun Sun
 * @Date： 2013.10.15
 */
public class Gcd { // 最大公约数类，取名自英文各首字母(Greatest Common Divisor)
	public int f(int a,int b){
		if(a < b){  // 保证a为最大值
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(b > 0){ // 求最大公约数
			if(a == b){
				return a;
			}else{
				int temp = a%b;
				a = b;
				b = temp;
			}
		}
		return a;
	}
}