package workshop.spring.exercises.ex2.domain;

public class Engine {

    public Condition condition;

    public static enum Condition{
        BAD, WELL_ENOUGH, GOOD;
    }
}
