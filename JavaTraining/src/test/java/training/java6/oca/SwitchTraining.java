package training.java6.oca;

import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import training.AbstractTest;

public class SwitchTraining extends AbstractTest {
    
    @Test
    public void switchTest1() {
        switchTest(-1);
    }
    
    @Test
    public void switchTest2() {
        switchTest(2);
    }

    public void switchTest(byte a) {
        switch (a) {
        default:
            System.out.println("default");
        case 0:
            System.out.println("0");
            break;
        case 1:
            System.out.println("1");
        case 2:
            System.out.println("2");
        case 3:
            System.out.println("3");
            break;
        case 4:
            System.out.println("4");
            break;
        }
    }
    
    @Test
    public void switchEnumTest() {        
        Season e = Season.FALL;
        Season t;
        switch(e) {
        case 0: //NOT COMPILE
            break;
        case Season.WINTER: //NOT COMPILE
            break;
        case SPRING:
            break;
        }
    }
    
    @Test
    public void switchEnum2Test() {
        Integer i1 = 0;
        Integer i2;
        switch(i1) {
        case 0:
            i2=0;
            break;
        }
        i2.intValue(); 
        // Unresolved compilation problem
        // The local variable i2 may not have been initialized
        // use default 
    }
    
    enum Season {
        WINTER, SPRING, SUMMER, FALL;
    }

}
