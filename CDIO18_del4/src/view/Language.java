package view;

/*
 * Class wrote by: Kasper Leiszner
 */

public class Language 
{
	private static String[] fieldInfo = {
			"Start",
			"Tribe Encampment",
			"Crater",
			"Mountain",
			"Cold Desert",
			"Black cave",
			"The Werewall",
			"Mountain village",
			"South Citadel",
			"Palace gates",
			"Tower",
			"Castle",
			"Walled city",
			"Monastery",
			"Huts in the mountain",
			"The pit",
			"Goldmine",
			"Caravan",
			"Second Sail",
			"Sea Grover",
			"The Buccaneers",
			"Privateer armade"
	};

	private static String[] yesNo = { "Yes", "No" };
	private static String[] fieldType = { "Start", "Territory", "Refuge", "Labor Camp", "Tax", "Fleet" };

	private static String winnerText = "The winner is";
	private static String endText = "One more game?";
	private static String playerCountText = "How many players?";
	private static String nameOfPlayer = "Name of player";
	private static String butName = "Roll the dice";
	private static String makeYourChoice = "Make your choice";
	private static String purchase = "purchase confirmed";
	private static String dpurchase = "purchase denied";
	private static String pay = "Pay";
	private static String tenPercent = "or pay 10% of your balance";
	private static String willYouBuy = "will you buy this field?";
	private static String payedRent = "Field is owned, you paid the rent";
	private static String ownField = "It's your own field -nothing happened";
	
	public static String getPayedRent() {
		return payedRent;
	}
	
	public static String ownField(){
		return ownField;
	}

	public static void setPayedRent(String payedRent) {
		Language.payedRent = payedRent;
	}

	// test mode Strings
	static String testString[] = {"Test mode options","Run Test Mode","Run Normal Game"};

	public static String[] getFieldType()
	{
		return fieldType;
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
		return fieldInfo;
	}

	public static String rollButName()
	{
		return butName;
	}

	public static String testModeStrings(int x)
	{
		return testString[x];
	}

	public static String purchaseString()
	{
		return purchase;
	}

	public static String dpurchaseString()
	{
		return dpurchase;
	}
	
	public static String payedRent()
	{
		return payedRent;
	}
}
