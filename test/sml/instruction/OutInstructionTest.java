package sml.instruction;

import org.junit.jupiter.api.*;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static sml.Registers.Register.*;

/**
 * @author Birkbeck College, and Samuel Rakhes
 */
class OutInstructionTest {
  private Machine machine;
  private Registers registers;

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    machine = new Machine(new Registers());
    registers = machine.getRegisters();
    System.setOut(new PrintStream(outputStreamCaptor));
//    Used to test output to console as per below:
//    https://www.baeldung.com/java-testing-system-out-println
  }
  @AfterEach
  void tearDown() {
    machine = null;
    registers = null;
    System.setOut(standardOut);
  }

  @Nested
  @DisplayName("Test of Valid inputs to the Class OutInstruction and execution of execute() method")
  class ValidAdditionTests {

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 1 - A positive integer stored in register EAX")
    void validAdditionTest() {
      registers.set(EAX, 5);
      Instruction instruction = new OutInstruction(null, EAX);
      instruction.execute(machine);
      Assertions.assertEquals("Contents of register 'EAX': 5", outputStreamCaptor.toString()
              .trim());
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 2 - A negative integer stored in register EAX")
    void validAdditionTestTwo() {
      registers.set(EAX, -5);
      Instruction instruction = new OutInstruction(null, EAX);
      instruction.execute(machine);
      Assertions.assertEquals("Contents of register 'EAX': -5", outputStreamCaptor.toString()
              .trim());
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 3 - A zero integer stored in register EAX")
    void validAdditionTestThree() {
      registers.set(EAX, 0);
      Instruction instruction = new OutInstruction(null, EAX);
      instruction.execute(machine);
      Assertions.assertEquals("Contents of register 'EAX': 0", outputStreamCaptor.toString()
              .trim());
    }
  }

  @Nested
  @DisplayName("Test of Valid equal inputs to the Class OutInstruction and execution of overridden equals() method")
  class ValidEqualsTests {

    @Nested
    @DisplayName("Test of Reflexivity (Against the same instances of OutInstruction) for the overridden equals() method")
    class ValidReflexivityTests {

//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 1 - A positive integer stored in register EAX")
      void validReflexiveEquals() {
        registers.set(EAX, 5);
        Instruction instruction = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 2 - A negative integer stored in register EAX")
      void validReflexiveEqualsTwo() {
        registers.set(EAX, -2);
        Instruction instruction = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 3 - A zero integer stored in registers EAX")
      void validReflexiveEqualsThree() {
        registers.set(EAX, 0);
        Instruction instruction = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Symmetry (Against two separate but identical instances of OutInstruction) for the overridden equals() method")
    class ValidSymmetryTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 1 - A positive integer stored in register EAX")
      void validSymmetricEquals() {
        registers.set(EAX, 5);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 2 - A negative integer stored in register EAX")
      void validSymmetricEqualsTwo() {
        registers.set(EAX, -10);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 3 - A zero integer stored in register EAX")
      void validSymmetricEqualsThree() {
        registers.set(EAX, 0);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Transitivity (Against three separate but identical instances of OutInstruction) for the overridden equals() method")
    class ValidTransitivityTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 1 - A positive integer stored in register EAX")
      void validTransitiveEquals() {
        registers.set(EAX, 9);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Instruction instructionThree = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 2 - A negative integer stored in register EAX")
      void validTransitiveEqualsTwo() {
        registers.set(EAX, -52);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Instruction instructionThree = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 3 - A zero integer stored in register EAX")
      void validTransitiveEqualsThree() {
        registers.set(EAX, 0);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Instruction instructionThree = new OutInstruction(null, EAX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }
    }

    @Nested
    @DisplayName("Test that OutInstruction not equal to null for the overridden equals() method")
    class ValidNonNullTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 1 - A positive integer stored in register EAX")
      void validNonNullEquals() {
        registers.set(EAX, 124);
        Instruction instruction = new OutInstruction(null, EAX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 2 - A negative integer stored in register EAX")
      void validNonNullEqualsTwo() {
        registers.set(EAX, -1854);
        Instruction instruction = new OutInstruction(null, EAX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 3 - A zero integer stored in register EAX")
      void validNonNullEqualsThree() {
        registers.set(EAX, 0);
        Instruction instruction = new OutInstruction(null, EAX);
        Assertions.assertNotEquals(instruction, null);
      }
    }
  }

  @Nested
  @DisplayName("Test of Valid Unequal inputs to the Class OutInstruction and execution of overridden equals() method")
  class ValidNonEqualsTests {
    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 1 - A positive integer stored in registers EAX and EBX")
    void validSymmetricUnequal() {
      registers.set(EAX, 956);
      registers.set(EBX, 145);
      Instruction instruction = new OutInstruction(null, EAX);
      Instruction instructionTwo = new OutInstruction(null, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 2 - A negative integer stored in registers EAX and EBX")
    void validSymmetricEqualsTwo() {
      registers.set(EAX, -56956);
      registers.set(EBX, -758145);
      Instruction instruction = new OutInstruction(null, EAX);
      Instruction instructionTwo = new OutInstruction(null, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 3 - A zero integer stored in registers EAX and EBX")
    void validSymmetricEqualsThree() {
      registers.set(EAX, 0);
      registers.set(EBX, 0);
      Instruction instruction = new OutInstruction(null, EAX);
      Instruction instructionTwo = new OutInstruction(null, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }
  }
  @Nested
  @DisplayName("Test of Reflexivity, Symmetry and Transitivity (Against three separate but identical instances of OutInstruction) for the overridden hashCode() method")
  class ValidHashCodeTests {

    @Nested
    @DisplayName("Test of the overridden hashCode() method where OutInstructions are equal")
    class ValidHashCodeEqualTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Equal HashCode 1 - A positive integer stored in register EAX")
      void validHashCodeEquals() {
        registers.set(EAX, 956841);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Instruction instructionThree = new OutInstruction(null, EAX);
        // Reflexivity
        Assertions.assertEquals(instruction, instruction);
        Assertions.assertEquals(instructionTwo, instructionTwo);
        Assertions.assertEquals(instructionThree, instructionThree);
        Assertions.assertEquals(instruction.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instructionThree.hashCode());
        // Symmetry
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
        Assertions.assertEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instruction, instructionThree);
        Assertions.assertEquals(instructionThree, instruction);
        Assertions.assertEquals(instruction.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instructionThree, instructionTwo);
        Assertions.assertEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instructionTwo.hashCode());
        // Transitivity
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
        Assertions.assertEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instruction.hashCode(), instructionThree.hashCode());
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Equal HashCode 2 - A negative integer stored in register EAX")
      void validHashCodeEqualsTwo() {
        registers.set(EAX, -56956841);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Instruction instructionThree = new OutInstruction(null, EAX);
        // Reflexivity
        Assertions.assertEquals(instruction, instruction);
        Assertions.assertEquals(instructionTwo, instructionTwo);
        Assertions.assertEquals(instructionThree, instructionThree);
        Assertions.assertEquals(instruction.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instructionThree.hashCode());
        // Symmetry
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
        Assertions.assertEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instruction, instructionThree);
        Assertions.assertEquals(instructionThree, instruction);
        Assertions.assertEquals(instruction.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instructionThree, instructionTwo);
        Assertions.assertEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instructionTwo.hashCode());
        // Transitivity
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
        Assertions.assertEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instruction.hashCode(), instructionThree.hashCode());
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Equal HashCode 3 - A zero integer stored in register EAX")
      void validHashCodeEqualsThree() {
        registers.set(EAX, 0);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EAX);
        Instruction instructionThree = new OutInstruction(null, EAX);
        // Reflexivity
        Assertions.assertEquals(instruction, instruction);
        Assertions.assertEquals(instructionTwo, instructionTwo);
        Assertions.assertEquals(instructionThree, instructionThree);
        Assertions.assertEquals(instruction.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instructionThree.hashCode());
        // Symmetry
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
        Assertions.assertEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instruction, instructionThree);
        Assertions.assertEquals(instructionThree, instruction);
        Assertions.assertEquals(instruction.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instruction.hashCode());
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instructionThree, instructionTwo);
        Assertions.assertEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instructionThree.hashCode(), instructionTwo.hashCode());
        // Transitivity
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
        Assertions.assertEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertEquals(instruction.hashCode(), instructionThree.hashCode());
      }
    }

    @Nested
    @DisplayName("Test of the overridden hashCode() method where OutInstructions are not equal")
    class ValidHashCodeNotEqualTests {

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Not Equal HashCode 1 - A positive integer stored in registers EAX, EBX and ECX")
      void validHashCodeNotEquals() {
        registers.set(EAX, 956841);
        registers.set(EBX, 1456);
        registers.set(ECX, 23);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EBX);
        Instruction instructionThree = new OutInstruction(null, ECX);
        // Symmetry
        Assertions.assertNotEquals(instruction, instructionTwo);
        Assertions.assertNotEquals(instructionTwo, instruction);
        Assertions.assertNotEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertNotEquals(instructionTwo.hashCode(), instruction.hashCode());
        Assertions.assertNotEquals(instruction, instructionThree);
        Assertions.assertNotEquals(instructionThree, instruction);
        Assertions.assertNotEquals(instruction.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instructionThree.hashCode(), instruction.hashCode());
        Assertions.assertNotEquals(instructionTwo, instructionThree);
        Assertions.assertNotEquals(instructionThree, instructionTwo);
        Assertions.assertNotEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instructionThree.hashCode(), instructionTwo.hashCode());
        // Transitivity
        Assertions.assertNotEquals(instruction, instructionTwo);
        Assertions.assertNotEquals(instructionTwo, instructionThree);
        Assertions.assertNotEquals(instruction, instructionThree);
        Assertions.assertNotEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertNotEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instruction.hashCode(), instructionThree.hashCode());
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Not Equal HashCode 2 - A negative integer stored in registers EAX, EBX and ECX")
      void validHashCodeNotEqualsTwo() {
        registers.set(EAX, -9561841);
        registers.set(EBX, -14516);
        registers.set(ECX, -213);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EBX);
        Instruction instructionThree = new OutInstruction(null, ECX);
        // Symmetry
        Assertions.assertNotEquals(instruction, instructionTwo);
        Assertions.assertNotEquals(instructionTwo, instruction);
        Assertions.assertNotEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertNotEquals(instructionTwo.hashCode(), instruction.hashCode());
        Assertions.assertNotEquals(instruction, instructionThree);
        Assertions.assertNotEquals(instructionThree, instruction);
        Assertions.assertNotEquals(instruction.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instructionThree.hashCode(), instruction.hashCode());
        Assertions.assertNotEquals(instructionTwo, instructionThree);
        Assertions.assertNotEquals(instructionThree, instructionTwo);
        Assertions.assertNotEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instructionThree.hashCode(), instructionTwo.hashCode());
        // Transitivity
        Assertions.assertNotEquals(instruction, instructionTwo);
        Assertions.assertNotEquals(instructionTwo, instructionThree);
        Assertions.assertNotEquals(instruction, instructionThree);
        Assertions.assertNotEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertNotEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instruction.hashCode(), instructionThree.hashCode());
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Not Equal HashCode 3 - Two zero integer stored in registers EAX, EBX and ECX")
      void validHashCodeNotEqualsThree() {
        registers.set(EAX, 0);
        registers.set(EBX, 0);
        registers.set(ECX, 0);
        Instruction instruction = new OutInstruction(null, EAX);
        Instruction instructionTwo = new OutInstruction(null, EBX);
        Instruction instructionThree = new OutInstruction(null, ECX);
        // Symmetry
        Assertions.assertNotEquals(instruction, instructionTwo);
        Assertions.assertNotEquals(instructionTwo, instruction);
        Assertions.assertNotEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertNotEquals(instructionTwo.hashCode(), instruction.hashCode());
        Assertions.assertNotEquals(instruction, instructionThree);
        Assertions.assertNotEquals(instructionThree, instruction);
        Assertions.assertNotEquals(instruction.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instructionThree.hashCode(), instruction.hashCode());
        Assertions.assertNotEquals(instructionTwo, instructionThree);
        Assertions.assertNotEquals(instructionThree, instructionTwo);
        Assertions.assertNotEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instructionThree.hashCode(), instructionTwo.hashCode());
        // Transitivity
        Assertions.assertNotEquals(instruction, instructionTwo);
        Assertions.assertNotEquals(instructionTwo, instructionThree);
        Assertions.assertNotEquals(instruction, instructionThree);
        Assertions.assertNotEquals(instruction.hashCode(), instructionTwo.hashCode());
        Assertions.assertNotEquals(instructionTwo.hashCode(), instructionThree.hashCode());
        Assertions.assertNotEquals(instruction.hashCode(), instructionThree.hashCode());
      }
    }
  }
}
