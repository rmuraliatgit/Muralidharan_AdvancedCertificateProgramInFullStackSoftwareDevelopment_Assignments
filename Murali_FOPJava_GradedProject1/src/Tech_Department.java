public class Tech_Department extends Super_Department{
    @Override
    public String  departmentName(){
        return "Tech Department";
    }
    @Override
    public String getTodaysWork(){
        return "Complete coding of module 1";
    }
    @Override
    public String getWorkDeadline(){
        return "Complete by EOD ";
    }
    public String getTechStackInformation(){
        return "Core Java";
    }
}
