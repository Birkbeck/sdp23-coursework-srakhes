package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

import static java.lang.Math.multiplyExact;

// TODO: write a JavaDoc for the class

/**
 *
 * @author Birkbeck College, and Samuel Rakhes
 */

public class OutInstruction extends Instruction {
	private final RegisterName result;
//	private final RegisterName source;

	public static final String OP_CODE = "out";

	public OutInstruction(String label, RegisterName result) {
		super(label, OP_CODE);
		this.result = result;
//		this.source = source;
	}

	@Override
	public int execute(Machine m) {
//		int value1 = m.getRegisters().get(result);
//		int value2 = m.getRegisters().get(source);
////		m.getRegisters().set(result, value1 * value2);
//		m.getRegisters().set(result, multiplyExact(value1, value2));
		// Will throw and ArithmeticException if over/underflow occur
		// https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Math.html#multiplyExact(int,int)
		System.out.println(m.getRegisters().toString());
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result;
	}
//	public String toString() {
//		return getLabelString() + getOpcode() + " " + result + " " + source;
//	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof OutInstruction that) {
			return this.result == that.result
//					&& this.source == that.source
					&& Objects.equals(this.label, that.label); // null-safe equals must be used
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.result); // as this has a single constructor Objects.hashCode() used instead of Objects.hash()
	}
//	public int hashCode() {
//		return Objects.hash(this.result, this.source); //could also multiply result by a prime number
//	}
}
