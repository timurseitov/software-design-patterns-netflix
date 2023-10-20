package Media;

public class FilmFactory implements MediaFactory{

    @Override
    public Media createMedia() {
        return new Film();

    }
}
