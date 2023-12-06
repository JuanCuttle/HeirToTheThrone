package model.services;

import model.Main;
import model.entities.Royal;
import model.entities.Targaryen;
import model.enums.GenderEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TargaryenService {

    private static final LocalDate currentLocalDate = LocalDate.now();

    public static List<Royal> getTargaryens() throws Exception {
        Targaryen rhaego = new Targaryen("Rhaego Targaryen", currentLocalDate.withYear(298),
                GenderEnum.MALE, new ArrayList<>());

        List<Royal> danysChildren = Arrays.asList(rhaego);

        Targaryen dany = new Targaryen("Daenerys 'Stormborn' Targaryen",
                currentLocalDate.withYear(284), GenderEnum.FEMALE, danysChildren);
        dany.setAlive(true);

        Targaryen viserysGoT = new Targaryen(
                "Viserys Targaryen (son of Aerys II)", currentLocalDate.withYear(276),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen aegonGriff = new Targaryen("Aegon 'Young Griff' Targaryen",
                currentLocalDate.withYear(282), GenderEnum.MALE, new ArrayList<>());

        Targaryen rhaenysGoT = new Targaryen(
                "Rhaenys Targaryen (daughter of Rhaegar)", currentLocalDate.withYear(280),
                GenderEnum.FEMALE, new ArrayList<>());

        List<Royal> rhaegarsChildren = Arrays.asList(rhaenysGoT, aegonGriff);

        Targaryen rhaegar = new Targaryen("Rhaegar Targaryen", currentLocalDate.withYear(259),
                GenderEnum.MALE, rhaegarsChildren);
        aegonGriff.setRoyalParent(rhaegar);

        List<Royal> aerysChildren = Arrays.asList(rhaegar, viserysGoT, dany);

        Targaryen aerysII = new Targaryen("Aerys II 'Mad King' Targaryen",
                currentLocalDate.withYear(244), GenderEnum.MALE, aerysChildren);

        List<Royal> rhaellasChildren = new ArrayList<>(aerysChildren);

        Targaryen rhaella = new Targaryen(
                "Rhaella Targaryen (daughter of Jaehaerys II)", currentLocalDate.withYear(245),
                GenderEnum.FEMALE, rhaellasChildren);

        List<Royal> jaehaerysIIChildren = Arrays.asList(aerysII, rhaella);

        Targaryen jaehaerysII = new Targaryen("Jaehaerys II Targaryen",
                currentLocalDate.withYear(225), GenderEnum.MALE, jaehaerysIIChildren);

        List<Royal> shaerasChildren = new ArrayList<>(jaehaerysIIChildren);

        Targaryen shaera = new Targaryen("Shaera Targaryen", currentLocalDate.withYear(226),
                GenderEnum.FEMALE, shaerasChildren);

        Targaryen duncan = new Targaryen(
                "Duncan 'Prince of Dragonflies' Targaryen", currentLocalDate.withYear(222),
                GenderEnum.MALE, new ArrayList<>());
        duncan.setAbdicated(true);

        Targaryen daeron228 = new Targaryen(
                "Daeron Targaryen (son of Aegon V)", currentLocalDate.withYear(228),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen joffreyBaratheon = new Targaryen("Joffrey Baratheon",
                currentLocalDate.withYear(286), GenderEnum.MALE, new ArrayList<>());
        Targaryen myrcellaBaratheon = new Targaryen("Myrcella Baratheon",
                currentLocalDate.withYear(290), GenderEnum.FEMALE, new ArrayList<>());
        Targaryen tommenBaratheon = new Targaryen("Tommen Baratheon", currentLocalDate.withYear(291), GenderEnum.MALE, new ArrayList<>());

        List<Royal> robertsChildren = Arrays.asList(joffreyBaratheon, myrcellaBaratheon, tommenBaratheon);

        Targaryen shireenBaratheon = new Targaryen("Shireen Baratheon",
                currentLocalDate.withYear(289), GenderEnum.FEMALE, new ArrayList<>());

        List<Royal> stannisChildren = Arrays.asList(shireenBaratheon);

        Targaryen robertBaratheon = new Targaryen("Robert I Baratheon",
                currentLocalDate.withYear(262), GenderEnum.MALE, robertsChildren);
        Targaryen stannisBaratheon = new Targaryen("Stannis Baratheon",
                currentLocalDate.withYear(264), GenderEnum.MALE, stannisChildren);
        Targaryen renlyBaratheon = new Targaryen("Renly Baratheon", currentLocalDate.withYear(277), GenderEnum.MALE, new ArrayList<>());

        List<Royal> steffonsChildren = Arrays.asList(robertBaratheon, stannisBaratheon, renlyBaratheon);

        Targaryen steffonBaratheon = new Targaryen("Steffon Baratheon",
                currentLocalDate.withYear(246), GenderEnum.MALE, steffonsChildren);

        List<Royal> rhaellesChildren = Arrays.asList(steffonBaratheon);

        Targaryen rhaelle = new Targaryen("Rhaelle Targaryen", currentLocalDate.withYear(231),
                GenderEnum.FEMALE, rhaellesChildren);

        List<Royal> aegonVChildren = Arrays.asList(duncan, jaehaerysII, shaera, daeron228, rhaelle);

        Targaryen aegonV = new Targaryen("Aegon V 'Egg' Targaryen", currentLocalDate.withYear(200), GenderEnum.MALE, aegonVChildren);

        Targaryen maesterAemon = new Targaryen("Maester Aemon Targaryen",
                currentLocalDate.withYear(198), GenderEnum.MALE, new ArrayList<>());
        maesterAemon.setAlive(true);
        maesterAemon.setAbdicated(true);

        Targaryen daeronDrunk = new Targaryen("Daeron 'the Drunk' Targaryen",
                currentLocalDate.withYear(190), GenderEnum.MALE, new ArrayList<>());

        Targaryen maegor232 = new Targaryen(
                "Maegor Targaryen (son of Aerion 'Brightflame')",
                currentLocalDate.withYear(232), GenderEnum.MALE, new ArrayList<>());

        List<Royal> aerionsChildren = Arrays.asList(maegor232);

        Targaryen aerion = new Targaryen("Aerion 'Brightflame' Targaryen",
                currentLocalDate.withYear(192), GenderEnum.MALE, aerionsChildren);

        Targaryen daella = new Targaryen(
                "Daella Targaryen (daughter of Maekar I)", currentLocalDate.withYear(199),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen rhae = new Targaryen("Rhae Targaryen", currentLocalDate.withYear(205),
                GenderEnum.FEMALE, new ArrayList<>());

        List<Royal> maekarsChildren = Arrays.asList(aegonV, maesterAemon, daeronDrunk, aerion, daella, rhae);

        Targaryen maekar = new Targaryen("Maekar I 'The Anvil' Targaryen",
                currentLocalDate.withYear(176), GenderEnum.MALE, maekarsChildren);

        Targaryen valarr = new Targaryen("Valarr 'the young Prince' Targaryen",
                currentLocalDate.withYear(183), GenderEnum.MALE, new ArrayList<>());

        Targaryen matarys = new Targaryen(
                "Matarys 'the even younger Prince' Targaryen", currentLocalDate.withYear(184),
                GenderEnum.MALE, new ArrayList<>());

        List<Royal> baelor170sChildren = Arrays.asList(valarr, matarys);

        Targaryen baelor170 = new Targaryen("Baelor 'Breakspear' Targaryen",
                currentLocalDate.withYear(170), GenderEnum.MALE, baelor170sChildren);

        Targaryen aerysI = new Targaryen("Aerys I Targaryen", currentLocalDate.withYear(174),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen aelora = new Targaryen("Aelora Targaryen", currentLocalDate.withYear(199),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen aelor = new Targaryen("Aelor Targaryen", currentLocalDate.withYear(199),
                GenderEnum.MALE, new ArrayList<>());

        List<Royal> daenorasChildren = new ArrayList<>(aerionsChildren);

        Targaryen daenora = new Targaryen("Daenora Targaryen", currentLocalDate.withYear(213),
                GenderEnum.FEMALE, daenorasChildren);

        List<Royal> rhaegelsChildren = Arrays.asList(aelora, aelor, daenora);

        Targaryen rhaegel = new Targaryen("Rhaegel Targaryen", currentLocalDate.withYear(175),
                GenderEnum.MALE, rhaegelsChildren);

        List<Royal> daeronIIsChildren = Arrays.asList(rhaegel, aerysI, baelor170, maekar);

        Targaryen daeronII = new Targaryen("Daeron II 'the Good' Targaryen",
                currentLocalDate.withYear(153), GenderEnum.MALE, daeronIIsChildren);

        Targaryen daenerys = new Targaryen(
                "Daenerys Targaryen (daughter of Aegon IV)", currentLocalDate.withYear(172),
                GenderEnum.FEMALE, new ArrayList<>());

        List<Royal> aegonIVsChildren = Arrays.asList(daeronII, daenerys);

        Targaryen aegonIV = new Targaryen("Aegon IV 'the Unworthy' Targaryen",
                currentLocalDate.withYear(135), GenderEnum.MALE, aegonIVsChildren);

        List<Royal> naerysChildren = new ArrayList<>(aegonIVsChildren);

        Targaryen naerys = new Targaryen("Naerys Targaryen", currentLocalDate.withYear(138),
                GenderEnum.FEMALE, naerysChildren);

        Targaryen aemon136 = new Targaryen("Aemon 'Dragonknight' Targaryen",
                currentLocalDate.withYear(136), GenderEnum.MALE, new ArrayList<>());

        List<Royal> viserysIIsChildren = Arrays.asList(aegonIV, naerys, aemon136);

        Targaryen viserysII = new Targaryen("Viserys II  Targaryen", currentLocalDate.withYear(122), GenderEnum.MALE, viserysIIsChildren);

        Targaryen daeronI = new Targaryen(
                "Daeron I 'the Young Dragon' Targaryen", currentLocalDate.withYear(143),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen baelorI = new Targaryen("Baelor I 'the Blessed' Targaryen",
                currentLocalDate.withYear(144), GenderEnum.MALE, new ArrayList<>());

        Targaryen daena = new Targaryen("Daena 'the Defiant' Targaryen",
                currentLocalDate.withYear(145), GenderEnum.FEMALE, new ArrayList<>());

        Targaryen rhaena147 = new Targaryen(
                "Rhaena Targaryen (daughter of Aegon III)", currentLocalDate.withYear(147),
                GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> philipPlummDesc = new ArrayList<>();
        Targaryen philipPlumm = new Targaryen("Philip Plumm", currentLocalDate.withYear(235),
                GenderEnum.MALE, philipPlummDesc);

        Targaryen benPlumm = new Targaryen("Ben Plumm", currentLocalDate.withYear(240),
                GenderEnum.MALE, new ArrayList<>());

        List<Royal> viserysPlummDesc = Arrays.asList(benPlumm, philipPlumm);

        Targaryen viserysPlumm = new Targaryen("Viserys Plumm", currentLocalDate.withYear(176),
                GenderEnum.MALE, viserysPlummDesc);

        Targaryen robinPenrose = new Targaryen("Robin Penrose", currentLocalDate.withYear(192),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen laenaPenrose = new Targaryen("Laena Penrose", currentLocalDate.withYear(191),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen jocelynPenrose = new Targaryen("Jocelyn Penrose", currentLocalDate.withYear(192), GenderEnum.FEMALE, new ArrayList<>());

        Targaryen joyPenrose = new Targaryen("Joy Penrose", currentLocalDate.withYear(193),
                GenderEnum.FEMALE, new ArrayList<>());

        List<Royal> elaenasChildren = Arrays.asList(viserysPlumm, robinPenrose, laenaPenrose, jocelynPenrose, joyPenrose);

        Targaryen elaena = new Targaryen("Elaena Targaryen", currentLocalDate.withYear(150),
                GenderEnum.FEMALE, elaenasChildren);

        List<Royal> aegonIIIsChildren = Arrays.asList(daeronI, baelorI, daena, rhaena147, elaena);

        Targaryen aegonIII = new Targaryen("Aegon III 'the Unlucky' Targaryen",
                currentLocalDate.withYear(120), GenderEnum.MALE, aegonIIIsChildren);

        Targaryen jacaerys = new Targaryen("Jacaerys Velaryon", currentLocalDate.withYear(114),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen lucerys = new Targaryen("Lucerys Velaryon", currentLocalDate.withYear(115),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen joffreyVelaryon = new Targaryen("Joffrey Velaryon", currentLocalDate.withYear(117), GenderEnum.MALE, new ArrayList<>());

        List<Royal> rhaenyrasChildren = Arrays.asList(aegonIII, viserysII, jacaerys, lucerys, joffreyVelaryon);

        Targaryen rhaenyra = new Targaryen(
                "Rhaenyra 'the Half-Year Queen' Targaryen", currentLocalDate.withYear(197),
                GenderEnum.FEMALE, rhaenyrasChildren);

        Targaryen jaehaerys123 = new Targaryen("Jaehaerys Targaryen", currentLocalDate.withYear(123), GenderEnum.MALE, new ArrayList<>());

        Targaryen jaehaera = new Targaryen("Jaehaera Targaryen", currentLocalDate.withYear(123),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen maelor = new Targaryen("Maelor Targaryen", currentLocalDate.withYear(127),
                GenderEnum.MALE, new ArrayList<>());

        List<Royal> aegonIIsChildren = Arrays.asList(jaehaerys123, jaehaera, maelor);

        Targaryen aegonII = new Targaryen("Aegon II 'the Elder' Targaryen",
                currentLocalDate.withYear(107), GenderEnum.MALE, aegonIIsChildren);

        Targaryen helaena = new Targaryen("Helaena Targaryen", currentLocalDate.withYear(109),
                GenderEnum.FEMALE, aegonIIsChildren);

        Targaryen aemond = new Targaryen("Aemond 'One-Eye' Targaryen",
                currentLocalDate.withYear(110), GenderEnum.MALE, new ArrayList<>());

        Targaryen daeron114 = new Targaryen("Daeron 'the Daring' Targaryen",
                currentLocalDate.withYear(114), GenderEnum.MALE, new ArrayList<>());

        List<Royal> viserysIsChildren = Arrays.asList(rhaenyra, aegonII, helaena, aemond, daeron114);

        Targaryen viserysI = new Targaryen(
                "Viserys I 'the Young King' Targaryen", currentLocalDate.withYear(77),
                GenderEnum.MALE, viserysIsChildren);

        Targaryen rhaena = new Targaryen(
                "Rhaena 'of Pentos' Targaryen (daughter of Laena Velaryon)",
                currentLocalDate.withYear(116), GenderEnum.FEMALE, new ArrayList<>());

        Targaryen baela = new Targaryen("Baela Targaryen", currentLocalDate.withYear(116),
                GenderEnum.FEMALE, new ArrayList<>());

        List<Royal> laenasChildren = Arrays.asList(rhaena, baela);

        Targaryen laena = new Targaryen("Laena Velaryon", currentLocalDate.withYear(93),
                GenderEnum.FEMALE, laenasChildren);

        List<Royal> daemonsChildren = Arrays.asList(aegonIII, viserysII, rhaena, baela);

        Targaryen daemon = new Targaryen("Daemon 'the Rogue Prince' Targaryen",
                currentLocalDate.withYear(81), GenderEnum.MALE, daemonsChildren);

        List<Royal> baelonsChildren = Arrays.asList(viserysI, daemon);

        Targaryen baelon = new Targaryen(
                "Baelon 'the Spring Prince' Targaryen", currentLocalDate.withYear(54),
                GenderEnum.MALE, baelonsChildren);

        List<Royal> alyssasChildren = new ArrayList<>(baelonsChildren);

        Targaryen alyssa = new Targaryen("Alyssa Targaryen", currentLocalDate.withYear(52),
                GenderEnum.FEMALE, alyssasChildren);

        List<Royal> laenorsChildren = Arrays.asList(jacaerys, lucerys, joffreyVelaryon);

        Targaryen laenor = new Targaryen("Laenor Velaryon", currentLocalDate.withYear(94),
                GenderEnum.MALE, laenorsChildren);

        List<Royal> rhaenys74sChildren = Arrays.asList(laena, laenor);

        Targaryen rhaenys74 = new Targaryen(
                "Rhaenys 'the Queen who never was' Targaryen", currentLocalDate.withYear(74),
                GenderEnum.FEMALE, rhaenys74sChildren);

        List<Royal> aemonsChildren = Arrays.asList(rhaenys74);

        Targaryen aemon = new Targaryen("Aemon Targaryen (son of Jaehaerys I)",
                currentLocalDate.withYear(53), GenderEnum.MALE, aemonsChildren);

        List<Royal> aemmasChildren = Arrays.asList(rhaenyra);

        Targaryen aemma = new Targaryen("Aemma Arryn", currentLocalDate.withYear(82),
                GenderEnum.FEMALE, aemmasChildren);

        List<Royal> daellasChildren = Arrays.asList(aemma);

        Targaryen daella55 = new Targaryen(
                "Daella Targaryen (daughter of Jaehaerys I)", currentLocalDate.withYear(55),
                GenderEnum.FEMALE, daellasChildren);

        Targaryen vaegon = new Targaryen("Vaegon Targaryen", currentLocalDate.withYear(56),
                GenderEnum.MALE, new ArrayList<>());
        vaegon.setAbdicated(true);

        Targaryen maegella = new Targaryen("Maegella Targaryen", currentLocalDate.withYear(57),
                GenderEnum.FEMALE, new ArrayList<>());
        maegella.setAbdicated(true);

        Targaryen saera = new Targaryen("Saera Targaryen", currentLocalDate.withYear(58),
                GenderEnum.FEMALE, new ArrayList<>());
        saera.setAbdicated(true);

        List<Royal> jaehaerysIsChildren = Arrays.asList(alyssa, aemon, baelon, daella55, vaegon, maegella, saera);

        Targaryen jaehaerysI = new Targaryen(
                "Jaehaerys I 'the Wise' Targaryen", currentLocalDate.withYear(34), GenderEnum.MALE,
                jaehaerysIsChildren);

        Targaryen aerea = new Targaryen("Aerea Targaryen", currentLocalDate.withYear(42),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen rhaella43 = new Targaryen(
                "Rhaella Targaryen (daughter of Aegon, son of Aenys I)",
                currentLocalDate.withYear(43), GenderEnum.FEMALE, new ArrayList<>());

        List<Royal> aegon26sChildren = Arrays.asList(aerea, rhaella43);

        Targaryen aegon26 = new Targaryen("Aegon Targaryen (son of Aenys I)",
                currentLocalDate.withYear(26), GenderEnum.MALE, aegon26sChildren);

        List<Royal> rhaena23sChildren = new ArrayList<>(aegon26sChildren);

        Targaryen rhaena23 = new Targaryen(
                "Rhaena Targaryen (daughter of Aenys I)", currentLocalDate.withYear(23),
                GenderEnum.FEMALE, rhaena23sChildren);

        Targaryen viserys29 = new Targaryen(
                "Viserys Targaryen (son of Aenys I)", currentLocalDate.withYear(29),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen alysanne = new Targaryen("(Good Queen) Alysanne Targaryen",
                currentLocalDate.withYear(36), GenderEnum.FEMALE, jaehaerysIsChildren);

        List<Royal> aenysIsChildren = Arrays.asList(jaehaerysI, rhaena23, aegon26, viserys29, alysanne);

        Targaryen aenysI = new Targaryen("Aenys I  Targaryen", currentLocalDate.withYear(7),
                GenderEnum.MALE, aenysIsChildren);

        Targaryen maegorI = new Targaryen("Maegor I 'the Cruel' Targaryen",
                currentLocalDate.withYear(12), GenderEnum.MALE, new ArrayList<>());

        List<Royal> aegonIsChildren = Arrays.asList(aenysI, maegorI);

        Targaryen aegonTheConqueror = new Targaryen(
                "Aegon I 'the Conqueror' Targaryen", currentLocalDate.withYear(-27),
                GenderEnum.MALE, aegonIsChildren);

        List<Royal> rhaenysChildren = Arrays.asList(aenysI);

        Targaryen rhaenys = new Targaryen("Rhaenys Targaryen", currentLocalDate.withYear(-25),
                GenderEnum.FEMALE, rhaenysChildren);

        List<Royal> visenyasChildren = Arrays.asList(maegorI);

        Targaryen visenya = new Targaryen("Visenya Targaryen", currentLocalDate.withYear(-28),
                GenderEnum.FEMALE, visenyasChildren);

        List<Royal> daddyAerionsChildren = Arrays.asList(aegonTheConqueror, rhaenys, visenya);

        Targaryen daddyAerion = new Targaryen(
                "Aerion Targaryen (father of Aegon I)", currentLocalDate.withYear(-52),
                GenderEnum.MALE, daddyAerionsChildren);

        rhaenys.setRoyalParent(daddyAerion);
        visenya.setRoyalParent(daddyAerion);
        aegonTheConqueror.setRoyalParent(daddyAerion);

        List<Royal> targaryens = Arrays.asList(daddyAerion, visenya, rhaenys, aegonTheConqueror,
                maegorI, aenysI, rhaena23, aegon26, aerea, rhaella43, viserys29, alysanne, jaehaerysI,
                daella55, aemma, vaegon, maegella, saera, alyssa, aemon, rhaenys74, laenor, laena, rhaena,
                baela, baelon, daemon, viserysI, helaena, aemond, daeron114, aegonII, jaehaerys123,
                jaehaera, maelor, rhaenyra, jacaerys, lucerys, joffreyVelaryon, aegonIII, daeronI,
                baelorI, daena, rhaena147, elaena, robinPenrose, laenaPenrose, jocelynPenrose, joyPenrose,
                viserysPlumm, benPlumm, philipPlumm, viserysII, aemon136, naerys, aegonIV, daenerys,
                daeronII, rhaegel, aelora, aelor, daenora, aerysI, baelor170, valarr, matarys, maesterAemon,
                maekar, daeronDrunk, aerion, maegor232, daella, rhae, aegonV, rhaelle, steffonBaratheon,
                renlyBaratheon, stannisBaratheon, shireenBaratheon, robertBaratheon, tommenBaratheon,
                myrcellaBaratheon, joffreyBaratheon, daeron228, shaera, jaehaerysII, rhaella, aerysII,
                rhaegar, rhaenysGoT, aegonGriff, viserysGoT, dany, rhaego);

        for (Royal r : targaryens) {
            r.sortChildrenMaleFirstDob();
            if (Main.fullLineage){
                r.setAlive(true);
                for (Royal c : r.getChildren()) {
                    c.setRoyalParent(r);
                }
            }
        }

        joffreyBaratheon.setAlive(true);
        myrcellaBaratheon.setAlive(true);
        tommenBaratheon.setAlive(true);
        stannisBaratheon.setAlive(true);
        shireenBaratheon.setAlive(true);
        renlyBaratheon.setAlive(true);

        viserysGoT.setAlive(true);
        aegonGriff.setAlive(true);
        benPlumm.setAlive(true);

        Main.getRecursiveLoDDMP(aegonTheConqueror);

        return targaryens;
    }

}
