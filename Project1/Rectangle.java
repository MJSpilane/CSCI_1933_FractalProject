//Written by Matthew Johnson, joh18723
import java.awt.Color;
public class Rectangle{
  double x;
  double y;
  double height;
  double width;
  double area;
  double perimeter;
  Color color; //color variable of type color that represents the color of the rectangle object

  public Rectangle(double x, double y, double height, double width){
    this.x = x; //x refers to the x coordinate of the upper left corner of the rectangle
    this.y = y;//y refers to the y coordinate of the upper left corner of the rectangle
    this.height = height;
    this.width = width;
    this.color = new Color(0,0,0);
  }
  public double calculatePerimeter(){
    return this.perimeter = ((2*width) + (2*height));
  }
  public double calculateArea(){
    return this.area = (this.height * this.width);
  }
  public void setColor(Color color){
    this.color = color;
    return;
  }
  public void setPos(double x, double y){
    this.x = x;
    this.y = y;
    return;
  }
  public void setHeight(double height){
    this.height = height;
    return;
  }
  public void setWidth(double width){
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
