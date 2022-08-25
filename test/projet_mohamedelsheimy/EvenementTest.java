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
public class EvenementTest {

    public EvenementTest() {
    }

    /**
     * Test Constructeur sans Exception.
     */
    @Test
    public void TestConstructeur() throws ErreurDate, ErreurEvenement {
        System.out.println("TestConstructeur1");
        Date debut = new Date(01, 02, 2022, 05, 25);
        Date fin = new Date(01, 02, 2022, 06, 25);

        Date debutPrevue = new Date(01, 02, 2022, 05, 25);
        Date finPrevue = new Date(01, 02, 2022, 06, 25);

        Evenement instance = new Evenement("clinique", debut, fin);

        assertEquals(instance.getNom(), "clinique");
        assertEquals(instance.getDebut().toString(), debutPrevue.toString());
        assertEquals(instance.getFin().toString(), finPrevue.toString());
    }//

    /**
     * Test Constructeur avec Exception.
     */
    @Test(expected = ErreurEvenement.class)
    public void TestConstructeur2() throws ErreurDate, ErreurEvenement {
        System.out.println("TestConstructeur2 avec exception");
        // debut = fin (duree=null)
        Date debut = new Date(01, 02, 2022, 05, 25);
        Date fin = new Date(01, 02, 2022, 05, 25);
        Evenement instance = new Evenement("clinique", debut, fin);
    }//
}
