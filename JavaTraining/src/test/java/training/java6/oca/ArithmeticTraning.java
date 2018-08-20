package training.java6.oca;

public class ArithmeticTraning {

	public static void main(String[] args) {
		int i=4;
		i*=i--;
		// i * (i--) = 4 * 4 = 16
		print("i*=i--", i);
		
		i=4; 
		i*=++i;
		// i * (++i) = 4 * 5 = 20
		print("i*=++i", i);
		
		i=4; 
		i/=--i;
		// i / (--i) = 4 / 3 = 1
		print("i/=--i", i);
		
		i=4; 
		i*=--i;
		// i * (--i) = 4 * 3 = 12
		print("i*=--i", i);
		
		i=4; 
		i*=i;//16
		print("i*=i", i);
	}
		
    protected static void print(Object v1, Object v2) {
        System.out.format("%-10s %-10s\n", v1, v2);
    }

}
