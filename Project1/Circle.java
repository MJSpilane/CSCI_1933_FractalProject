//Written by Matthew Johnson, joh18723
import java.awt.Color;
public class Circle{
  double x;
  double y;
  double radius;
  double perimeter;
  double area;
  Color color;
  //The constructor method that initializes the circle object, giving it a x and y coordinate, as well as a radius
  public Circle(double x, double y, double radius){
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.color = new Color(0,0,0);
  }
  public double calculatePerimeter(){
    return this.perimeter = (2 * this.radius * 3.14159265359);
  }
  public double calculateArea(){
    return  this.area = (this.radius * this.radius * 3.14159265359);
  }
  public void setColor(Color newcolor){
    this.color = newcolor;
    return;
  }
  public void setPos(double x, double y){
    this.x = x;
    this.y = y;
    return;
  }
  public void setRadius(double radius){
    this.radius = radius;
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
  public double getRadius(){
    return radius;
  }
}
