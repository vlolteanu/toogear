package toogear.items;

import java.util.Set;
import toogear.traits.BadTrait;
import toogear.traits.BadTraitFactory;
import toogear.traits.Trait;

public class Ring extends Item
{
	protected Set<Trait> traits;
	protected BadTrait badTrait;

	public Ring(String name, Set<Trait> traits, BadTrait badTrait, String source)
	{
		super(name, source);
		this.traits = traits;
		this.badTrait = badTrait;
	}
	
	public boolean supersedes(Ring other)
	{
		if (!traits.containsAll(other.traits))
			return false;
		
		if (badTrait.supersedes(other.badTrait))
			return true;
		
		if (badTrait != other.badTrait)
			return false;
		
		return traits.size() > other.traits.size();
	}
	
	public static Ring parse(String line)
	{
		String tokens[] = line.split("\t");
		
		return new Ring(tokens[0], parseTraits(tokens[1]), BadTraitFactory.get(tokens[2]), tokens[3]);
	}
}
