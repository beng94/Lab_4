import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BeerRegister {
	private ArrayList<Beer> list;
	
	private void add(String name, String style, double strength)
	{
		Beer b = new Beer(name, style, strength);
		this.list.add(b);
	}
	
	private void list()
	{
		for(Beer b: this.list)
		{
			System.out.println(
					b.getName() + " " +
					b.getStyle() + " " +
					b.getStrength()					
					);
		}
	}
	
	private void list(String cmd)
	{
		switch (cmd)
		{
		case "name":
			Collections.sort(this.list, new NameComparator());
			break;
		case "style":
			Collections.sort(this.list, new StyleComparator());
			break;
		case "strength":
			Collections.sort(this.list, new StrengthComparator());
			break;
		default:
			System.out.println("list: argument not supported");
		}
		
		list();
	}
	
	public void readIn() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] cmd = line.split(" ");
		
		switch (cmd[0])
		{
		case "add":
			add(cmd[1], cmd[2], Double.parseDouble(cmd[3]));
			break;
		case "list":
			if(cmd.length > 1) list(cmd[1]);
			else list();
			break;
		case "load":
			load(cmd[1]);
			break;
		case "save":
			save(cmd[1]);
			break;
		case "delete":
			delete(cmd[1]);
			break;
		default:
			System.out.println("readIn: not handleg input");
		}
	}
	
	//TODO
	public void load(String file)
	{
		
	}
	
	//TODO
	public void save(String file)
	{
		
	}
	
	public void delete(String name)
	{
		int id = Collections.binarySearch(this.list, 
								 new Beer(name, "", 0.0),
								 new NameComparator());
		if(id == -1)
		{
			System.out.println("delete: Item not found");
			return;
		}
		else
		{
			this.list.remove(id);
		}
	}
	
	BeerRegister()
	{
		this.list = new ArrayList();
	}
}
