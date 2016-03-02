package toogear;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import toogear.items.Amulet;
import toogear.items.Item;
import toogear.items.Ring;
import toogear.items.Weapon;

public class ToOGear
{
	protected static Scanner getResource(String fileName) throws FileNotFoundException
	{
		return new Scanner(new File((new ToOGear()).getClass().getClassLoader().getResource(fileName).getFile()));
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		LinkedList<Amulet> amulets = new LinkedList<>();
		LinkedList<Ring> rings = new LinkedList<>();
		LinkedList<Weapon> weapons = new LinkedList<>();
		
		Scanner amuletScanner = getResource("resources/amulets.dat");
		Scanner ringScanner = getResource("resources/rings.dat");
		Scanner weaponScanner = getResource("resources/weapons.dat");
		
		nextAmulet:
		while (amuletScanner.hasNextLine())
		{
			String line = amuletScanner.nextLine();
			Amulet amulet = Amulet.parse(line);
			Iterator<Amulet> it = amulets.iterator();
			
			while (it.hasNext())
			{
				Amulet otherAmulet = it.next();
				
				if (amulet.supersedes(otherAmulet))
					it.remove();
				else if (otherAmulet.supersedes(amulet))
					continue nextAmulet;
			}
			amulets.add(amulet);
		}
		
		nextRing:
		while (ringScanner.hasNextLine())
		{
			String line = ringScanner.nextLine();
			Ring ring = Ring.parse(line);
			Iterator<Ring> it = rings.iterator();
			
			while (it.hasNext())
			{
				Ring otherRing = it.next();
				
				if (ring.supersedes(otherRing))
					it.remove();
				else if (otherRing.supersedes(ring))
					continue nextRing;
			}
			rings.add(ring);
		}
		
		nextWeapon:
		while (weaponScanner.hasNextLine())
		{
			String line = weaponScanner.nextLine();
			Weapon weapon = Weapon.parse(line);
			Iterator<Weapon> it = weapons.iterator();
			
			while (it.hasNext())
			{
				Weapon otherWeapon = it.next();
				
				if (weapon.supersedes(otherWeapon))
					it.remove();
				else if (otherWeapon.supersedes(weapon))
					continue nextWeapon;
			}
			weapons.add(weapon);
		}
		
		System.out.println("## Amulets");
		for (Item item: amulets)
			System.out.println(" * " + item);
		
		System.out.println();
		
		System.out.println("## Rings");
		for (Item item: rings)
			System.out.println(" * " + item);
		
		System.out.println();
		
		System.out.println("## Weapons");
		for (Item item: weapons)
			System.out.println(" * " + item);
	}
	
}
