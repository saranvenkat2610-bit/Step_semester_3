
import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    boolean supportsSaver() {
        return false;
    }

    double getUnits(boolean saver) {
        double units = getPower() * hours / 1000.0;

        if (saver && supportsSaver()) {
            units *= 0.75;
        }

        return units;
    }

    double getCost(boolean saver) {
        return getUnits(saver) * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNextLine()) {
                String extra = sc.nextLine().trim();
                saver = extra.equalsIgnoreCase("SAVER");
            }

            Appliance a = null;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                case "WASHER":
                    a = new Washer(hours);
                    break;
            }

            if (a != null) {
                if (saver && !a.supportsSaver()) {
                    System.out.println(
                        type + ": saver mode not supported"
                    );
                } else {
                    double units = a.getUnits(saver);
                    double cost = a.getCost(saver);

                    System.out.printf(
                        "%s: Units=%.2f Cost=%.2f%n",
                        type, units, cost
                    );

                    total += cost;
                }
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
