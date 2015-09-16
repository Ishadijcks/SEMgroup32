import static org.junit.Assert.*;

import java.util.ArrayList;

import game.Logger;

import org.junit.Test;


public class LoggerTest {

    @Test
    public void test() {
        Logger.log("Hoi",1 , 5);
        Logger.log("Hallo",2 , 4);
        Logger.log("Hoe",3 , 3);
        Logger.log("Gaat",4 , 2);
        Logger.log("Het",5 , 1);
        Logger.log("Met",1 , 3);
        Logger.log("Jou",1 , 2);
        
        ArrayList<Integer> categoryList = new ArrayList<Integer>();
        categoryList.add(1);
        categoryList.add(2);
        categoryList.add(100);
        for( int i = 0; i<Logger.getFilteredLogs(categoryList, 4).size(); i++){
            System.out.println(Logger.getFilteredLogs(categoryList, 4).get(i).getMessage());
        }
    }

}
