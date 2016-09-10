package com.may.one;

import java.io.*;
public class CandidateCode 
{ 

    public static String[] amount_value(int input1,String[] input2)
    {
    	String[] result=null;
    	int[][] numbers=getArrayInBoard(input1, input2);
    	return result;
    }
    
    public static int[][] getArrayInBoard(int input1,String[] input2){
    	int[][] numbers = new int[input1][input1];
    	
    	for(int i=0;i<input1;i++){
    		String[] temp = input2[i].split("#");
    		for(int j=0;j<temp.length;j++){
    			numbers[i][j]=Integer.parseInt(temp[j]);
    		}
    	}
    	
    	return numbers;
    }
    
    public static void main(String[] args){
    	
    	String[] arr = {"12#45#33","94#54#23","98#59#27"};
    	amount_value(3, arr);
//    	String[] arr = {"12#45#33#27","94#54#23#53","98#59#27#62","11#51#67#13"};
//    	amount_value(4, arr);
    }
}