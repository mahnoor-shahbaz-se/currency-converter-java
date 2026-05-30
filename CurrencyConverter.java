import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyConverter {

    static final BigDecimal RATE_USD = new BigDecimal("1.0");
    static final BigDecimal RATE_EUR = new BigDecimal("0.92");
    static final BigDecimal RATE_GBP = new BigDecimal("0.79");
    static final BigDecimal RATE_INR = new BigDecimal("83.50");
    static final BigDecimal RATE_AED = new BigDecimal("3.67");
    static final BigDecimal RATE_PKR = new BigDecimal("278.50");
    static final BigDecimal RATE_JPY = new BigDecimal("149.50");
    static final BigDecimal RATE_AUD = new BigDecimal("1.53");
    static final BigDecimal RATE_CAD = new BigDecimal("1.36");
    static final BigDecimal RATE_KWD = new BigDecimal("0.307");

    static final int BOX_WIDTH = 46;
    static final String BORDER = "=" .repeat(BOX_WIDTH + 2);

    static BigDecimal getRate(String currency) {
        switch (currency.toUpperCase()) {
            case "USD": return RATE_USD;
            case "EUR": return RATE_EUR;
            case "GBP": return RATE_GBP;
            case "INR": return RATE_INR;
            case "AED": return RATE_AED;
            case "PKR": return RATE_PKR;
            case "JPY": return RATE_JPY;
            case "AUD": return RATE_AUD;
            case "CAD": return RATE_CAD;
            case "KWD": return RATE_KWD;
            default:    return null;
        }
    }

    static BigDecimal convert(BigDecimal amount,
                              BigDecimal sourceRate,
                              BigDecimal targetRate) {
        BigDecimal inUSD = amount.divide(sourceRate, MathContext.DECIMAL128);
        return inUSD.multiply(targetRate).setScale(2, RoundingMode.HALF_EVEN);
    }

    static void printRow(String text) {
        System.out.printf("|%-" + BOX_WIDTH + "s|%n", text);
    }

    static void showMenu() {
        System.out.println(BORDER);
        printRow("  CURRENCY CONVERTER");
        System.out.println(BORDER);
        printRow("  Supported Currencies:");
        printRow("  USD   EUR   GBP   INR   AED");
        printRow("  PKR   JPY   AUD   CAD   KWD");
        System.out.println(BORDER);
    }

    static void showResult(BigDecimal amount, String src,
                           BigDecimal result, String tgt) {
        String line = String.format("  %,.2f %s  =  %,.2f %s",
                amount.doubleValue(), src,
                result.doubleValue(), tgt);
        System.out.println(BORDER);
        printRow("  RESULT");
        System.out.println(BORDER);
        printRow(line);
        System.out.println(BORDER);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continueApp = true;

        System.out.println(BORDER);
        printRow("  Welcome to the Currency Converter!");
        System.out.println(BORDER);

        do {

            showMenu();

            // ---- read amount ----------------------------------------
            BigDecimal amount = null;

            while (amount == null) {
                System.out.print("\nEnter amount (0 to exit): ");
                String amountInput = scanner.nextLine().trim();

                try {
                    double input = Double.parseDouble(amountInput);

                    if (input == 0) {
                        continueApp = false;
                        break;
                    }

                    if (input < 0) {
                        System.out.println("ERROR: Amount cannot be negative. Try again.");
                        continue;
                    }

                    amount = new BigDecimal(String.valueOf(input));

                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Please enter a valid number.");
                }
            }

            if (!continueApp) break;

            // ---- read source currency --------------------------------
            System.out.print("Enter source currency (e.g. PKR): ");
            String sourceCurrency = scanner.nextLine().toUpperCase().trim();
            BigDecimal sourceRate = getRate(sourceCurrency);

            if (sourceRate == null) {
                System.out.println("ERROR: Unknown currency '" + sourceCurrency + "'. Try again.");
                continue;
            }

            // ---- read target currency --------------------------------
            System.out.print("Enter target currency (e.g. USD): ");
            String targetCurrency = scanner.nextLine().toUpperCase().trim();
            BigDecimal targetRate = getRate(targetCurrency);

            if (targetRate == null) {
                System.out.println("ERROR: Unknown currency '" + targetCurrency + "'. Try again.");
                continue;
            }

            if (sourceCurrency.equals(targetCurrency)) {
                System.out.println("ERROR: Source and target currency cannot be the same.");
                continue;
            }

            // ---- convert --------------------------------------------
            BigDecimal result = convert(amount, sourceRate, targetRate);

            // ---- display result -------------------------------------
            showResult(amount, sourceCurrency, result, targetCurrency);

            // ---- ask to continue ------------------------------------
            System.out.print("\nConvert again? (yes / no): ");
            String again = scanner.nextLine().toLowerCase().trim();
            if (again.equals("no") || again.equals("n")) {
                continueApp = false;
            }

        } while (continueApp);

        scanner.close();
        System.out.println(BORDER);
        printRow("Goodbye!");
        System.out.println(BORDER);
    }
}

