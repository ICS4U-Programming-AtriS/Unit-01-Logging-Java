
// Importing classes
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Enterprise software for ATREE Logging Company.
 * This software is used to calculate the amount of logs that a truck can fit.
 * Given input for a log length, it will return the log amount.
 *
 * @author Atri Sarker
 * @version 1.0
 * @since 2025-09-17
 */
public final class Logging {
  /**
   * Private constructor to satisfy style checker.
   *
   * @exception IllegalStateException for the utility class.
   * @see IllegalStateException
   */
  private Logging() {
    // Prevents illegal states.
    throw new IllegalStateException("Utility class.");
  }

  /**
   * Maximum payload capacity for the truck. [IN KG]
   */
  public static final int TRUCK_WEIGHT_LIMIT = 1100;

  /**
   * Rate that defines how much a log weighs per meter. [IN KG/M]
   */
  public static final int WEIGHT_PER_METER = 20;

  /**
   * Our company's offered log lengths.
   * Only these lengths are offered due to ease of inventory and transport.
   * More log lengths may be offered in the future.
   */
  public static final double[] LOG_LENGTHS = {0.25, 0.5, 1};

  /**
   * Entrypoint of the program.
   *
   * @param args UNUSED.
   */
  public static void main(final String[] args) {
    // Welcome message
    System.out.print("Welcome to the ATREE logging company's ");
    System.out.println("tooling kit for industry-standard log packing.");
    System.out.print("Our software is known to be robust ");
    System.out.println("and military-grade, much like our logs.");
    System.out.println();
    // Prompt for log length.
    System.out.println("LOG LENGTHS (m): " + Arrays.toString(LOG_LENGTHS));
    System.out.print("Enter the length of the log (m): ");
    // Initialize Scanner for user input.
    final Scanner scanner = new Scanner(System.in);
    // TRY CATCH
    try {
      // Read length as a double.
      final double logLength = scanner.nextDouble();
      // Close scanner
      scanner.close();

      // Check if the log length is a valid length
      if (logLength > 0) {
        // Calculate the amount of logs that can fit in the truck
        final double logAmount = TRUCK_WEIGHT_LIMIT
            / (WEIGHT_PER_METER * logLength);
        // Display the result
        System.out.printf("\033[0;34mLog Amount : %.0f", logAmount);
        System.out.println("");
      } else {
        // Error message for invalid log length
        System.out.println("\033[0;31mERROR: INVALID LOG LENGTH.");
      }
    } catch (InputMismatchException error) {
      // Error message for non-numeric length. [IN RED]
      System.out.println("\033[0;31mERROR: LOG LENGTH MUST TO NUMERIC");
    }
  }
}
