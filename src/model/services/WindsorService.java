package model.services;

import model.Main;
import model.entities.Royal;
import model.enums.GenderEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.Month.*;

public class WindsorService {

    public static List<Royal> getCurrentRoyalFamily() {
        Royal louis = new Royal("Louis Arthur Charles", LocalDate.of(2018, APRIL, 23),
                GenderEnum.MALE, true, new ArrayList<Royal>());

        Royal charlotte = new Royal("Charlotte Elizabeth Diana", LocalDate.of(2015,
                MAY, 2), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal george = new Royal("George Alexander Louis",
                LocalDate.of(2013, JULY, 22), GenderEnum.MALE, true,
                new ArrayList<>());

        List<Royal> williamsChildren = Arrays.asList(george, charlotte, louis);

        Royal william = new Royal("William Arthur Philip Louis", LocalDate.of(1982,
                JUNE, 21), GenderEnum.MALE, true, williamsChildren);

        Royal archie = new Royal("Archie Harrison Mountbatten-Windsor", LocalDate.of(2019, MAY,
                6), GenderEnum.MALE, true, new ArrayList<>());

        Royal lilibet = new Royal("Lilibet Diana Mountbatten-Windsor", LocalDate.of(2021, JUNE,
                4), GenderEnum.FEMALE, true, new ArrayList<>());

        List<Royal> harrysChildren = Arrays.asList(archie, lilibet);

        Royal harry = new Royal("Henry Charles Albert David", LocalDate.of(1984, SEPTEMBER,
                15), GenderEnum.MALE, true, harrysChildren);

        harry.setInvalid(true); // Left the Royal Family and subsequent Royal heir rights

        List<Royal> charlesChildren = Arrays.asList(william, harry);

        Royal charlesIII = new Royal("Charles Philip Arthur George", LocalDate.of(
                1948, NOVEMBER, 14), GenderEnum.MALE, true, charlesChildren);

        Royal savannah = new Royal("Savannah Anne Kathleen", LocalDate.of(2010,
                DECEMBER, 29), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal isla = new Royal("Isla Elizabeth", LocalDate.of(2012,
                MARCH, 29), GenderEnum.FEMALE, true, new ArrayList<>());

        List<Royal> petersChildren = Arrays.asList(savannah, isla);

        Royal peter = new Royal("Peter Mark Andrew Phillips", LocalDate.of(1977,
                NOVEMBER, 15), GenderEnum.MALE, true, petersChildren);

        Royal mia = new Royal("Mia Grace Tindall", LocalDate.of(2014,
                JANUARY, 17), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal lena = new Royal("Lena Elizabeth Tindall ", LocalDate.of(2018,
                JUNE, 18), GenderEnum.FEMALE, true, new ArrayList<>());

        List<Royal> zarasChildren = Arrays.asList(mia, lena);

        Royal zara = new Royal("Zara Anne Elizabeth Phillips", LocalDate.of(1981,
                MAY, 15), GenderEnum.FEMALE, true, zarasChildren);

        List<Royal> annesChildren = Arrays.asList(peter, zara);

        Royal anne = new Royal("Anne Elizabeth Alice Louise", LocalDate.of(1950, AUGUST,
                15), GenderEnum.FEMALE, true, annesChildren);

        Royal beatrice = new Royal("Beatrice Elizabeth Mary", LocalDate.of(1988, AUGUST,
                8), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal eugenie = new Royal("Eugenie Victoria Helena", LocalDate.of(1990, MARCH,
                23), GenderEnum.FEMALE, true, new ArrayList<>());

        List<Royal> andrewsChildren = Arrays.asList(beatrice, eugenie);

        Royal andrew = new Royal("Andrew Albert Christian Edward", LocalDate.of(
                1960, FEBRUARY, 19), GenderEnum.MALE, true, andrewsChildren);

        Royal louise = new Royal(
                "Louise Alice Elizabeth Mary Mountbatten-Windsor", LocalDate.of(
                2003, NOVEMBER, 8), GenderEnum.FEMALE, true,
                new ArrayList<>());

        Royal james = new Royal(
                "James Alexander Philip Theo Mountbatten-Windsor", LocalDate.of(
                2007, DECEMBER, 17), GenderEnum.MALE, true,
                new ArrayList<>());

        List<Royal> edwardsChildren = Arrays.asList(louise, james);

        Royal edward = new Royal("Edward Antony Richard Louis", LocalDate.of(1964,
                MARCH, 10), GenderEnum.MALE, true, edwardsChildren);

        List<Royal> queensChildren = Arrays.asList(charlesIII, anne, andrew, edward);

        Royal elizabethII = new Royal("Elizabeth Alexandra Mary", LocalDate.of(
                1926, APRIL, 21), GenderEnum.FEMALE, false, queensChildren);


        Royal charles1999 = new Royal("Charles Patrick Inigo Armstrong-Jones", LocalDate.of(
                1999, JULY, 1), GenderEnum.MALE, true, new ArrayList<>());

        Royal margarita = new Royal("Margarita Elizabeth Rose Alleyne Armstrong-Jones", LocalDate.of(
                2002, MAY, 14), GenderEnum.FEMALE, true, new ArrayList<>());

        List<Royal> davidsChildren = Arrays.asList(charles1999, margarita);

        Royal david = new Royal("David Albert Charles Armstrong-Jones", LocalDate.of(
                1961, NOVEMBER, 3), GenderEnum.MALE, true, davidsChildren);

        Royal samuel = new Royal("Samuel David Benedict Chatto", LocalDate.of(
                1996, JULY, 28), GenderEnum.MALE, true, new ArrayList<>());

        Royal arthur = new Royal("Arthur Robert Nathaniel Chatto", LocalDate.of(
                1999, FEBRUARY, 5), GenderEnum.MALE, true, new ArrayList<>());

        List<Royal> sarahsChildren = Arrays.asList(samuel, arthur);

        Royal sarah = new Royal("Sarah Frances Elizabeth Chatto", LocalDate.of(
                1964, MAY, 1), GenderEnum.FEMALE, true, sarahsChildren);

        List<Royal> margaretsChildren = Arrays.asList(david, sarah);

        Royal margaret = new Royal("Margaret Rose", LocalDate.of(
                1930, AUGUST, 21), GenderEnum.FEMALE, true, margaretsChildren);

        List<Royal> georgeVIschildren = Arrays.asList(elizabethII, margaret);

        Royal georgeVI = new Royal("Albert Frederick Arthur George", LocalDate.of(
                1895, DECEMBER, 14), GenderEnum.MALE, true, georgeVIschildren);

        List<Royal> windsors = Arrays.asList(georgeVI, margaret, david, charles1999, margarita, sarah, samuel, arthur,
                elizabethII, edward, james, louise, andrew, eugenie, beatrice, anne, peter, charlesIII, george, charlotte,
                louis, zara, harry, archie, william);

        if (Main.fullLineage) {
            for (Royal r : windsors) {
                r.setAlive(true);
                for (Royal c : r.getChildren()) {
                    c.setRoyalParent(r);
                }
            }
        }

        //Main.getRecursiveLoDDP(ElizabethRegnum);

        return windsors;
    }
}
