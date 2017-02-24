package workshop.spring.exercises.ex2.domain;

import com.google.common.collect.Sets;

import java.util.Set;

public class SafetyReport {
    private Set<Object> thingsToFix = Sets.newHashSet();

    public Set<Object> getThingsToFix() {
        return thingsToFix;
    }
}
