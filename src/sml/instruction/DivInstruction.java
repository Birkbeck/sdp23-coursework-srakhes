package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.Main;
import sml.RegisterName;

import java.util.Objects;

import static java.lang.Math.divideExact;

/**
 * Takes input of two RegisterNames , one 'source' and one 'result' and will integer divide the contents of 'result' by 'source'
 * and store the product of both in RegisterName 'result'.
 * ('result' / 'source')
 *
 * @author Birkbeck College, and Samuel Rakhes
 */
public class DivInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "div";

	/**
	 * Takes input of two RegisterNames , one 'source' and one 'result' and will integer divide the contents of 'result' by 'source'
	 *  * and store the product of both in RegisterName 'result'.
	 *  * ('result' / 'source')
	 * @param result - The RegisterName where the product (division of 'result' and 'source') of
	 *                  DivInstruction.execute() method will be stored.
	 * <p>
	 * @param source - The RegisterName whose contents will be the divisor to RegisterName 'result'
	 * <p>
	 * @author Birkbeck College, and Samuel Rakhes
	 */
	public DivInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		try {
			int value1 = m.getRegisters().get(result);
			int value2 = m.getRegisters().get(source);
			m.getRegisters().set(result, divideExact(value1, value2));
			// Will throw and ArithmeticException if over/underflow occur
			// https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Math.html#divideExact(int,int)
		} catch (ArithmeticException e) {
			if (m.getRegisters().get(source) == 0) {
				// Uncomment for Junit Tests
//				throw new ArithmeticException();
				// and comment out the below.
				Main.gracefulExitWithException("The divisor within instruction '" + this + "' must not be zero.");
			}
			Main.gracefulExitWithException("The product of instruction '" + this + "' results in integer over/underflow.");
		}
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof DivInstruction that) {
			return this.result == that.result
					&& this.source == that.source
					&& Objects.equals(this.label, that.label); // null-safe equals must be used
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.result, this.source); //could also multiply result by a prime number
	}
}
