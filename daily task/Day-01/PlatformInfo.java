public class PlatformInfo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         JAVA RUNTIME & PLATFORM INFO             ");
        System.out.println("==================================================");
        System.out.println("Java Version     : " + System.getProperty("java.version"));
        System.out.println("Java Vendor      : " + System.getProperty("java.vendor"));
        System.out.println("Java Home        : " + System.getProperty("java.home"));
        System.out.println("OS Name          : " + System.getProperty("os.name"));
        System.out.println("OS Architecture  : " + System.getProperty("os.arch"));
        System.out.println("OS Version       : " + System.getProperty("os.version"));
        System.out.println("Available Cores  : " + Runtime.getRuntime().availableProcessors());
        System.out.println("Max JVM Memory   : " + (Runtime.getRuntime().maxMemory() / (1024 * 1024)) + " MB");
        System.out.println("Total JVM Memory : " + (Runtime.getRuntime().totalMemory() / (1024 * 1024)) + " MB");
        System.out.println("Free JVM Memory  : " + (Runtime.getRuntime().freeMemory() / (1024 * 1024)) + " MB");
        System.out.println("==================================================");
    }
}
