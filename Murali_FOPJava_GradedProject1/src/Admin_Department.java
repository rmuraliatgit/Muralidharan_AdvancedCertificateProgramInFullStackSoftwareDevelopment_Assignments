public class Admin_Department extends Super_Department{
    @Override
    public  String departmentName() {
        return "Admin Department";
    }
    @Override
    public  String getTodaysWork() {
        return "Complete your documents Submission";
    }
    @Override
    public  String getWorkDeadline() {
        return "Complete by EOD";
    }
    @Override
    public  String isTodayAHoliday() {
        return super.isTodayAHoliday();
    }
}
