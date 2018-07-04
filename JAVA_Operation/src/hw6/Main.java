package hw6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String str = keyboard.nextLine();
		String num1 = "";
		String num2 = "";
		String operator = "";
		String check = "";
		String result = "";
		int spacenext = 0;
		int space = str.indexOf(" ");
		int firstward = 1;
		int count = 0;
		int secondward = 1;
		if (str.substring(0, 1).equals("-"))
		{
			firstward=-1;
			num1 = str.substring(1, space);
		}
		else
		{
			num1 = str.substring(0, space);
		}
		while(space>=0){
			
			str = str.substring(space);
			operator = str.substring(1,2);
			space = str.indexOf(" ",1);
			spacenext = str.indexOf(" ",space+1);
			if(spacenext==-1)spacenext = str.length();
			if (str.substring(space+1,space+2).equals("-"))
			{
				secondward=-1;
				num2 = str.substring(space+2,spacenext);
			}
			else
			{
				secondward = 1;
				num2 = str.substring(space+1,spacenext);
			}
			str = str.substring(space);
			space = str.indexOf(" ",1);
			IOperation operation1 = new Subtraction();
			IOperation operation2 = new Comparison();
			IOperation operation3 = new Addition();
			if(operator.equals("+")){
				check = operation2.perform(num1, num2);
				
				
				if(firstward==1&&secondward==1){
					result = operation3.perform(num1,num2);
					num1 = result;
				}
				else if(firstward==-1&&secondward==-1){
					firstward = -1;
					result = "-" + operation3.perform(num1, num2);
					num1 = operation3.perform(num1, num2);
				}
				else if(firstward==-1&&secondward==1){
					if (check.equals("large"))
					{
						firstward = -1;
						result = "-" + operation1.perform(num1,num2);
						num1 = operation1.perform(num1,num2);
					}
					else if (check.equals("small"))
					{
						firstward = 1;
						result = operation1.perform(num2,num1);
						num1 = result;
					}
					else if (check.equals("equal"))
					{
						firstward = 1;
						result = "0";
						num1 = "0";
					}
				}
				else if(firstward==1&&secondward==-1){
					if (check.equals("large"))
					{
						firstward = 1;
						result = operation1.perform(num1,num2);
						num1 = result;
					}
					else if (check.equals("small"))
					{
						firstward = -1;
						result = "-" + operation1.perform(num2,num1);
						num1 = operation1.perform(num2,num1);
					}
					else if (check.equals("equal"))
					{
						firstward = 1;
						result = "0";
						num1 = "0";
					}
				}
			}
			else if(operator.equals("-"))
			{					
				check = operation2.perform(num1,num2);
				if (firstward==1&&secondward==1)
				{
					if (check.equals("large"))
					{
						result = operation1.perform(num1,num2);
						num1 = result;
					}
					else if (check.equals("small"))
					{
						result = "-"+operation1.perform(num2,num1);
						firstward = -1;
					}
					else if (check.equals("equal"))
					{
						result = "0";
						firstward = 1;
						num1 = "0";
					}
				}
				else if(firstward==-1 && secondward==-1){
					
					if (check.equals("large"))
					{
						result ="-"+operation1.perform(num1,num2);
						num1 = result;
					}
					else if (check.equals("small"))
					{
						result = operation1.perform(num2,num1);
						firstward = 1;
					}
					else if (check.equals("equal"))
					{
						result = "0";
						firstward = 1;
						num1 = "0";
					}
				}
				else if (firstward==-1 && secondward==1)
				{
					result = "-" + operation3.perform(num1,num2);
					num1 = operation3.perform(num1,num2);
					firstward = -1;
					
				}
				else if (firstward==1 && secondward==-1)
				{
					result = operation3.perform(num1,num2);
					num1 = operation3.perform(num1,num2);
					firstward = 1;
				}
			}
			else if (operator.equals(">"))
			{
				IOperation operation = new Comparison();
				result = operation.perform(num1,num2);
				if (result.equals("large"))
				{
					if(firstward==1)
						result = "true";
					else{
						result = "false";
					}
				}
				else if(result.equals("small"))
				{
					if(secondward==-1)
						result = "true";
					else result = "false";
				}else result = "false";
			
			}
			else if (operator.equals("<"))
			{
				IOperation operation = new Comparison();
				result = operation.perform(num1,num2);
				
				if (result.equals("small"))
				{
					if(secondward==1)
						result = "true";
					else result = "false";
				}
				else if(result.equals("large"))
				{
					if(firstward==-1)result = "true";
					else result = "false";
				}else result = "false";
			}
			else if (operator.equals("="))
			{
				IOperation operation = new Comparison();
				result = operation.perform(num1,num2);
				
				if (result.equals("equal")&&firstward==secondward)
				{
					result = "true";
				}
				else
				{
					result = "false";
				}
			}
			//operator = "";
		}
		if(result.charAt(0)=='-'){
			for(int i = 1;i<result.length()-1;i++){
				if(result.charAt(i)!='0'){
					break;
				}count++;
			}
			count++;
			result = "-" + result.substring(count, result.length());
		}
		else{
			for(int i = 0;i<result.length()-1;i++){
				if(result.charAt(i)!='0'){
					break;
				}else count++;
			}
			result = result.substring(count, result.length());
		}
		System.out.print(result);
	}

}
