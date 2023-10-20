package SubscribersObserver;

import Media.Media;
import Media.MediaFactory;
import SubscriptionPlanDecorator.Subscription;

import java.util.ArrayList;
import java.util.List;

import static Media.Execute.createMediaByForm;

public class Netflix implements Subject {

    private List<Subscriber> subscribers;

    private static List<Media> films;
    private static List<Media> serials;

    MediaFactory filmFactory = createMediaByForm("Film");
    MediaFactory serialFactory = createMediaByForm("Serial");

    public Netflix() {
        subscribers = new ArrayList<>();
        films = new ArrayList<>();
        serials = new ArrayList<>();
    }

    public List<Media> getFilms() {
        return films;
    }

    public static List<Media> getSerials() {
        return serials;
    }

    public void addNewFilm(String filmName) {
        Media film = filmFactory.createMedia();
        films.add(film);
        film.setName(filmName);
        notifyAllObservers(film);
    }

    public Media getFilm(String filmName) {
        for (Media films : films) {
            if (films.getName().equalsIgnoreCase(filmName)) {
                return films;
            }
        }
        return null;
    }

    public void removeFilm(String filmName) {
        Media film = filmFactory.createMedia();
        film.setName(filmName);
        films.removeIf(films -> films.getName().equalsIgnoreCase(filmName));

        //films.removeIf(filmss -> filmss.getName().contentEquals(filmName));

        notifyAllObservers(film);
    }


    public void addNewSerial(String serialName) {
        Media serial = serialFactory.createMedia();
        serial.setName(serialName);
        serials.add(serial);

        notifyAllObservers(serial);
    }

    public Media getSerial(String serialName) {
        for (Media serial : serials) {
            if (serial.getName().equalsIgnoreCase(serialName)) {
                return serial;
            }
        }
        return null;
    }

    public void removeSerial(String serialName) {
        Media serial = serialFactory.createMedia();
        serial.setName(serialName);
        serials.removeIf(serials -> serial.getName().equalsIgnoreCase(serialName));

        notifyAllObservers(serial);
    }

    @Override
    public void addObserver(Subscriber observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Subscriber observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Media media) {
        for (MyObserver subscriber : subscribers) {
            subscriber.update(media);
        }
    }

    public void showFilms() {
        for (Media films : films) {
            System.out.println("=====================================");
            System.out.println(films.getName());
        }
    }

    public void showSerials() {
        for (Media serial : serials) {
            System.out.println("=====================================");
            System.out.println(serial.getName());
        }
    }

    public void showSubscribers() {
        for (int i = 0; i < subscribers.size(); i++) {
            System.out.print(subscribers.get(i).getName() + " ");
        }
    }

    public void showSubscriberWithPlan(Subscription subscription) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getSubscription().equals(subscription)) {
                System.out.println(subscriber.getName());
            }
        }
    }
}
