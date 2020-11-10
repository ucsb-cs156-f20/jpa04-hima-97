package edu.ucsb.cs56.pconrad.menuitem;
import java.util.ArrayList;

import java.util.Comparator;

public class Menu {

    private ArrayList<MenuItem> menuitems;
    public static String nl = System.lineSeparator();
    
    public Menu()
    {
        // Eppty array list:
        this.menuitems = new ArrayList<> ();    }

    public void add(MenuItem mi) 
    {
        menuitems.add(mi);
    }

    /**
     * Return pointer to a given menu item
     * @param name MenuItem being looked up
     * @return reference to MenuItem or null if not found
     */
    public MenuItem lookup(String name)
    {
        for(int i = 0; i < menuitems.size(); i++)
        {
            if(name == menuitems.get(i).getName())
            {
                return menuitems.get(i);
            }
        }

        return null;
    }

    /**
     * Return a string consisting of each menu item
     * in the list, in the current order, separated
     * by the System.lineSeparator() character 
     * @return resulting string.  Empty list should return ""
     */
    public String csv() {
        String result = "";
        for(int i = 0; i < menuitems.size(); i++)
        {
            result += menuitems.get(i).getName() + "," + menuitems.get(i).getPriceInCents() + "," + menuitems.get(i).getCategory() + nl;
        }
        return result;
    }

    public void sortByName() 
    {
        // Calling the "Collisions" built-in sort function that compares by name by default:
        java.util.Collections.sort(menuitems);
    }

    // "Comparator" function to compare by category and then name:
    Comparator<MenuItem> byCategoryThenName = new Comparator<MenuItem> () 
    {
        public int compare(MenuItem m1, MenuItem m2) 
        {
            if (m1.getCategory().equals(m2.getCategory())) 
            {
			return m1.getName().compareTo(m2.getName());
            }
            else 
            {
			return m1.getCategory().toUpperCase().compareTo(m2.getCategory().toUpperCase());
		    }
		}
    };

    public void sortByCategoryThenName()
    {
        menuitems.sort(byCategoryThenName);
    }

    /** 
     * Put items in categories first, where the categories are in 
     * lexicographic order.  Then sort in order of descending price,
     * with most expensive items first, and least expensive items last.
     * Break ties of items within a category that have the same price
     * by putting them in lexicographic order.
     */

    Comparator<MenuItem> byCategoryThenPriceDescendingThenByName = new Comparator<MenuItem> () 
    {
        public int compare(MenuItem s1, MenuItem s2) 
        {
            if (s1.getCategory().equals(s2.getCategory())) 
            {
                if((s1.getPriceInCents()) == (s2.getPriceInCents())) 
                {
                    return s1.getName().compareTo(s2.getName());
                }
                else 
                {
                    if(s1.getPriceInCents() > s2.getPriceInCents()) 
                    {
                        return -1;
                    } else 
                    {
                        return 1;
                    }  
                }
            }
            else 
            {
			    return s1.getCategory().toUpperCase().compareTo(s2.getCategory().toUpperCase());
		    }
		}
    };

    
    public void sortByCategoryThenPriceDescendingThenByName()
    {
        menuitems.sort(byCategoryThenPriceDescendingThenByName);
    }
}