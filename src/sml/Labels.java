package sml;

import sml.customExceptions.InvalidLabelSMLInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class

/**
 *
 * @author Birkbeck College, and Samuel Rakhes
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
//		TODO: this needs to be changed to throw error back to main where program can gracefully exit
//		TODO: add a try catch to catch null pointer exception if the label is null
// 		TODO: Add a check that there are no label duplicates.
//		TODO: use containsKey here within hashmap.
//		TODO: add a catch here to catch an exception raised if there are duplicate labels.
		try {
//			label = null; // TODO: for testing purposes - remove after testing
			Objects.requireNonNull(label);
			if (labels.containsKey(label)) {
				throw new InvalidLabelSMLInputException();
			}
			labels.put(label, address);
		} catch (NullPointerException e) {
			Main.gracefulExitWithException("Labels with a value of 'null' are not allowed within your SML input file.");
//			System.err.println("Labels with a value of 'null' are not allowed within your SML input file.");
//			System.err.println("Program did not complete successfully.\nEnding program execution.");
//			System.exit(-1);
//			throw new InvalidLabelSMLInputException("Labels with a value of 'null' are not allowed in your SML input file.");
		} catch (InvalidLabelSMLInputException e) {
			Main.gracefulExitWithException("Duplicate labels are not allowed within your SML input file: '" + label + "' has been used as a label two (or more) times.");
////			System.err.println(e.getMessage());
//			System.err.println("Duplicate labels are not allowed within your SML input file: '" + label + "' has been used as a label two (or more) times.");
//			System.err.println("Program did not complete successfully.\nEnding program execution.");
//			System.exit(-1);
//			throw e;
		}
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
//		System.out.println(labels.get(label)); TODO: for testing purposes - remove after testing
		try {
			return labels.get(label);
		} catch (NullPointerException e) {
			Main.gracefulExitWithException("Label '" + label + "' has been used in a 'jnz' instruction but is not found within your SML input file.");
		}
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
		String returnStr = labels.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(e -> e.getKey() + " -> " + e.getValue())
				.collect(Collectors.joining(", ", "[", "]")) ;
		// TODO: Implement the method using the Stream API (see also class Registers).
		return returnStr;
	}

	// TODO: Implement equals and hashCode (needed in class Machine).

	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
