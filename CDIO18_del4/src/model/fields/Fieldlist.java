package model.fields;

import view.Language;
import view.Out;

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
				new Plot(FieldNames[1], FieldDescription[1], 60, 2, out),
				new Chance(FieldNames[2], FieldDescription[1], out),
				new Plot(FieldNames[3], FieldDescription[1], 60, 4, out),
				new Tax(FieldNames[4], FieldDescription[1], 200, 10, out),
				new Fleet(FieldNames[5], FieldDescription[1], 200, 25,out),
				new Plot(FieldNames[6], FieldDescription[1], 100,6,out),
				new Chance(FieldNames[7], FieldDescription[1], out),
				new Plot(FieldNames[8], FieldDescription[1], 100, 6,out),
				new Plot(FieldNames[9], FieldDescription[1], 120, 8,out),
				new Parking(FieldNames[10], FieldDescription[1], 0, out),
				new Plot(FieldNames[11], FieldDescription[1], 140, 10,out),
				new Brewery(FieldNames[12], FieldDescription[2], 150, 4,out),
				new Plot(FieldNames[13], FieldDescription[2], 140, 10,out),
				new Plot(FieldNames[14], FieldDescription[3], 160, 12,out),
				new Fleet(FieldNames[15], FieldDescription[3], 200, 25,out), 
				new Plot(FieldNames[16], FieldDescription[4], 180, 14,out),
				new Chance(FieldNames[17], FieldDescription[4], out),
				new Plot(FieldNames[18], FieldDescription[5], 180, 14,out), 
				new Plot(FieldNames[19], FieldDescription[5], 200, 16,out),
				new Parking(FieldNames[20], FieldDescription[5], 0, out),
				new Plot(FieldNames[21], FieldDescription[5], 220, 18,out),
				new Chance(FieldNames[22], FieldDescription[5] ,out),
				new Plot(FieldNames[23], FieldDescription[5], 220, 18,out),
				new Plot(FieldNames[24], FieldDescription[5], 240, 20,out),
				new Fleet(FieldNames[25], FieldDescription[5], 200, 25,out),
				new Plot(FieldNames[26], FieldDescription[5], 260, 22,out),
				new Plot(FieldNames[27], FieldDescription[5], 260, 22,out),
				new Brewery(FieldNames[28], FieldDescription[5], 150, 4,out),
				new Plot(FieldNames[29], FieldDescription[5], 280, 24,out),
				new Prison(FieldNames[30], FieldDescription[5],out),
				new Plot(FieldNames[31], FieldDescription[5], 300, 26,out),
				new Plot(FieldNames[32], FieldDescription[5], 300, 26,out),
				new Chance(FieldNames[33], FieldDescription[5], out),
				new Plot(FieldNames[34], FieldDescription[5], 320, 28,out),
				new Fleet(FieldNames[35], FieldDescription[5], 200, 25,out),
				new Chance(FieldNames[36], FieldDescription[5], out),
				new Plot(FieldNames[37], FieldDescription[5], 350, 35,out),
				new Tax(FieldNames[38], FieldDescription[5], 100, 0,out),
				new Plot(FieldNames[39], FieldDescription[5], 400, 50,out),
			};
	}

	public model.fields.Field[] getFields()
	{
		return fields;
	}

}