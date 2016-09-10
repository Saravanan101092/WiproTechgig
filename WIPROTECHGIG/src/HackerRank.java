import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HackerRank {

	
	public static void printThreeValues(List<Long> numbers){
		System.out.println(printSum(numbers,0) + " " +printSum(numbers,1)+ " " +printSum(numbers,2));
	}
	
	public static long printSum(List<Long> numbers, int start){
		int count=start;
		long sum =0;
		while(count<numbers.size()){
			sum+=numbers.get(count);
			count+=3;
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		List<Long> list = new ArrayList<Long>();
		long N = scanner.nextLong();
		for(long i=0;i<N;i++){
		  list.add(scanner.nextLong());
		}
			
		printThreeValues(list);
       

	}

}
