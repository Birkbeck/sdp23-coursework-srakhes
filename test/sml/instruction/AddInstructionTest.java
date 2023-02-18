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

  @Test
  @DisplayName("Test of AddInstruction overridden equals() method with two identical instances of AddInstruction")
  void executeValidFive() {
    registers.set(EAX, 1);
    registers.set(EBX, 2);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    Assertions.assertEquals(true, instruction.equals(instruction));
  }

  @Test
  @DisplayName("Test of AddInstruction overridden equals() method with two identical but separate instances of AddInstruction")
  void executeValidSix() {
    registers.set(EAX, 1);
    registers.set(EBX, 2);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    Instruction instructionCopy = new AddInstruction(null, EAX, EBX);
    Assertions.assertEquals(true, instruction.equals(instructionCopy));
  }

  @Test
  @DisplayName("Test of AddInstruction overridden equals() method with two different instances of AddInstruction")
  void executeValidSeven() {
    registers.set(EAX, 1);
    registers.set(EBX, 2);
    registers.set(ECX, 3);
    registers.set(EDX, 4);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    Instruction instructionDiff = new AddInstruction(null, ECX, EDX);
    Assertions.assertEquals(false, instruction.equals(instructionDiff));
  }

  @Test
  @DisplayName("Test of AddInstruction overridden hashCode() method with two identical but separate instances of AddInstruction")
  void executeValidEight() {
    registers.set(EAX, 1);
    registers.set(EBX, 2);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    Instruction instructionCopy = new AddInstruction(null, EAX, EBX);
    Assertions.assertEquals(true, instruction.hashCode() == instructionCopy.hashCode());
  }

  @Test
  @DisplayName("Test of AddInstruction overridden equals() method with two different instances of AddInstruction")
  void executeValidNine() {
    registers.set(EAX, 1);
    registers.set(EBX, 2);
    registers.set(ECX, 3);
    registers.set(EDX, 4);
    Instruction instruction = new AddInstruction(null, EAX, EBX);
    Instruction instructionDiff = new AddInstruction(null, ECX, EDX);
    Assertions.assertEquals(false, instruction.hashCode() == instructionDiff.hashCode());
  }
}