package SubscriptionPlanDecorator;

import SubscriptionPlanDecorator.Genres.Genre;

public class SubscriptionDecorator implements Subscription{

    private Subscription subscription;

    public SubscriptionDecorator (Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String showQuality() {
        return subscription.showQuality();
    }

    @Override
    public String getSubscriptionName() {
        return subscription.getSubscriptionName();
    }

    @Override
    public double price() {
        return subscription.price();
    }

    @Override
    public double addGenre(Genre genre) {
        return subscription.price() + genre.price();
    }

    public double removeGenre(Genre genre) {
        return subscription.price() - genre.price();
    }

    @Override
    public double totalPrice() {
        return 0;
    }


}
