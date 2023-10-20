package Media;

public class Film implements Media {
    private String name;
    private int releaseYear;

    public Film (String filmName) {
        setName(filmName);
    }

    public Film () {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void setReleaseYear( int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void getInformation() {
        System.out.println(getName() + ", " + getReleaseYear());
    }
}
