package io.github.andersonalexsandro.SecundModule.bruteForce.backtracking;

import java.util.List;

import java.util.Arrays;

public class Subsets {

    int[] valores = {1, 2, 3};
    int[] solution = new int[valores.length];

    public void backtracking(int k){
        if(k == valores.length){
            System.out.println(Arrays.toString(solution));
        }
        else{
            for(int i=0; i<= valores.length; i++) {
                solution[k] = i;
                backtracking(k + 1);
            }
        }
    }

    public static void main(String[] args){
        Subsets subsets = new Subsets();
        subsets.backtracking(0);
    }
}
