import com.hms_networks.americas.sc.logging.Logger;

/**
 * Ewon Flexy Azure Connector main class.
 *
 * @author HMS Networks, MU Americas Solution Center
 * @since 1.0
 */
public class ConnectorMain {

  /** Configures the logger to the logging level specified in the configuration. */
  private static void configLogger() {
    // Configure logger to desired log level
    int loglevel = 5;

    Logger.SET_LOG_LEVEL(loglevel);
  }

  /**
   * Main method for the Ewon Flexy Connector Template. This is the primary application entry point,
   * and will run the Azure Connector application.
   *
   * @param args program arguments (ignored)
   */
  public static void main(String[] args) {
    // Load configuration

    // Configure logger to desired log level
    configLogger();

    System.out.println("start up and running");
    // Show startup message
    Logger.LOG_CRITICAL("Start up");
  }
}
