package toogear;

import java.io.InputStream;

public class ToOGear
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		InputStream is = args.getClass().getResourceAsStream("resources/amulets.dat");
	}
	
}
