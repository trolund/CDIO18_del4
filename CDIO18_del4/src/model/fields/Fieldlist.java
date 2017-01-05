package model.fields;

import view.Language;
import view.Out;
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
	public Fieldlist(Out out)
	{
		fields = new model.fields.Field[] 
			{
				new Parking(FieldNames[0], FieldDescription[0], 0, out),
				new Plot(FieldNames[1], FieldDescription[1], 60, 100, out),
				new Chance(FieldNames[2], FieldDescription[1], out),
				new Plot(FieldNames[3], FieldDescription[1], 60, 500, out),
				new Tax(FieldNames[4], FieldDescription[1], 200, 10, out),
				new Fleet(FieldNames[5], FieldDescription[1], 200, 1000,out),
				new Plot(FieldNames[6], FieldDescription[1], 4300,1300,out),
				new Chance(FieldNames[7], FieldDescription[1], out),
				new Plot(FieldNames[8], FieldDescription[1], 100, 2000,out),
				new Plot(FieldNames[9], FieldDescription[1], 120, 2600,out),
				new Parking(FieldNames[10], FieldDescription[1], 0, out),
				new Plot(FieldNames[11], FieldDescription[1], 140, 4000,out),
				new Brewery(FieldNames[12], FieldDescription[2], 150, 5000,out),
				new Plot(FieldNames[13], FieldDescription[2], 140, 500,out),
				new Plot(FieldNames[14], FieldDescription[3], 140, 100,out),
				new Fleet(FieldNames[15], FieldDescription[3], 200, 100,out), 
				new Plot(FieldNames[16], FieldDescription[4], 180, 0,out),
				new Chance(FieldNames[17], FieldDescription[4], out),
				new Plot(FieldNames[18], FieldDescription[5], 180, 500,out), 
				new Plot(FieldNames[19], FieldDescription[5], 180, 500,out),
				new Parking(FieldNames[20], FieldDescription[5], 0, out),
				new Plot(FieldNames[21], FieldDescription[5], 220, 500,out),
				new Chance(FieldNames[21], FieldDescription[5] ,out),
				new Plot(FieldNames[21], FieldDescription[5], 220, 500,out),
				new Plot(FieldNames[21], FieldDescription[5], 240, 500,out),
				new Fleet(FieldNames[21], FieldDescription[5], 200, 500,out),
				new Plot(FieldNames[21], FieldDescription[5], 260, 500,out),
				new Plot(FieldNames[21], FieldDescription[5], 260, 500,out),
				new Brewery(FieldNames[21], FieldDescription[5], 150, 500,out),
				new Plot(FieldNames[21], FieldDescription[5], 280, 500,out),
				new Prison(FieldNames[21], FieldDescription[5],out),
				new Plot(FieldNames[21], FieldDescription[5], 300, 500,out),
				new Plot(FieldNames[21], FieldDescription[5], 300, 500,out),
				new Chance(FieldNames[21], FieldDescription[5], out),
				new Plot(FieldNames[21], FieldDescription[5], 320, 500,out),
				new Fleet(FieldNames[21], FieldDescription[5], 200, 500,out),
				new Chance(FieldNames[21], FieldDescription[5], out),
				new Plot(FieldNames[21], FieldDescription[5], 350, 500,out),
				new Tax(FieldNames[21], FieldDescription[5], 100, 0,out),
				new Plot(FieldNames[21], FieldDescription[5], 400, 500,out),
			};
	}

	public model.fields.Field[] getFields()
	{
		return fields;
	}

}