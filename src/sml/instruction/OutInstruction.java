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
	}

	@Override
	public int execute(Machine m) {
		int returnValue = m.getRegisters().get(result);
		System.out.println("Contents of register " + result + ": " + returnValue);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof OutInstruction that) {
			return this.result == that.result
					&& Objects.equals(this.label, that.label); // null-safe equals must be used
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.result); // as this has a single constructor Objects.hashCode() used instead of Objects.hash()
	}
}
