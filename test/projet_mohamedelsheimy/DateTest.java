/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_mohamedelsheimy;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohamed
 */
public class DateTest {

    public DateTest() {
    }

    /**
     * Test Constructeur sans Exception.
     */
    @Test
    public void TestConstructeur() throws ErreurDate {
        System.out.println("TestConstructeur1");
        Date instance = new Date(01, 02, 2022, 05, 25);
        assertEquals(instance.getJour(), 01);
        assertEquals(instance.getMois(), 02);
        assertEquals(instance.getAnnee(), 2022);
        assertEquals(instance.getHeure(), 05);
        assertEquals(instance.getMinute(), 25);
    }//

    /**
     * Test Constructeur avec Exception.
     */
    @Test(expected = ErreurDate.class)
    public void TestConstructeur2() throws ErreurDate {
        System.out.println("TestConstructeur2 avec exception");
        //date before 01 janvier 2022,0h00
        Date instance = new Date(01, 02, 2021, 05, 25);
    }//
}
