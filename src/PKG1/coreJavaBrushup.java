package PKG1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class coreJavaBrushup {

	public static void main(String[] args) {
		
		//Array concept
		
		int[] arr = new int[4];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		
		System.out.println(arr[2]);
		
		int[] arr1 = {5,6,7,8,9};
		System.out.println(arr1[3]);
		
		//iterate using for loop
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		System.out.println("##############");
		
		//we use shortcut foreach loop as well to iterate the output
		for(int a1: arr1)
		{
			System.out.println(a1);
		}
		System.out.println("##############");
		String[] name = {"Ram","Shyam","Mohan"};
		for(String s : name)
		{
			System.out.println(s);
		}
		
		//////ArrayList- not giving any size, creating string arraylist
		ArrayList<String> a= new ArrayList<String>();
		a.add("Rama");
		a.add("Kumar");
		a.add("mIshra");
		
		System.out.println("getting ArrayList value: "+a.get(1));
		
		for(String s1: a)
		{
			System.out.println(s1);
		}
		
		System.out.println(a.contains("Rama"));
		
		// how to convert array to arraylist
		String[] state = {"Bihar","UP","MP"};
		List<String> arrToList = Arrays.asList(state);
		System.out.println(arrToList.contains("UP"));
		
		/////String concepts
		String fName = "Avinash Kumar Mishra";
		//splliting by space and storing in array because we have multiple values
		String[] splitedString= fName.split(" ");
		for(String s2:splitedString)
		{
			System.out.println(s2);
		}
		String[] splitedString2= fName.split("Kumar");
		System.out.println(splitedString2[0]);
		System.out.println(splitedString2[1]);
		//trim so all space go
		System.out.println(splitedString2[1].trim());
	}

}
