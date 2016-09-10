import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Wipro{

//	public static String OPEN_BRACKET = "(";
//	public static String CLOSE_BRACKET = ")";
//	public static String OPEN_FLR_BRACKET = "{";
//	public static String CLOSE_FLR_BRACKET = "}";
//	public static String comma=",";
//	
//	static final long l=343L;
//	public static void add(long l){
//		++l;
//		System.out.println(l);
//		return;
//	}
//	//input1:2
//	//input2:(10,{10,6,3,9,7,2,5,8,4,1}),(9,{6,3,9,7,2,5,8,4,1})
//	//Sampleoutput: {33,25}
	public static void main(String[] args) {
		
	}
//	C gettype(){
//		return new C();
//	}
//	A gettype(){
//		return this;
//	}
	
	String gettype(){
		return "";
	}
	/*public static int[] GetBrightnessValue(int input1,String input2)
	{
		
		int[] output = new int[input1];
		String[] testcasesStrings = new String[input1];
		int[][] peartIntArrays = new int[input1][];
		String TESTCASES = input2;
		
		//Write code here
		System.out.println(input2);


		for(int testcase=0;testcase<input1;testcase++){
			int teststart=TESTCASES.indexOf(OPEN_BRACKET);
			int testend=TESTCASES.indexOf(CLOSE_BRACKET);
			testcasesStrings[testcase] = TESTCASES.substring(teststart+1, testend);
			System.out.println(testcasesStrings[testcase]);
			peartIntArrays[testcase]=getPearls(testcasesStrings[testcase]);
			output[testcase]=splitPearls(peartIntArrays[testcase]);
			TESTCASES=TESTCASES.substring(testend+1, TESTCASES.length());
			System.out.println(TESTCASES);
		}
		
		System.out.println(output);
		return output;
	}
	
	public static int[] getPearls(String individualPearlString){
		String testcase = individualPearlString;
		int nindex = testcase.indexOf(comma);
		int noOfpearls = Integer.parseInt(testcase.substring(0, nindex));
		String[] pearlsInThisTC = new String[noOfpearls];
		int pearlsStartIndex = testcase.indexOf(OPEN_FLR_BRACKET);
		int pearlsCloseIndex = testcase.indexOf(CLOSE_FLR_BRACKET);
		String pearls = testcase.substring(pearlsStartIndex+1, pearlsCloseIndex);
		pearlsInThisTC = pearls.split(comma);
		int[] pearlsasInt = new int[noOfpearls];
		for(int pearlIndex =0;pearlIndex<pearlsInThisTC.length;pearlIndex++){
			pearlsasInt[pearlIndex]=Integer.parseInt(pearlsInThisTC[pearlIndex]);
		}
		return pearlsasInt;
	}
	
	public static int splitPearls(int[] pearls){
		final int diffPercentage = 10;
		final int maxdiff_NoOfpearls = 3;
		int MaxDiffBetweenNoOfPearls; float OriginalAVG;
		int percentageDiff = pearls.length/diffPercentage;
		if(percentageDiff > maxdiff_NoOfpearls){
			MaxDiffBetweenNoOfPearls = percentageDiff;
		}else{
			MaxDiffBetweenNoOfPearls = maxdiff_NoOfpearls;
		}
		List<Integer> OriginalString=new ArrayList<Integer>();
		for(int i=0;i<pearls.length;i++){
			OriginalString.add(pearls[i]);
		}
		OriginalAVG=calculateAvgBrightness(OriginalString);
		System.out.println("Avg="+OriginalAVG+" \n"+OriginalString );
		Collections.sort(OriginalString);Collections.reverse(OriginalString);
		System.out.println(OriginalString);
		List<Integer> pearlString1=new ArrayList<Integer>();
		List<Integer> pearlString2=new ArrayList<Integer>();
		
		int max=0;int max1=1;
		while(OriginalString.size()>0){
			pearlString1.add(OriginalString.get(0));
			if(OriginalString.size()>1){
				pearlString2.add(OriginalString.get(1));
				
				if(calculateAvgBrightness(pearlString2)<OriginalAVG){
					pearlString2.remove(OriginalString.get(1));
					if(pearlString1.size()-pearlString2.size()>MaxDiffBetweenNoOfPearls){
						return 0;
					}else{	
						pearlString1.add(OriginalString.get(1));
					}
				}
				OriginalString.remove(1);
			}
			OriginalString.remove(0);
			if(OriginalString.size()>0){
			Collections.reverse(OriginalString);
				pearlString1.add(OriginalString.get(0));
			if(OriginalString.size()>1){
				pearlString2.add(OriginalString.get(1));
				OriginalString.remove(1);
			}
			OriginalString.remove(0);
			Collections.reverse(OriginalString);
			}
		}
		
		if(calculateSumBrightness(pearlString1)>calculateSumBrightness(pearlString2)){
			return calculateSumBrightness(pearlString1);
		}else{
			return calculateSumBrightness(pearlString2);
		}
	}
	
//	public static boolean checkDifference(List<Integer> pearls1,List<Integer> pearls2,int MaxDiffBetweenNoOfPearls){
//		if((calculateAvgBrightness(pearls1)-calculateAvgBrightness(pearls2))>MaxDiffBetweenNoOfPearls)
//	}
	public static float calculateAvgBrightness(List<Integer> pearls){
		
		if(pearls.size()==0){
			return 0;
		}
		float avg;
		float sum=0;
		for(int i=0;i<pearls.size();i++){
			sum+=pearls.get(i);
		}
		avg=sum/pearls.size();
		return avg;
	}
	public static int calculateSumBrightness(List<Integer> pearls){
		
		if(pearls.size()==0){
			return 0;
		}
		int sum=0;
		for(int i=0;i<pearls.size();i++){
			sum+=pearls.get(i);
		}
		return sum;
	}*/
	
}
