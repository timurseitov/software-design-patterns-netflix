package SubscriptionPlanDecorator;

import SubscriptionPlanDecorator.Genres.Genre;

public class StandardSubscription extends SubscriptionDecorator {

    private static StandardSubscription instance = new StandardSubscription(new BasicSubscription());

    private double sumCost = price();

    public StandardSubscription(Subscription subscription) {
        super(subscription);
    }

    @Override
    public String showQuality() {
        return super.showQuality() + ", 1080p";
    }

    @Override
    public double price() {
        sumCost = super.price() + 10;
        return sumCost;
    }

    public double totalPrice() {
        return sumCost;
    }

    public String getSubscriptionName() {
        return "standard";
    }

    @Override
    public double addGenre(Genre genre) {
        sumCost = sumCost + genre.price();
        return sumCost;
    }

    public static StandardSubscription getInstance() {
        if (instance == null) return new StandardSubscription(new BasicSubscription());

        return instance;
    }
}
