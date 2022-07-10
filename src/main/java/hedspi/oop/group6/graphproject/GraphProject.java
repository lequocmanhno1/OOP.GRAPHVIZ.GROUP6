package hedspi.oop.group6.graphproject;

import hedspi.oop.group6.Controller.context.Context;
import hedspi.oop.group6.model.graph.Graph;
import hedspi.oop.group6.model.algorithm.Algorithm;
import hedspi.oop.group6.model.algorithm.BFS;
import hedspi.oop.group6.model.algorithm.BipartiteGraph;
import hedspi.oop.group6.model.algorithm.SCC;

import java.util.Scanner;

public class GraphProject {
    
    public static void showMenu1(){
        System.out.println("1. Create Vertex");
        System.out.println("2. Create Edge");
        System.out.println("3. Delete Vertex");
        System.out.println("4. Delete Edge");
        System.out.println("5. Show Graph");
        System.out.println("6. Delete Graph");
        System.out.println("0. Back");
    	System.out.println("Choose 0-6:  ");
    }
    
    public static void showMenu(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("      Graph Traversal     ");
        System.out.println("1. Draw Graph");
        System.out.println("2. Example Graphs");
        System.out.println("3. Breadth-First Sreach");
        System.out.println("4. Bipartite graph checker for BFS");
        System.out.println("5. Strongly connected component algorithm - Kosaraju's algorithm");
        System.out.println("0. Exit");
        System.out.println("----------------------------------------------------------------");
    	System.out.println("Choose 0-5:");
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        //
        Context context = null;

        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1 :
                    int c;
                    do{
                        showMenu1();
                        c = Integer.parseInt(sc.nextLine());
                        switch (c) {
                            case 1 :
                                System.out.println("Enter number of vertexs: ");
                                int n = Integer.parseInt(sc.nextLine());
                                for(int i=0; i<n; i++){
                                    g.addVertex();
                                }
                                break;
                            case 2 :
                                System.out.println("Enter number of edges: ");
                                int m = Integer.parseInt(sc.nextLine());
                                for(int i=0; i<m; i++){
                                    g.addEdge();
                                }
                                break;
                            case 3:
                                System.out.println("Enter id of vertex you want to remove: ");
                                int id = Integer.parseInt(sc.nextLine());
                                //g.removeVertex(id);
                                g.deleteVertex(id);
                                break;
                            case 4:
                                System.out.println("Enter information of edge you want to remove: ");
                                System.out.println("From: ");
                                int from = Integer.parseInt(sc.nextLine());
                                System.out.println("To: ");
                                int to = Integer.parseInt(sc.nextLine());
                                //g.removeEdge(from, to);
                                g.deleteEdge(from, to);
                                break;
                            case 5 : g.printGraph(); break;
                            case 6 : g.removeAllOfGraph(); break;
                            case 0 : System.out.println("Back to main menu");
                        }
                    }while(c != 0);
                    break;
                case 2 :
                    int x;
                    do{
                        System.out.println("1. CP3 4.9 DG");
                        System.out.println("2. Graph 8-24 Bit");
                        System.out.println("3. Graph 8-14 SCC "); // SCC 023 14 567
                        
                        System.out.println("9. Show Graph");
                        System.out.println("0. Back");
                        System.out.println("Choose 0-4:");
                        x = Integer.parseInt(sc.nextLine());
                        switch (x) {
                            case 1: case 2: case 3:
                                    g.removeAllOfGraph();
                                    g = Graph.exampleGraph(x);
                                break;
                            case 9 : g.printGraph();
                                break;
                            case 0 : System.out.println("Back to main menu");
                        }
                    }while(x != 0);
                    break;

                case 3 :
                    Algorithm algorithm = new BFS(g);
                    System.out.print("Start from source s = ");
                    int id = Integer.parseInt(sc.nextLine());
                    algorithm.setSourceVertex(g.findVertex(id));
                    context.setAlgorithm(algorithm);
                    context.execute();
                    break;
                case 4 :
                    Algorithm test = new BipartiteGraph(g);
                    System.out.print("Start from source s = ");
                    int idd = Integer.parseInt(sc.nextLine());
                    test.setSourceVertex(g.findVertex(idd));
                    context.setAlgorithm(test);
                    context.execute();
                    break;

                case 5 :
                    Algorithm test2 = new SCC(g);
                    System.out.print("Start from source s = ");
                    int iid = Integer.parseInt(sc.nextLine());
                    test2.setSourceVertex(g.findVertex(iid));
                    context.setAlgorithm(test2);
                    context.execute();
                    break;
                case 0 : System.out.println("EXIT");
            }
        }while(choice != 0);
    }
    
}
