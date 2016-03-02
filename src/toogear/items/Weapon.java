package toogear.items;

import toogear.traits.TraitFactory;
import toogear.traits.Trait;

public class Weapon extends Item
{
	protected int power;
	protected int rateOfFire;
	protected int ammoConsumption;
	protected Trait type;

	public Weapon(String name, int power, int rateOfFire, int ammoConsumption, Trait type, String source)
	{
		super(name, source);
		this.power = power;
		this.rateOfFire = rateOfFire;
		this.ammoConsumption = ammoConsumption;
		this.type = type;
	}
	
	public boolean supersedes(Weapon other)
	{
		//TODO: remove this once all weapons have been cathegorized
		if (type == TraitFactory.get("TBD"))
			return false;
		
		/* don't compare weapons of same type */
		if (type != other.type)
			return false;
		
		/* same specs */
		if (power == other.power && rateOfFire == other.rateOfFire && ammoConsumption == other.ammoConsumption)
			return false;
		
		if (power >= other.power && rateOfFire >= other.rateOfFire && ammoConsumption <= other.ammoConsumption)
			return true;
		
		return false;
	}
	
	public Weapon parse(String line)
	{
		String tokens[] = line.split("\t");
		
		return new Weapon(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), TraitFactory.get(tokens[5]), tokens[4]);
	}
}
