public class Employee {
    static int id = 0;
    String employeeFirstName;
    String employeeLastName;
    String department;
    String company;
    String email;
    String password;


    public Employee(String employeeFirstName, String employeeLastName, String department,String company, String email, String password) {
        super();
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.department = department;
        this.company = company;
        this.email = email;
        this.password = password;
        this.id = id+1;
    }

    public int getId() {
        return id;
    }


    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
