package hw6;

public class Addition implements IOperation {
	public String perform (String num1,String num2){
		String ans = "";
		int temp = 0;
		int n1 = 0;
		int n2 = 0;
		int lengthnum1 = num1.length();
		int lengthnum2 = num2.length();
		if(lengthnum1<lengthnum2){
			for(int i = lengthnum1;i<lengthnum2;i++){
				num1 = "0" + num1;
			}
		}else if(lengthnum1>lengthnum2){
			for(int i = lengthnum2;i<lengthnum1;i++){
				num2 = "0" + num2;
			}
		}
		for (int i = num1.length()-1; i>=0 ; i--)
		{
			n1 = num1.charAt(i)-48;
			n2 = num2.charAt(i)-48;

			if ((n1+n2+temp)>=10)
			{
				if(i==0){
					ans = Integer.toString((n1+n2+temp))+ans;
					continue;
				}
				ans = Integer.toString((n1+n2+temp-10))+ans;
				temp=1;
			}
			else
			{
				ans = Integer.toString((n1+n2+temp))+ans;
				temp = 0;
			}
		}
		return ans;
	}
}
