package problems.dynamicProgramming;

import java.time.Duration;
import java.time.LocalDateTime;

//Dynamic Programming
public class Fibonacci {

	public static void main(String[] args) {
		
		int n=30;
		int[] fibo = new int[n+1];
	
		LocalDateTime start = LocalDateTime.now();
		fibo[0]=0;
		fibo[1]=1;
		System.out.print(fibo[0]+",");
		System.out.print(fibo[1]+",");
		for(int i=2;i<=n;i++) {
			fibo[i]=fibo[i-1]+fibo[i-2];
			System.out.print(fibo[i]+",");
		}
		LocalDateTime end = LocalDateTime.now();
		System.out.println();
		System.out.println("TimeTaken ="+Duration.between(start, end).getNano()+"\n");
		start = LocalDateTime.now();
		System.out.print(fibonacci(n));
		end = LocalDateTime.now();
		System.out.println();
		System.out.println("TimeTaken ="+Duration.between(start, end).getNano()+"\n");
		
		
	}
	
	public static int fibonacci(int num) {
	
		if(num<=1) {
			return num;
		}else {
			return fibonacci(num-1)+fibonacci(num-2);
		}
		
		
	}
	
	
}
