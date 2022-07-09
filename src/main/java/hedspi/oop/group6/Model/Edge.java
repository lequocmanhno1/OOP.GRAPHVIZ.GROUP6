package hedspi.oop.group6.Model;

public class Edge implements Comparable<Edge>{
    private Vertex from;
    private Vertex to;

    public Edge() {
    }

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }


    public Vertex getFrom() {
        return from;
    }

    public void setFrom(Vertex from) {
        this.from = from;
    }

    public Vertex getTo() {
        return to;
    }

    public void setTo(Vertex to) {
        this.to = to;
    }
    
    @Override
    public String toString(){
        return "Edge: " + this.getFrom() + " - " + this.getTo();
    }

    @Override
    public int compareTo(Edge o) {
        Integer vfrom1_id = this.from.getVertexId();
        Integer vfrom2_id = o.from.getVertexId();
        int result1 = vfrom1_id.compareTo(vfrom2_id);
        if(result1 != 0 ) return result1;
        Integer vto1_id = this.to.getVertexId();
        Integer vto2_id = o.to.getVertexId();
        int result2 = vto1_id.compareTo(vto2_id);
        return result2;
    }
}
