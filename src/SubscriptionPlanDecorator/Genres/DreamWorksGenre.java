package SubscriptionPlanDecorator.Genres;

import SubscriptionPlanDecorator.Genres.Genre;
import SubscriptionPlanDecorator.Genres.GenreDecorator;

public class DreamWorksGenre extends GenreDecorator {
    public DreamWorksGenre(Genre genre) {
        super(genre);
    }

    public double price() {
        return super.price() + 0.25;
    }
}
