package dining_philosophers_problem;

import java.util.Random;

public class Philosopher implements Runnable {
	// those are the variables that are used in the class
	private int id; // the id of the philosopher
	private int eatingCounter; // the counter of the eating
	private volatile boolean full; // To check if the philosopher is full or not
	private Chopstick leftChopstick; // the left chop stick
	private Chopstick rightChopstick; // the right chop stick
	private Random random; // To generate random numbers for the sleep time

	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) { // the constructor of the class
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.random = new Random();

	}

	@Override
	public void run() { // the run method of the class that is used to run the threads

		try {
			while (!full) { // while the philosopher is not full

				think(); // the philosopher thinks first

				if (leftChopstick.pickUp(this, State.LEFT)) { // if the left chop stick is picked up by the philosopher

					if (rightChopstick.pickUp(this, State.RIGHT)) { // and if the right chop stick is picked up by the
																	// philosopher

						eat(); // then the philosopher eats and the counter of the eating is incremented
						rightChopstick.putDown(this, State.RIGHT); // the right chop stick is put down by the
																	// philosopher after eating

					}

					leftChopstick.putDown(this, State.LEFT); // also the left chop stick is put down by the philosopher
																// after eating
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void think() throws InterruptedException { // the think method of the class
		System.out.println(this + " is thinking...");
		Thread.sleep(random.nextInt(1000)); // the philosopher sleeps for a random time
	}

	private void eat() throws InterruptedException { // the eat method of the class

		System.out.println(this + " is eating...");
		eatingCounter++; // the counter of the eating is incremented by 1
		Thread.sleep(random.nextInt(1000)); // the philosopher sleeps for a random time
	}

	public int getEatingCounter() { // To get the counter of the eating of the philosopher
		return eatingCounter;
	}

	public void setFull(boolean isFull) { // To set the philosopher as full
		full = isFull;
	}

	public boolean isFull() { // To check if the philosopher is full or not
		return full;
	}

	@Override
	public String toString() { // To print the philosopher and the number of times he ate
		return "Philosopher-" + id;
	}

}
