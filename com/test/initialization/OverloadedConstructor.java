package com.test.initialization;

public class OverloadedConstructor {
    char Symbol;
    OverloadedConstructor(){
        this('w');
        this.Symbol = 'S';
        System.out.println("This is first constructor with void arguments." + Symbol);

    }
    OverloadedConstructor(char x){
        Symbol = x;
        System.out.println("This is second constructor with char argument. Char is " + Symbol);
    }
    public static void main(String[] args){
        OverloadedConstructor b = new OverloadedConstructor();
    }
}
