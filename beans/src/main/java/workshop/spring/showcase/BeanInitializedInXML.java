package workshop.spring.showcase;

//has no @Component annotation
public class BeanInitializedInXML {

    private final EmailGenerator emailGenerator;
    private String description;

    public BeanInitializedInXML(EmailGenerator emailGenerator) {
        this.emailGenerator = emailGenerator;
    }

    public String generate() {
        return "wrapped with ["+description+"]: " + emailGenerator.generate();
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
