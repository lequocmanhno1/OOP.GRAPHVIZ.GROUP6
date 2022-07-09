package hedspi.oop.group6.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    private final List<Vertex> listOfVertexs = new ArrayList<>();
    private final List<Edge> listOfEdges = new ArrayList<>();

    public Graph() {
    }

    public List<Vertex> getListOfVertexs() {
        return listOfVertexs;
    }

    public void addVertex() {
        this.listOfVertexs.add(inputVertex());
    }

    public void addVertex(Vertex Vertex) {
        this.listOfVertexs.add(Vertex);
    }

    public void addVertexs(List<Vertex> Vertexs) {
        this.listOfVertexs.addAll(Vertexs);
    }

    public List<Edge> getListOfEdges() {
        return listOfEdges;
    }

    public void addEdge() {
        this.listOfEdges.add(inputEdge());
    }

    public void addEdge(int from, int to) {
        Vertex f = findVertex(from);
        Vertex t = findVertex(to);
        this.listOfEdges.add(new Edge(f, t, 1));
    }

    public void addEdge(Edge Edge) {
        this.listOfEdges.add(Edge);
    }

    public void addEdges(List<Edge> Edges) {
        this.listOfEdges.addAll(Edges);
    }

    public Vertex inputVertex() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        return new Vertex(id);
    }

    public Vertex findVertex(int id) {
        for (int i = 0; i < this.listOfVertexs.size(); i++) {
            if (this.listOfVertexs.get(i).getVertexId() == id) {
                return this.listOfVertexs.get(i);
            }
        }
        return null;
    }

    public int findEdge(int from, int to) {
        Vertex fr = findVertex(from);
        Vertex t = findVertex(to);
        int i;
        for (i = 0; i < listOfEdges.size(); i++) {
            if (fr.equals(listOfEdges.get(i).getFrom()) && t.equals(listOfEdges.get(i).getTo())) {
                return i;
            }
        }
        return -1;
    }

    public void deleteEdge(int from, int to) {
        if (findEdge(from, to) != -1) this.listOfEdges.remove(findEdge(from, to));
    }

    public void deleteEdgeInList(List<Vertex> list) {
        for (int i = 0; i < this.listOfEdges.size(); i++) {
            if (!list.contains(this.getListOfEdges().get(i))) {
                for (int j = 0; j < list.size(); j++) {
                    deleteEdge(this.getListOfEdges().get(i).getFrom().getVertexId(), list.get(j).getVertexId());
                }
            }
        }
    }

    public List<Edge> findNeighbors(Vertex v, List<Vertex> vlist) {
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < listOfEdges.size(); i++) {
            if (listOfEdges.get(i).getTo() == v && !vlist.contains(listOfEdges.get(i).getFrom())) {
                list.add(listOfEdges.get(i));
            }
        }
        return list;
    }

    public void removeNB(Vertex v, List<Vertex> list) {
        listOfEdges.removeAll(this.findNeighbors(v, list));
    }

    public void deleteVertex(int v) {
        int i;
        for (i = 0; i < listOfVertexs.size(); i++) {
            deleteEdge(v, listOfVertexs.get(i).getVertexId());
        }
        for (i = 0; i < listOfVertexs.size(); i++) {
            deleteEdge(listOfVertexs.get(i).getVertexId(), v);
        }
        listOfVertexs.remove(findVertex(v));
    }

    public Edge inputEdge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Vertex from: ");
        int fr = Integer.parseInt(sc.nextLine());
        Vertex from = findVertex(fr);
        System.out.println("Enter Vertex to: ");
        int t = Integer.parseInt(sc.nextLine());
        Vertex to = findVertex(t);
//        System.out.println("Enter Edge weight: ");
//        int weight = Integer.parseInt(sc.nextLine());
        int weight = 1;
        return new Edge(from, to, weight);
    }

    public void removeAllOfGraph() {
        while (!listOfVertexs.isEmpty()) {
            deleteVertex(listOfVertexs.get(0).getVertexId());
        }
    }

    public void printGraph() {
        for (int i = 0; i < this.listOfVertexs.size(); i++) {
            System.out.println(listOfVertexs.get(i).toString());
        }
        for (int i = 0; i < this.listOfEdges.size(); i++) {
            System.out.println(listOfEdges.get(i).toString());
        }
    }

    public static Graph exampleGraph(int x) {
        Graph g = new Graph();
        switch (x) {
            case 1:
                for (int i = 0; i <= 7; i++) {
                    g.addVertex(new Vertex(i));
                }
                g.addEdge(0, 1);
                g.addEdge(1, 3);
                g.addEdge(2, 1);
                g.addEdge(3, 2);
                g.addEdge(3, 4);
                g.addEdge(4, 5);
                g.addEdge(5, 7);
                g.addEdge(6, 4);
                g.addEdge(7, 6);
                break;
            case 2:
                for (int i = 0; i <= 7; i++) {
                    g.addVertex(new Vertex(i));
                }
                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(0, 6);
                g.addEdge(1, 0);
                g.addEdge(1, 4);
                g.addEdge(1, 7);
                g.addEdge(2, 0);
                g.addEdge(2, 3);
                g.addEdge(2, 4);
                g.addEdge(3, 2);
                g.addEdge(3, 5);
                g.addEdge(3, 6);
                g.addEdge(4, 1);
                g.addEdge(4, 2);
                g.addEdge(4, 5);
                g.addEdge(5, 3);
                g.addEdge(5, 4);
                g.addEdge(5, 7);
                g.addEdge(6, 0);
                g.addEdge(6, 3);
                g.addEdge(6, 7);
                g.addEdge(7, 1);
                g.addEdge(7, 5);
                g.addEdge(7, 6);
                break;
            case 3:
                for (int i = 0; i <= 7; i++) {
                    g.addVertex(new Vertex(i));
                }
                g.addEdge(0, 1);
                g.addEdge(0, 3);
                g.addEdge(1, 4);
                g.addEdge(2, 0);
                g.addEdge(3, 1);
                g.addEdge(3, 2);
                g.addEdge(3, 5);
                g.addEdge(4, 1);
                g.addEdge(5, 4);
                g.addEdge(5, 7);
                g.addEdge(6, 4);
                g.addEdge(6, 7);
                g.addEdge(7, 5);
                g.addEdge(7, 6);
                break;
        }
            return g;
    }
}
