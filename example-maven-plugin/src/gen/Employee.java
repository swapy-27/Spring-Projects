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
     * Returns theempNo.
     */
    public String getempNo() {
        return empNo;
    }

    /**
     * Set theempNo.
     */
    public void setempNo(String empNo) {
        this.empNo = empNo;
    }

    /**
     * Returns thename.
     */
    public Integer getname() {
        return name;
    }

    /**
     * Set thename.
     */
    public void setname(Integer name) {
        this.name = name;
    }

    /**
     * Returns theaddress.
     */
    public Boolean getaddress() {
        return address;
    }

    /**
     * Set theaddress.
     */
    public void setaddress(Boolean address) {
        this.address = address;
    }
}
