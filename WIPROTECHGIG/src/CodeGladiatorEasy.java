
public class CodeGladiatorEasy {

	public static int passCount(int input1,int input2,int input3)
	{
		int move = input3%input1;
		int noOfTimesBallPassed=0;
		int[] playerCount=new int[input1];
		int currentPlayerCount = 0;
		if(input1>2 && input2>2 && input3>0){
			while(true){
				playerCount[currentPlayerCount]++;
				
				if(playerCount[currentPlayerCount]==input2){
					return noOfTimesBallPassed;
				}
				noOfTimesBallPassed++;
				
				if(playerCount[currentPlayerCount]%2 ==0){
					if((currentPlayerCount-move)<0){
						currentPlayerCount=input1+(currentPlayerCount-move);
					}else{
					currentPlayerCount=currentPlayerCount-move;
					}
				}else{
					currentPlayerCount=(currentPlayerCount+move)%input1;
				}
			}
		}
		return noOfTimesBallPassed;
	}



	public static void main(String[] args) {
		System.out.println(passCount(10, 10, 3));
//		System.out.println(-5 % 6);
	}

}
