package com.partern.test;

public class Test1 {

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        int n=29;
        t1.dfs(n,1,n);
        System.out.println(t1.max);
    }

    private int max=0;

    public void dfs(int rest,int total,int n){
        if(rest==0){
            if(total>max){
                max = total;
            }
        }
        for(int i=1;i<=rest;i++){
            if(rest==n&&i==rest) continue;
            dfs(rest-i,total*i,n);
        }
    }
}
