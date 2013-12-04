
import net.synapsehaven.tiff.*;

public class Runner
{
	public static void main(String[] args)
	{
		System.out.println("Nonsense.");

		Tiff tiffy = new Tiff(new String[]{"inkfeather.png","inkfeather.png","inkfeather.png"});
		tiffy.save("yay.tiff");
	}
}
