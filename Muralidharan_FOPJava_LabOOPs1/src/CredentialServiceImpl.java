import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CredentialServiceImpl implements CredentialService {
    HashMap<Employee,Integer> employees = new HashMap<>();
    ArrayList<String> passwordHistory = new ArrayList<>();

    @Override
    public String generatePassword() {

        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[8];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< 8 ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        String pass = new String(password);
        System.out.println(pass);
        if(passwordHistory.contains(pass))generatePassword();

        return pass;
    }

    @Override
    public String generateEmailAddress(String firstName,String lastName,String department,String company) {
        String newEmail = firstName+lastName+"@"+department+"."+company+".com";
        return newEmail;
    }

    @Override
    public void showCredentials(Employee employee) {
        System.out.println("Dear "+employee.getEmployeeFirstName()+" your generated credentials are as follows");
        System.out.println("Email--> "+employee.getEmail());
        System.out.println("Password--> "+employee.getPassword());
    }
}
