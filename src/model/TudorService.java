package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.Month.*;
import static java.time.Month.JUNE;
import static model.Main.fullLineage;

public class TudorService {

    public static void generateTudorLineage() throws Exception {

        ArrayList<Royal> tudors = new ArrayList<>();

        Royal mary = new Royal("Mary I Tudor", LocalDate.of(1516, FEBRUARY, 18),
                Gender.FEMALE, true, new ArrayList<>());
        Royal elizabeth = new Royal("Elizabeth I Tudor", LocalDate.of(1533, SEPTEMBER, 7),
                Gender.FEMALE, true, new ArrayList<>());
        Royal edward = new Royal("Edward VI Tudor", LocalDate.of(1537, OCTOBER, 12),
                Gender.MALE, true, new ArrayList<>());

        List<Royal> henryChildren = Arrays.asList(mary, elizabeth, edward);

        Royal henryVIII = new Royal("Henry VIII Tudor", LocalDate.of(1491, JUNE, 28),
                Gender.MALE, true, henryChildren);

        tudors.add(mary);
        tudors.add(elizabeth);
        tudors.add(edward);
        tudors.add(henryVIII);

        for (Royal r : tudors) {
            r.sortChildrenMaleFirstDob();
            if (fullLineage) {
                r.setAlive(true);
            }
        }

        Main.getRecursiveLoDDMP(henryVIII);

    }
}
