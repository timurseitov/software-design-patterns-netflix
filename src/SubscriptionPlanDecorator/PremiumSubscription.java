package SubscriptionPlanDecorator;

import SubscriptionPlanDecorator.Genres.Genre;

public class PremiumSubscription extends SubscriptionDecorator {

    private static PremiumSubscription instance = new PremiumSubscription(new StandardSubscription(new BasicSubscription()));

    private double sumCost = price();

    public PremiumSubscription(Subscription subscription) {
        super(subscription);
    }

    @Override
    public String showQuality() {
        return super.showQuality() + ", 4K Ultra HD";
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
        return "premium";
    }

    @Override
    public double addGenre(Genre genre) {
        return 0;
    }

    public double removeGenre(Genre genre) {
        sumCost = sumCost - genre.price();
        return sumCost;
    }

    public static PremiumSubscription getInstance() {
        if (instance == null) return new PremiumSubscription(new StandardSubscription(new BasicSubscription()));
        return instance;
    }
}
