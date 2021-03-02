/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PrikaziKoncerteLogikaTest {

    @Test
    public void testPrikaziSveKoncerteFail() {

        System.out.println("prikaziSveKoncerte");

        PrikaziKoncerteLogika instance = new PrikaziKoncerteLogika();

        ObservableList<Koncert> expResult = FXCollections.observableArrayList();
        ObservableList<Koncert> result = instance.prikaziSveKoncerte();

        System.out.println(result);
        System.out.println(expResult);
        
        assertNotEquals(expResult, result);
    }

    @Test
    public void testPrikaziSveKoncertePass()
    {
        System.out.println("prikaziSveKoncerte");
        PrikaziKoncerteLogika instance = new PrikaziKoncerteLogika();

        ObservableList<Koncert> expResult = FXCollections.observableArrayList();
        ObservableList<Koncert> result = instance.prikaziSveKoncerte();

        System.out.println(expResult);
        System.out.println(result);

        assertEquals(expResult, result);

    }
}