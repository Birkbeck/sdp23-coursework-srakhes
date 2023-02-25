package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

import static java.lang.Math.divideExact;

// TODO: write a JavaDoc for the class

/**
 *
 * @author Birkbeck College, and Samuel Rakhes
 */

public class DivInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "div";

	public DivInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		int value2 = m.getRegisters().get(source);
//		m.getRegisters().set(result, value1 / value2);
//		System.out.println("Before: " + value1/value2);
//		System.out.println("Before: " + divideExact(value1, value2));
		System.out.println((value1/value2) == divideExact(value1, value2)); //TODO: catch arithmetic exception and gracefully exit
		m.getRegisters().set(result, divideExact(value1, value2));
		// Will throw and ArithmeticException if over/underflow occur
		// https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Math.html#divideExact(int,int)
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
