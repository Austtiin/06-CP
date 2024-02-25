
package Module06CP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

interface Patient{
	public int CalScore();
	public int CalBMI();
}


 class Person implements Patient{
	String Name, Birthday, Weight, Height;
	String InsuranceCat = null;
	public int CalScore(int InBMI) {
		
		if(InBMI <= 18.5)
		{
			this.InsuranceCat = "Low";
			return 0;
			
		}
		if(InBMI > 18.6 & InBMI < 24.9)
		{
			this.InsuranceCat = "Low";
			return 1;
		}
		if(InBMI > 25 & InBMI < 29.9)
		{
			this.InsuranceCat = "High";
			return 2;
		}
		if(InBMI > 29.9)
		{
			this.InsuranceCat = "Highest";
			return 3;
		}
		return InBMI;
		
	}
	
	
	public int CalBMI() {
		Float OUT = Float.parseFloat(this.Weight) / Float.parseFloat(this.Height) / Float.parseFloat(this.Height) * 703;
		return OUT.intValue();
		
	}


	@Override
	public int CalScore() {
		return 0;
	}
	
	
	 
	
}

 class PersonBMIScore extends Person  {
	String[] BMIScore = {"Underweight", "Normal-Weight", "Over-Weight", "Obesity"};
	int OURBMINUM;
	void WriteTO() throws IOException {
		File fout = new File("C:/JavaFiles/OutputM04.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
			bw.write(this.Name);
			bw.newLine();
			bw.write(this.Weight);
			bw.newLine();
			bw.write(this.Height);
			bw.newLine();
			bw.write(this.Birthday);
			bw.newLine();
			bw.write(this.InsuranceCat);
			bw.newLine();
			bw.write(this.BMIScore[OURBMINUM]);
			bw.newLine();
			bw.newLine();
			
			bw.newLine();
			bw.close();
	}
}

public abstract class M06CP extends Person{

	public static void main(String[] args) {
		
		Scanner UserInput = new Scanner(System.in);
		PersonBMIScore Person1 = new PersonBMIScore();
		Deque<String> nameArray = new ArrayDeque<String>();
		
		
		try {
			
		while(true) {
			
			while(!UserInput.equals("q")) {
				System.out.println("Please Enter Name, q to exit");
				Person1.Name = UserInput.nextLine();
				if (Person1.Name.equals("q")) {
					break;
				}
				nameArray.add(Person1.Name);
		System.out.println("Please Enter Height in Inches");
		Person1.Height = UserInput.nextLine();
		nameArray.add(Person1.Height);
		
		System.out.println("Please Enter Wight In LBS");
		Person1.Weight = UserInput.nextLine();
		nameArray.add(Person1.Weight);
		
		System.out.println("Please Enter Birthday");
		Person1.Birthday = UserInput.nextLine();
		nameArray.add(Person1.Birthday);
		
		
		System.out.println("\n");
		System.out.println("\n Welcome " + Person1.Name);
		
		System.out.println("Based On You Input You Are In The Range Of: ");
		System.out.println(Person1.BMIScore[Person1.CalScore(Person1.CalBMI())]);
		Person1.OURBMINUM = Person1.CalScore(Person1.CalBMI());
		System.out.println("And Have an Insurance Payment of: ");
		System.out.println(Person1.InsuranceCat);
		Person1.WriteTO();
		
		
		////
		System.out.println(nameArray);
		System.out.println(nameArray.pop());
	
		}
			break;
		}
		
		
		
		
		}catch(Exception e) {}
		
		}
		
		
	}


