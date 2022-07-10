package hedspi.oop.group6.model.graph;

public class Vertex{

    private int vertexId;
    private int color = -1 ;
    // 0 là đỏ 1 là xanh -1 là chưa tô
    public Vertex() {
    }

    public Vertex(int vertexId) {
        this.vertexId = vertexId;
    }

    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }
    

    public boolean equals(Vertex v) {
    	return this.vertexId == v.getVertexId();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    @Override
    public String toString(){
        String i = String.valueOf(this.getVertexId());
        return i;
    }
}
