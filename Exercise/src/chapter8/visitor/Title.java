package chapter8.visitor;

public enum Title
{	
	PROF("Prof. "), DR("Dr. "), NONE("");
	
	private final String aText;
	
	private Title(String pText)
	{
		aText = pText;
	}
	
	public String asText()
	{
		return aText;
	}
}
