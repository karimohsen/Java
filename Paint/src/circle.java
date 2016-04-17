/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karim
 */
public class circle {
    private int x1;
    private int y1;
    private int height;
    private int width;
    public boolean flag=false;
    public String col="black";
    public circle(){

    }
    public circle(int firstX,int firstY,int h,int w,boolean f,String c){
        x1=firstX;
        y1=firstY;
        height=h;
        width=w;
        flag=f;
        col=c;
    }
    public void setx1(int x){
        x1=x;
    }
    public void sety1(int y){
        y1=y;
    }
    public void setwidth(int x){
        width=x;
    }
    public void setheight(int h){
        height=h;
    }
    public int getx1(){
        return x1;
    }
    public int gety1(){
        return y1;
    }
    public int getwidth(){
        return width;
    }
    public int getheight(){
        return height;
    }
}
