import SubscribersObserver.Netflix;
import SubscribersObserver.Subscriber;
import SubscriptionPlanDecorator.BasicSubscription;
import SubscriptionPlanDecorator.Genres.AnyGenre;
import SubscriptionPlanDecorator.Genres.DisneyGenre;
import SubscriptionPlanDecorator.Genres.DreamWorksGenre;
import SubscriptionPlanDecorator.Genres.Genre;
import SubscriptionPlanDecorator.PremiumSubscription;
import SubscriptionPlanDecorator.StandardSubscription;
import SubscriptionPlanDecorator.Subscription;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private final Netflix netflix;

    private final Subscription basic;
    private final Subscription standard;
    private final Subscription premium;

    private final Genre disney = new DisneyGenre(new AnyGenre());
    private final Genre dreamWorks = new DreamWorksGenre(new AnyGenre());

    public User(Netflix netflix, Subscription basic, Subscription standard, Subscription premium) {
        this.netflix = netflix;
        this.basic = basic;
        this.standard = standard;
        this.premium = premium;
    }

    public void client() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("------------------------------------------------------");
            System.out.println("Netflix.exe");
            System.out.println("------------------------------------------------------");

            System.out.println("Hello, what's your name?");
            String name = scanner.next();
            System.out.println("Would you like to watch netflix? ");
            System.out.println("Press 1 if yes, 0 if no");
            int answer = scanner.nextInt();
            if (answer == 1) {

                askSubscriptionPlan();
                answer = scanner.nextInt();

                if (answer == 1) {
                    System.out.println("------------------------------------------------------");

                    Subscriber subscriber = new Subscriber(name, basic);
                    netflix.addObserver(subscriber);

                    basicPlanDetails(subscriber);
                    askGenresToAdd();

                    answer = scanner.nextInt();
                    if (answer == 1) {
                        System.out.println("------------------------------------------------------");

                        System.out.println("Alright! What genres do you want? Press\n"
                                + "1 if disney\n" + "2 if dreamworks");
                        answer = scanner.nextInt();
                        if (answer == 1) {
                            System.out.println("------------------------------------------------------");

                            System.out.println("Good!");
                            subscriber.getSubscription().addGenre(disney);
                            System.out.println("Alright, your total price is: ");
                            System.out.println(subscriber.getSubscription().totalPrice());
                            break;
                        } else if (answer == 2) {
                            System.out.println("------------------------------------------------------");

                            System.out.println("Good!");
                            subscriber.getSubscription().addGenre(dreamWorks);
                            System.out.println("Alright, your total price is: ");
                            System.out.println(subscriber.getSubscription().totalPrice());
                            break;
                        }
                    } else if (answer == 0) {
                        System.out.println("------------------------------------------------------");

                        System.out.println("OK");
                        System.out.println("Alright, your total price is: ");
                        System.out.println(subscriber.getSubscription().totalPrice());
                        break;
                    } else {
                        System.out.println("------------------------------------------------------");

                        System.out.println("Please select one from the options");
                    }
                } else if (answer == 2) {
                    System.out.println("------------------------------------------------------");

                    Subscriber subscriber = new Subscriber(name, standard);
                    System.out.println("Good, what you will get: ");
                    System.out.println(subscriber.getSubscription().showQuality());
                    System.out.print("Price: ");
                    System.out.println(subscriber.getSubscription().totalPrice() + " $");
                    System.out.println("------------------------------------------------------");

                    System.out.println("Do you want some genres to add, but cost will increase?");
                    System.out.println("Press 1 if yes, 0 if no");
                    answer = scanner.nextInt();
                    if (answer == 1) {
                        System.out.println("------------------------------------------------------");

                        System.out.println("Alright! What genres do you want? Press\n"
                                + "1 if disney\n" + "2 if dreamworks");
                        answer = scanner.nextInt();
                        if (answer == 1) {
                            System.out.println("------------------------------------------------------");

                            System.out.println("Good!");
                            subscriber.getSubscription().addGenre(disney);
                            System.out.println("Alright, your total price is: ");
                            System.out.println(subscriber.getSubscription().totalPrice());
                            break;
                        } else if (answer == 2) {
                            System.out.println("------------------------------------------------------");

                            System.out.println("Good!");
                            subscriber.getSubscription().addGenre(dreamWorks);
                            System.out.println("Alright, your total price is: ");
                            System.out.println(subscriber.getSubscription().totalPrice());
                            break;
                        }
                    } else if (answer == 0) {
                        System.out.println("------------------------------------------------------");

                        System.out.println("OK");
                        System.out.println("Alright, your total price is: ");
                        System.out.println(subscriber.getSubscription().totalPrice());
                        break;
                    } else {
                        System.out.println("------------------------------------------------------");

                        System.out.println("Please select one from the options");
                    }
                } else if (answer == 3){
                    System.out.println("------------------------------------------------------");

                    Subscriber subscriber = new Subscriber(name, premium);
                    System.out.println("Good, what you will get: ");
                    System.out.println(subscriber.getSubscription().showQuality());
                    System.out.print("Price: ");
                    System.out.println(subscriber.getSubscription().totalPrice() + " $");
                    System.out.println("------------------------------------------------------");

                    System.out.println("Do you want some genres to remove? (the cost will decrease)");
                    System.out.println("Press 1 if yes, 0 if no");
                    answer = scanner.nextInt();
                    if (answer == 1) {
                        System.out.println("------------------------------------------------------");

                        System.out.println("Alright! What genres do you want to remove? Press\n"
                                + "1 if disney\n" + "2 if dreamworks\n" + "3 if both");
                        answer = scanner.nextInt();
                        if (answer == 1) {
                            System.out.println("------------------------------------------------------");

                            System.out.println("Good!");
                            subscriber.getSubscription().removeGenre(disney);
                            System.out.println("Alright, your total price is: ");
                            System.out.println(subscriber.getSubscription().totalPrice());
                            break;
                        } else if (answer == 2) {
                            System.out.println("------------------------------------------------------");

                            System.out.println("Good!");
                            subscriber.getSubscription().removeGenre(dreamWorks);
                            System.out.println("Alright, your total price is: ");
                            System.out.println(subscriber.getSubscription().totalPrice());
                            break;
                        } else if (answer == 3) {
                            System.out.println("------------------------------------------------------");

                            System.out.println("Ok!");
                            subscriber.getSubscription().removeGenre(dreamWorks);
                            subscriber.getSubscription().removeGenre(disney);
                            System.out.println("Alright, your total price is: ");
                            System.out.println(subscriber.getSubscription().totalPrice());
                            break;
                        }
                    }

                } else{
                    System.out.println("------------------------------------------------------");

                    System.out.println("Please select one from the options");
                }
            } else {
                System.out.println("------------------------------------------------------");

                System.out.println("oh...ok");
                break;
            }
            System.out.println("------------------------------------------------------");
        }
        System.out.println("------------------------------------------------------");
    }

    private static void askGenresToAdd() {
        System.out.println("Do you want some genres to add, but cost will increase?");
        System.out.println("Press 1 if yes, 0 if no");
    }

    private static void basicPlanDetails(Subscriber subscriber) {
        System.out.println("Good, what you will get: ");
        System.out.println(subscriber.getSubscription().showQuality());
        System.out.print("Price: ");
        System.out.println(subscriber.getSubscription().totalPrice() + " $");
        System.out.println("------------------------------------------------------");
    }

    private static void askSubscriptionPlan() {
        System.out.println("------------------------------------------------------");

        System.out.println("Great! What plan do you want? Press\n"
                + "1 if basic\n" + "2 if standard\n" + "3 if premium");
    }

    private static void showMedia(Netflix netflix) {
        System.out.println("Films to watch:");
        netflix.showFilms();
        System.out.println("TV-shows: ");
        netflix.showSerials();
    }
}
