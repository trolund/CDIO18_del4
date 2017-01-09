package view;

import model.Player;

/*
 * Class wrote by: Kasper Leiszner
 */

public class Language 
{
	private static String[] fieldName = 
		{
				"Start",
				"Rødovrevej",
				"Prøv lykken",
				"Hvidovrevej",
				"Skat",
				"Øresund",
				"Roskildevej",
				"Prøv lykken",
				"Valby Langgade",
				"Allegade",
				"Fængsel",
				"Frederiksberg Allé",
				"Tuborg",
				"Bulowsvej",
				"Gammel Kongevej",
				"D.F.D.S",
				"Bernstorffsvej",
				"Prøv lykken",
				"Hellerupvej",
				"Strandvejen",
				"Helle",
				"Trianglen",
				"Prøv lykken",
				"Østerbrogade",
				"Grønningen",
				"Ø.S.",
				"Bredgade",
				"Kgs. Nytorv",
				"Calsberg",
				"Østergade",
				"Gå i fængsel",
				"Amagertorv",
				"Vimmelskaftet",
				"Prøv lykken",
				"Nygade",
				"Bornholm",
				"Prøv lykken",
				"Frederiksberggade",
				"Skat",
				"Rådhuspladsen"
		};
	
	public static String[] getCardDescriptions() {
		return cardDescriptions;
	}

	private static String[] cardDescriptions =
		{
//				"Ejendomsskatterne er steget. Ekstraudgifterne er: kr. 800 pr. hus, kr. 2.300 pr. hotel.",
//				"Ryk frem til Frederiksberg Allé. Hvis De passerer START, indkassér da kr. 4.000",
//				"Det er Deres fødselsdag. Modtag af hver medspiller kr. 200.",
//				"Ryk tre felter frem",
//				"De modtager Deres aktieudbytte. Modtag kr. 1.000 af banken.",
//				"Grundet dyrtiden har De fået gageforhøjelse. Modtag kr. 1.000.",
//				"Betal for vognvask og smøring kr. 300.",
//				"Deres præmieobligation er udtrukket. De modtager kr. 1.000 af banken.",
//				"Deres præmieobligation er udtrukket. De modtager kr. 1.000 af banken.",
//				"Ryk frem til START. Du får ingen start bonus",
//				"Ryk frem til START. Du får ingen start bonus",
//				"De skal holde familiefest og fået et tilskud fra hver medspiller på kr. 500.",
//				"Tag ind på Rådhuspladsen.",
//				"Tag med Øresundsredderiet. Flyt brikken frem, og hvis De passerer “START”, indkassér da kr. 4.000.",
//				"De har købt 4 nye dæk til Deres vogn. Betal kr. 1.000.",
//				"De har fået en parkeringsbøde. Betal kr. 200 i bøde.",
//				"Betal kr. 200 for levering af 2 kasser øl.",
//				"Tag med den nærmeste færge. Flyt brikken frem, og hvis De passerer “START”, indkassér da kr. 4.000.",
//				"Gå i fængsel. Tyk direkte til fængslet. Selv om de passerer “START”, indkasserer de ikke kr. 4.000.",
//				"Gå i fængsel. Tyk direkte til fængslet. Selv om de passerer “START”, indkasserer de ikke kr. 4.000.",
//				"Oliepriserne er steget, og De skal betale: kr. 500 pr. Hus, kr. 2.000 pr. hotel",
//				"Modtag udbytte af Deres aktier – kr. 1000.",
//				"Modtag udbytte af Deres aktier – kr. 1000.",
				"Ryk brikken frem til det nærmeste rederi og betal lejeren to gange leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan du købe det af banken.",
				"Ryk frem til Strandvejen. Hvis du passerer start, indkassér kr. 4000.",
				"Betal deres bilforsikring – kr. 1000.",
				"De havde en række med elleve rigtige i tipning. Modtag kr. 1000.",
				"De har vundet i klasselotteriet. Modtag kr. 500.",
				"De har vundet i klasselotteriet. Modtag kr. 500.",
				"Ryk frem til Vimmelskaftet. Hvis de passerer start, indkassér da kr. 4000.",
				"Ryk tre felter tilbage",
				"Ryk tre felter tilbage",
				"I anledning af kongens fødselsdag benådes de herved for fængsel. Dette kort kan opbevares indtil De får brug for det eller De kan sælge det.",
				"I anledning af kongens fødselsdag benådes de herved for fængsel. Dette kort kan opbevares indtil De får brug for det eller De kan sælge det.",
				"Betal kr. 3000. for reparation af Deres vogn.",
				"De har solgt nogle gamle møbler på auktion. Modtag kr. 1000 af banken.",
				"De har været en tur i udlandet og haft mange cigaretter med hjem. Betal told kr. 200.",
				"Ryk frem til Grønningen. Hvis de passerer start indkassér da kr. 4000.",
				"Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3000.",
				"De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller kr. 500.",
				"De har kørt frem for ”Fuldt stop”. Betal kr. 1000 i bøde.",
				"De har modtaget deres tandlægeregning. Betal kr. 2000.",
				"Værdien af egen avl fra nyttehaven udgør kr. 200 som De modtager af banken.",



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
