import java.util.Comparator;

public class StyleComparator implements Comparator{
	
	public int compare(Object a, Object b)
	{
		String a_style = ((Beer) a).getStyle();
		String b_style = ((Beer) b).getStyle();
		
		return a_style.compareTo(b_style);
	}
}
