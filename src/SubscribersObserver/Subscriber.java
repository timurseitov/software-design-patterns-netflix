package SubscribersObserver;

import Media.Media;
import SubscriptionPlanDecorator.Genres.Genre;
import SubscriptionPlanDecorator.Subscription;

public class Subscriber implements MyObserver {
    private String name;
    private Subscription subscription;
    private Genre genre;

    public Subscriber(String name) {
        this.name = name;
    }

    public Subscriber(String name, Subscription subscription) {
        this.name = name;
        setSubscription(subscription);
    }

    public Subscriber() {}


    public Subscriber(String name, Subscription subscription, Genre genre) {
        this.name = name;
        this.genre = genre;
        setSubscription(subscription);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void update(Media media) {
        System.out.println(getName() + ": I got notification! There's some update: " + "\n" + media.getName());
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "name='" + name + '\'' +
                ", subscription=" + subscription +
                ", genre=" + genre +
                '}';
    }
}
