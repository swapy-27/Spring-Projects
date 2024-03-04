package org.swapnil.gen;

import java.io.Serializable;


/**
 * A simple Json2PoJo convertor.
 */
public class Employee
    implements Serializable
{
    public String empNo;
    public Integer name;
    public Boolean address;

    /**
     * Creates a new Employee.
     */
    public Employee() {
    }
}
