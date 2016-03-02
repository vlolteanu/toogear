package toogear.items;

import java.util.LinkedHashSet;
import java.util.Set;
import toogear.traits.Trait;
import toogear.traits.TraitFactory;

public abstract class Item
{
	protected String name;
	protected String source;

	public Item(String name, String source)
	{
		this.name = name;
		this.source = source;
	}

	public String getSource()
	{
		return source;
	}
	
	protected static Set<Trait> parseTraits(String line)
	{
		String tokens[] = line.split(",");
		Set<Trait> ret = new LinkedHashSet<>();
		
		for (String token: tokens)
			ret.add(TraitFactory.get(token));
		
		return ret;
	}
}
