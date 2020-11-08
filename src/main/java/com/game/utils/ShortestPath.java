package com.game.utils;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.game.model.Character;

public class ShortestPath {
    
    private boolean matrix[][];

    
    /**
     * <h1>Calcular Ruta</h1>
     * <p>Dados dos puntos, calcula la ruta mas optima de un punto A a uno B </p>
     * @return Una lista con la ruta
     * */
    // This will return the path in a ArrayList sorted
    public ArrayList<Node> getShortestPath(Character[][] board, Point from, Point to){
        ArrayList<Node> list = new ArrayList<>();
        Node node = calcRout(board, from, to);
        
        while (node != null){
            list.add(node);
            
            node = node.getFather();
        }
        
        Collections.reverse(list);
        
        return list;
    }
    private Node calcRout(Character[][] board, Point from, Point to){
        matrix = new boolean[board.length][board.length];
        convertMatrix(board, to);
        
        Node source = new Node(from.x, from.y, null);
        Node poped;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(source);
        
        while(!queue.isEmpty()){
            poped = queue.poll();
            
            if (poped.getX() == to.x && poped.getY() == to.y){
                return poped;
            }else{
                matrix[poped.getX()][poped.getY()] = true;
                
                List<Node> neighbours = addNeighbours(poped, matrix);
                queue.addAll(neighbours);
            }
        } 
        return null;
    }
    
    private void convertMatrix(Character[][] board, Point to){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (i != to.x && j != to.y)
                    matrix[i][j] = board[i][j] != null;
            }
        }
    }
    
    // This just return the neighbours
    private static List<Node> addNeighbours(Node poped, boolean [][]matrix){
        List <Node> list = new LinkedList<>();
        
        int x = poped.getX();
        int y = poped.getY();
        
        // Left
        if ((x-1 > 0 && x-1 < matrix.length) && matrix[x-1][y] != true){
            list.add(new Node(x-1, y, poped));
        }
        
        // Right
        if ((x+1 > 0 && x+1 < matrix.length) && matrix[x+1][y] != true){
            list.add(new Node(x+1, y, poped));
        }
        
        // Down
        if ((y-1 > 0 && y-1 < matrix.length) && matrix[x][y-1] != true){
            list.add(new Node(x, y-1, poped));
        }
        
        // Up
        if ((y+1 > 0 && y+1 < matrix.length) && matrix[x][y+1] != true){
            list.add(new Node(x, y+1, poped));
        }
        
        return list;
    }
}