/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toogear.traits;

import java.util.HashMap;

public class BadTraitFactory
{
	protected static HashMap<String, BadTrait> traits = new HashMap<>();
	
	public static BadTrait get(String name)
	{
		BadTrait trait = traits.get(name);
		
		if (trait == null)
		{
			trait = new BadTrait(name);
			traits.put(name, trait);
		}
		
		return trait;
	}
}
