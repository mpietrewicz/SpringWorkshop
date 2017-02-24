package workshop.spring.exercises.ex5;

public class Cow {
    private Sex sex;
    private int weight;
    private String stamp;

    public Cow(Sex sex, int weight) {
        this.sex = sex;
        this.weight = weight;
    }

    public String getStamp() {
        return stamp;
    }
}
