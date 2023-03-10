package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * Takes input of one RegisterName and will output the product of the register to console (System.out).
 *
 * @author Birkbeck College, and Samuel Rakhes
 */
public class OutInstruction extends Instruction {
	private final RegisterName result;

	public static final String OP_CODE = "out";

	/**
	 * Takes input of one RegisterName and will output the product of the register to console (System.out).
	 * @param result - The RegisterName whose contents will be output to console (System.out).
	 * <p>
	 * @author Birkbeck College, and Samuel Rakhes
	 */
	public OutInstruction(String label, RegisterName result) {
		super(label, OP_CODE);
		this.result = result;
	}

	@Override
	public int execute(Machine m) {
		int returnValue = m.getRegisters().get(result);
		System.out.println("Contents of register '" + result + "': " + returnValue);
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
		// TODO: check if this.label could also be used to generate hashcode
	}
}
