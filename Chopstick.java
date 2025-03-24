package dining_philosophers_problem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

	private int id; // the id of the chop stick
	private Lock lock; // the lock of the chop stick to make sure that only one philosopher can pick it
						// up at a time

	public Chopstick(int id) { // the constructor of the class
		this.id = id;
		this.lock = new ReentrantLock(); // the lock is initialized
	}

	public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException { // the pick up method of
																								// the class that is
																								// used to pick up the
																								// chop stick

		if (lock.tryLock(10, TimeUnit.MILLISECONDS)) { // if the lock is available then the philosopher picks up the chop stick
			System.out.println(philosopher + " picked up " + state.toString() + " chopstick " + this); // the output printed
			return true; // true is returned
		}
		return false; // false is returned if the lock is not available
	}

	public void putDown(Philosopher philosopher, State state) { // the put down method of the class that is used to put down the chop stick
		lock.unlock(); // the lock is unlocked because the philosopher is done with the chop stick
		System.out.println(philosopher + " put down " + state.toString() + " chopstick " + this); // the output is printed
	}

	public String toString() { // the toString method of the class that is used to return the id of the chop stick
		return "Chopstick-" + id;
	}

}
