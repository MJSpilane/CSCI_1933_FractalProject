// FractalDrawer class draws a fractal of a shape indicated by user input
//Writen by Matthew Johnson, joh18723
import java.awt.Color;
import java.util.Scanner;
public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area
    int startRadius;
    int startHeight;
    int startWidth;
    int startX;
    int startY;
    int startLevel;
    float red;
    float green;
    float blue;
    Color startColor;
    public FractalDrawer() {
      startRadius = 100;
      startHeight = 100;
      startWidth = 100;
      startX = 600;
      startY = 600;
      startLevel = 0;
      startColor = new Color((int)(Math.random()*0x1000000));
    }  // contructor (set a base height, radius, width, x, y , color, and level)


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
      Canvas can = new Canvas(1200, 1200);
      if (type.equals("circle")){
        drawCircleFractal(startRadius, startX, startY, startColor, can, startLevel);
      }
      if(type.equals("triangle")){
        drawTriangleFractal(startWidth, startHeight, startX, 850, startColor, can, startLevel);
      }
      if(type.equals("rectangle")){
        drawRectangleFractal(startWidth, startHeight, startX, startY, startColor, can, startLevel);
      }
      return totalArea;
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
      Triangle myTriangle = new Triangle(x, y, width, height);
      myTriangle.setColor(c);
      can.drawShape(myTriangle);
      double currentArea = (myTriangle.calculateArea());
      totalArea += currentArea;
      double newWidth = width/2;
      double newHeight = height/2;
      double babyTriangle1X = (x+(width/4)); //new x coordinate for top baby triangle
      double babyTriangle1Y = (y - height); // new y coordinate for top baby triangle
      double babyTriangle2X = (x + width); // new x coordinate for right baby triangle (y stays the same)
      double babyTriangle3X = (x - newWidth);//new x coordinate for left baby triangle (y stays the same)
      Color newColor = new Color((int)(Math.random()*0x1000000));
      level += 1;
      if (level < 8){
        drawTriangleFractal(newWidth, newHeight, babyTriangle1X, babyTriangle1Y, newColor, can, level);// drawing top baby triangle
        drawTriangleFractal(newWidth, newHeight, babyTriangle2X, y, newColor, can, level);
        drawTriangleFractal(newWidth, newHeight, babyTriangle3X, y, newColor, can, level);
      }
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
      Circle myCircle = new Circle(x, y, radius);
      myCircle.setColor(c);
      can.drawShape(myCircle);
      double currentArea = (myCircle.calculateArea());
      totalArea += currentArea;
      double newRadius = radius/2;
      double babyCircle1X = (x-radius-newRadius); //x coordinate for the left baby circle, the y stays the same
      double babyCircle2Y = (y + radius + newRadius); //y coordinate for the top baby circle, the x stays the same
      double babyCircle3X = (x + radius + newRadius); //x coordinate for the right baby circle, the y stays the same
      double babyCircle4Y = (y -radius - newRadius);
      Color newColor = new Color((int)(Math.random()*0x1000000));
      level += 1;
      if (level < 8){
        drawCircleFractal(newRadius, babyCircle1X, y, newColor, can, level);//draws the left circle
        drawCircleFractal(newRadius, x, babyCircle2Y, newColor, can, level);//draws the top circle
        drawCircleFractal(newRadius, babyCircle3X, y, newColor, can, level);//draws the right circle
        drawCircleFractal(newRadius, x, babyCircle4Y, newColor, can, level); //draws the bottom circle
      }
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
      Rectangle myRectangle = new Rectangle(x, y, height, width);
      myRectangle.setColor(c);
      can.drawShape(myRectangle);
      double currentArea = (myRectangle.calculateArea());
      totalArea += currentArea;
      double newHeight = height / 2;
      double newWidth = width/2;
      double leftRecX = x-newWidth; //x coord for the left baby rectangles
      double topRecY = y - newHeight; // y coord for top  baby rectangles
      double rightRecX = x + width; // x coord for the right baby rectangles
      double bottomRecY = y + height; //y coord for the bottom baby rectangles
      Color newColor = new Color((int)(Math.random()*0x1000000));
      level += 1;
      if (level < 8){
        drawRectangleFractal(newWidth, newHeight, leftRecX, topRecY, newColor, can, level);//draw the top left baby rectangle
        drawRectangleFractal(newWidth, newHeight, rightRecX, topRecY, newColor, can, level);//draw the top right baby rectangle
        drawRectangleFractal(newWidth, newHeight, leftRecX, bottomRecY, newColor, can, level);//draw the bottom left baby rectangle
        drawRectangleFractal(newWidth, newHeight, rightRecX, bottomRecY, newColor, can, level);//draw the bottom right baby rectangle
      }
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
      Scanner myScanner = new Scanner(System.in);
      System.out.println("Please enter a shape (circle, rectangle, or triangle):");
      String response = myScanner.next();
      FractalDrawer myFractal = new FractalDrawer();
      System.out.println("The total area of this fractal is:" + myFractal.drawFractal(response));
    }
}
