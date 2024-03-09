import java.io.Serializable;


/**
 * A simple Json2PoJo convertor.
 */
public class Employee
    implements Serializable
{
    private String empNo;
    Integer name;
    protected Boolean address;

    /**
     * Creates a new Employee.
     */
    public Employee() {
    }

    /**
     * Returns the empNo.
     */
    public String getempNo() {
        return empNo;
    }

    /**
     * Set the empNo.
     */
    public void setempNo(String empNo) {
        this.empNo = empNo;
    }

    /**
     * Returns the name.
     */
    public Integer getname() {
        return name;
    }

    /**
     * Set the name.
     */
    public void setname(Integer name) {
        this.name = name;
    }

    /**
     * Returns the address.
     */
    public Boolean getaddress() {
        return address;
    }

    /**
     * Set the address.
     */
    public void setaddress(Boolean address) {
        this.address = address;
    }
}
