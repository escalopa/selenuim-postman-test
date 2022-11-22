package org.example;

import org.example.basic.CreateWorkSpaceTest;
import org.example.basic.EditWorkSpaceTest;
import org.junit.Test;
import org.junit.Before;


public class MainTest {


    TestBase testBase;

    @Before
    public void setUp() {
        testBase = new TestBase();
    }

    @Test
    public void createWorkSpaceTest() {
        CreateWorkSpaceTest.run(testBase);
    }

    @Test
    public void editWorkSpaceTest() {
        EditWorkSpaceTest.run(testBase);
    }
}
