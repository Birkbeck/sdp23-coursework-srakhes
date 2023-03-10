package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * Takes input of a single RegisterName and a single String representing the Label of the next instruction to execute,
 * one 'labelNext' and one 'result' and will return NORMAL_PROGRAM_COUNTER_UPDATE if the contents of the Register
 * representing the new label are equal to zero, otherwise, it will return the element in which the desired instruction
 * resides.
 *
 * @author Birkbeck College, and Samuel Rakhes
 */
public class JnzInstruction extends Instruction {
	private final RegisterName result;
	private final String labelNext;

	public static final String OP_CODE = "jnz";

	/**
	 * Takes input of a single RegisterName and a single String representing the Label of the next instruction to execute,
	 * one 'labelNext' and one 'result' and will return NORMAL_PROGRAM_COUNTER_UPDATE if the contents of the Register
	 * representing the new label are equal to zero, otherwise, it will return the element in which the desired instruction
	 * resides.
	 * @param result - The RegisterName which will be checked if contents are equal to zero.
	 * <p>
	 * @param labelNext - The Label of the desired Instruction to execute if 'result' not equal to zero.
	 * <p>
	 * @author Birkbeck College, and Samuel Rakhes
	 */
	public JnzInstruction(String label, RegisterName result, String labelNext) {
		super(label, OP_CODE);
		this.result = result;
		this.labelNext = labelNext;
	}

	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		if (value1 != 0) {
			int addressNext = m.getLabels().getAddress(labelNext); // label not found error caught in getAddress() method
			System.out.println(addressNext);
			return addressNext;
		}
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + labelNext;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof JnzInstruction that) {
			return this.result == that.result
					&& Objects.equals(this.labelNext, that.labelNext) // null-safe equals must be used
					&& Objects.equals(this.label, that.label); // null-safe equals must be used
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.result, this.labelNext); //could also multiply result by a prime number
	}
}
