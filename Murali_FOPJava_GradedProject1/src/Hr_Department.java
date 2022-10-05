public class Hr_Department extends Super_Department{
    @Override
    public String departmentName() {
        return "HR Department";
    }
    @Override
    public String getTodaysWork() {
        return "Fill today’s timesheet and mark your attendance";
    }
    @Override
    public String getWorkDeadline() {
        return "Complete by EOD";
    }
    public String doActivity() {
        return "team Lunch";
    }

}
