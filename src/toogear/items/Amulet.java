package toogear.items;

import toogear.traits.Trait;
import java.util.Set;

public class Amulet extends Item
{
	protected Set<Trait> traits;

	public Amulet(String name, Set<Trait> traits, String source)
	{
		super(name, source);
		this.traits = traits;
	}
	
	public boolean supersedes(Amulet other)
	{
		if (traits.size() <= other.traits.size())
			return false;
		
		return traits.containsAll(other.traits);
	}
	
	public static Amulet parse(String line)
	{
		String tokens[] = line.split("\t");
		
		return new Amulet(tokens[0], parseTraits(tokens[1]), tokens[2]);
	}

	@Override
	public String toString()
	{
		String ret = name + "\t";
		
		for (Trait trait: traits)
			ret += trait + ",";
		
		ret += "\t" + source;
		
		return ret;
	}
}
