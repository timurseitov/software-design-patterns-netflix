package SubscriptionPlanDecorator.Genres;

import SubscriptionPlanDecorator.Genres.Genre;

public class AnyGenre implements Genre {
    @Override
    public double price() {
        return 1;
    }
}
