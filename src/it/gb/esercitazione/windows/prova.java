package it.gb.esercitazione.windows;

import java.util.PriorityQueue;
import java.util.Scanner;

public class prova {

	public static void main(String[] args) {
		//11111111111111111111111111111111111111111111111111111111111111
		//String S = "11100";
		//int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
		//System.out.println("ciao "+S.length());
		//System.out.println("Soluzione: "+method(S));
		//System.out.println("Soluzione: "+method2(A));
//		String argsd [] = {"a", "n", "c"};
//		System.out.println(Integer.parseInt("x"));
//		
//			 Scanner sc = new Scanner(System.in);
//		        String sub = sc.nextLine();
//		        String ab = "Ciao$$##5$$##2";
//		        ItemSeparator itemData = new ItemSeparator(ab);
//		        System.out.println("Item Name: " + itemData.getName());
//		        System.out.println("Item Price: " + itemData.getPrice());
//		       System.out.println("Item Quantity: " + itemData.getQuantity());
		
		int c = -1;
		int a = 4;
		int b = 0;
		try {
			c = a / b;
		}
		catch (Exception e) {
			System.out.println("Esception");
		}
		finally {
			System.out.println("Finally");
		}

	
	}
	


	
	public static int method(String S) {
//	        long V=  Long.parseLong(S,2);
//	        int i=0;
//	        for(; V>0; i++){
//	        	System.out.println(V);
//	            if(V%2==0){
//	                V = V/2;
//	            } else {
//	                V--;
//	            }
//	        }
			S = S.replaceFirst("^0+(?!$)", "");
			int i = 0;
			int r = 1;
			for (char ch: S.toCharArray()) {
				i++;
				if(i>1) {
					if(ch == '1' ) {
						r = r+2;	
					} else {
						r++;
					}
					
				}
			}
	        return r;
	}
	
	
	public static int method2(int[] A) { int diff;
		int diff1 = 0;
	    int diffp = 999999999;
	    int found = 0;
	    for(int i=0; i<A.length-1; i++) {
	    	int c = 1;
	        for(int j=i; j<A.length; j++){
	        	
	            diff1 = A[j]-A[i];
	            if(diff1==diffp) {
	            	c++;
	            	if(c>2) {
	                found++;
	            	}
	            } else if(i>0){
	                diffp = diff1;
	                i--;
	                j = A.length;
	            }
	        }
	    }
	
	    return found;
}

}
