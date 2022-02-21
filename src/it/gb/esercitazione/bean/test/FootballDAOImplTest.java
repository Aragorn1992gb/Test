package it.gb.esercitazione.bean.test;

import static org.junit.Assert.assertNotNull;

import org.junit.*;

import it.gb.esercitazione.daoImpl.FootballDAOImpl;

// Junit class test for footballDAOImpl methods
public class FootballDAOImplTest {
	FootballDAOImpl footballDAOImpl = new FootballDAOImpl(); // Class tested
	
    @Test
    public void canReadFile() {
        assertNotNull("Read ok",footballDAOImpl.findFootballData());
    }
}