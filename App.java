package dining_philosophers_problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = null;
		Philosopher[] philosophers = null;
		Chopstick[] chopsticks = null;

		try {
			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS]; // This is where the number of
																				// philosophers is set
			chopsticks = new Chopstick[Constants.NUMBER_OF_CHOPSTICKS]; // This is where the number of chop sticks is
																		// set

			for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) { // This is where the chop sticks are initialized
				chopsticks[i] = new Chopstick(i);
			}

			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS); // This is where the
																								// number of threads is
																								// set

			for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) { // This is where the philosophers are
																			// initialized
				philosophers[i] = new Philosopher(i, chopsticks[i],
						chopsticks[(i + 1) % Constants.NUMBER_OF_PHILOSOPHERS]); // This is where the philosophers are
																					// assigned chop sticks and the
																					// order in which they are assigned
				executorService.execute(philosophers[i]);

			}

			Thread.sleep(Constants.SIMULATION_RUNNING_TIME); // This is where the simulation running time is set from
																// Constants.java

			for (Philosopher philosopher : philosophers) { // This is where the philosophers are checked to see if they
															// are full or not
				philosopher.setFull(true);
			}

		} finally {

			executorService.shutdown(); // This is where the executor service is shut down to stop the threads

			while (!executorService.isTerminated()) { // This is where the executor service is checked to see if it is
														// terminated
				Thread.sleep(1000);
			}

			for (Philosopher philosopher : philosophers) {
				System.out.println(philosopher + " eats " + philosopher.getEatingCounter() + " times."); // This is
																											// where the
																											// final
																											// output is
																											// printed
			}

		}

	}

}
