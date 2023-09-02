//Written by Matthew Johnson, joh18723
import java.awt.Color;
public class Triangle{
  double x;
  double y;
  double height;
  double width;
  double area;
  double perimeter;
  Color color;
  public Triangle(double x, double y, double width, double height){
    this.x = x; //x refers to the x coordinate of the bottom left corner of the triangle
    this.y = y;//y refers to the y coordinate of the bottom left corner of the triangle
    this.height = height;
    this.width = width;
    this.color = new Color(0,0,0);
  }
  public double calculatePerimeter(){
    double sideLength = Math.sqrt(((0.5*width)*(0.5*width)) + (height * height));
    return ((sideLength *2) + width);
  }
  public double calculateArea(){
    return (0.5*width*height);
  }
  public void setColor(Color color){
    this.color = color;
    return;
  }
  public void setPos(int x, int y){
    this.x = x;
    this.y = y;
    return;
  }
  public void setHeight(int height){
    this.height = height;
    return;
  }
  public void setWidth(int width){
    this.width = width;
    return;
  }
  public Color getColor(){
    return this.color;
  }
  public double getXPos(){
    return this.x;
  }
  public double getYPos(){
    return this.y;
  }
  public double getHeight(){
    return this.height;
  }
  public double getWidth(){
    return this.width;
  }
}
