import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Shape shape = new Shape();
        Shape shapeOne = new Shape();
        Triangle triangle = new Triangle("I am a triangle", "glass", 11, 15);
        Triangle triangleOne = triangle;
        Rectangle rectangle = new Rectangle("I am a rectangle", "metal", 13, 16);
        Rectangle rectangleOne = new Rectangle("I am a rectangle", "metal", 13, 16);
        Triangle hashTest1 = new Triangle ("test", "test", 11, 11);
        Rectangle hashTest2 = new Rectangle ("test", "test", 11, 11);

        System.out.println(shape.hashCode());
        System.out.println(shapeOne.hashCode());
        System.out.println(triangle.hashCode());
        System.out.println(triangleOne.hashCode());
        System.out.println(rectangle.hashCode());
        System.out.println(rectangleOne.hashCode());
        System.out.println(hashTest1.hashCode());
        System.out.println(hashTest2.hashCode());

        Shape shape1 = new Shape("SHAPEONE", "material1");
        Shape shape2 = new Shape ("SHAPETWO", "material2");
        Triangle triangle1 = new Triangle ("TRIANGLEONE", "wood", 12, 13);
        Triangle triangle2 = new Triangle ("TRIANGLETWO", "metal", 24, 43);
        Rectangle rectangle1 = new Rectangle ("RECTANGLEONE", "steel", 33, 8);
        Rectangle rectangle2 = new Rectangle ("RECTANGLETWO", "obsidian", 61, 12);

        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(shape1);
        shapeList.add(shape2);
        shapeList.add(triangle1);
        shapeList.add(triangle2);
        shapeList.add(rectangle1);
        shapeList.add(rectangle2);

        for (Shape smth : shapeList) {
            System.out.println(smth.toString());
            System.out.println(smth.getSize());
            if (smth instanceof Triangle) {
                ((Triangle) smth).displayTriangleHeight();
            }
            if (smth instanceof Rectangle) {
                ((Rectangle) smth).displayRectangleHeight();
            }
        }
    }
}
