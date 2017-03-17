import java.util.ArrayList;
import java.awt.Color;

public class Vertex
{
	//Instance Fields
	private String name;
	private ArrayList<Edge> edges;
	
	private Vertex predecessor;
	private Color color;
	
	//Constructor
	public Vertex(String n)
	{
		name = n;
		edges = new ArrayList<Edge>();
		
		color = Color.WHITE;
		predecessor = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void addEdge(Edge e)
	{
		if(!edges.contains(e))
			edges.add(e);
	}
	
	public void removeEdge(Edge e)
	{
		if(edges.contains(e))
			edges.remove(e);
	}
	
	public boolean containsEdge(Edge e)
	{
		return edges.contains(e);
	}
	
	public void removeAll(Vertex v)
	{
		for(int i = 0; i < edges.size(); i++)
		{
			Edge e = edges.get(i);
			if(e.getTwo().equals(v))
			{
				edges.remove(i);
				i--;
			}
		}
	}
	
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean equals(Object o)
	{
		return name.equals(((Vertex) o).name);
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}

	
}
