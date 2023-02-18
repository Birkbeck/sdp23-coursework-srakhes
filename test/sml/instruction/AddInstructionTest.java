package sml.instruction;

import org.junit.jupiter.api.*;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

class AddInstructionTest {
  private Machine machine;
  private Registers registers;

  @BeforeEach
  void setUp() {
    machine = new Machine(new Registers());
    registers = machine.getRegisters();
    //...
  }

  @AfterEach
  void tearDown() {
    machine = null;
    registers = null;
  }

  @Test
  @DisplayName("Test of AddInstruction with two positive integers stored in registers EAX and EBX")
  void executeValid() {
    registers.set(EAX, 5);
    registers.set(EBX, 6);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(11, machine.getRegisters().get(EAX));
  }

  @Test
  @DisplayName("Test of AddInstruction with a positive and negative integer stored in registers EAX and EBX")
  void executeValidTwo() {
    registers.set(EAX, -5);
    registers.set(EBX, 6);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(1, machine.getRegisters().get(EAX));
  }

  @Test
  @DisplayName("Test of AddInstruction with two negative integers stored in registers EAX and EBX")
  void executeValidThree() {
    registers.set(EAX, -5);
    registers.set(EBX, -5);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(-10, machine.getRegisters().get(EAX));
  }

  @Test
  @DisplayName("Test of AddInstruction with two zero integers stored in registers EAX and EBX")
  void executeValidFour() {
    registers.set(EAX, 0);
    registers.set(EBX, 0);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(0, machine.getRegisters().get(EAX));
  }
}