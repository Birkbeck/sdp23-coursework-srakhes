package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 *
 *
 *
 *
 * @author Birkbeck College, and Samuel Rakhes
 */

public class AddInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "add";

	public AddInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		int value2 = m.getRegisters().get(source);
		m.getRegisters().set(result, value1 + value2);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}

	//	TODO: Override equals
	@Override
	public boolean equals(Object o) {
//		if (o == this) {
//			return true;
//		}
//		if (!(o instanceof AddInstruction)) {
//			return false;
//		}
//		if (o == null) {
//			return false;
//		}
//		AddInstruction oCast = (AddInstruction) o; // add a try catch block to catch cast error and return false.
//		if (this == o) { return true; } // TODO: this may not be necessary - reread notes and omit if not needed!
		if (o instanceof AddInstruction that) {
			return this.result == that.result
					&& this.source == that.source
					&& Objects.equals(this.label, that.label); // null-safe equals must be used
		}
		return false;
	}
	//	TODO: Override hashCode
	@Override
	public int hashCode() {
		return Objects.hash(this.result, this.source); //could also multiply result by a prime number
	}
}
