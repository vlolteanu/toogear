package toogear.traits;

import java.util.HashMap;

public class TraitFactory
{
	protected static HashMap<String, Trait> traits;
	
	public static Trait get(String name)
	{
		Trait trait = traits.get(name);
		
		if (trait == null)
		{
			trait = new Trait(name);
			traits.put(name, trait);
		}
		
		return trait;
	}
}
