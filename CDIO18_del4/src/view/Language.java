package view;

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

	private static String[] yesNo = 
		{ 
				"Ja", 
				"Nej" 
		};

	private static String[] fieldDescription = 
		{ 
				"Start", 
				"Territory", 
				"Refuge", 
				"Labor Camp", 
				"Tax", 
				"Fleet" 
		};

	private static String testString[] = 
		{
				"Test mode options",
				"Run Test Mode",
				"Run Normal Game"
		};

	private static String winnerText = "Vinderen er";
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
}
