package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * Takes input of a single RegisterName and a single int, one 'source' and one 'result' and
 * will store the value of int 'source' in RegisterName 'result'.
 *
 * @author Birkbeck College, and Samuel Rakhes
 */
public class MovInstruction extends Instruction {
	private final RegisterName result;
	private final int source;

	public static final String OP_CODE = "mov";

	public MovInstruction(String label, RegisterName result, int source) { // TODO: Test to see if runtime error is generator if an int larger than int type can hold.
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		m.getRegisters().set(result, source); // TODO: Check if the translator will catch integer overflow - if not then check needs to be created here
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof MovInstruction that) {
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
