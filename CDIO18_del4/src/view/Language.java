package view;

import model.Player;

/*
 * Class wrote by: Kasper Leiszner
 */

public class Language 
{
	private static String[] fieldName = 
		{
				"Start",				// felt 0
				"Rødovrevej",
				"Prøv lykken",
				"Hvidovrevej",
				"Skat",
				"Øresund",
				"Roskildevej",
				"Prøv lykken",
				"Valby Langgade",
				"Allegade",
				"Fængsel",				// felt 10
				"Frederiksberg Allé",
				"Tuborg",
				"Bulowsvej",
				"Gammel Kongevej",
				"D.F.D.S",
				"Bernstorffsvej",
				"Prøv lykken",
				"Hellerupvej",
				"Strandvejen",
				"Helle",				//felt 20
				"Trianglen",
				"Prøv lykken",
				"Østerbrogade",
				"Grønningen",
				"Ø.S.",
				"Bredgade",
				"Kgs. Nytorv",
				"Calsberg",
				"Østergade",
				"Gå i fængsel",			//felt 30
				"Amagertorv",
				"Vimmelskaftet",
				"Prøv lykken",
				"Nygade",
				"Bornholm",
				"Prøv lykken",
				"Frederiksberggade",
				"Skat",
				"Rådhuspladsen"			// felt 39
		};
	
	public static String[] getCardDescriptions() {
		return cardDescriptions;
	}

	private static String[] cardDescriptions =
		{
				"Ejendomsskatterne er steget, ekstraudgifterne er: kr. 50,00 pr. hus, kr. 125,00 pr. hotel.",
				"Ryk frem til Frederiksberg Allé. Hvis De passerer START, indkassér da kr. 200,00",
				"De har lagt penge ud til sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller kr. 25,00",
				"Ryk tre felter tilbage",
				"De modtager Deres aktieudbytte. Modtag kr. 50 af banken.",
				"Grundet dyrtiden har De fået gageforhøjelse. Modtag kr. 25,00.",
				"Betal for vognvask og smøring kr. 10,00.",
				"Deres præmieobligation er udtrukket. De modtager kr. 100 af banken.",
				"Deres præmieobligation er udtrukket. De modtager kr. 100 af banken.",
				"Ryk frem til START.",
				"Ryk frem til START.",
				"De skal holde familiefest og fået et tilskud fra hver medspiller på kr. 25,00.",
				"Tag ind på Rådhuspladsen.",
				"Tag med Øresundsredderiet. Flyt brikken frem, og hvis De passerer “START”, indkassér da kr. 200,00.",
				"De har købt 4 nye dæk til Deres vogn. Betal kr. 50,00.",
				"De har fået en parkeringsbøde. Betal kr. 20,00 i bøde.",
				"Betal kr. 10 for levering af 2 kasser øl.",
				"Tag med den nærmeste færge. Flyt brikken frem, og hvis De passerer “START”, indkassér da kr. 200.",
				"Gå i fængsel. Ryk direkte til fængslet. Selv om de passerer “START”, indkasserer de ikke kr. 200.",
				"Gå i fængsel. Ryk direkte til fængslet. Selv om de passerer “START”, indkasserer de ikke kr. 200.",
				"Oliepriserne er steget, og De skal betale: kr. 25 pr. Hus, kr. 100 pr. hotel",
				"Modtag udbytte af Deres aktier: kr. 50,00.",
				"Modtag udbytte af Deres aktier: kr. 50,00.",
				"Ryk brikken frem til det nærmeste rederi og betal lejeren to gange leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan du købe det af banken.",
				"Ryk frem til Strandvejen. Hvis du passerer start, indkassér kr. 200,00.",
				"Betal deres bilforsikring – kr. 50,00.",
				"De havde en række med elleve rigtige i tipning. Modtag kr. 50.",
				"De har vundet i klasselotteriet. Modtag kr. 25.",
				"De har vundet i klasselotteriet. Modtag kr. 25.",
				"Ryk frem til Vimmelskaftet. Hvis de passerer start, indkassér da kr. 200,00.",
				"Ryk tre felter tilbage",
				"Ryk tre felter tilbage",
				"I anledning af kongens fødselsdag benådes de herved for fængsel. Dette kort kan opbevares indtil De får brug for det eller De kan sælge det.",
				"I anledning af kongens fødselsdag benådes de herved for fængsel. Dette kort kan opbevares indtil De får brug for det eller De kan sælge det.",
				"Betal kr. 150,00. for reparation af Deres vogn.",
				"De har solgt nogle gamle møbler på auktion. Modtag kr. 50 af banken.",
				"De har været en tur i udlandet og haft mange cigaretter med hjem. Betal told kr. 10.",
				"Ryk frem til Grønningen. Hvis de passerer start indkassér da kr. 200,00.",
				"Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 150,00.",
				"De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller kr. 25,00.",
				"De har kørt frem for ”Fuldt stop”. Betal kr. 50,00 i bøde.",
				"De har modtaget deres tandlægeregning. Betal kr. 10,00.",
				"Værdien af egen avl fra nyttehaven udgør kr. 100,00 som De modtager af banken.",



		};

	private static String[] yesNo = 
		{ 
				"Ja", 
				"Nej" 
		};

	private static String[] fieldDescription = 
		{ 
				"Start", //[0]
				"Grund", //[1]
				"Parkering", //[2]
				"Bryggeri", //[3]
				"SKAT", //[4]
				"Redderi", //[5]
				"Fængsel", //[6]
				"Ryk i fængsel" //[7]
		};

	private static String testString[] = 
		{
				"Test mode options",
				"Run Test Mode",
				"Run Normal Game"
		};

	private static String winnerText = "YOYOYOYO! Vinderen af matador-master-badboy-game-2017 er:";
	private static String endText = "Vil du spille igen?";
	private static String playerCountText = "Hvor mange spilere er i?";
	private static String nameOfPlayer = "Navnet på spiller";
	private static String rollDice = "Kast terningerne";
	private static String makeYourChoice = "Tag dit valg";
	private static String purchase = "Købet gik igennem";
	private static String deniedPurchase = "Købet blev afvist";
	private static String pay = "Betal";
	private static String tenPercent = "eller betal 10% af din balance";
	private static String willYouBuy = "Vil du købe denne grund?";
	private static String payedRent = "Feltet er ejet, du betalte leje til ejeren";
	private static String ownField = "Dette er dit eget felt";

	public static String getPayedRent() 
	{
		return payedRent;
	}

	public static String ownField()
	{
		return ownField;
	}

	public static void setPayedRent(String payedRent) 
	{
		Language.payedRent = payedRent;
	}

	public static String[] getFieldDecription()
	{
		return fieldDescription;
	}

	public static String[] getYesNo()
	{
		return yesNo;
	}

	public static String getWillYouBuy()
	{
		return willYouBuy;
	}

	public static String getTenPercent()
	{
		return tenPercent;
	}

	public static String getPayMSG()
	{
		return pay;
	}

	public static String getMakeYourChoiceMSG()
	{
		return makeYourChoice;
	}

	public static String getPlayerCountText()
	{
		return playerCountText;
	}

	public static String getNameOfPlayer()
	{
		return nameOfPlayer;
	}

	public static String getEndText()
	{
		return endText;
	}

	public static String getWinnerText()
	{
		return winnerText;
	}

	public static String[] getFieldNames()
	{
		return fieldName;
	}

	public static String rollDiceText()
	{
		return rollDice;
	}

	public static String testModeStrings(int x)
	{
		return testString[x];
	}

	public static String purchaseString()
	{
		return purchase;
	}

	public static String deniedPurchaseString()
	{
		return deniedPurchase;
	}

	public static String payedRent()
	{
		return payedRent;
	}
	
	public static String whoseTurn(Player p)
	{
		return "Det er " + p.getName() + "'s tur";
	}
	
	public static String extraTurn(Player p)
	{
		return p.getName() + " slog to ens, og belønnes med en ekstra tur";
	}
}
