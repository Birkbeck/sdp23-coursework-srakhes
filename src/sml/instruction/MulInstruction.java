package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.Main;
import sml.RegisterName;

import java.util.Objects;

import static java.lang.Math.multiplyExact;

/**
 * Takes input of two RegisterNames , one 'source' and one 'result' and will multiply the contents of 'source' and 'result'
 * and store the product of both in RegisterName 'result'.
 *
 * @author Birkbeck College, and Samuel Rakhes
 */
public class MulInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "mul";

	/**
	 * Takes input of two RegisterNames , one 'source' and one 'result' and will multiply the contents of source by results
	 * and store the product of both in RegisterName 'source'
	 * @param result - The RegisterName where the product (multiplication of 'result' and 'source') of
	 *                  MulInstruction.execute() method will be stored.
	 * <p>
	 * @param source - The RegisterName whose contents will be multiplied by RegisterName 'result'
	 * <p>
	 * @author Birkbeck College, and Samuel Rakhes
	 */
	public MulInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		try {
			int value1 = m.getRegisters().get(result);
			int value2 = m.getRegisters().get(source);
			m.getRegisters().set(result, multiplyExact(value1, value2));
			// Will throw and ArithmeticException if over/underflow occur
			// https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Math.html#multiplyExact(int,int)
		} catch (ArithmeticException e) {
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
		if (o instanceof MulInstruction that) {
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
