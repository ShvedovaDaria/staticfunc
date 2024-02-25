import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 999.99, 2);
        Product smartphone = new Product("Smartphone", 499.99, 3);

        Order order = new Order("Paul Mccartney", "123 Main St");

        order.addProduct(laptop);
        order.addProduct(smartphone);

        System.out.println("Order Details:");
        System.out.println("Client: " + order.getClient());
        System.out.println("Delivery Address: " + order.getDeliveryAddress());
        System.out.println("Payment Status: " + (order.isPaymentStatus() ? "Paid" : "Not Paid"));

        System.out.println("Products:");
        for (Product product : order.getProducts()) {
            System.out.println("  - " + product.getName() + ": $" + product.getPrice() + " x" + product.getQuantity());
        }

        System.out.println("\n-----------------------------\n");

        Rectangle rectangle = new Rectangle(10, 20, "Red", 30, 40);
        Circle circle = new Circle(50, 60, "Blue", 15);
        Line line = new Line(5, 10, "Green", 15, 25);

        System.out.println("Graphic Objects:");
        printGraphicObjectDetails(rectangle);
        printGraphicObjectDetails(circle);
        printGraphicObjectDetails(line);
    }

    private static void printGraphicObjectDetails(GraphicObject graphicObject) {
        System.out.println("Type: " + graphicObject.getClass().getSimpleName());
        System.out.println("Position: (" + graphicObject.getX() + ", " + graphicObject.getY() + ")");
        System.out.println("Color: " + graphicObject.getColor());
        graphicObject.draw();
        System.out.println("\n-----------------------------\n");
    }

    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    static class Order {
        private List<Product> products;
        private String client;
        private String deliveryAddress;
        private boolean paymentStatus;

        public Order(String client, String deliveryAddress) {
            this.products = new ArrayList<>();
            this.client = client;
            this.deliveryAddress = deliveryAddress;
            this.paymentStatus = false;
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public void removeProduct(Product product) {
            products.remove(product);
        }

        public void changeOrderStatus(boolean paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public List<Product> getProducts() {
            return products;
        }

        public String getClient() {
            return client;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public boolean isPaymentStatus() {
            return paymentStatus;
        }
    }

    static class GraphicObject {
        protected int x;
        protected int y;
        protected String color;

        public GraphicObject(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void draw() {
        }


        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getColor() {
            return color;
        }
    }

    static class Rectangle extends GraphicObject {
        private int width;
        private int height;

        public Rectangle(int x, int y, String color, int width, int height) {
            super(x, y, color);
            this.width = width;
            this.height = height;
        }


        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    static class Circle extends GraphicObject {
        private int radius;

        public Circle(int x, int y, String color, int radius) {
            super(x, y, color);
            this.radius = radius;
        }


        public int getRadius() {
            return radius;
        }
    }

    static class Line extends GraphicObject {
        private int x2;
        private int y2;

        public Line(int x, int y, String color, int x2, int y2) {
            super(x, y, color);
            this.x2 = x2;
            this.y2 = y2;
        }


        public int getX2() {
            return x2;
        }

        public int getY2() {
            return y2;
        }
    }
}
