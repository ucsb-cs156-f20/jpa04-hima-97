package edu.ucsb.cs56.pconrad.menuitem;

public class MenuItem implements Comparable <MenuItem>
{
    private String name;
    private int priceInCents;
    private String category;

    /**
     * Custom exception thrown when getPrice is called with a width
     * that is too narrow for the formatted price.
     */

    public static class TooNarrowException extends RuntimeException 
    {
    
    }


    public MenuItem(String name, int priceInCents, String category) 
    {
        this.name = name;
        this.priceInCents = priceInCents;
        this.category = category;	// stub
    }

    /**
     * Returns the price, formatted as a string with a $.
     * For example "$0.99", "$10.99", or "$3.50"
     */

    public String getPrice()
    {
	int myDollars = Math.floorDiv(this.priceInCents, 100);
        int myCents = priceInCents % 100;
	if(myCents <= 9)
	{
		return ("$" + myDollars + ".0" + myCents);
	}
	String myPrice = ("$" + myDollars + "." + myCents);
	return myPrice;
    }

    /**
     * Returns the price, formatted as a string with a $,
     * right justified in a field with the specified width.
     * For example "$0.99", "$10.99", or "$3.50".
     * <p>
     * If the width is too small, throws IllegalArgumentException
     *
     * @param width width of returned string
     */

    public String getPrice(int width) 
    {
	    double myPriceInCents =  ((double) this.priceInCents) / 100.0;
	    String myPriceString = ("$" + myPriceInCents);
	    int getLength = myPriceString.length();
	    String myPrice;

	    if(width < getLength)
	    {
		    throw new TooNarrowException();
	    }
	    else
	    {
		    myPrice = String.format("%1$" + width + "s", myPriceString);
	    }

        return myPrice;
    }

    public int  getPriceInCents()
    {
	    return this.priceInCents;
    }

    public String getCategory()
    {
	    return this.category;
    }

    public String getName()
    {
	    return this.name;
    }

    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     *
     * @return string in csv format
     */

    @Override
    public String toString() 
    {
        return (this.name + "," + this.priceInCents + "," + this.category);
    }

    // Function for Comparable to sort by name (compareTo does not work for integers):
    public int compareTo(MenuItem otherItem)
    {
        if (this.name.compareTo(otherItem.getName()) < 0) 
        {
            return -1;
        }
        else if (this.name.equals(otherItem.getName())) 
        {
            return 0; 
        }
        else 
        {
            return 1;
        } 
    }


}