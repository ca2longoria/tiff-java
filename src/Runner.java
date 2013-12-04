
import java.util.Arrays;

import net.synapsehaven.tiff.*;

public class Runner
{
	public static void main(String[] args)
	{
		if (args.length <= 0)
			System.exit(1);
		
		System.out.println(Arrays.toString(args));
		
		Tiff tiffy = new Tiff(Arrays.copyOfRange(args, 1, args.length));
		tiffy.save(args[0]);
	}
}
