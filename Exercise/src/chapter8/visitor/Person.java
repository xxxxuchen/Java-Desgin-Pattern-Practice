package chapter8.visitor;

import java.util.Objects;

public class Person
{
	private final String aName;
	private final Title aTitle;
	
	public Person(Title pTitle, String pName)
	{
		aTitle = pTitle;
		aName = pName;
	}
	
	public String name()
	{
		return aTitle.asText() + aName;
	}
	
	@Override
	public String toString()
	{
		return name();
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(aName);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Person other = (Person) obj;
		return Objects.equals(aName, other.aName);
	}
}
