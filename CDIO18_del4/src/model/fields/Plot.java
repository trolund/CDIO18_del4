package model.fields;

import model.Player;
import view.Out;
import view.Output;

public class Plot extends Ownabel
{
	
	private int rent;
	private boolean[] house = new boolean[6];

	public Plot(String name, String description, int price, int rent, Out out){
		super(name, description, price, out);
		this.rent = rent;
	}

	@Override
	public int getRent(Player p){
		// ignore player
		return rent;
	}
	
	public void buildhouse(){
		for (int i = 0; i < house.length; i++) {
			if(!(house[i])){
				// der kan bygges og der bliver bygget på den første ledige grund.
				house[i] = true;
				break;
			}
			
			else{
				// vil du bygge et hotel?
			} 
				
		}
		
		
	}
	
}


