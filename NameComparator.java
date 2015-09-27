import java.util.Comparator;

public class NameComparator implements Comparator {
	
	public int compare(Object a, Object b)
	{
		String a_name = ((Beer) a).getName();
		String b_name = ((Beer) b).getName();
		
		return a_name.compareTo(b_name);
	}

}
