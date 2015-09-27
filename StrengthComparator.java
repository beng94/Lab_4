import java.util.Comparator;

public class StrengthComparator implements Comparator{
	
	public int compare(Object a, Object b)
	{
		double a_str = ((Beer) a).getStrength();
		double b_str = ((Beer) b).getStrength();
		
		return (int) (a_str - b_str);
	}

}
