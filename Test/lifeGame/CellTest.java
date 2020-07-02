package lifeGame;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellTest {
    private static Cell cell=new Cell(0,0);
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        ;
    }

    @Test
    public void testsetStatus(){
        cell.setStatus(0);
        assertEquals(0,cell.getStatus());
        cell.setStatus(1);
        assertEquals(1,cell.getStatus());
    }

    @Test
    public void testsetLiving(){
        cell.setLiving(0);
        assertEquals(0,cell.getLiving());
        cell.setLiving(8);
        assertEquals(8,cell.getLiving());
    }

    @Test
    public void testUpdateStatus() {
        cell.setLiving(1);
        cell.UpdateStatus();
        assertEquals(0,cell.getStatus());
        cell.setLiving(3);
        cell.UpdateStatus();
        assertEquals(1,cell.getStatus());
        cell.setLiving(4);
        cell.UpdateStatus();
        assertEquals(0,cell.getStatus());
        cell.setStatus(1);
        cell.setLiving(2);
        cell.UpdateStatus();
        assertEquals(1,cell.getStatus());
    }

}

