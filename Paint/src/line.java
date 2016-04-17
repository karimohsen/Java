/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karim
 */
public class line {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public String col="black";
    public line(){
        
    }
    public line(int firstX,int firstY,int secondX,int SecondY,String c){
        x1=firstX;
        y1=firstY;
        x2=secondX;
        y2=SecondY;
        col=c;
    }
    public void setx1(int x){
        x1=x;
    }
    public void sety1(int y){
        y1=y;
    }
    public void sety2(int y){
        y2=y;
    }
    public void setx2(int x){
        x2=x;
    }
    public int getx1(){
        return x1;
    }
    public int gety1(){
        return y1;
    }
    public int getx2(){
        return x2;
    }
    public int gety2(){
        return y2;
    }
}
