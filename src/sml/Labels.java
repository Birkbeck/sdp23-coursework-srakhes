package sml;

import sml.customExceptions.DuplicateLabelSMLInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 *
 * @author ...
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
//		try {
//			Objects.requireNonNull(label);
//			if (labels.containsKey(label)) {
//				System.out.println("Duplicate");
//				throw new DuplicateLabelSMLInputException("Text");
//			}
//		} catch (DuplicateLabelSMLInputException e) {
//			throw new DuplicateLabelSMLInputException("Duplicate labels are not allowed in your SML file: " + label + " has been used as a label two (or more) times.");
////			System.out.println("Duplicate labels are not allowed in your SML file: " + label + " has been used as a label two (or more) times.");
////			System.exit(1); // TODO: this needs to be changed to throw error back to main where program can gracefully exit
//		} catch (ArithmeticException e) {
//			throw new ArithmeticException("Label can not be null");
//		}

		Objects.requireNonNull(label); //TODO: add a try catch to catch null pointer exception if the label is null
		// TODO: Add a check that there are no label duplicates.
		// TODO: use containsKey here within hashmap.
		// TODO: add a catch here to catch an exception raised if there are duplicate labels.
		if (labels.containsKey(label)) {
			System.out.println("Duplicate labels are not allowed in your SML file: " + label + " has been used as a label two (or more) times.");
		}
		labels.put(label, address);
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// TODO: Where can NullPointerException be thrown here?
		//       (Write an explanation.)
		//       Add code to deal with non-existent labels.
		return labels.get(label);
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers).
		return "";
	}

	// TODO: Implement equals and hashCode (needed in class Machine).

	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
