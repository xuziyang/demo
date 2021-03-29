package com.xzy.jvm.escape;

public class EscapeTest {
    public static void main(String[] args) throws InterruptedException {
        String hello_world = test("hello world", "!");
        System.out.println(hello_world);
        Thread.sleep(1000000L);
    }
    
    public static String test(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(str2);
        return sb.toString();
    }
    
}
