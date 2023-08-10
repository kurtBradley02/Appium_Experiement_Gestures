package util;
import java.io.IOException;

public class CmdTrigger {
	
	public static void main(String[] args) {
        String[] commands = {
            "cmd.exe", "/c",
            "cd C:\\Users\\kurtb\\AppData\\Local\\Android\\Sdk\\emulator && emulator -avd Pixel_6_API_33 -no-audio -no-window &"
        };

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            processBuilder.redirectErrorStream(true); // Redirect error stream to standard output

            Process process = processBuilder.start();

            // Read the output of the process
            java.io.InputStream inputStream = process.getInputStream();
            java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
            String output = scanner.hasNext() ? scanner.next() : "";

            // Print the output
            System.out.println("CMD Output:\n" + output);

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
	

	public CmdTrigger() {
		// TODO Auto-generated constructor stub
	}

}
