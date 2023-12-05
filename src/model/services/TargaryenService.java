package model.services;

import model.enums.GenderEnum;
import model.Main;
import model.entities.Royal;
import model.entities.Targaryen;

import java.time.LocalDate;
import java.util.ArrayList;

public class TargaryenService {

    private static final LocalDate currentLocalDate = LocalDate.now();

    public static ArrayList<Royal> getTargaryens() throws Exception {
        ArrayList<Royal> targaryens = new ArrayList<>();

        Targaryen rhaego = new Targaryen("Rhaego Targaryen", currentLocalDate.withYear(298),
                GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> danysChildren = new ArrayList<>();
        danysChildren.add(rhaego);

        Targaryen dany = new Targaryen("Daenerys 'Stormborn' Targaryen",
                currentLocalDate.withYear(284), GenderEnum.FEMALE, danysChildren);
        dany.setAlive(true);

        Targaryen viserysgot = new Targaryen(
                "Viserys Targaryen (son of Aerys II)", currentLocalDate.withYear(276),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen aegonGriff = new Targaryen("Aegon 'Young Griff' Targaryen",
                currentLocalDate.withYear(282), GenderEnum.MALE, new ArrayList<>());
        Targaryen rhaenysgot = new Targaryen(
                "Rhaenys Targaryen (daughter of Rhaegar)", currentLocalDate.withYear(280),
                GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> rhaegarsChildren = new ArrayList<>();
        rhaegarsChildren.add(rhaenysgot);
        rhaegarsChildren.add(aegonGriff);

        Targaryen rhaegar = new Targaryen("Rhaegar Targaryen", currentLocalDate.withYear(259),
                GenderEnum.MALE, rhaegarsChildren);
        aegonGriff.setRoyalParent(rhaegar);

        ArrayList<Royal> aerysChildren = new ArrayList<>();
        aerysChildren.add(rhaegar);
        aerysChildren.add(viserysgot);
        aerysChildren.add(dany);

        Targaryen aerysII = new Targaryen("Aerys II 'Mad King' Targaryen",
                currentLocalDate.withYear(244), GenderEnum.MALE, aerysChildren);

        ArrayList<Royal> rhaellasChildren = new ArrayList<>();
        rhaellasChildren.addAll(aerysChildren);

        Targaryen rhaella = new Targaryen(
                "Rhaella Targaryen (daughter of Jaehaerys II)", currentLocalDate.withYear(245),
                GenderEnum.FEMALE, rhaellasChildren);

        ArrayList<Royal> jaehaerysIIChildren = new ArrayList<>();
        jaehaerysIIChildren.add(aerysII);
        jaehaerysIIChildren.add(rhaella);

        Targaryen jaehaerysII = new Targaryen("Jaehaerys II Targaryen",
                currentLocalDate.withYear(225), GenderEnum.MALE, jaehaerysIIChildren);

        ArrayList<Royal> shaerasChildren = new ArrayList<>(); //
        shaerasChildren.addAll(jaehaerysIIChildren);

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

        ArrayList<Royal> robertsChildren = new ArrayList<>();
        robertsChildren.add(joffreyBaratheon);
        robertsChildren.add(myrcellaBaratheon);
        robertsChildren.add(tommenBaratheon);

        Targaryen shireenBaratheon = new Targaryen("Shireen Baratheon",
                currentLocalDate.withYear(289), GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> stannisChildren = new ArrayList<>();
        stannisChildren.add(shireenBaratheon);

        Targaryen robertBaratheon = new Targaryen("Robert I Baratheon",
                currentLocalDate.withYear(262), GenderEnum.MALE, robertsChildren);
        Targaryen stannisBaratheon = new Targaryen("Stannis Baratheon",
                currentLocalDate.withYear(264), GenderEnum.MALE, stannisChildren);
        Targaryen renlyBaratheon = new Targaryen("Renly Baratheon", currentLocalDate.withYear(277), GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> steffonsChildren = new ArrayList<>();
        steffonsChildren.add(robertBaratheon);
        steffonsChildren.add(stannisBaratheon);
        steffonsChildren.add(renlyBaratheon);

        Targaryen steffonBaratheon = new Targaryen("Steffon Baratheon",
                currentLocalDate.withYear(246), GenderEnum.MALE, steffonsChildren);

        ArrayList<Royal> rhaellesChildren = new ArrayList<>();
        rhaellesChildren.add(steffonBaratheon);

        Targaryen rhaelle = new Targaryen("Rhaelle Targaryen", currentLocalDate.withYear(231),
                GenderEnum.FEMALE, rhaellesChildren);

        ArrayList<Royal> aegonVChildren = new ArrayList<>();
        aegonVChildren.add(duncan);
        aegonVChildren.add(jaehaerysII);
        aegonVChildren.add(shaera);
        aegonVChildren.add(daeron228);
        aegonVChildren.add(rhaelle);

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

        ArrayList<Royal> aerionsChildren = new ArrayList<>();
        aerionsChildren.add(maegor232);

        Targaryen aerion = new Targaryen("Aerion 'Brightflame' Targaryen",
                currentLocalDate.withYear(192), GenderEnum.MALE, aerionsChildren);

        Targaryen daella = new Targaryen(
                "Daella Targaryen (daughter of Maekar I)", currentLocalDate.withYear(199),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen rhae = new Targaryen("Rhae Targaryen", currentLocalDate.withYear(205),
                GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> maekarsChildren = new ArrayList<>();
        maekarsChildren.add(aegonV);
        maekarsChildren.add(maesterAemon);
        maekarsChildren.add(daeronDrunk);
        maekarsChildren.add(aerion);
        maekarsChildren.add(daella);
        maekarsChildren.add(rhae);

        Targaryen maekar = new Targaryen("Maekar I 'The Anvil' Targaryen",
                currentLocalDate.withYear(176), GenderEnum.MALE, maekarsChildren);

        Targaryen valarr = new Targaryen("Valarr 'the young Prince' Targaryen",
                currentLocalDate.withYear(183), GenderEnum.MALE, new ArrayList<>());

        Targaryen matarys = new Targaryen(
                "Matarys 'the even younger Prince' Targaryen", currentLocalDate.withYear(184),
                GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> baelor170sChildren = new ArrayList<>();
        baelor170sChildren.add(valarr);
        baelor170sChildren.add(matarys);

        Targaryen baelor170 = new Targaryen("Baelor 'Breakspear' Targaryen",
                currentLocalDate.withYear(170), GenderEnum.MALE, baelor170sChildren);

        Targaryen aerysI = new Targaryen("Aerys I Targaryen", currentLocalDate.withYear(174),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen aelora = new Targaryen("Aelora Targaryen", currentLocalDate.withYear(199),
                GenderEnum.FEMALE, new ArrayList<>());
        Targaryen aelor = new Targaryen("Aelor Targaryen", currentLocalDate.withYear(199),
                GenderEnum.MALE, new ArrayList<>());
        ArrayList<Royal> daenorasChildren = new ArrayList<>();
        daenorasChildren.addAll(aerionsChildren);
        Targaryen daenora = new Targaryen("Daenora Targaryen", currentLocalDate.withYear(213),
                GenderEnum.FEMALE, daenorasChildren);

        ArrayList<Royal> rhaegelsChildren = new ArrayList<>();
        rhaegelsChildren.add(aelora);
        rhaegelsChildren.add(aelor);
        rhaegelsChildren.add(daenora);

        Targaryen rhaegel = new Targaryen("Rhaegel Targaryen", currentLocalDate.withYear(175),
                GenderEnum.MALE, rhaegelsChildren);

        ArrayList<Royal> daeronIIsChildren = new ArrayList<>();
        daeronIIsChildren.add(rhaegel);
        daeronIIsChildren.add(aerysI);
        daeronIIsChildren.add(baelor170);
        daeronIIsChildren.add(maekar);

        Targaryen daeronII = new Targaryen("Daeron II 'the Good' Targaryen",
                currentLocalDate.withYear(153), GenderEnum.MALE, daeronIIsChildren);

        Targaryen daenerys = new Targaryen(
                "Daenerys Targaryen (daughter of Aegon IV)", currentLocalDate.withYear(172),
                GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> aegonIVsChildren = new ArrayList<>();
        aegonIVsChildren.add(daeronII);
        aegonIVsChildren.add(daenerys);

        Targaryen aegonIV = new Targaryen("Aegon IV 'the Unworthy' Targaryen",
                currentLocalDate.withYear(135), GenderEnum.MALE, aegonIVsChildren);

        ArrayList<Royal> naerysChildren = new ArrayList<>();
        naerysChildren.add(daeronII);
        naerysChildren.add(daenerys);

        Targaryen naerys = new Targaryen("Naerys Targaryen", currentLocalDate.withYear(138),
                GenderEnum.FEMALE, naerysChildren);

        Targaryen aemon136 = new Targaryen("Aemon 'Dragonknight' Targaryen",
                currentLocalDate.withYear(136), GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> viserysIIsChildren = new ArrayList<>();
        viserysIIsChildren.add(aegonIV);
        viserysIIsChildren.add(naerys);
        viserysIIsChildren.add(aemon136);

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

        ArrayList<Royal> viserysPlummDesc = new ArrayList<>();
        viserysPlummDesc.add(benPlumm);
        viserysPlummDesc.add(philipPlumm);

        Targaryen viserysPlumm = new Targaryen("Viserys Plumm", currentLocalDate.withYear(176),
                GenderEnum.MALE, viserysPlummDesc);

        Targaryen robinPenrose = new Targaryen("Robin Penrose", currentLocalDate.withYear(192),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen laenaPenrose = new Targaryen("Laena Penrose", currentLocalDate.withYear(191),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen jocelynPenrose = new Targaryen("Jocelyn Penrose", currentLocalDate.withYear(192), GenderEnum.FEMALE, new ArrayList<>());

        Targaryen joyPenrose = new Targaryen("Joy Penrose", currentLocalDate.withYear(193),
                GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> elaenasChildren = new ArrayList<>();
        elaenasChildren.add(viserysPlumm);
        elaenasChildren.add(robinPenrose);
        elaenasChildren.add(laenaPenrose);
        elaenasChildren.add(jocelynPenrose);
        elaenasChildren.add(joyPenrose);

        Targaryen elaena = new Targaryen("Elaena Targaryen", currentLocalDate.withYear(150),
                GenderEnum.FEMALE, elaenasChildren);

        ArrayList<Royal> aegonIIIsChildren = new ArrayList<>();
        aegonIIIsChildren.add(daeronI);
        aegonIIIsChildren.add(baelorI);
        aegonIIIsChildren.add(daena);
        aegonIIIsChildren.add(rhaena147);
        aegonIIIsChildren.add(elaena);

        Targaryen aegonIII = new Targaryen("Aegon III 'the Unlucky' Targaryen",
                currentLocalDate.withYear(120), GenderEnum.MALE, aegonIIIsChildren);

        Targaryen jacaerys = new Targaryen("Jacaerys Velaryon", currentLocalDate.withYear(114),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen lucerys = new Targaryen("Lucerys Velaryon", currentLocalDate.withYear(115),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen joffreyVelaryon = new Targaryen("Joffrey Velaryon", currentLocalDate.withYear(117), GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> rhaenyrasChildren = new ArrayList<>();
        rhaenyrasChildren.add(aegonIII);
        rhaenyrasChildren.add(viserysII);
        rhaenyrasChildren.add(jacaerys);
        rhaenyrasChildren.add(lucerys);
        rhaenyrasChildren.add(joffreyVelaryon);

        Targaryen rhaenyra = new Targaryen(
                "Rhaenyra 'the Half-Year Queen' Targaryen", currentLocalDate.withYear(197),
                GenderEnum.FEMALE, rhaenyrasChildren);

        Targaryen jaehaerys123 = new Targaryen("Jaehaerys Targaryen", currentLocalDate.withYear(123), GenderEnum.MALE, new ArrayList<>());

        Targaryen jaehaera = new Targaryen("Jaehaera Targaryen", currentLocalDate.withYear(123),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen maelor = new Targaryen("Maelor Targaryen", currentLocalDate.withYear(127),
                GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> aegonIIsChildren = new ArrayList<>();
        aegonIIsChildren.add(jaehaerys123);
        aegonIIsChildren.add(jaehaera);
        aegonIIsChildren.add(maelor);

        Targaryen aegonII = new Targaryen("Aegon II 'the Elder' Targaryen",
                currentLocalDate.withYear(107), GenderEnum.MALE, aegonIIsChildren);

        Targaryen helaena = new Targaryen("Helaena Targaryen", currentLocalDate.withYear(109),
                GenderEnum.FEMALE, aegonIIsChildren);

        Targaryen aemond = new Targaryen("Aemond 'One-Eye' Targaryen",
                currentLocalDate.withYear(110), GenderEnum.MALE, new ArrayList<>());

        Targaryen daeron114 = new Targaryen("Daeron 'the Daring' Targaryen",
                currentLocalDate.withYear(114), GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> viserysIsChildren = new ArrayList<>();
        viserysIsChildren.add(rhaenyra);
        viserysIsChildren.add(aegonII);
        viserysIsChildren.add(helaena);
        viserysIsChildren.add(aemond);
        viserysIsChildren.add(daeron114);

        Targaryen viserysI = new Targaryen(
                "Viserys I 'the Young King' Targaryen", currentLocalDate.withYear(77),
                GenderEnum.MALE, viserysIsChildren);

        ArrayList<Royal> daemonsChildren = new ArrayList<>();
        daemonsChildren.add(aegonIII);
        daemonsChildren.add(viserysII);

        Targaryen daemon = new Targaryen("Daemon 'the Rogue Prince' Targaryen",
                currentLocalDate.withYear(81), GenderEnum.MALE, daemonsChildren);

        ArrayList<Royal> baelonsChildren = new ArrayList<>();
        baelonsChildren.add(viserysI);
        baelonsChildren.add(daemon);

        Targaryen baelon = new Targaryen(
                "Baelon 'the Spring Prince' Targaryen", currentLocalDate.withYear(54),
                GenderEnum.MALE, baelonsChildren);

        ArrayList<Royal> alyssasChildren = new ArrayList<>();
        alyssasChildren.addAll(baelonsChildren);

        Targaryen alyssa = new Targaryen("Alyssa Targaryen", currentLocalDate.withYear(52),
                GenderEnum.FEMALE, alyssasChildren);

        Targaryen rhaena = new Targaryen(
                "Rhaena 'of Pentos' Targaryen (daughter of Laena Velaryon)",
                currentLocalDate.withYear(116), GenderEnum.FEMALE, new ArrayList<>());

        Targaryen baela = new Targaryen("Baela Targaryen", currentLocalDate.withYear(116),
                GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> laenasChildren = new ArrayList<>();
        laenasChildren.add(rhaena);
        laenasChildren.add(baela);

        Targaryen laena = new Targaryen("Laena Velaryon", currentLocalDate.withYear(93),
                GenderEnum.FEMALE, laenasChildren);
        daemonsChildren.addAll(laenasChildren);

        ArrayList<Royal> laenorsChildren = new ArrayList<>();
        laenorsChildren.add(jacaerys);
        laenorsChildren.add(lucerys);
        laenorsChildren.add(joffreyVelaryon);

        Targaryen laenor = new Targaryen("Laenor Velaryon", currentLocalDate.withYear(94),
                GenderEnum.MALE, laenorsChildren);

        ArrayList<Royal> rhaenys74sChildren = new ArrayList<>();
        rhaenys74sChildren.add(laena);
        rhaenys74sChildren.add(laenor);

        Targaryen rhaenys74 = new Targaryen(
                "Rhaenys 'the Queen who never was' Targaryen", currentLocalDate.withYear(74),
                GenderEnum.FEMALE, rhaenys74sChildren);

        ArrayList<Royal> aemonsChildren = new ArrayList<>();
        aemonsChildren.add(rhaenys74);

        Targaryen aemon = new Targaryen("Aemon Targaryen (son of Jaehaerys I)",
                currentLocalDate.withYear(53), GenderEnum.MALE, aemonsChildren);

        ArrayList<Royal> aemmasChildren = new ArrayList<>();
        aemmasChildren.add(rhaenyra);

        Targaryen aemma = new Targaryen("Aemma Arryn", currentLocalDate.withYear(82),
                GenderEnum.FEMALE, aemmasChildren);

        ArrayList<Royal> daellasChildren = new ArrayList<>();
        daellasChildren.add(aemma);

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

        ArrayList<Royal> jaehaerysIsChildren = new ArrayList<>();
        jaehaerysIsChildren.add(alyssa);
        jaehaerysIsChildren.add(aemon);
        jaehaerysIsChildren.add(baelon);
        jaehaerysIsChildren.add(daella55);
        jaehaerysIsChildren.add(vaegon);
        jaehaerysIsChildren.add(maegella);
        jaehaerysIsChildren.add(saera);

        Targaryen jaehaerysI = new Targaryen(
                "Jaehaerys I 'the Wise' Targaryen", currentLocalDate.withYear(34), GenderEnum.MALE,
                jaehaerysIsChildren);

        Targaryen aerea = new Targaryen("Aerea Targaryen", currentLocalDate.withYear(42),
                GenderEnum.FEMALE, new ArrayList<>());

        Targaryen rhaella43 = new Targaryen(
                "Rhaella Targaryen (daughter of Aegon, son of Aenys I)",
                currentLocalDate.withYear(43), GenderEnum.FEMALE, new ArrayList<>());

        ArrayList<Royal> aegon26sChildren = new ArrayList<>();
        aegon26sChildren.add(aerea);
        aegon26sChildren.add(rhaella43);

        Targaryen aegon26 = new Targaryen("Aegon Targaryen (son of Aenys I)",
                currentLocalDate.withYear(26), GenderEnum.MALE, aegon26sChildren);

        ArrayList<Royal> rhaena23sChildren = new ArrayList<>();
        rhaena23sChildren.addAll(aegon26sChildren);

        Targaryen rhaena23 = new Targaryen(
                "Rhaena Targaryen (daughter of Aenys I)", currentLocalDate.withYear(23),
                GenderEnum.FEMALE, rhaena23sChildren);

        Targaryen viserys29 = new Targaryen(
                "Viserys Targaryen (son of Aenys I)", currentLocalDate.withYear(29),
                GenderEnum.MALE, new ArrayList<>());

        Targaryen alysanne = new Targaryen("(Good Queen) Alysanne Targaryen",
                currentLocalDate.withYear(36), GenderEnum.FEMALE, jaehaerysIsChildren);

        ArrayList<Royal> aenysIsChildren = new ArrayList<>();
        aenysIsChildren.add(jaehaerysI);
        aenysIsChildren.add(rhaena23);
        aenysIsChildren.add(aegon26);
        aenysIsChildren.add(viserys29);
        aenysIsChildren.add(alysanne);

        Targaryen aenysI = new Targaryen("Aenys I  Targaryen", currentLocalDate.withYear(7),
                GenderEnum.MALE, aenysIsChildren);

        Targaryen maegorI = new Targaryen("Maegor I 'the Cruel' Targaryen",
                currentLocalDate.withYear(12), GenderEnum.MALE, new ArrayList<>());

        ArrayList<Royal> aegonIsChildren = new ArrayList<>();
        aegonIsChildren.add(aenysI);
        aegonIsChildren.add(maegorI);

        Targaryen aegonTheConqueror = new Targaryen(
                "Aegon I 'the Conqueror' Targaryen", currentLocalDate.withYear(-27),
                GenderEnum.MALE, aegonIsChildren);

        ArrayList<Royal> rhaenysChildren = new ArrayList<>();
        rhaenysChildren.add(aenysI);

        Targaryen rhaenys = new Targaryen("Rhaenys Targaryen", currentLocalDate.withYear(-25),
                GenderEnum.FEMALE, rhaenysChildren);

        ArrayList<Royal> visenyasChildren = new ArrayList<>();
        visenyasChildren.add(maegorI);

        Targaryen visenya = new Targaryen("Visenya Targaryen", currentLocalDate.withYear(-28),
                GenderEnum.FEMALE, visenyasChildren);

        ArrayList<Royal> daddyAerionsChildren = new ArrayList<>();
        daddyAerionsChildren.add(aegonTheConqueror);
        daddyAerionsChildren.add(rhaenys);
        daddyAerionsChildren.add(visenya);

        Targaryen daddyAerion = new Targaryen(
                "Aerion Targaryen (father of Aegon I)", currentLocalDate.withYear(-52),
                GenderEnum.MALE, daddyAerionsChildren);

        rhaenys.setRoyalParent(daddyAerion);
        visenya.setRoyalParent(daddyAerion);
        aegonTheConqueror.setRoyalParent(daddyAerion);

        targaryens.add(daddyAerion);
        targaryens.add(visenya);
        targaryens.add(rhaenys);
        targaryens.add(aegonTheConqueror);
        targaryens.add(maegorI);
        targaryens.add(aenysI);
        targaryens.add(rhaena23);
        targaryens.add(aegon26);
        targaryens.add(aerea);
        targaryens.add(rhaella43);
        targaryens.add(viserys29);
        targaryens.add(alysanne);
        targaryens.add(jaehaerysI);
        targaryens.add(daella55);
        targaryens.add(aemma);
        targaryens.add(vaegon);
        targaryens.add(maegella);
        targaryens.add(saera);
        targaryens.add(alyssa);
        targaryens.add(aemon);
        targaryens.add(rhaenys74);
        targaryens.add(laenor);
        targaryens.add(laena);
        targaryens.add(rhaena);
        targaryens.add(baela);
        targaryens.add(baelon);
        targaryens.add(daemon);
        targaryens.add(viserysI);
        targaryens.add(helaena);
        targaryens.add(aemond);
        targaryens.add(daeron114);
        targaryens.add(aegonII);
        targaryens.add(jaehaerys123);
        targaryens.add(jaehaera);
        targaryens.add(maelor);
        targaryens.add(rhaenyra);
        targaryens.add(jacaerys);
        targaryens.add(lucerys);
        targaryens.add(joffreyVelaryon);
        targaryens.add(aegonIII);
        targaryens.add(daeronI);
        targaryens.add(baelorI);
        targaryens.add(daena);
        targaryens.add(rhaena147);
        targaryens.add(elaena);
        targaryens.add(robinPenrose);
        targaryens.add(laenaPenrose);
        targaryens.add(jocelynPenrose);
        targaryens.add(joyPenrose);
        targaryens.add(viserysPlumm);
        targaryens.add(benPlumm);
        targaryens.add(philipPlumm);
        targaryens.add(viserysII);
        targaryens.add(aemon136);
        targaryens.add(naerys);
        targaryens.add(aegonIV);
        targaryens.add(daenerys);
        targaryens.add(daeronII);
        targaryens.add(rhaegel);
        targaryens.add(aelora);
        targaryens.add(aelor);
        targaryens.add(daenora);
        targaryens.add(aerysI);
        targaryens.add(baelor170);
        targaryens.add(valarr);
        targaryens.add(matarys);
        targaryens.add(maesterAemon);
        targaryens.add(maekar);
        targaryens.add(daeronDrunk);
        targaryens.add(aerion);
        targaryens.add(maegor232);
        targaryens.add(daella);
        targaryens.add(rhae);
        targaryens.add(aegonV);
        targaryens.add(rhaelle);
        targaryens.add(steffonBaratheon);
        targaryens.add(renlyBaratheon);
        targaryens.add(stannisBaratheon);
        targaryens.add(shireenBaratheon);
        targaryens.add(robertBaratheon);
        targaryens.add(tommenBaratheon);
        targaryens.add(myrcellaBaratheon);
        targaryens.add(joffreyBaratheon);

        targaryens.add(daeron228);
        targaryens.add(shaera);
        targaryens.add(jaehaerysII);
        targaryens.add(rhaella);
        targaryens.add(aerysII);
        targaryens.add(rhaegar);
        targaryens.add(rhaenysgot);
        targaryens.add(aegonGriff);
        targaryens.add(viserysgot);
        targaryens.add(dany);
        targaryens.add(rhaego);

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

        viserysgot.setAlive(true);
        aegonGriff.setAlive(true);
        benPlumm.setAlive(true);

        Main.getRecursiveLoDDMP(aegonTheConqueror);

        return targaryens;
    }

}
