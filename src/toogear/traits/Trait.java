package toogear.traits;

public class Trait
{
	String name;

	public Trait(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	
	public boolean supersedes(Trait other)
	{
		return false;
	}
}
