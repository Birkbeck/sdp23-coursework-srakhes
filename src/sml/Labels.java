package sml;

import sml.customExceptions.InvalidLabelSMLInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Takes an input of a string 'label'. Labels are used to identify instructions within the SML file.
 * A label must be unique, no two instructions can be instantiated with the same label and the SML
 * program complete.
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
		try {
			Objects.requireNonNull(label);
			if (labels.containsKey(label)) {
				throw new InvalidLabelSMLInputException();
			}
			labels.put(label, address);
		} catch (NullPointerException e) {
			Main.gracefulExitWithException("Labels with a value of 'null' are not allowed within your SML input file.");
		} catch (InvalidLabelSMLInputException e) {
			Main.gracefulExitWithException("Duplicate labels are not allowed within your SML input file: '" + label + "' has been used as a label two (or more) times.");
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

	@Override
	public boolean equals(Object o) {
		// https://docs.oracle.com/en/java/javase/14/language/pattern-matching-instanceof-operator.html
		if (o instanceof Labels that) {
			return this.labels == that.labels;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(labels);
	}


	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
