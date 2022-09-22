public interface CredentialService {

    String generatePassword( );
    public String generateEmailAddress(String firstName,String lastName,String department,String company);
    void showCredentials(Employee employee);
}
