package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.Main;
import sml.RegisterName;

import java.util.Objects;

import static java.lang.Math.subtractExact;

/**
 * Takes input of two RegisterNames , one 'source' and one 'result' and will subtract the contents of 'source' from 'result'
 * and store the product of both in RegisterName 'result'.
 *
 * @author Birkbeck College, and Samuel Rakhes
 */
public class SubInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "sub";

	/**
	 * Takes input of two RegisterNames , one 'source' and one 'result' and will subtract the contents of 'source' from 'result'
	 * and store the product of both in RegisterName 'result'.
	 * @param result - The RegisterName where the product (subtraction of 'source' from 'result') of
	 *                  SubInstruction.execute() method will be stored.
	 * <p>
	 * @param source - The RegisterName whose contents will be subtracted from RegisterName 'result'
	 * <p>
	 * @author Birkbeck College, and Samuel Rakhes
	 */
	public SubInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		try {
			int value1 = m.getRegisters().get(result);
			int value2 = m.getRegisters().get(source);
			m.getRegisters().set(result, subtractExact(value1, value2));
			// Will throw and ArithmeticException if over/underflow occur
			// https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Math.html#subtractExact(int,int)
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
		if (o instanceof SubInstruction that) {
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
