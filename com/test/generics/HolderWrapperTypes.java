package com.test.generics;

public class HolderWrapperTypes {
  public static void main(String[] args) {
    Holder<Boolean> booleanHolder = new Holder<>();
    booleanHolder.set(true);
    Boolean b = booleanHolder.get();
    System.out.println(b);

    Holder<Character> characterHolder = new Holder<>();
    characterHolder.set('c');
    Character c = characterHolder.get();
    System.out.println(c);

    Holder<Byte> byteHolder = new Holder<>();
    byteHolder.set((byte) 127);
    Byte bt = byteHolder.get();
    System.out.println(bt);

    Holder<Short> shortHolder = new Holder<>();
    shortHolder.set((short) 1254);
    Short shrt = shortHolder.get();
    System.out.println(shrt);

    Holder<Integer> integerHolder = new Holder<>();
    integerHolder.set(5671286);
    Integer integer = integerHolder.get();
    System.out.println(integer);

    Holder<Long> longHolder = new Holder<>();
    longHolder.set(5789432L);
    Long lng = longHolder.get();
    System.out.println(lng);

    Holder<Float> floatHolder = new Holder<>();
    floatHolder.set(5912748F);
    Float flt = floatHolder.get();
    System.out.println(flt);

    Holder<Double> doubleHolder = new Holder<>();
    doubleHolder.set(4562.3253);
    Double dbl = doubleHolder.get();
    System.out.println(dbl);
  }
}
