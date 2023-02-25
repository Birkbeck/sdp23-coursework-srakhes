package sml;

import sml.customExceptions.InvalidLabelSMLInputException;

import java.io.IOException;

public class Main {
	/**
	 * Initialises the system and executes the program.
	 *
	 * @param args name of the file containing the program text.
	 */
	public static void main(String... args) {
		if (args.length != 1) {
			gracefulExitWithException("Incorrect number of arguments - Machine <file> - required");
//			System.err.println("Incorrect number of arguments - Machine <file> - required");
//			System.exit(-1);
		}

		try {
			Translator t = new Translator(args[0]);
			Machine m = new Machine(new Registers());
			t.readAndTranslate(m.getLabels(), m.getProgram());

//			TODO: Remove these after testing
//			int maxIntAdd = Integer.MAX_VALUE;
//			int maxIntSub = Integer.MIN_VALUE;
//			System.out.println(Math.addExact(maxIntAdd , 1));
//			System.out.println(Math.subtractExact(maxIntSub , 1));

			System.out.println("Here is the program; it has " + m.getProgram().size() + " instructions.");
			System.out.println(m);
			System.out.println("Beginning program execution.");
			m.execute();
			System.out.println("Ending program execution.");

			System.out.println("Values of registers at program termination:" + m.getRegisters() + ".");
		}
		catch (IOException e) {
			System.out.println("Error reading the program from " + args[0]);
		}
//		catch (InvalidLabelSMLInputException | NullPointerException e) {
//			throw e; // TODO: replace with more meaningful exception description and or handle exceptions where they occur
//		}
	}
	public static void gracefulExitWithException(String message) {
		System.err.println(message);
		System.err.println("Program did not complete successfully.\nEnding program execution.");
		System.exit(-1);
	}
}
