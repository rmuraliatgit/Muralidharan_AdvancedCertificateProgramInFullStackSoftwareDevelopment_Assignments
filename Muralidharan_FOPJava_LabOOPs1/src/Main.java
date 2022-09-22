import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CredentialService credentialService = new CredentialServiceImpl();
        boolean loop = true;
        String firstName = "",  lastName ="", department ="", company ="",  password = "", email = "";
        Employee employee = null;
        while(loop) {
            System.out.println("1--> Enter your First Name: \n2--> Enter your Last Name: \n3--> Enter your Department Name: \n4--> Enter your Company Name: \n5--> Generate password \n6--> Generate Email \n7--> Show Credentials \n8--> Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter your First Name: ");
                     firstName = scanner.next();
                    break;
                }
                case 2: {
                    System.out.println("Enter your Last Name: ");
                     lastName = scanner.next();
                    break;
                }
                case 3: {
                    System.out.println("Enter your Department Name: ");
                     department = scanner.next();
                    break;
                }
                case 4: {
                    System.out.println("Enter your Company Name: ");
                    company = scanner.next();
                    break;
                }
                case 5:{
                    password =  credentialService.generatePassword();
                    break;
                }
                case 6:{
                    email = credentialService.generateEmailAddress(firstName,lastName,department,company);
                    break;
                }
                case 7:{
                    employee = new Employee(firstName,lastName,department,company,email, password);
                    credentialService.showCredentials(employee);
                }
                case 8: loop = false;
            }
            // employee = new Employee(firstName,lastName,department,company,email, password);
            //System.out.println(employee.toString());
        }


    }
}