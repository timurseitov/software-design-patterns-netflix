package SubscribersObserver;

import Media.Media;

public interface Subject {
    void addObserver(Subscriber observer);
    void removeObserver(Subscriber observer);
    void notifyAllObservers(Media media);
}
