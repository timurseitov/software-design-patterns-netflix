package Media;

public class SerialFactory implements MediaFactory {
    @Override
    public Media createMedia() {
        return new Serial();
    }
}
