package com.chenhongzhi.maven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetStudentTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("AfterMethod");
    }

    @Test
    public void testGetStudent() {
        System.out.println("TestMehtod");
        GetStudent.getStudent("sdfsdfhd");
    }
}