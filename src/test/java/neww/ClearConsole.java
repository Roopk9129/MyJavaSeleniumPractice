package neww;

public class ClearConsole {
	public static void main(String[] args) {
        clearConsole();
        System.out.println("Console cleared!");
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // Handle exceptions as needed
            e.printStackTrace();
        }
    }
}
