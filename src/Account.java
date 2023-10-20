import Media.Media;
import SubscribersObserver.Netflix;
import SubscribersObserver.Subscriber;
import SubscriptionPlanDecorator.Subscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Account {
    public static void createAccount(Netflix netflix, Subscription basic, Subscription standard, Subscription premium, Media film, Media serial) {
        System.out.println("------------------------------------------------------");
        System.out.println("Netflix.exe");
        System.out.println("------------------------------------------------------");
        System.out.println("Choose an Account: Press \n1) User \n2) Admin");
        Scanner scanner = new Scanner(System.in);
        byte answer = scanner.nextByte();
        if (answer == 1) {
            User user = new User(netflix, basic, standard, premium);
            user.client();
        } else if (answer == 2) {
            System.out.println("Enter your Admin-Name: ");
            String name = scanner.next();
            Admin admin = new Admin(name, netflix, basic, standard, premium, film, serial);
            admin.start();
        }
    }
}
