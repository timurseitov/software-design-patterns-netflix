package SubscriptionPlanDecorator;

import SubscriptionPlanDecorator.Genres.Genre;

public interface Subscription {
    String showQuality();

    String getSubscriptionName();

    double price();

    double addGenre(Genre genre);

    double removeGenre(Genre genre);

    double totalPrice();

}
