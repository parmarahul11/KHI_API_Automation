package utility;

public class createBaseURL {
	
	public final static String baseURI= "https://api.c9z0em8xjj-kawasakih2-s1-public.model-t.cc.commerce.ondemand.com/occ/v2";
	public final static String baseSiteId="/khib2b";
	public static String getBaseURI()
	{
		return baseURI;
	}
	//public static void main(String[] args)
	//{
	//System.out.println(baseURI+baseSiteId);
	//}
	
	public static String getBaseURI(String resoursePath)
	{
		return baseURI+baseSiteId+resoursePath;
	}
}
