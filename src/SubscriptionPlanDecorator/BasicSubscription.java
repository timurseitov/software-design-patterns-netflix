package SubscriptionPlanDecorator;

import SubscriptionPlanDecorator.Genres.Genre;

public class BasicSubscription implements Subscription {

    private static BasicSubscription instance;

    private double sumCost = price();   //конечная сумма

    public BasicSubscription () {  //обычный конструктор

    }

    public BasicSubscription (Genre genre) { //конструктор с жанром
        addGenre(genre);
    }

    @Override
    public String showQuality() {
        return "Video quality can be: 480";
    }

    @Override
    public String getSubscriptionName() {
        return "basic";
    }

    @Override
    public double price() {
        return 10;
    }

    public double totalPrice() {
        return sumCost;
    }


    @Override
    public double addGenre(Genre genre) {
        sumCost = sumCost + genre.price();
        return sumCost;
    }

    @Override
    public double removeGenre(Genre genre) {
        return 0;
    }

    public static BasicSubscription getInstance() {
        if (instance == null) return new BasicSubscription();
        return instance;
    }


}
