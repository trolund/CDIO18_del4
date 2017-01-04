package model.fields;

import view.Language;
import view.Output;

/**
 * 
 * @author von Scholten
 *
 */

public class  Fieldlist 
{
	//an array of the fieldlist
	private model.fields.Field[] fields = new Field[22];

	//list of fields
	public Fieldlist(Output o)
	{
		
		
		//Start field
		//Refuge type with no bonus
		fields[0] = new Parking(Language.getFieldNames()[0], Language.getFieldType()[0], 0, o);

		//Territory type fields is ownable with a price and a rent
		fields[1] = new Plot(Language.getFieldNames()[1], Language.getFieldType()[1], 1000, 100,o);
		fields[2] = new Plot(Language.getFieldNames()[2], Language.getFieldType()[1], 1500, 300,o);
		fields[3] = new Plot(Language.getFieldNames()[3], Language.getFieldType()[1], 2000, 500,o);
		fields[4] = new Plot(Language.getFieldNames()[4], Language.getFieldType()[1], 3000, 700,o);
		fields[5] = new Plot(Language.getFieldNames()[5], Language.getFieldType()[1], 4000, 1000,o);
		fields[6] = new Plot(Language.getFieldNames()[6], Language.getFieldType()[1], 4300,1300,o);
		fields[7] = new Plot(Language.getFieldNames()[7], Language.getFieldType()[1], 4750, 1600,o);
		fields[8] = new Plot(Language.getFieldNames()[8], Language.getFieldType()[1], 5000, 2000,o);
		fields[9] = new Plot(Language.getFieldNames()[9], Language.getFieldType()[1], 5500, 2600,o);
		fields[10] = new Plot(Language.getFieldNames()[10], Language.getFieldType()[1], 6000, 3200,o);
		fields[11] = new Plot(Language.getFieldNames()[11], Language.getFieldType()[1], 8000, 4000,o);
		
		//Refuge type fields is not ownable
		//adds a bonus
		fields[12] = new Parking(Language.getFieldNames()[12], Language.getFieldType()[2], 5000,o);
		fields[13] = new Parking(Language.getFieldNames()[13], Language.getFieldType()[2], 500,o);

		//Brewery type fields is ownable with a price and a rent 
		//baseRent multiplied by a dice roll and number of owned fields 
		fields[14] = new Brewery(Language.getFieldNames()[14], Language.getFieldType()[3], 2500, 100,o); //100*sumOfDice
		fields[15] = new Brewery(Language.getFieldNames()[15], Language.getFieldType()[3], 2500, 100,o); //100*sumOfDice

		//Tax type fields is not ownable
		//withdraw a baseRent or (only [17]) chose to pay 10% of accets
		fields[16] = new Tax(Language.getFieldNames()[16], Language.getFieldType()[4], 2000, 0,o);
		fields[17] = new Tax(Language.getFieldNames()[17], Language.getFieldType()[4], 4000, 10,o);

		//Fleet type fields is ownable with a price and a rent 
		//baseRent multiplied by owned fields 
		fields[18] = new Fleet(Language.getFieldNames()[18], Language.getFieldType()[5], 4000, 500,o); // Mellem 500 og 4000 rent
		fields[19] = new Fleet(Language.getFieldNames()[19], Language.getFieldType()[5], 4000, 500,o);
		fields[20] = new Fleet(Language.getFieldNames()[20], Language.getFieldType()[5], 4000, 500,o);
		fields[21] = new Fleet(Language.getFieldNames()[21], Language.getFieldType()[5], 4000, 500,o);
	}

	public model.fields.Field[] getFields()
	{
		return fields;
	}

}