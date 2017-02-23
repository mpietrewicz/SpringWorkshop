package workshop.spring.showcase;

import org.springframework.stereotype.Component;

@Component
public class EmailGenerator {
    public String generate() {
        return "feedback@yoursite.com";
    }
}
