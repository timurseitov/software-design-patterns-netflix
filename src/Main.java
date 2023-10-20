import Media.Media;
import Media.MediaFactory;
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

import java.util.Scanner;

import static Media.Execute.createMediaByForm;

public class Main {
    public static void main(String[] args) {
        //SubscribersObserver.Netflix application
        Netflix netflix = new Netflix();

        Subscription basic = BasicSubscription.getInstance();
        Subscription standard = StandardSubscription.getInstance();
        Subscription premium = PremiumSubscription.getInstance();

        Genre disney = new DisneyGenre(new AnyGenre());
        Genre dreamWorks = new DreamWorksGenre(new AnyGenre());

        MediaFactory filmFactory = createMediaByForm("Film");
        MediaFactory serialFactory = createMediaByForm("Serial");
        Media film = filmFactory.createMedia();
        Media serial = serialFactory.createMedia();

        netflix.addNewFilm("Spider-Man");
        netflix.addNewFilm("Hobbit");
        netflix.addNewFilm("BlackAdam");
        netflix.addNewFilm("OnePieceFilmRED");

        netflix.addNewSerial("Jojo'sBizarreAdventure");
        netflix.addNewSerial("NeonGenesisEvangelion");
        netflix.addNewSerial("OnePiece");
        netflix.addNewSerial("HunterxHunter");


        netflix.showFilms();
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many accounts do you want? ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Account.createAccount(netflix, basic, standard, premium, film, serial);
        }
    }



}

