package com.test.control;

public class TelephoneNumber {
    public static String createPhoneNumber(int[] i){  // => returns "(123) 456-7890"
        return (String.format("(%d%d%d) %d%d%d-%d%d%d%d", i[0], i[1],i[2],i[3],i[4],i[5],i[6],i[7],i[8], i[9]));
    }
    public static void main(String[] args){
        System.out.println(createPhoneNumber(new int[] {1,2,3,4,5,6,7,8,9,0}));
    }
}
