/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karim
 */
public class rect {
    private int x1;
    private int y1;
    private int height;
    private int width;
    public Boolean flag=false;
    public String col="black";
    public rect(){

    }
    public rect(int firstX,int firstY,int h,int w,String c,boolean f){
        x1=firstX;
        y1=firstY;
        height=h;
        width=w;
        col=c;
        flag=f;
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
