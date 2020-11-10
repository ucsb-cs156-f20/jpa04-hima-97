package edu.ucsb.cs56.pconrad.menuitem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class MenuTest 
{

    private Menu m = new Menu();
    private String nl = System.lineSeparator();

    @Before
    public void setUp() 
    {
        m.add(new MenuItem("Small Poke Bowl", 1049, "Poke Bowls"));
        m.add(new MenuItem("Medium Poke Bowl", 1249, "Poke Bowls"));
        m.add(new MenuItem("Large Poke Bowl", 1449, "Poke Bowls"));
        m.add(new MenuItem("Milk Tea", 249, "Beverage"));
        m.add(new MenuItem("Boba Tea", 249, "Beverage"));
        m.add(new MenuItem("Green Tea", 149, "Beverage"));
    }

    // Test for when you don't find what you look for:
    @Test
    public void test_lookup_notfound() 
    {
        assertEquals(null, m.lookup("Hima"));
    }

    // Test for when you find what you look for:
    @Test
    public void test_lookup_found() 
    {
        MenuItem s = new MenuItem("Small Poke Bowl");
        assertEquals(s, m.lookup("Small Poke Bowl"));
    }

    @Test
    public void test_csv() 
    {
        String expected = "";
        expected += "Small Poke Bowl,1049,Poke Bowls" + nl;
        expected += "Medium Poke Bowl,1249,Poke Bowls" + nl;
        expected += "Large Poke Bowl,1449,Poke Bowls" + nl;
        expected += "Milk Tea,249,Beverage" + nl;
        expected += "Boba Tea,249,Beverage" + nl;
        expected += "Green Tea,149,Beverage" + nl;
        assertEquals(expected, m.csv());
    }

    @Test
    public void test_csvSortedByName() 
    {
        String expected = "";
        expected += "Boba Tea,249,Beverage" + nl;
        expected += "Green Tea,149,Beverage" + nl;
        expected += "Large Poke Bowl,1449,Poke Bowls" + nl;
        expected += "Medium Poke Bowl,1249,Poke Bowls" + nl;
        expected += "Milk Tea,249,Beverage" + nl;
        expected += "Small Poke Bowl,1049,Poke Bowls" + nl;

        m.sortByName();        
        assertEquals(expected, m.csv());
    }

    @Test
    public void test_csvSortedByCategoryThenName() {
        String expected = "";
        expected += "Boba Tea,249,Beverage" + nl;
        expected += "Green Tea,149,Beverage" + nl;
        expected += "Milk Tea,249,Beverage" + nl;
        expected += "Large Poke Bowl,1449,Poke Bowls" + nl;
        expected += "Medium Poke Bowl,1249,Poke Bowls" + nl;
        expected += "Small Poke Bowl,1049,Poke Bowls" + nl;
        m.sortByCategoryThenName();        
        assertEquals(expected, m.csv());
    }

}