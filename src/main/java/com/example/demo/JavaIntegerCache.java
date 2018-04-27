package com.example.demo;

public class JavaIntegerCache {
	public static void main(String... strings) {
		 
        Integer integer1 = 3;
        Integer integer2 = 3;
        Boolean b=true;
        Boolean b1=true;
       if(b instanceof Boolean)
        if(b==b1){
        	System.out.println("xxxxxxxxxxxxx");
        }
 
        if (integer1 == integer2)//返回的竟然是true
            System.out.println("integer1 == integer2");
        else
            System.out.println("integer1 != integer2");
 
        Integer integer3 = 300;
        Integer integer4 = 300;
 
        if (integer3 == integer4)//返回false
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");
 
    }

}
