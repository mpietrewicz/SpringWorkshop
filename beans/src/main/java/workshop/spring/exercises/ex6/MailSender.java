package workshop.spring.exercises.ex6;

import java.util.Collection;

public interface MailSender {
    void sendMessageAboutInvalidPackages(Collection<Integer> packageNumbers);
}
