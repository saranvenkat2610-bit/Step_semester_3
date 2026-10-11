
import java.util.Scanner;

abstract class Cab {
    static final double MIN_FARE = 100.0;

    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    boolean hasNightService() {
        return false;
    }

    double getFare(boolean night) {
        double fare = Math.max(MIN_FARE, km * getRate());

        if (night && hasNightService()) {
            fare *= 1.20;
        }

        return fare;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14.0;
    }

    boolean hasNightService() {
        return true;
    }
}

class SUV extends Cab {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18.0;
    }

    boolean hasNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();
            boolean night = time.equals("NIGHT");
            Cab cab = null;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
            }

            if (cab != null) {
                if (night && !cab.hasNightService()) {
                    System.out.println(
                        type + ": night service not available"
                    );
                } else {
                    double fare = cab.getFare(night);
                    System.out.printf("%s: %.2f%n", type, fare);
                    total += fare;
                }
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
