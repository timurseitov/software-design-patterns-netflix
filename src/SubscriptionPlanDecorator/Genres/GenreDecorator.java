package SubscriptionPlanDecorator.Genres;

import SubscriptionPlanDecorator.Genres.Genre;

public class GenreDecorator implements Genre {
    Genre genre;

    public GenreDecorator (Genre genre) {
        this.genre = genre;
    }

    @Override
    public double price() {
        return genre.price();
    }


}
