package workshop.spring.exercises.ex4.processing;

import workshop.spring.exercises.ex4.Element;

public class ActivationNeedingProcessor {
    private final String id;
    private boolean activated;

    public ActivationNeedingProcessor(String id) {
        this.id = id;
    }

    public void processElement(Element element) {
        if (activated) {
            element.wasProcessedBy(id);
        }
    }

    public void activate() {
        activated = true;
    }

}
