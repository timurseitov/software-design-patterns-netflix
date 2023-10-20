import Media.Media;
import Media.MediaFactory;
import SubscribersObserver.Netflix;
import SubscriptionPlanDecorator.Genres.AnyGenre;
import SubscriptionPlanDecorator.Genres.DisneyGenre;
import SubscriptionPlanDecorator.Genres.DreamWorksGenre;
import SubscriptionPlanDecorator.Genres.Genre;
import SubscriptionPlanDecorator.Subscription;

import java.util.Scanner;

import static Media.Execute.createMediaByForm;

public class Admin{

    private int id;
    private String name;

    private Netflix netflix;

    private Subscription basic;
    private Subscription standard;
    private Subscription premium;

    private final Genre disney = new DisneyGenre(new AnyGenre());
    private final Genre dreamWorks = new DreamWorksGenre(new AnyGenre());

    MediaFactory filmFactory = createMediaByForm("Film");
    MediaFactory serialFactory = createMediaByForm("Serial");
    Media film = filmFactory.createMedia();
    Media serial = serialFactory.createMedia();


    public Admin(String name, Netflix netflix, Subscription basic, Subscription standard, Subscription premium, Media film, Media serial) {
        setName(name);
        this.netflix = netflix;
        this.basic = basic;
        this.standard = standard;
        this.premium = premium;
        this.film = film;
        this.serial = serial;
    }


    public void addFilm(String filmName) {
        netflix.addNewFilm(filmName);
    }

    public void deleteFilm(String filmName) {
        netflix.removeFilm(filmName);
    }

    public void addSerial(String serialName) {
        netflix.addNewSerial(serialName);
    }

    public void deleteSerial(String serialName) {
        netflix.removeSerial(serialName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    Scanner scanner = new Scanner(System.in);




    public void start() {
        System.out.println("------------------------------------------------------");

        Admin admin = new Admin(name, netflix, basic, standard, premium, film, serial);

        System.out.println("Hello, " + admin.getName());
        System.out.println("What would you like to do? Press \n1) Add new media \n2) Remove media");

        byte answer = scanner.nextByte();
        if (answer == 1) { //add Media
            System.out.println("What type of Media it is: Press \n1) Film \n2) Show(Serial)");

            answer = scanner.nextByte();
            String mediaName;
            if(answer == 1) {  //add film
                System.out.print("Amount: ");
                answer = scanner.nextByte();
                for (int i = 0; i < answer; i++) {
                    System.out.print("Name of the film: ");
                    mediaName = scanner.next();
                    admin.addFilm(mediaName);
                }
                System.out.println("Operation Completed");
                netflix.showFilms();
            } else if (answer == 2) { //add serial
                System.out.print("Amount: ");
                answer = scanner.nextByte();
                for (int i = 0; i < answer; i++) {
                    System.out.print("Name of the serial: ");
                    mediaName = scanner.next();
                    admin.addSerial(mediaName);
                }
                System.out.println("Operation Completed");
            }
        }
        else if (answer == 2) {  //delete Media
            System.out.println("What type of Media it is: Press \n1) Film \n2) Show(Serial)");

            answer = scanner.nextByte();
            String mediaName;
            if(answer == 1) {  //delete film
                System.out.print("Amount: ");
                answer = scanner.nextByte();
                for (int i = 0; i < answer; i++) {
                    System.out.print("Name of the film: ");
                    mediaName = scanner.next();
                    admin.deleteFilm(mediaName);
                }
                System.out.println("Operation Completed");
                netflix.showFilms();
            } else if (answer == 2) { //delete serial
                System.out.print("Amount: ");
                answer = scanner.nextByte();
                for (int i = 0; i < answer; i++) {
                    System.out.print("Name of the serial: ");
                    mediaName = scanner.next();
                    admin.deleteSerial(mediaName);
                }
                System.out.println("Operation Completed");
            }
        }
    }



}
