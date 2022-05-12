package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorAscByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenSortAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Ant", 0),
                new Job("Dom", 1),
                new Job("Bom", 2)
        );
        List<Job> exp = Arrays.asList(
                new Job("Ant", 0),
                new Job("Bom", 2),
                new Job("Dom", 1)
        );
        Collections.sort(jobs, new JobAscByName());
        assertEquals(exp, jobs);
    }

    @Test
    public void whenSortDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Ant", 0),
                new Job("Dom", 1),
                new Job("Bom", 2)
        );
        List<Job> exp = Arrays.asList(
                new Job("Dom", 1),
                new Job("Bom", 2),
                new Job("Ant", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        assertEquals(exp, jobs);
    }

    @Test
    public void whenSortAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Ant", 1),
                new Job("Dom", 0),
                new Job("Bom", 2)
        );
        List<Job> exp = Arrays.asList(
                new Job("Dom", 0),
                new Job("Ant", 1),
                new Job("Bom", 2)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertEquals(exp, jobs);
    }

    @Test
    public void whenSortDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Ant", 1),
                new Job("Dom", 0),
                new Job("Bom", 2)
        );
        List<Job> exp = Arrays.asList(
                new Job("Bom", 2),
                new Job("Ant", 1),
                new Job("Dom", 0)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertEquals(exp, jobs);
    }
}