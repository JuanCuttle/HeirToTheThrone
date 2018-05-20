package model;
import java.util.ArrayList;
import java.util.Date;

import basic_gui.BasicInterface;

@SuppressWarnings("deprecation")
public class Main {

	// Enables/disables debugging messages
	private static Boolean debugMode = false;
	
	// Enables/disables fancy JFrame window for viewing the lineages
	private static Boolean interfaceMode = true;
	
	// Pointer to GUI
	private static BasicInterface basicInterface;
	
	// Enables/disables full lineage viewing
	private static Boolean fullLineage = false;

	/*
	 * Concepts and acronyms: 
	 * 	Recursive: Technique for scanning generic tree [size,
	 * 				depth, any shape]
	 * 	DP: Direct Primogeniture
	 * 	DMP: Direct Male Primogeniture
	 * 	LoD: Line of Descent
	 */

	public static void main(String[] args) throws Exception {
		//tudors();
		//currentRoyalFamily();
		targaryens();

	}

	public static void tudors() throws Exception {

		ArrayList<Royal> tudors = new ArrayList<Royal>();

		Royal mary = new Royal("Mary I Tudor", new Date(1516, 2, 18),
				Gender.FEMALE, true, new ArrayList<Royal>());
		Royal elizabeth = new Royal("Elizabeth I Tudor", new Date(1533, 9, 7),
				Gender.FEMALE, true, new ArrayList<Royal>());
		Royal edward = new Royal("Edward VI Tudor", new Date(1537, 10, 12),
				Gender.MALE, true, new ArrayList<Royal>());

		ArrayList<Royal> henryChildren = new ArrayList<Royal>();
		henryChildren.add(mary);
		henryChildren.add(elizabeth);
		henryChildren.add(edward);

		Royal henryVIII = new Royal("Henry VIII Tudor", new Date(1491, 6, 28),
				Gender.MALE, true, henryChildren);

		/*
		 * String heir = showHeir(henryVIII); System.out.println(heir);
		 */

		tudors.add(mary);
		tudors.add(elizabeth);
		tudors.add(edward);
		tudors.add(henryVIII);

		for (Royal r : tudors) {
			r.sortChildrenMaleFirstDob();
			if (fullLineage) {
				r.setAlive(true);
			}
			/*
			 * for (Royal c : r.getChildren()) { c.setRoyalParent(r); }
			 */
		}

		getRecursiveLoDDMP(henryVIII);

	}

	public static void currentRoyalFamily() throws Exception {

		ArrayList<Royal> windsor = new ArrayList<Royal>();

		Royal Louis = new Royal("Louis Arthur Charles", new Date(2018, 4, 23),
				Gender.MALE, true, new ArrayList<Royal>());

		Royal Charlotte = new Royal("Charlotte Elizabeth Diana", new Date(2015,
				5, 2), Gender.FEMALE, true, new ArrayList<Royal>());

		Royal George = new Royal("George Alexander Louis",
				new Date(2013, 7, 22), Gender.MALE, true,
				new ArrayList<Royal>());

		ArrayList<Royal> williamsChildren = new ArrayList<Royal>();
		williamsChildren.add(George);
		williamsChildren.add(Charlotte);
		williamsChildren.add(Louis);

		Royal William = new Royal("William Arthur Philip Louis", new Date(1982,
				6, 21), Gender.MALE, true, williamsChildren);

		Royal Harry = new Royal("Henry Charles Albert David", new Date(1984, 9,
				15), Gender.MALE, true, new ArrayList<Royal>());

		ArrayList<Royal> charlesChildren = new ArrayList<Royal>();
		charlesChildren.add(William);
		charlesChildren.add(Harry);

		Royal Charles = new Royal("Charles Philip Arthur George", new Date(
				1948, 11, 14), Gender.MALE, true, charlesChildren);

		Royal Peter = new Royal("Peter Mark Andrew Phillips", new Date(1977,
				11, 15), Gender.MALE, true, new ArrayList<Royal>());

		Royal Zara = new Royal("Zara Anne Elizabeth Phillips", new Date(1981,
				5, 15), Gender.FEMALE, true, new ArrayList<Royal>());

		ArrayList<Royal> annesChildren = new ArrayList<Royal>();
		annesChildren.add(Peter);
		annesChildren.add(Zara);

		Royal Anne = new Royal("Anne Elizabeth Alice Louise", new Date(1950, 8,
				15), Gender.FEMALE, true, annesChildren);

		Royal Beatrice = new Royal("Beatrice Elizabeth Mary", new Date(1988, 8,
				8), Gender.FEMALE, true, new ArrayList<Royal>());

		Royal Eugenie = new Royal("Eugenie Victoria Helena", new Date(1990, 3,
				23), Gender.FEMALE, true, new ArrayList<Royal>());

		ArrayList<Royal> andrewsChildren = new ArrayList<Royal>();
		andrewsChildren.add(Beatrice);
		andrewsChildren.add(Eugenie);

		Royal Andrew = new Royal("Andrew Albert Christian Edward", new Date(
				1960, 2, 19), Gender.MALE, true, andrewsChildren);

		Royal Louise = new Royal(
				"Louise Alice Elizabeth Mary Mountbatten-Windsor", new Date(
						2003, 11, 8), Gender.FEMALE, true,
				new ArrayList<Royal>());

		Royal James = new Royal(
				"James Alexander Philip Theo Mountbatten-Windsor", new Date(
						2007, 12, 17), Gender.MALE, true,
				new ArrayList<Royal>());

		ArrayList<Royal> edwardsChildren = new ArrayList<Royal>();
		edwardsChildren.add(Louise);
		edwardsChildren.add(James);

		Royal Edward = new Royal("Edward Antony Richard Louis", new Date(1964,
				3, 10), Gender.MALE, true, edwardsChildren);

		ArrayList<Royal> queensChildren = new ArrayList<Royal>();
		queensChildren.add(Charles);
		queensChildren.add(Anne);
		queensChildren.add(Andrew);
		queensChildren.add(Edward);

		Royal ElizabethRegnum = new Royal("Elizabeth Alexandra Mary", new Date(
				1926, 4, 21), Gender.FEMALE, true, queensChildren);

		/*
		 * String heir = showHeir(ElizabethRegnum); System.out.println(heir);
		 */

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
		windsor.add(Zara);
		windsor.add(Harry);
		windsor.add(William);

		if (fullLineage) {
			for (Royal r : windsor) {
				r.setAlive(true);
			}
/*			for (Royal c : r.getChildren()) {
				c.setRoyalParent(r);
			}*/
		}

		getRecursiveLoDDP(ElizabethRegnum);
	}

	public static void targaryens() throws Exception {
		ArrayList<Royal> targaryens = new ArrayList<Royal>();

		Targaryen rhaego = new Targaryen("Rhaego Targaryen", new Date(298),
				Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> danysChildren = new ArrayList<Royal>();
		danysChildren.add(rhaego);

		Targaryen dany = new Targaryen("Daenerys 'Stormborn' Targaryen",
				new Date(284), Gender.FEMALE, danysChildren);
		dany.setAlive(true);

		Targaryen viserysgot = new Targaryen(
				"Viserys Targaryen (son of Aerys II)", new Date(276),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen aegonGriff = new Targaryen("Aegon 'Young Griff' Targaryen",
				new Date(282), Gender.MALE, new ArrayList<Royal>());
		Targaryen rhaenysgot = new Targaryen(
				"Rhaenys Targaryen (daughter of Rhaegar)", new Date(280),
				Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> rhaegarsChildren = new ArrayList<Royal>();
		rhaegarsChildren.add(rhaenysgot);
		rhaegarsChildren.add(aegonGriff);

		Targaryen rhaegar = new Targaryen("Rhaegar Targaryen", new Date(259),
				Gender.MALE, rhaegarsChildren);
		aegonGriff.setRoyalParent(rhaegar);

		ArrayList<Royal> aerysChildren = new ArrayList<Royal>();
		aerysChildren.add(rhaegar);
		aerysChildren.add(viserysgot);
		aerysChildren.add(dany);

		Targaryen aerysII = new Targaryen("Aerys II 'Mad King' Targaryen",
				new Date(244), Gender.MALE, aerysChildren);

		ArrayList<Royal> rhaellasChildren = new ArrayList<Royal>(); //
		rhaellasChildren.addAll(aerysChildren);

		Targaryen rhaella = new Targaryen(
				"Rhaella Targaryen (daughter of Jaehaerys II)", new Date(245),
				Gender.FEMALE, rhaellasChildren);

		ArrayList<Royal> jaehaerysIIChildren = new ArrayList<Royal>();
		jaehaerysIIChildren.add(aerysII);
		jaehaerysIIChildren.add(rhaella);

		Targaryen jaehaerysII = new Targaryen("Jaehaerys II Targaryen",
				new Date(225), Gender.MALE, jaehaerysIIChildren);

		ArrayList<Royal> shaerasChildren = new ArrayList<Royal>(); //
		shaerasChildren.addAll(jaehaerysIIChildren);

		Targaryen shaera = new Targaryen("Shaera Targaryen", new Date(226),
				Gender.FEMALE, shaerasChildren);

		Targaryen duncan = new Targaryen(
				"Duncan 'Prince of Dragonflies' Targaryen", new Date(222),
				Gender.MALE, new ArrayList<Royal>());
		duncan.setAbdicated(true);

		Targaryen daeron228 = new Targaryen(
				"Daeron Targaryen (son of Aegon V)", new Date(228),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen joffreyBaratheon = new Targaryen("Joffrey Baratheon",
				new Date(286), Gender.MALE, new ArrayList<Royal>());
		Targaryen myrcellaBaratheon = new Targaryen("Myrcella Baratheon",
				new Date(290), Gender.FEMALE, new ArrayList<Royal>());
		Targaryen tommenBaratheon = new Targaryen("Tommen Baratheon", new Date(
				291), Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> robertsChildren = new ArrayList<Royal>();
		robertsChildren.add(joffreyBaratheon);
		robertsChildren.add(myrcellaBaratheon);
		robertsChildren.add(tommenBaratheon);

		Targaryen shireenBaratheon = new Targaryen("Shireen Baratheon",
				new Date(289), Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> stannisChildren = new ArrayList<Royal>();
		stannisChildren.add(shireenBaratheon);

		Targaryen robertBaratheon = new Targaryen("Robert I Baratheon",
				new Date(262), Gender.MALE, robertsChildren);
		Targaryen stannisBaratheon = new Targaryen("Stannis Baratheon",
				new Date(264), Gender.MALE, stannisChildren);
		Targaryen renlyBaratheon = new Targaryen("Renly Baratheon", new Date(
				277), Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> steffonsChildren = new ArrayList<Royal>();
		steffonsChildren.add(robertBaratheon);
		steffonsChildren.add(stannisBaratheon);
		steffonsChildren.add(renlyBaratheon);

		Targaryen steffonBaratheon = new Targaryen("Steffon Baratheon",
				new Date(246), Gender.MALE, steffonsChildren);

		ArrayList<Royal> rhaellesChildren = new ArrayList<Royal>();
		rhaellesChildren.add(steffonBaratheon);

		Targaryen rhaelle = new Targaryen("Rhaelle Targaryen", new Date(231),
				Gender.FEMALE, rhaellesChildren);

		ArrayList<Royal> aegonVChildren = new ArrayList<Royal>();
		aegonVChildren.add(duncan);
		aegonVChildren.add(jaehaerysII);
		aegonVChildren.add(shaera);
		aegonVChildren.add(daeron228);
		aegonVChildren.add(rhaelle);

		Targaryen aegonV = new Targaryen("Aegon V 'Egg' Targaryen", new Date(
				200), Gender.MALE, aegonVChildren);

		Targaryen maesterAemon = new Targaryen("Maester Aemon Targaryen",
				new Date(198), Gender.MALE, new ArrayList<Royal>());
		maesterAemon.setAlive(true);
		maesterAemon.setAbdicated(true);

		Targaryen daeronDrunk = new Targaryen("Daeron 'the Drunk' Targaryen",
				new Date(190), Gender.MALE, new ArrayList<Royal>());

		Targaryen maegor232 = new Targaryen(
				"Maegor Targaryen (son of Aerion 'Brightflame')",
				new Date(232), Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> aerionsChildren = new ArrayList<Royal>();
		aerionsChildren.add(maegor232);

		Targaryen aerion = new Targaryen("Aerion 'Brightflame' Targaryen",
				new Date(192), Gender.MALE, aerionsChildren);

		Targaryen daella = new Targaryen(
				"Daella Targaryen (daughter of Maekar I)", new Date(199),
				Gender.FEMALE, new ArrayList<Royal>());

		Targaryen rhae = new Targaryen("Rhae Targaryen", new Date(205),
				Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> maekarsChildren = new ArrayList<Royal>();
		maekarsChildren.add(aegonV);
		maekarsChildren.add(maesterAemon);
		maekarsChildren.add(daeronDrunk);
		maekarsChildren.add(aerion);
		maekarsChildren.add(daella);
		maekarsChildren.add(rhae);

		Targaryen maekar = new Targaryen("Maekar I 'The Anvil' Targaryen",
				new Date(176), Gender.MALE, maekarsChildren);

		Targaryen valarr = new Targaryen("Valarr 'the young Prince' Targaryen",
				new Date(183), Gender.MALE, new ArrayList<Royal>());

		Targaryen matarys = new Targaryen(
				"Matarys 'the even younger Prince' Targaryen", new Date(184),
				Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> baelor170sChildren = new ArrayList<Royal>();
		baelor170sChildren.add(valarr);
		baelor170sChildren.add(matarys);

		Targaryen baelor170 = new Targaryen("Baelor 'Breakspear' Targaryen",
				new Date(170), Gender.MALE, baelor170sChildren);

		Targaryen aerysI = new Targaryen("Aerys I Targaryen", new Date(174),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen aelora = new Targaryen("Aelora Targaryen", new Date(199),
				Gender.FEMALE, new ArrayList<Royal>());
		Targaryen aelor = new Targaryen("Aelor Targaryen", new Date(199),
				Gender.MALE, new ArrayList<Royal>());
		ArrayList<Royal> daenorasChildren = new ArrayList<Royal>(); //
		daenorasChildren.addAll(aerionsChildren);
		Targaryen daenora = new Targaryen("Daenora Targaryen", new Date(213),
				Gender.FEMALE, daenorasChildren);

		ArrayList<Royal> rhaegelsChildren = new ArrayList<Royal>();
		rhaegelsChildren.add(aelora);
		rhaegelsChildren.add(aelor);
		rhaegelsChildren.add(daenora);

		Targaryen rhaegel = new Targaryen("Rhaegel Targaryen", new Date(175),
				Gender.MALE, rhaegelsChildren);

		ArrayList<Royal> daeronIIsChildren = new ArrayList<Royal>();
		daeronIIsChildren.add(rhaegel);
		daeronIIsChildren.add(aerysI);
		daeronIIsChildren.add(baelor170);
		daeronIIsChildren.add(maekar);

		Targaryen daeronII = new Targaryen("Daeron II 'the Good' Targaryen",
				new Date(153), Gender.MALE, daeronIIsChildren);

		Targaryen daenerys = new Targaryen(
				"Daenerys Targaryen (daughter of Aegon IV)", new Date(172),
				Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> aegonIVsChildren = new ArrayList<Royal>();
		aegonIVsChildren.add(daeronII);
		aegonIVsChildren.add(daenerys);

		Targaryen aegonIV = new Targaryen("Aegon IV 'the Unworthy' Targaryen",
				new Date(135), Gender.MALE, aegonIVsChildren);

		ArrayList<Royal> naerysChildren = new ArrayList<Royal>(); //
		naerysChildren.add(daeronII);
		naerysChildren.add(daenerys);

		Targaryen naerys = new Targaryen("Naerys Targaryen", new Date(138),
				Gender.FEMALE, naerysChildren);

		Targaryen aemon136 = new Targaryen("Aemon 'Dragonknight' Targaryen",
				new Date(136), Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> viserysIIsChildren = new ArrayList<Royal>();
		viserysIIsChildren.add(aegonIV);
		viserysIIsChildren.add(naerys);
		viserysIIsChildren.add(aemon136);

		Targaryen viserysII = new Targaryen("Viserys II  Targaryen", new Date(
				122), Gender.MALE, viserysIIsChildren);

		Targaryen daeronI = new Targaryen(
				"Daeron I 'the Young Dragon' Targaryen", new Date(143),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen baelorI = new Targaryen("Baelor I 'the Blessed' Targaryen",
				new Date(144), Gender.MALE, new ArrayList<Royal>());

		Targaryen daena = new Targaryen("Daena 'the Defiant' Targaryen",
				new Date(145), Gender.FEMALE, new ArrayList<Royal>());

		Targaryen rhaena147 = new Targaryen(
				"Rhaena Targaryen (daughter of Aegon III)", new Date(147),
				Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> philipPlummDesc = new ArrayList<Royal>();
		Targaryen philipPlumm = new Targaryen("Philip Plumm", new Date(235),
				Gender.MALE, philipPlummDesc);

		Targaryen benPlumm = new Targaryen("Ben Plumm", new Date(240),
				Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> viserysPlummDesc = new ArrayList<Royal>();
		viserysPlummDesc.add(benPlumm);
		viserysPlummDesc.add(philipPlumm);

		Targaryen viserysPlumm = new Targaryen("Viserys Plumm", new Date(176),
				Gender.MALE, viserysPlummDesc);

		Targaryen robinPenrose = new Targaryen("Robin Penrose", new Date(192),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen laenaPenrose = new Targaryen("Laena Penrose", new Date(191),
				Gender.FEMALE, new ArrayList<Royal>());

		Targaryen jocelynPenrose = new Targaryen("Jocelyn Penrose", new Date(
				192), Gender.FEMALE, new ArrayList<Royal>());

		Targaryen joyPenrose = new Targaryen("Joy Penrose", new Date(193),
				Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> elaenasChildren = new ArrayList<Royal>();
		elaenasChildren.add(viserysPlumm);
		elaenasChildren.add(robinPenrose);
		elaenasChildren.add(laenaPenrose);
		elaenasChildren.add(jocelynPenrose);
		elaenasChildren.add(joyPenrose);

		Targaryen elaena = new Targaryen("Elaena Targaryen", new Date(150),
				Gender.FEMALE, elaenasChildren);

		ArrayList<Royal> aegonIIIsChildren = new ArrayList<Royal>();
		aegonIIIsChildren.add(daeronI);
		aegonIIIsChildren.add(baelorI);
		aegonIIIsChildren.add(daena);
		aegonIIIsChildren.add(rhaena147);
		aegonIIIsChildren.add(elaena);

		Targaryen aegonIII = new Targaryen("Aegon III 'the Unlucky' Targaryen",
				new Date(120), Gender.MALE, aegonIIIsChildren);

		Targaryen jacaerys = new Targaryen("Jacaerys Velaryon", new Date(114),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen lucerys = new Targaryen("Lucerys Velaryon", new Date(115),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen joffreyVelaryon = new Targaryen("Joffrey Velaryon", new Date(
				117), Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> rhaenyrasChildren = new ArrayList<Royal>();
		rhaenyrasChildren.add(aegonIII);
		rhaenyrasChildren.add(viserysII);
		rhaenyrasChildren.add(jacaerys);
		rhaenyrasChildren.add(lucerys);
		rhaenyrasChildren.add(joffreyVelaryon);

		Targaryen rhaenyra = new Targaryen(
				"Rhaenyra 'the Half-Year Queen' Targaryen", new Date(97),
				Gender.FEMALE, rhaenyrasChildren);

		Targaryen jaehaerys123 = new Targaryen("Jaehaerys Targaryen", new Date(
				123), Gender.MALE, new ArrayList<Royal>());

		Targaryen jaehaera = new Targaryen("Jaehaera Targaryen", new Date(123),
				Gender.FEMALE, new ArrayList<Royal>());

		Targaryen maelor = new Targaryen("Maelor Targaryen", new Date(127),
				Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> aegonIIsChildren = new ArrayList<Royal>();
		aegonIIsChildren.add(jaehaerys123);
		aegonIIsChildren.add(jaehaera);
		aegonIIsChildren.add(maelor);

		Targaryen aegonII = new Targaryen("Aegon II 'the Elder' Targaryen",
				new Date(107), Gender.MALE, aegonIIsChildren);

		Targaryen helaena = new Targaryen("Helaena Targaryen", new Date(109),
				Gender.FEMALE, aegonIIsChildren); //

		Targaryen aemond = new Targaryen("Aemond 'One-Eye' Targaryen",
				new Date(110), Gender.MALE, new ArrayList<Royal>());

		Targaryen daeron114 = new Targaryen("Daeron 'the Daring' Targaryen",
				new Date(114), Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> viserysIsChildren = new ArrayList<Royal>();
		viserysIsChildren.add(rhaenyra);
		viserysIsChildren.add(aegonII);
		viserysIsChildren.add(helaena);
		viserysIsChildren.add(aemond);
		viserysIsChildren.add(daeron114);

		Targaryen viserysI = new Targaryen(
				"Viserys I 'the Young King' Targaryen", new Date(77),
				Gender.MALE, viserysIsChildren);

		ArrayList<Royal> daemonsChildren = new ArrayList<Royal>();
		daemonsChildren.add(aegonIII); //
		daemonsChildren.add(viserysII); //

		Targaryen daemon = new Targaryen("Daemon 'the Rogue Prince' Targaryen",
				new Date(81), Gender.MALE, daemonsChildren);

		ArrayList<Royal> baelonsChildren = new ArrayList<Royal>();
		baelonsChildren.add(viserysI);
		baelonsChildren.add(daemon);

		Targaryen baelon = new Targaryen(
				"Baelon 'the Spring Prince' Targaryen", new Date(54),
				Gender.MALE, baelonsChildren);

		ArrayList<Royal> alyssasChildren = new ArrayList<Royal>(); //
		alyssasChildren.addAll(baelonsChildren);

		Targaryen alyssa = new Targaryen("Alyssa Targaryen", new Date(52),
				Gender.FEMALE, alyssasChildren);

		Targaryen rhaena = new Targaryen(
				"Rhaena 'of Pentos' Targaryen (daughter of Laena Velaryon)",
				new Date(116), Gender.FEMALE, new ArrayList<Royal>());

		Targaryen baela = new Targaryen("Baela Targaryen", new Date(116),
				Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> laenasChildren = new ArrayList<Royal>();
		laenasChildren.add(rhaena);
		laenasChildren.add(baela);

		Targaryen laena = new Targaryen("Laena Velaryon", new Date(93),
				Gender.FEMALE, laenasChildren);
		daemonsChildren.addAll(laenasChildren); //

		ArrayList<Royal> laenorsChildren = new ArrayList<Royal>(); //
		laenorsChildren.add(jacaerys);
		laenorsChildren.add(lucerys);
		laenorsChildren.add(joffreyVelaryon);

		Targaryen laenor = new Targaryen("Laenor Velaryon", new Date(94),
				Gender.MALE, laenorsChildren);

		ArrayList<Royal> rhaenys74sChildren = new ArrayList<Royal>();
		rhaenys74sChildren.add(laena);
		rhaenys74sChildren.add(laenor);

		Targaryen rhaenys74 = new Targaryen(
				"Rhaenys 'the Queen who never was' Targaryen", new Date(74),
				Gender.FEMALE, rhaenys74sChildren);

		ArrayList<Royal> aemonsChildren = new ArrayList<Royal>();
		aemonsChildren.add(rhaenys74);

		Targaryen aemon = new Targaryen("Aemon Targaryen (son of Jaehaerys I)",
				new Date(53), Gender.MALE, aemonsChildren);

		ArrayList<Royal> aemmasChildren = new ArrayList<Royal>(); //
		aemmasChildren.add(rhaenyra);

		Targaryen aemma = new Targaryen("Aemma Arryn", new Date(82),
				Gender.FEMALE, aemmasChildren);

		ArrayList<Royal> daellasChildren = new ArrayList<Royal>();
		daellasChildren.add(aemma);

		Targaryen daella55 = new Targaryen(
				"Daella Targaryen (daughter of Jaehaerys I)", new Date(55),
				Gender.FEMALE, daellasChildren);

		Targaryen vaegon = new Targaryen("Vaegon Targaryen", new Date(56),
				Gender.MALE, new ArrayList<Royal>());
		vaegon.setAbdicated(true);

		Targaryen maegella = new Targaryen("Maegella Targaryen", new Date(57),
				Gender.FEMALE, new ArrayList<Royal>());
		maegella.setAbdicated(true);

		Targaryen saera = new Targaryen("Saera Targaryen", new Date(58),
				Gender.FEMALE, new ArrayList<Royal>());
		saera.setAbdicated(true);

		ArrayList<Royal> jaehaerysIsChildren = new ArrayList<Royal>();
		jaehaerysIsChildren.add(alyssa);
		jaehaerysIsChildren.add(aemon);
		jaehaerysIsChildren.add(baelon);
		jaehaerysIsChildren.add(daella55);
		jaehaerysIsChildren.add(vaegon);
		jaehaerysIsChildren.add(maegella);
		jaehaerysIsChildren.add(saera);

		Targaryen jaehaerysI = new Targaryen(
				"Jaehaerys I 'the Wise' Targaryen", new Date(34), Gender.MALE,
				jaehaerysIsChildren);

		Targaryen aerea = new Targaryen("Aerea Targaryen", new Date(42),
				Gender.FEMALE, new ArrayList<Royal>());

		Targaryen rhaella43 = new Targaryen(
				"Rhaella Targaryen (daughter of Aegon, son of Aenys I)",
				new Date(43), Gender.FEMALE, new ArrayList<Royal>());

		ArrayList<Royal> aegon26sChildren = new ArrayList<Royal>();
		aegon26sChildren.add(aerea);
		aegon26sChildren.add(rhaella43);

		Targaryen aegon26 = new Targaryen("Aegon Targaryen (son of Aenys I)",
				new Date(26), Gender.MALE, aegon26sChildren);

		ArrayList<Royal> rhaena23sChildren = new ArrayList<Royal>(); //
		rhaena23sChildren.addAll(aegon26sChildren);

		Targaryen rhaena23 = new Targaryen(
				"Rhaena Targaryen (daughter of Aenys I)", new Date(23),
				Gender.FEMALE, rhaena23sChildren);

		Targaryen viserys29 = new Targaryen(
				"Viserys Targaryen (son of Aenys I)", new Date(29),
				Gender.MALE, new ArrayList<Royal>());

		Targaryen alysanne = new Targaryen("(Good Queen) Alysanne Targaryen",
				new Date(36), Gender.FEMALE, jaehaerysIsChildren); //

		ArrayList<Royal> aenysIsChildren = new ArrayList<Royal>();
		aenysIsChildren.add(jaehaerysI);
		aenysIsChildren.add(rhaena23);
		aenysIsChildren.add(aegon26);
		aenysIsChildren.add(viserys29);
		aenysIsChildren.add(alysanne);

		Targaryen aenysI = new Targaryen("Aenys I  Targaryen", new Date(7),
				Gender.MALE, aenysIsChildren);

		Targaryen maegorI = new Targaryen("Maegor I 'the Cruel' Targaryen",
				new Date(12), Gender.MALE, new ArrayList<Royal>());

		ArrayList<Royal> aegonIsChildren = new ArrayList<Royal>();
		aegonIsChildren.add(aenysI);
		aegonIsChildren.add(maegorI);

		Targaryen aegonTheConqueror = new Targaryen(
				"Aegon I 'the Conqueror' Targaryen", new Date(-27),
				Gender.MALE, aegonIsChildren);

		ArrayList<Royal> rhaenysChildren = new ArrayList<Royal>(); //
		rhaenysChildren.add(aenysI);

		Targaryen rhaenys = new Targaryen("Rhaenys Targaryen", new Date(-25),
				Gender.FEMALE, rhaenysChildren);

		ArrayList<Royal> visenyasChildren = new ArrayList<Royal>(); //
		visenyasChildren.add(maegorI);

		Targaryen visenya = new Targaryen("Visenya Targaryen", new Date(-28),
				Gender.FEMALE, visenyasChildren);

		ArrayList<Royal> daddyAerionsChildren = new ArrayList<Royal>();
		daddyAerionsChildren.add(aegonTheConqueror);
		daddyAerionsChildren.add(rhaenys);
		daddyAerionsChildren.add(visenya);

		Targaryen daddyAerion = new Targaryen(
				"Aerion Targaryen (father of Aegon I)", new Date(-52),
				Gender.MALE, daddyAerionsChildren);

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
			if (fullLineage){
				r.setAlive(true);
			}
			/*
			 * for (Royal c : r.getChildren()) { c.setRoyalParent(r); }
			 */
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

		// System.out.println(aerysII.getKin());
		getRecursiveLoDDMP(aegonTheConqueror);

	}

	public static Royal findHeirDP(Royal root) {

		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		Royal heir = root;

		for (Royal r : root.getChildren()) {
			if (r.canBeHeir()) {
				heir = r;
				break;
			} else {
				heir = findHeirDP(r);
				break;
			}
		}

		if (heir == root) {
			ArrayList<Royal> heirsAux = root.getRoyalParent().getChildren();
			int index = heirsAux.indexOf(root);
			if (index + 1 < heirsAux.size()) {
				Royal nextRoot = heirsAux.get(index + 1);
				// System.out.println(nextRoot.getName());
				if (nextRoot.canBeHeir()) {
					heir = nextRoot;
				} else {
					heir = findHeirDP(nextRoot);
				}
			} else {

				Royal nextLevel = root.getRoyalParent();
				if (nextLevel != null && nextLevel.getRoyalParent() != null) {
					heirsAux = nextLevel.getRoyalParent().getChildren();
					/*
					 * System.out.println(nextLevel.getName() + "'s kin: " +
					 * heirsAux);
					 */
					int index1 = heirsAux.indexOf(nextLevel);
					// System.out.println(index1);
					if (index1 + 1 < heirsAux.size()) {
						Royal nextRoot = heirsAux.get(index1 + 1);
						// System.out.println(nextRoot.getName());
						if (nextRoot.canBeHeir()) {
							heir = nextRoot;
						} else {
							heir = findHeirDP(nextRoot);
						}
					} else {
						return null;
					}
				} else {
					return null;
				}
			}
			// completar se não houverem irmãos válidos, subindo até achar
		}

		return heir;
	}

	public static ArrayList<Royal> findHeirRecursiveDP(Royal root) {

		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		ArrayList<Royal> result = new ArrayList<Royal>();
		ArrayList<Royal> heirs = root.getChildren();

		result.add(root);

		for (int j = 0; j < heirs.size(); j++) {
			if (heirs.get(j).getRoyalParent() == null) {
				heirs.get(j).setRoyalParent(root);
			}
			if (!heirs.get(j).getVisited()) {
				ArrayList<Royal> children = findHeirRecursiveDP(heirs.get(j));
				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
					}
				}
			}
		}

		ArrayList<Royal> kin = root.getKin();

		for (int j = 0; j < kin.size(); j++) {
			if (!kin.get(j).getVisited()) {
				ArrayList<Royal> children = findHeirRecursiveDP(kin.get(j));
				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
					}
				}
			}
		}

		Royal parent = root.getRoyalParent();

		if (parent != null) {

			ArrayList<Royal> uncles = parent.getKin();

			if (debugMode) {
				System.out.println("Parent: " + parent.getName());
				System.out.println(uncles);
			}

			for (int j = 0; j < uncles.size(); j++) {
				if (!uncles.get(j).getVisited()) {
					ArrayList<Royal> unclesChildren = findHeirRecursiveDP(uncles
							.get(j));
					for (int k = 0; k < unclesChildren.size(); k++) {
						Royal child = unclesChildren.get(k);
						if (!result.contains(child) && child.canBeHeir()) {
							result.add(child);
						}
					}
				}
			}
		}

		return result;
	}

	public static Royal findHeirDMP(Royal root) {

		root.sortChildrenMaleFirstDob();
		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		Royal heir = root;

		for (Royal r : root.getMaleChildren()) {
			if (r.canBeHeir()) {
				heir = r;
				break;
			} else {
				heir = findHeirDMP(r);
				break;
			}
		}

		if (heir == root) {
			for (Royal r : root.getFemaleChildren()) {
				if (r.canBeHeir()) {
					heir = r;
					break;
				} else {
					heir = findHeirDMP(r);
					break;
				}
			}
		}

		if (heir == root) {
			ArrayList<Royal> heirsAux = root.getRoyalParent().getChildren();
			if (debugMode)
				System.out.println("[DEBUG] Kin of root: " + heirsAux);
			int index = heirsAux.indexOf(root);
			if (index + 1 < heirsAux.size()) {
				Royal nextRoot = heirsAux.get(index + 1);
				// System.out.println(nextRoot.getName());
				if (nextRoot.canBeHeir()) {
					heir = nextRoot;
				} else {
					heir = findHeirDMP(nextRoot);
				}
			} else {

				Royal nextLevel = root.getRoyalParent();
				if (nextLevel != null && nextLevel.getRoyalParent() != null) {
					heirsAux = nextLevel.getRoyalParent().getChildren();
					/*
					 * System.out.println(nextLevel.getName() + "'s kin: " +
					 * heirsAux);
					 */

					int index1 = heirsAux.indexOf(nextLevel);
					// System.out.println(index1);
					if (index1 + 1 < heirsAux.size()) {
						Royal nextRoot = heirsAux.get(index1 + 1);
						// System.out.println(nextRoot.getName());
						if (nextRoot.canBeHeir()) {
							heir = nextRoot;
						} else {
							heir = findHeirDMP(nextRoot);
						}
					} else {
						nextLevel = nextLevel.getRoyalParent();
						if (nextLevel != null
								&& nextLevel.getRoyalParent() != null) {
							heirsAux = nextLevel.getRoyalParent().getChildren();
							/*
							 * System.out.println(nextLevel.getName() +
							 * "'s kin: " + heirsAux);
							 */

							index1 = heirsAux.indexOf(nextLevel);
							// System.out.println(index1);
							if (index1 + 1 < heirsAux.size()) {
								Royal nextRoot = heirsAux.get(index1 + 1);
								// System.out.println(nextRoot.getName());
								if (nextRoot.canBeHeir()) {
									heir = nextRoot;
								} else {
									heir = findHeirDMP(nextRoot);
								}
							} else {
								return null;
							}
						} else {
							return null;
						}
					}
				} else {
					return null;
				}
			}
			// completar se não houverem irmãos válidos, subindo até achar
		}

		return heir;
	}

	public static ArrayList<Royal> findHeirRecursiveDMP(Royal root) {

		if (root instanceof Targaryen) {
			root = (Targaryen) root;
		}

		// root.sortChildrenMaleFirstDob();

		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		ArrayList<Royal> result = new ArrayList<Royal>();
		ArrayList<Royal> heirs = root.getChildren();

		result.add(root);
		root.setVisited(true);

		for (int j = 0; j < heirs.size(); j++) {
			if (heirs.get(j).getRoyalParent() == null) {
				heirs.get(j).setRoyalParent(root);
			}
			if (!heirs.get(j).getVisited()) {
				// heirs.get(j).setVisited(true);

				ArrayList<Royal> children = findHeirRecursiveDMP(heirs.get(j));

				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
						// child.setVisited(true);
					}
				}
			}
		}

		ArrayList<Royal> kin = root.getKin();

		for (int j = 0; j < kin.size(); j++) {
			if (!kin.get(j).getVisited()) {
				// kin.get(j).setVisited(true);
				ArrayList<Royal> children = findHeirRecursiveDMP(kin.get(j));
				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
					}
				}
			}
		}

		Royal parent = root.getRoyalParent();

		if (parent != null) {

			ArrayList<Royal> uncles = parent.getKin();

			if (debugMode) {
				System.out.println("Parent: " + parent.getName());
				System.out.println(uncles);
			}
			for (int j = 0; j < uncles.size(); j++) {
				if (!uncles.get(j).getVisited()) {
					// uncles.get(j).setVisited(true);
					ArrayList<Royal> unclesChildren = findHeirRecursiveDMP(uncles
							.get(j));
					for (int k = 0; k < unclesChildren.size(); k++) {
						Royal child = unclesChildren.get(k);
						/*
						 * if (child.getRoyalParent() == null){
						 * child.setRoyalParent(uncles.get(j)); }
						 */
						if (!result.contains(child) && child.canBeHeir()) {
							result.add(child);
						}
					}
				}
			}
		}

		return result;
	}

	public static void getLoDDP(Royal root) {
		Royal h = root;
		Royal aux;
		int i = 0;
		String message = "\nLine of descent of " + root.getName() + ":\n";
		do {
			i++;
			aux = findHeirDP(h);
			if (aux != null) {
				message += i + ". " + aux.getName() + "\n";
			}
			h = aux;
		} while (aux != null);
		System.out.println(message);
	}

	public static void getRecursiveLoDDP(Royal root) throws Exception {
		Royal h = root;
		String title = "\nLine of descent of " + root.getName() + ":\n";
		String message = "";
		String messageAux = "";
		ArrayList<Royal> lineage = new ArrayList<Royal>();
		lineage = findHeirRecursiveDP(h);
		if (lineage.size() <= 12) {
			for (int i = 1; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			System.out.println(title);
			System.out.println(message);
		} else {
			for (int i = 1; i <= 12; i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			message += "\n";
			for (int i = 13; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				messageAux += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					messageAux += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
				if (i % 12 == 0 && !interfaceMode) {
					messageAux += "\n";
				}
			}
			System.out.println(title);
			System.out.println(message + messageAux);
		}

		if (interfaceMode) {
			basicInterface = new BasicInterface();
			basicInterface.showLineage(message, messageAux, title);
			basicInterface.setVisible(true);
		}
	}

	public static void getLoDDMP(Royal root) throws Exception {
		Royal h = root;
		Royal aux;
		int i = 0;
		String message = "\nLine of descent of " + root.getName() + ":\n";
		do {
			i++;
			aux = findHeirDMP(h);
			if (aux != null) {
				message += i + ". " + aux.getName() + "\n";
			}
			h = aux;
		} while (aux != null);
		System.out.println(message);
	}

	public static void getRecursiveLoDDMP(Royal root) throws Exception {
		Royal h = root;
		String title = "\nLine of descent of " + root.getName() + ":\n";
		String message = "";
		String messageAux = "";
		ArrayList<Royal> lineage = new ArrayList<Royal>();
		lineage = findHeirRecursiveDMP(h);
		if (lineage.size() <= 12) {
			for (int i = 1; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			System.out.println(title);
			System.out.println(message);
		} else {
			for (int i = 1; i <= 12; i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			message += "\n";
			for (int i = 13; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				messageAux += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					messageAux += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
				if (i % 12 == 0 && !interfaceMode) {
					messageAux += "\n";
				}
			}
			System.out.println(title);
			System.out.println(message + messageAux);
		}
		if (interfaceMode) {
			basicInterface = new BasicInterface();
			basicInterface.showLineage(message, messageAux, title);
			basicInterface.setVisible(true);
		}
	}

	@SuppressWarnings("unused")
	private static String showHeirDP(Royal root) {
		Royal heir = findHeirDP(root);
		String message = "";
		if (heir != root && heir != null) {
			message = "Heir to " + root.getName() + ": HRH Prince";
			if (heir.getGender() == Gender.FEMALE) {
				message += "ss";
			}
			message += " " + heir.getName();
		} else {
			message = "No heirs!";
		}
		return message;
	}

	@SuppressWarnings("unused")
	private static String showHeirDMP(Royal root) {
		Royal heir = findHeirDMP(root);
		String message = "";
		if (heir != root && heir != null) {
			message = "Heir to " + root.getName() + ": HRH Prince";
			if (heir.getGender() == Gender.FEMALE) {
				message += "ss";
			}
			message += " " + heir.getName();
		} else {
			message = "No heirs!";
		}
		return message;
	}

}
