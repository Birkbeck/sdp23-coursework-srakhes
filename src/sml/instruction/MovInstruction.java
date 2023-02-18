package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * @author Birkbeck College, and Samuel Rakhes
 */

public class MovInstruction extends Instruction {
	private final RegisterName result;
	private final Integer source;

	public static final String OP_CODE = "mov";

	public MovInstruction(String label, RegisterName result, Integer source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source; //possibly rename this to prevent ambiguity with other register-based variables.
	}

	@Override
	public int execute(Machine m) {
//		int value1 = m.getRegisters().get(result);
//		int value2 = m.getRegisters().get(source);
		m.getRegisters().set(result, source);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; } // TODO: this may not be necessary - reread notes and omit if not needed!
		if (o instanceof MovInstruction that) {
			return this.result == that.result
					&& this.source == that.source
					&& this.opcode == that.opcode;
		}
		return false;
	}
	//	TODO: Override hashCode
	@Override
	public int hashCode() {
		return Objects.hash(this.result, this.source);
	}
}
