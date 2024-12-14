package ca.lambton.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class ExamApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);

		// Test Q6: Consonant counting
		System.out.println(ExamQuestions.countConsonants("food"));
		System.out.println(ExamQuestions.countConsonants("abcdef"));

		// Test Q7: Prime checking
		System.out.println(ExamQuestions.isPrime(7));
		System.out.println(ExamQuestions.isPrime(17));
		System.out.println(ExamQuestions.isPrime(4));
	}

	// Event listener to open the browser after Spring Boot application starts
	@EventListener(ApplicationReadyEvent.class)
	public void openBrowserAfterStartup() {
		String url = "http://localhost:8080"; // URL to open after startup

		// Try to open the default browser with the URL
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			try {
				// Open the default browser
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace(); // Print the error if the browser cannot be opened
			}
		} else {
			// Fallback in case Desktop class is not supported
			Runtime runtime = Runtime.getRuntime();
			try {
				// Try to open the URL using an OS-specific method
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				e.printStackTrace(); // Print the error if it fails to open the browser
			}
		}
	}
}
