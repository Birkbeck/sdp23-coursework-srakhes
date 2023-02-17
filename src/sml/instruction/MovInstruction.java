package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

public class MovInstruction extends Instruction {
	private final RegisterName result;
	private final Integer source;

	public static final String OP_CODE = "mov";

	public MovInstruction(String label, RegisterName result, Integer source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
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
}
