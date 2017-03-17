import java.util.ArrayList;
import java.awt.Color;

public class Graph 
{
	private ArrayList<Vertex> vertices;
	
	public Graph()
	{
		vertices = new ArrayList<Vertex>();
	}
	
	public void addVertex(Vertex v)
	{
		if(!vertices.contains(v))
			vertices.add(v);
	}
	
	public void removeVertex(Vertex v)
	{
		if(vertices.contains(v))
			vertices.remove(v);
		
		for(Vertex vertex : vertices)
		{
			vertex.removeAll(v);
		}
	}
	
	public boolean addEdge(Vertex one, Vertex two)
	{
		return addEdge(one, two,1);
	}
	
	public boolean addEdge(Vertex one, Vertex two, int weight)
	{
		//if not already in list, add vertices
		if(!vertices.contains(one))
			addVertex(one);
		
		if(!vertices.contains(two))
			addVertex(two);
		
		Edge e = new Edge(one, two, weight);
		int index = vertices.indexOf(one);
		//if already there, do not add
		if(vertices.get(index).containsEdge(e))
			return false;
		
		vertices.get(index).addEdge(e);
		return true;
	}
	
	public boolean removeEdge(Vertex one, Vertex two)
	{
		return removeEdge(one, two, 1);
	}
	
	public boolean removeEdge(Vertex one, Vertex two, int weight)
	{
		if(!vertices.contains(one) || !vertices.contains(two))
			return false;
		
		if(one.containsEdge(new Edge(one, two, weight)))
		{
			one.removeEdge(new Edge(one, two, weight));
			return true;
		}
		
		return false;
	}
	
	public String toString()
	{
		String ans = "";
		
		for(Vertex vertex : vertices)
		{
			ans += vertex + ": ";
			ArrayList<Edge> edges = vertex.getEdges();
			for(int i =0; i < edges.size(); i++)
			{
				ans += edges.get(i).getTwo() + " " + edges.get(i).getWeight() + "| ";
			}
			ans = ans.trim()+ "\n";
		}
		if(ans.charAt(ans.length()-1) == '\n')
			ans = ans.substring(0, ans.length()-1);
		return ans;
	}
}
