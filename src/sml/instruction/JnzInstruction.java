package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 *
 * @author Birkbeck College, and Samuel Rakhes
 */

public class JnzInstruction extends Instruction {
	private final RegisterName result;
	private final String labelNext;

	public static final String OP_CODE = "jnz";

	public JnzInstruction(String label, RegisterName result, String labelNext) {
		super(label, OP_CODE);
		this.result = result;
//		this.source = source;
		this.labelNext = labelNext;
	}

	@Override
	public int execute(Machine m) {
		// TODO: Get the value of Register
		// TODO: If not equal to zero...
		// TODO: Find labelNext in the Labels HashMap and retrieve its 'address'
		// TODO: Use this address to update program counter
		// TODO: otherwise return normal program counter update
//		try {
		int value1 = m.getRegisters().get(result);
		if (value1 != 0) {
//			int address = m.getLabels().getAddress(label);
//			System.out.println(address);
			int addressNext = m.getLabels().getAddress(labelNext); //TODO: label not found error caught in getAddress() method
			System.out.println(addressNext);
			return addressNext;
		}
//		} catch (InvalidSMLInputException e) {
//			System.err.println(e.getMessage());
//			System.exit(-1);
////			throw e;
//		}

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
