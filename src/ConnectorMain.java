import com.ewon.ewonitf.ScheduledActionManager;
import com.ewon.ewonitf.SysControlBlock;

public class ConnectorMain {


  private static void setHttpTimeouts() {
    SysControlBlock SCB;

    final String httpSendTimeoutName = "HTTPC_SDTO";
    final String httpReadTimeoutName = "HTTPC_RDTO";
    char timeout = '2';
    final String timeoutVal = Character.toString(timeout);
    boolean needsSave = false;
    try {
      SCB = new SysControlBlock(SysControlBlock.SYS);

      SCB.setItem(httpSendTimeoutName, timeoutVal);

      SCB.setItem(httpReadTimeoutName, timeoutVal);

      SCB.saveBlock(true);

    } catch (Exception e) {
      System.err.println("Setting HTTP timeouts failed.");
      System.err.println(e);
    }
  }



  /**
   * Sets the directory that the Ewon uses to check for SSL Certificates
   *
   * @param path directory path where certificate is stored
   */
  private static void setCertificatePath(String path) {
    SysControlBlock SCB;
    try {
      SCB = new SysControlBlock(SysControlBlock.SYS);
      System.out.println(SCB.getItem("httpCertDir"));
      if (!SCB.getItem("HttpCertDir").equals(path)) {
         SCB.setItem("HttpCertDir", path);
         SCB.saveBlock(true);
      }
    } catch (Exception e) {
      System.out.println("Setting certificate directory failed");
      System.exit(0);
    }
  }


  public static void main(String[] args) {
    System.out.println("start up and running ");

    int res = 0;
    //String url = "https://example99.hmsamericas.com/";
    String url = "https://34.207.190.113/";
    System.out.println("connecting to " + url);

    String eWONCertificatePath = "/usr/certs";
    setCertificatePath(eWONCertificatePath);
    // setHttpTimeouts();

    String header = "Content-Type=application/json";
    String data = "{ \"name\": \"test\" }";
    int i = 3;
    while (i > 0) {
      try {
        res = ScheduledActionManager.RequestHttpX(url, "POST", header, data, "", "/usr/resp1.txt");
        System.err.println("response val " + res);
      } catch (Exception e) {
        System.err.println("exception ");
        e.printStackTrace();
        System.err.println(e.getMessage());
      }

      try {
        Thread.sleep(100);
      } catch (Exception e) {
      }
      i = i - 1;
    }
    System.err.println("test complete ");
  }

}
