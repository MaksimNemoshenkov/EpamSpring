package hospital;

public class PickleImpl implements Pickle {
    private boolean crewed;

    @Override
    public boolean isChewed() {
        return crewed;
    }

    @Override
    public void crew() {
        crewed = true;
    }
}
