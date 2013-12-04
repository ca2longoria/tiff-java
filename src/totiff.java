import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.synapsehaven.tiff.Tiff;

public class totiff
{
	public static void main(String[] args)
	{
		if (args.length <= 0)
			System.exit(1);
		
		final String sep = System.getProperty("file.separator");
		
		Map<String,String> options = new HashMap<String,String>();
		final int argsBegin = parseOptions(options,args);
		
		for (int i=argsBegin+1; i < args.length; ++i)
			args[i] =
				(options.containsKey("src")
					? options.get("src") + sep : "")
				+ args[i];
		
		Tiff tiffy = new Tiff(Arrays.copyOfRange(args, argsBegin+1, args.length));
		tiffy.save(
			(options.containsKey("dst")
				? options.get("dst") + sep : "")
			+ args[argsBegin]);
	}
	
	private static int parseOptions(Map<String,String> map, String[] args)
	{
		if (map == null)
			map = new HashMap<String,String>();
		
		String s = null;
		int i = 0;
		for (; i < args.length; ++i)
		{
			s = args[i];
			
			if (s.indexOf("-") != 0) break;
			s = args[i].substring(1);
			
			if (s.equals("src"))
			{
				// Source directory
				map.put("src", args[++i]);
			}
			else if (s.equals("dst"))
			{
				// Destination directory
				map.put("dst", args[++i]);
			}
		}
		return i;
	}
}
