package hospital;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AssistantImpl implements Assistant {
    @Autowired
    private Pickle pickle;
    @Autowired
    private Scalpel scalpel;
    @Autowired
    private Alcohol alcohol;

    @Override
    public abstract Pickle getPickle();

    @Override
    public Scalpel getScalpel() {
        return scalpel;
    }

    @Override
    public Alcohol getAlcohol() {
        return alcohol;
    }
}
