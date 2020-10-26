package hospital;

import org.springframework.beans.factory.annotation.Autowired;

public class SurgeonImpl implements Surgeon {
    @Autowired
    private Assistant assistant;
    @Override
    public void operate() {
        System.out.println("Спирт");
        assistant.getAlcohol().drink();
        System.out.println("Скальпель");
        assistant.getScalpel().cut();
        System.out.println("Спирт");
        assistant.getAlcohol().drink();
        System.out.println("Спирт");
        assistant.getAlcohol().drink();
        System.out.println("Соленый огурец");
        Pickle pickle = assistant.getPickle();
        if(pickle.isChewed()){
            System.out.println("Ах ты ж гад!! дал мне использованый огурец");
        } else {
            pickle.crew();
            System.out.println("Хорошо пошла");
        }
    }
}
