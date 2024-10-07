package test.java.pages;
import java.util.*;

import java.util.ArrayList;

public class Staticvalues {
  public ArrayList c;
    public Staticvalues() {
        listholder(); // Initialize the list in the constructor
    }

    public void listholder() {
        c = new ArrayList();
        c.add("➤ QTP (Quick Test Professional)");
        c.add("➤ Selenium");
        c.add("➤ Mobile App Testing");
        c.add("➤ Cucumber Testing");
        c.add("➤ SoapUI");

    }
        public ArrayList<String> getelementslist()
    {
            return c;
        }

}





