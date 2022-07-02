import java.util.Scanner;

public class DepositCalculator {

    private static final double YEAR_RATE = 0.06;

    public static void main(String[] args) {
        new DepositCalculator().getDepositResult();
    }

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round(double value, int numbersAfterComma) {
        double scale = Math.pow(10, numbersAfterComma);
        return Math.round(value * scale) / scale;
    }

    void getDepositResult() {
        int period;
        int depositType;
        double depositResult;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        switch (depositType) {
            case 1: depositResult = calculateSimplePercent(amount, YEAR_RATE, period); break;
            case 2: depositResult = calculateComplexPercent(amount, YEAR_RATE, period); break;
            default: depositResult = 0;
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositResult);
    }

}
