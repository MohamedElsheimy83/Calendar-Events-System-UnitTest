/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_mohamedelsheimy;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// using SuiteClasses to do parameterized and nonparameterizes tests at the same test class
@RunWith(Suite.class)
@SuiteClasses({AgendaTest.AgendaTestNonParameter.class, AgendaTest.AgendaTestParameter.class})

/**
 *
 * @author Mohamed
 */
public class AgendaTest {

    public static class TestBase {

        public TestBase() {
        }
    }//

    // non parameterized test 
    public static class AgendaTestNonParameter extends TestBase {

        /**
         * Test Constructeur .
         */
        @Test
        public void TestConstructeur() throws ErreurDate, ErreurEvenement {
            System.out.println("Test Constructeur");
            Date debut = new Date(01, 02, 2022, 05, 25);
            Date fin = new Date(01, 02, 2022, 06, 25);
            Evenement evenement = new Evenement("clinique", debut, fin);
            Agenda instance = new Agenda();
            instance.ajouter(evenement);

            assertEquals("Evenement{nom=clinique, debut=Date{jour=1, mois=2, annee=2022, heure=5, minute=25}, fin=Date{jour=1, mois=2, annee=2022, heure=6, minute=25}}", instance.getEvenements().get(0).toString());
            assertEquals("clinique", instance.getEvenements().get(0).getNom());
            assertEquals(debut.toString(), instance.getEvenements().get(0).getDebut().toString());
            assertEquals(fin.toString(), instance.getEvenements().get(0).getFin().toString());
        }//

        /**
         * Test methode Ajouter .
         */
        @Test
        public void TestAjouter() throws ErreurDate, ErreurEvenement {
            System.out.println("Test Ajouter");
            //evenement1
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);
            //evenement2
            Date debut2 = new Date(01, 03, 2022, 05, 25);
            Date fin2 = new Date(01, 03, 2022, 06, 25);
            Evenement evenement2 = new Evenement("Clinique2", debut2, fin2);

            assertTrue(instance1.ajouter(evenement2));
        }//

        /**
         * Test methode Supprimer .
         */
        @Test
        public void TestSupprimer() throws ErreurDate, ErreurEvenement {
            System.out.println("Test Supprimer");
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);

            assertTrue(instance1.supprimer("Clinique"));
        }//

        /**
         * Test methode Chercher Evenement .
         */
        @Test
        public void TestChercherEvenement() throws ErreurDate, ErreurEvenement {
            System.out.println("Test Chercher Evenement");
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);

            assertEquals("Clinique", instance1.chercherEvenement(debut1));
        }//

        /**
         * Test methode DateDebut avec Exception.
         */
        @Test(expected = ErreurAgenda.class)
        public void TestDateDebut() throws ErreurDate, ErreurEvenement, ErreurAgenda {
            System.out.println("Test DateDebut >> avec exception");
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);
            //Event name doesn't exist >> raise exception        
            assertEquals(debut1, instance1.dateDebut("GYM"));
        }//

        /**
         * Test methode DateFin sans Exception.
         */
        @Test
        public void TestDateFin() throws ErreurDate, ErreurEvenement, ErreurAgenda {
            System.out.println("Test DateFin");
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);

            assertEquals(fin1, instance1.dateFin("Clinique"));
        }//

        /**
         * Test methode Prevu.
         */
        @Test
        public void TestPrevu() throws ErreurDate, ErreurEvenement, ErreurAgenda {
            System.out.println("Test Prevu");
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);

            assertTrue(instance1.prevu("Clinique"));
        }//
    }// class AgendaTestNonParameters

    /////////////////////////////////////////////////  4  ///////////////////////////////////////////
    // parameterized tests
    @RunWith(Parameterized.class)
    public static class AgendaTestParameter extends TestBase {

        private final Date date;
        private final String nom;

        public AgendaTestParameter(Date date, String nom) {
            this.date = date;
            this.nom = nom;
        }

        @Parameterized.Parameters
        public static Collection listTest() throws ErreurDate {
            Object[][] lp = {{new Date(01, 02, 2022, 05, 25), "Clinique"}, {new Date(01, 03, 2022, 05, 25), "GYM"}};
            return Arrays.asList(lp);
        }

        /**
         * Test methode ChercherEvenement Parameters.
         *
         */
        @Test
        public void TestChercherEvenementParameters() throws ErreurDate, ErreurEvenement, ErreurAgenda {
            System.out.println("Test ChercherEvenement >> Parameters");
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);

            //evenement2
            Date debut2 = new Date(01, 03, 2022, 05, 25);
            Date fin2 = new Date(01, 03, 2022, 06, 25);
            Evenement evenement2 = new Evenement("GYM", debut2, fin2);
            instance1.ajouter(evenement2);
            //test
            assertEquals(nom, instance1.chercherEvenement(date));
        }//

        /**
         * Test methode DateDebutParameters .
         *
         */
        @Test
        public void TestDateDebutParameters() throws ErreurDate, ErreurEvenement, ErreurAgenda {
            System.out.println("Test DateDebut>> Parameters");
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);

            //evenement2
            Date debut2 = new Date(01, 03, 2022, 05, 25);
            Date fin2 = new Date(01, 03, 2022, 06, 25);
            Evenement evenement2 = new Evenement("GYM", debut2, fin2);
            instance1.ajouter(evenement2);
            //test
            assertEquals(date.toString(), instance1.dateDebut(nom).toString());

        }//

        /**
         * Test methode DateFinParameters .
         *
         */
        @Test
        public void TestDateFinParameters() throws ErreurDate, ErreurEvenement, ErreurAgenda {
            System.out.println("Test DateFin>> Parameters >> test will fail(compared dates are not the same)");
            //evenement1
            Date debut1 = new Date(01, 02, 2022, 05, 25);
            Date fin1 = new Date(01, 02, 2022, 06, 25);
            Evenement evenement1 = new Evenement("Clinique", debut1, fin1);
            Agenda instance1 = new Agenda();
            instance1.ajouter(evenement1);

            //evenement2
            Date debut2 = new Date(01, 03, 2022, 05, 25);
            Date fin2 = new Date(01, 03, 2022, 06, 25);
            Evenement evenement2 = new Evenement("GYM", debut2, fin2);
            instance1.ajouter(evenement2);
            //test will be failed as the collection object include dateDebut
            assertEquals(date.toString(), instance1.dateFin(nom).toString());
        }//

    }//class AgendaTestParameters

} //class TestBase 
