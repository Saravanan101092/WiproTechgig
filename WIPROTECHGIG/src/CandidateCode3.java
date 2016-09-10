import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JSlider;


public class CandidateCode3{

	public static Set<String> products;
	public static List<Customer> customers;
	public static int maxLike;
	public static class Customer{
		public String Name;

		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Customer(String name){
			this.Name = name;
			productLikingMap = new HashMap<String, Integer>();
			likes = new TreeSet<String>();
		}
		public Map<String, Integer> getProductLikingMap() {
			return productLikingMap;
		}
		public void setProductLikingMap(Map<String, Integer> productLikingMap) {
			this.productLikingMap = productLikingMap;
		}
		public Map<String,Integer> productLikingMap;
		public Set<String> likes;

		public Set<String> getLikes() {
			return likes;
		}
		public void setLikes(Set<String> likes) {
			this.likes = likes;
		}
	}

		public static String process(List<Customer> customers){
		//		List<Customer> tempCustomers = new ArrayList<Customer>();
		//		tempCustomers.addAll(customers);
		//		AllotProduct(avaliableProducts, 0,tempCustomers);
		List<List<String>> combinations = new ArrayList<List<String>>();
		for(Customer customer : customers){

			combinations = getCombinations(customer.getLikes(), combinations);
		}
		List<List<String>> solutions=findSolutions(combinations);

		List<List<String>> maxSolutions;
		if(solutions.size()>0){
			maxSolutions=getSolutionsWithLikes(solutions);
		}else{
			return "Matching not possible";
		}


		return writeOutput(maxSolutions);
	}

	public static List<List<String>> getSolutionsWithLikes(List<List<String>> solutions){
		Map<Integer,List<List<String>>> solutionsWithLikes = new HashMap<Integer,List<List<String>>>();

		int max=0;
		for(List<String> thissolution : solutions){
			int likelinessSize =0;
			for(int i=0;i<thissolution.size();i++){
				Customer thisCustomer = customers.get(i);
				likelinessSize+=thisCustomer.getProductLikingMap().get(thissolution.get(i));
			}
			if(max<likelinessSize){
				max=likelinessSize;
				if(solutionsWithLikes.containsKey(likelinessSize)){
					solutionsWithLikes.get(likelinessSize).add(thissolution);
				}else{
					List<List<String>> maxSolutions = new ArrayList<List<String>>();
					maxSolutions.add(thissolution);
					solutionsWithLikes.put(likelinessSize,maxSolutions);
				}
			}
		}
		maxLike=max;
		return solutionsWithLikes.get(max);
	}
	public static boolean isSolution(List<String> thisCombination){
		for(String product :products){
			if(!thisCombination.contains(product)){
				return false;
			}
		}
		return true;
	}
	public static List<List<String>> findSolutions(List<List<String>> combinations){
		List<List<String>> Solutions = new ArrayList<List<String>>();

		for(List<String> thisCombination :combinations){
			if(isSolution(thisCombination)){
				Solutions.add(thisCombination);
			}
		}
		combinations.clear();
		return Solutions;
	}


	public static List<List<String>> getCombinations(Set<String> newList, List<List<String>> listWithPreviousCombinations) {

		List<List<String>> listWithNewCombinations = new ArrayList<List<String>>();
		List<String> keyList;
		if (listWithPreviousCombinations.isEmpty()) {
			for (String value : newList) {
				keyList = new ArrayList<String>();
				keyList.add(value);
				listWithNewCombinations.add(keyList);
			}
		} else {
			for (String newString : newList) {
				for (List<String> stringlist : listWithPreviousCombinations) {
					keyList = new ArrayList<String>();
					for (String value : stringlist) {
						keyList.add(value);
					}
					keyList.add(newString);
					listWithNewCombinations.add(keyList);
				}
			}
		}
		listWithPreviousCombinations.clear();
		return listWithNewCombinations;
	}

	public static List<Customer> readInput(final String input){
		String inputString = input;
		List<Customer> customers = new ArrayList<Customer>();
			
		while(inputString.contains("(")){
			String custName="";
			String likelynessStr = "";
			int openbrckt = inputString.indexOf("(");
			int clsebrckt = inputString.indexOf(")");
			custName = inputString.substring(0,openbrckt); 
			likelynessStr = inputString.substring(openbrckt+1, clsebrckt);
			Customer thisCustomer = new Customer(custName);
			String[] productsStr = likelynessStr.split(",", -1);
			for(int i=0;i<productsStr.length;i++){
				String[] productStr = productsStr[i].split("-", -1);
				if(productStr.length>1){
					thisCustomer.getProductLikingMap().put(productStr[0], Integer.parseInt(productStr[1]));
					thisCustomer.getLikes().add(productStr[0]);
				}else{
					return null;
				}
				products.add(productStr[0]);
			}
			inputString=inputString.substring(clsebrckt+1);
			customers.add(thisCustomer);
		}
		return customers;
	}


	public static String writeOutput(List<List<String>> maxSolutions){
		String output="";
		output+=maxLike;
		boolean isFirst = true;
		for(List<String> thisSolution:maxSolutions){
			if(isFirst){
				for(int i=0;i<thisSolution.size();i++){
					output+="("+customers.get(i).getName()+","+thisSolution.get(i)+")";
				}
			}else{
				for(int i=0;i<thisSolution.size();i++){
					output+="#("+customers.get(i).getName()+","+thisSolution.get(i)+")";
				}
			}
			isFirst=false;
		}

		return output;
	}


	public boolean hasAvailableProducts(List<Customer> customers, Set<String> availableProducts){

		for(Customer customer : customers){
			if(!customerAvailableLikes(customer, availableProducts)){
				return false;
			}	
		}
		return true;
	}

	public boolean customerAvailableLikes(Customer customer,Set<String> availableProducts ){
		for(String product: customer.getLikes()){
			if(availableProducts.contains(product)){
				return true;
			}
		}
		return false;
	}
public static String matching(String input){
		
		products = new TreeSet<String>();
		String answer = "";

		customers = readInput(input);
		if(customers !=null &&customers.size()==products.size()){
			//		NOofCustomers = customers.size();
			answer=process(customers);
		}else{
			return "Matching not possible";
		}
		return answer;
	}



	public static void main(String[] args){
		CandidateCode3 n = new CandidateCode3();
		//		String input = "C1(P2-5,P5-3)C2(P1-4,P2-6)C3(P1-7,P3-5,P2-6)C4(P2-10,P5-5)C5(P4-9)";
		String input = "C1(P2-5,P4-3)C2(P1-4,P2-6)C3(P1-7,P3-5,P4-6)C4(P4-10,P5-5)C5(P4-9,P5-3)";
		System.out.println(n.matching(input));
	}
}

