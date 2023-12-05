package model.services;

import model.enums.GenderEnum;
import model.Main;
import model.entities.Royal;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.Month.*;
import static java.time.Month.DECEMBER;

public class WindsorService {

    public static ArrayList<Royal> getCurrentRoyalFamily() {

        ArrayList<Royal> windsor = new ArrayList<>();

        Royal Louis = new Royal("Louis Arthur Charles", LocalDate.of(2018, APRIL, 23),
                GenderEnum.MALE, true, new ArrayList<Royal>());

        Royal Charlotte = new Royal("Charlotte Elizabeth Diana", LocalDate.of(2015,
                MAY, 2), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal George = new Royal("George Alexander Louis",
                LocalDate.of(2013, JULY, 22), GenderEnum.MALE, true,
                new ArrayList<>());

        ArrayList<Royal> williamsChildren = new ArrayList<Royal>();
        williamsChildren.add(George);
        williamsChildren.add(Charlotte);
        williamsChildren.add(Louis);

        Royal William = new Royal("William Arthur Philip Louis", LocalDate.of(1982,
                JUNE, 21), GenderEnum.MALE, true, williamsChildren);

        Royal Archie = new Royal("Archie Harrison Mountbatten-Windsor", LocalDate.of(2019, MAY,
                6), GenderEnum.MALE, true, new ArrayList<>());

        Royal Lilibet = new Royal("Lilibet Diana Mountbatten-Windsor", LocalDate.of(2021, JUNE,
                4), GenderEnum.FEMALE, true, new ArrayList<>());

        ArrayList<Royal> harrysChildren = new ArrayList<>();
        harrysChildren.add(Archie);
        harrysChildren.add(Lilibet);

        Royal Harry = new Royal("Henry Charles Albert David", LocalDate.of(1984, SEPTEMBER,
                15), GenderEnum.MALE, true, harrysChildren);

        Harry.setInvalid(true); // Left the Royal Family and subsequent Royal heir rights

        ArrayList<Royal> charlesChildren = new ArrayList<>();
        charlesChildren.add(William);
        charlesChildren.add(Harry);

        Royal Charles = new Royal("Charles Philip Arthur George", LocalDate.of(
                1948, NOVEMBER, 14), GenderEnum.MALE, true, charlesChildren);

        Royal Savannah = new Royal("Savannah Anne Kathleen", LocalDate.of(2010,
                DECEMBER, 29), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal Isla = new Royal("Isla Elizabeth", LocalDate.of(2012,
                MARCH, 29), GenderEnum.FEMALE, true, new ArrayList<>());

        ArrayList<Royal> petersChildren = new ArrayList<>();
        petersChildren.add(Savannah);
        petersChildren.add(Isla);

        Royal Peter = new Royal("Peter Mark Andrew Phillips", LocalDate.of(1977,
                NOVEMBER, 15), GenderEnum.MALE, true, petersChildren);

        Royal Mia = new Royal("Mia Grace Tindall", LocalDate.of(2014,
                JANUARY, 17), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal Lena = new Royal("Lena Elizabeth Tindall ", LocalDate.of(2018,
                JUNE, 18), GenderEnum.FEMALE, true, new ArrayList<>());

        ArrayList<Royal> zarasChildren = new ArrayList<>();
        zarasChildren.add(Mia);
        zarasChildren.add(Lena);

        Royal Zara = new Royal("Zara Anne Elizabeth Phillips", LocalDate.of(1981,
                MAY, 15), GenderEnum.FEMALE, true, zarasChildren);

        ArrayList<Royal> annesChildren = new ArrayList<>();
        annesChildren.add(Peter);
        annesChildren.add(Zara);

        Royal Anne = new Royal("Anne Elizabeth Alice Louise", LocalDate.of(1950, AUGUST,
                15), GenderEnum.FEMALE, true, annesChildren);

        Royal Beatrice = new Royal("Beatrice Elizabeth Mary", LocalDate.of(1988, AUGUST,
                8), GenderEnum.FEMALE, true, new ArrayList<>());

        Royal Eugenie = new Royal("Eugenie Victoria Helena", LocalDate.of(1990, MARCH,
                23), GenderEnum.FEMALE, true, new ArrayList<>());

        ArrayList<Royal> andrewsChildren = new ArrayList<>();
        andrewsChildren.add(Beatrice);
        andrewsChildren.add(Eugenie);

        Royal Andrew = new Royal("Andrew Albert Christian Edward", LocalDate.of(
                1960, FEBRUARY, 19), GenderEnum.MALE, true, andrewsChildren);

        Royal Louise = new Royal(
                "Louise Alice Elizabeth Mary Mountbatten-Windsor", LocalDate.of(
                2003, NOVEMBER, 8), GenderEnum.FEMALE, true,
                new ArrayList<>());

        Royal James = new Royal(
                "James Alexander Philip Theo Mountbatten-Windsor", LocalDate.of(
                2007, DECEMBER, 17), GenderEnum.MALE, true,
                new ArrayList<>());

        ArrayList<Royal> edwardsChildren = new ArrayList<>();
        edwardsChildren.add(Louise);
        edwardsChildren.add(James);

        Royal Edward = new Royal("Edward Antony Richard Louis", LocalDate.of(1964,
                MARCH, 10), GenderEnum.MALE, true, edwardsChildren);

        ArrayList<Royal> queensChildren = new ArrayList<>();
        queensChildren.add(Charles);
        queensChildren.add(Anne);
        queensChildren.add(Andrew);
        queensChildren.add(Edward);

        Royal ElizabethRegnum = new Royal("Elizabeth Alexandra Mary", LocalDate.of(
                1926, APRIL, 21), GenderEnum.FEMALE, false, queensChildren);


        Royal Charles1999 = new Royal("Charles Patrick Inigo Armstrong-Jones", LocalDate.of(
                1999, JULY, 1), GenderEnum.MALE, true, new ArrayList<>());

        Royal Margarita = new Royal("Margarita Elizabeth Rose Alleyne Armstrong-Jones", LocalDate.of(
                2002, MAY, 14), GenderEnum.FEMALE, true, new ArrayList<>());

        ArrayList<Royal> davidsChildren = new ArrayList<>();
        davidsChildren.add(Charles1999);
        davidsChildren.add(Margarita);

        Royal David = new Royal("David Albert Charles Armstrong-Jones", LocalDate.of(
                1961, NOVEMBER, 3), GenderEnum.MALE, true, davidsChildren);

        Royal Samuel = new Royal("Samuel David Benedict Chatto", LocalDate.of(
                1996, JULY, 28), GenderEnum.MALE, true, new ArrayList<>());

        Royal Arthur = new Royal("Arthur Robert Nathaniel Chatto", LocalDate.of(
                1999, FEBRUARY, 5), GenderEnum.MALE, true, new ArrayList<>());

        ArrayList<Royal> sarahsChildren = new ArrayList<>();
        sarahsChildren.add(Samuel);
        sarahsChildren.add(Arthur);

        Royal Sarah = new Royal("Sarah Frances Elizabeth Chatto", LocalDate.of(
                1964, MAY, 1), GenderEnum.FEMALE, true, sarahsChildren);

        ArrayList<Royal> margaretsChildren = new ArrayList<>();
        margaretsChildren.add(David);
        margaretsChildren.add(Sarah);

        Royal Margaret = new Royal("Margaret Rose", LocalDate.of(
                1930, AUGUST, 21), GenderEnum.FEMALE, true, margaretsChildren);

        ArrayList<Royal> georgeVIschildren = new ArrayList<>();
        georgeVIschildren.add(ElizabethRegnum);
        georgeVIschildren.add(Margaret);

        Royal GeorgeVI = new Royal("Albert Frederick Arthur George", LocalDate.of(
                1895, DECEMBER, 14), GenderEnum.MALE, true, georgeVIschildren);


        windsor.add(GeorgeVI);
        windsor.add(Margaret);
        windsor.add(David);
        windsor.add(Charles1999);
        windsor.add(Margarita);
        windsor.add(Sarah);
        windsor.add(Samuel);
        windsor.add(Arthur);
        windsor.add(ElizabethRegnum);
        windsor.add(Edward);
        windsor.add(James);
        windsor.add(Louise);
        windsor.add(Andrew);
        windsor.add(Eugenie);
        windsor.add(Beatrice);
        windsor.add(Anne);
        windsor.add(Peter);
        windsor.add(Charles);
        windsor.add(George);
        windsor.add(Charlotte);
        windsor.add(Louis);
        windsor.add(Zara);
        windsor.add(Harry);
        windsor.add(Archie);
        windsor.add(William);

        if (Main.fullLineage) {
            for (Royal r : windsor) {
                r.setAlive(true);
                for (Royal c : r.getChildren()) {
                    c.setRoyalParent(r);
                }
            }
        }

        //Main.getRecursiveLoDDP(ElizabethRegnum);

        return windsor;
    }
}
