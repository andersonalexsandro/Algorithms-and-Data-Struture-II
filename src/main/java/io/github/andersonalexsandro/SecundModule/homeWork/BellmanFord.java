package io.github.andersonalexsandro.SecundModule.homeWork;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BellmanFord {

    private static final double EPSILON = 1E-14;
    private double[] distTo; //distTo[v] = distance of shortest s->v

    private int[] edgeTo; //edgeTo[v] = last edge on shortest s->v
    private DirectedEdge[] aresta; //queue of edges to relax
    private int cost; // number of relax()
    private int V;
    private int E;
    private int s;

    public BellmanFord(String filepath, int source){
        s = source;

        readInput(filepath);
        inicializa();

        int i,j;
        for(i=1; i<V; i++){
            for(j=0; j<E; j++){
                relax(aresta[j]);
            }
        }
        for(i=0; i<V; i++){
            System.out.printf("Rota de %d a %d (%5.2f)", s, i, distTo[i]);
            printPathTo(i);
            System.out.println();
        }
        if(negative()){
            System.out.println("Ciclo negativo detectado");
        }
    }

    private boolean negative(){
        int v, w;
        double peso;
        boolean negative = false;
        for(int i=0; i<E; i++){
            v = aresta[i].from();
            w = aresta[i].to();
            peso = aresta[i].weight();
            if(distTo[w] > distTo[v] + peso + EPSILON){
                negative = true;
                System.out.printf("\nCiclo negativo detectado: %d %d\n", v, w);
                break;
            }
        }
        return negative;
    }

    public void printPathTo(int v){
        if(v == s){
            System.out.println("\t");
            System.out.println(s);
        }
        printPathTo(edgeTo[v]);
        System.out.println("->" + v);
    }

    public void inicializa(){
        for (int i = 0; i < V; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
            edgeTo[i] = -1;
        }
        distTo[s] = 0.0;
    }

    private void relax(DirectedEdge aresta){
        int v= aresta.from(), w = aresta.to();
        double peso = aresta.weight();
        if(distTo[w] > distTo[v] + peso + EPSILON){
            distTo[w] = distTo[v] + peso;
            edgeTo[w] = v;
        }
    }

    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public void readInput(String filepath){
        Scanner sc;
        File file = null;
        String line;
        int a,b;
        double cost;
        StringTokenizer tk;
        try{
            file = new File(filepath);
            sc = new Scanner(file);
            if(sc.hasNext()) V = sc.nextInt();
            else{
                System.out.println("\nArquivo Invalido");
            }
            if(sc.hasNext()) E = sc.nextInt();
            else{
                System.out.println("\nArquivo Invalido");
            }
            distTo = new double[V];
            edgeTo = new int[V];
            aresta = new DirectedEdge[E];

            for(int i=0; i<E; i++){
                a = sc.nextInt();
                b = sc.nextInt();
                cost = Double.parseDouble(sc.next());
                aresta[i] = new DirectedEdge(a,b,cost);
            }
        }catch (Exception e){
            System.out.println("Erro na leitura do arquivo");
            return;
        }
    }

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("\n\nUso java BellmanFord no-inicial\n");
            return;
        }
        BellmanFord bf = new BellmanFord(args[0], Integer.parseInt(args[1]));
    }
}
