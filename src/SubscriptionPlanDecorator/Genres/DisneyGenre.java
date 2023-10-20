package SubscriptionPlanDecorator.Genres;

import SubscriptionPlanDecorator.Genres.Genre;
import SubscriptionPlanDecorator.Genres.GenreDecorator;

public class DisneyGenre extends GenreDecorator {
    public DisneyGenre (Genre genre) {
        super(genre);
    }

    @Override
    public double price() {
        return super.price() + 0.5;
    }
}
