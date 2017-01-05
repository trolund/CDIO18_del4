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
	private model.fields.Field[] fields;
	private String[] FieldNames = Language.getFieldNames();
	private String[] FieldDescription = Language.getFieldDecription();

	//list of fields
	public Fieldlist(Output o)
	{
		fields = new model.fields.Field[] 
			{
				new Parking(FieldNames[0], FieldDescription[0], 0, o),
				new Plot(FieldNames[1], FieldDescription[1], 60, 100, o),
				new Chance(FieldNames[2], FieldDescription[1], o),
				new Plot(FieldNames[3], FieldDescription[1], 60, 500, o),
				new Tax(FieldNames[4], FieldDescription[1], 200, 10, o),
				new Fleet(FieldNames[5], FieldDescription[1], 200, 1000,o),
				new Plot(FieldNames[6], FieldDescription[1], 4300,1300,o),
				new Chance(FieldNames[7], FieldDescription[1], o),
				new Plot(FieldNames[8], FieldDescription[1], 100, 2000,o),
				new Plot(FieldNames[9], FieldDescription[1], 120, 2600,o),
				new Parking(FieldNames[10], FieldDescription[1], 0, o),
				new Plot(FieldNames[11], FieldDescription[1], 140, 4000,o),
				new Brewery(FieldNames[12], FieldDescription[2], 150, 5000,o),
				new Plot(FieldNames[13], FieldDescription[2], 140, 500,o),
				new Plot(FieldNames[14], FieldDescription[3], 140, 100,o),
				new Fleet(FieldNames[15], FieldDescription[3], 200, 100,o), 
				new Plot(FieldNames[16], FieldDescription[4], 180, 0,o),
				new Chance(FieldNames[17], FieldDescription[4], o),
				new Plot(FieldNames[18], FieldDescription[5], 180, 500,o), 
				new Plot(FieldNames[19], FieldDescription[5], 180, 500,o),
				new Parking(FieldNames[20], FieldDescription[5], 0, o),
				new Plot(FieldNames[21], FieldDescription[5], 220, 500,o),
				new Chance(FieldNames[21], FieldDescription[5] ,o),
				new Plot(FieldNames[21], FieldDescription[5], 220, 500,o),
				new Plot(FieldNames[21], FieldDescription[5], 240, 500,o),
				new Fleet(FieldNames[21], FieldDescription[5], 200, 500,o),
				new Plot(FieldNames[21], FieldDescription[5], 260, 500,o),
				new Plot(FieldNames[21], FieldDescription[5], 260, 500,o),
				new Brewery(FieldNames[21], FieldDescription[5], 150, 500,o),
				new Plot(FieldNames[21], FieldDescription[5], 280, 500,o),
				new Prison(FieldNames[21], FieldDescription[5],o),
				new Plot(FieldNames[21], FieldDescription[5], 300, 500,o),
				new Plot(FieldNames[21], FieldDescription[5], 300, 500,o),
				new Chance(FieldNames[21], FieldDescription[5], o),
				new Plot(FieldNames[21], FieldDescription[5], 320, 500,o),
				new Fleet(FieldNames[21], FieldDescription[5], 200, 500,o),
				new Chance(FieldNames[21], FieldDescription[5], o),
				new Plot(FieldNames[21], FieldDescription[5], 350, 500,o),
				new Tax(FieldNames[21], FieldDescription[5], 100, 0,o),
				new Plot(FieldNames[21], FieldDescription[5], 400, 500,o),
			};
	}

	public model.fields.Field[] getFields()
	{
		return fields;
	}

}