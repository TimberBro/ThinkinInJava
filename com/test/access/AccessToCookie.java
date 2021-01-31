package com.test.access;

public class AccessToCookie {

  public static void main(String[] args) {
    Cookie cookie = new Cookie();
    System.out.println(cookie.width);
    System.out.println(cookie.thick);
    //System.out.println(
    //    cookie.weight); // Error:(9, 30) java: weight has private access in com.test.access.Cookie
    cookie.pub();
    cookie.prot();
    //cookie.priv(); // Error:(12, 11) java: priv() has private access in com.test.access.Cookie
  }
}
