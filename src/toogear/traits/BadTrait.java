package toogear.traits;

public class BadTrait extends Trait
{
	public BadTrait(String name)
	{
		super(name);
	}
	
	public boolean supersedes(BadTrait other)
	{
		if (name.equals(other.name))
			return false;
		
		if (name.equals(""))
			return true;
		
		if (name.equals("Night or Cold Weather Only") && (other.name.equals("Nighttime Only") || other.name.equals("Cold Weather Only")))
			return true;
		
		if (name.equals("Daytime or Rainy Only") && (other.name.equals("Daytime Only") || other.name.equals("Rainy Weather Only")))
			return true;
		
		return false;
	}
}
