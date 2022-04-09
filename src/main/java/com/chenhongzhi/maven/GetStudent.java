package com.chenhongzhi.maven;

public class GetStudent {
    public static String getStudent(String student){
        int length = student.length();
        System.out.println(student+" is name and length is"+length);
        return student+length;
    }
}
