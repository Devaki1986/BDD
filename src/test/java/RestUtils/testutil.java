package RestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class testutil {
	
	public static String name() {
		String Genstr = RandomStringUtils.randomAlphabetic(1);
		
		System.out.println("anil"+Genstr);
		
		
		return ("anil"+Genstr);
		
	}
	
	public static String job() {
		String Genstr = RandomStringUtils.randomAlphabetic(1);
		System.out.println("leader"+Genstr);
		
		return ("leader"+Genstr);
		
	}
	
	public static String salary() {
		int Genstr = (int) Math.round(100000);
		System.out.println(Genstr);
		System.out.println(10000+Genstr);
		return ("10000"+Genstr);
		
	}

}
