
import java.util.Scanner;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double getBill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double getBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double getBill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double getBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();
            Connection c = null;

            switch (type) {
                case "HOME":
                    c = new Home(units);
                    break;
                case "SHOP":
                    c = new Shop(units);
                    break;
                case "FACTORY":
                    c = new Factory(units);
                    break;
            }

            if (c != null) {
                double bill = c.getBill();
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
