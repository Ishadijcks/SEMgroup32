import static org.junit.Assert.*;

import java.util.ArrayList;

import game.log.LogSettings;
import game.log.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTest {

    @Before
    public void initTest() {
        Logger.log("Hoi", 1, 5);
        Logger.log("Hallo", 2, 4);
        Logger.log("Hoe", 3, 3);
        Logger.log("Gaat", 4, 2);
        Logger.log("Het", 5, 1);
        Logger.log("Met", 1, 3);
        Logger.log("Jou", 1, 2);
        Logger.log("Test", 3, 3);
        Logger.log("Test2", 6, 1);
        Logger.log("Test3", 8, 1);
        Logger.log("Test4", 3, 1);
        Logger.log("Test5", 2, 2);
    }


//
//    @Test
//    public void getFilteredLogsTest2() {
//        ArrayList<Integer> categoryList = new ArrayList<Integer>();
//        categoryList.add(3);
//        categoryList.add(4);
//        assertEquals(6, Logger.getFilteredLogs(categoryList, 2).size());
//        categoryList.add(5);
//        assertEquals(9, Logger.getFilteredLogs(categoryList, 2).size());
//    }
//
//    @Test
//    public void getFilteredLogsTestWrongInput() {
//        ArrayList<Integer> categoryList = new ArrayList<Integer>();
//
//        assertEquals(0, Logger.getFilteredLogs(categoryList, 5).size());
//        categoryList.add(100);
//        assertEquals(0, Logger.getFilteredLogs(categoryList, 5).size());
//    }
//
//    @Test
//    public void getFilteredLogsTest4() {
//        ArrayList<Integer> categoryList = new ArrayList<Integer>();
//        categoryList.add(1);
//        categoryList.add(2);
//        assertEquals(0, Logger.getFilteredLogs(categoryList, 1).size());
//        categoryList.add(3);
//        categoryList.add(4);
//        assertEquals(4, Logger.getFilteredLogs(categoryList, 1).size());
//    }
//}
