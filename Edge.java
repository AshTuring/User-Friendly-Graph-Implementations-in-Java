
public class Edge
{
	private Vertex v1;
	private Vertex v2;
	private int weight;
	
	public Edge(Vertex v1, Vertex v2, int weight)
	{
		this.v1 = v1; this.v2 = v2; this.weight = weight;
	}
	
	public Vertex getOne()
	{
		return v1;
	}
	
	public Vertex getTwo()
	{
		return v2;
	}
	
	public void setOne(Vertex vOne)
	{
		v1 = vOne;
	}
	
	public void setTwo(Vertex vTwo)
	{
		v2 = vTwo;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setWeight(int w)
	{
		weight = w;
	}
	
	public boolean equals(Object o)
	{
		Edge other = (Edge) o;
		return other.v1.equals(this.v1) && other.v2.equals(this.v2);
	}
	
	public String toString()
	{
		return v1 + "-->" + v2 + ", " + weight;
	}
	
	public int hashCode()
	{
		return (v1 + "__" + v2).hashCode();
	}
	
}
