package sml.instruction;

import org.junit.jupiter.api.*;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;
import static sml.Registers.Register.ECX;

/**
 * @author Birkbeck College, and Samuel Rakhes
 */
class MovInstructionTest {
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

  @Nested
  @DisplayName("Test of Valid inputs to the Class MovInstruction and execution of execute() method")
  class ValidAdditionTests {

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 1 - A positive integer stored in register EAX")
    void validAdditionTest() {
      Instruction instruction = new MovInstruction(null, EAX, 5);
      instruction.execute(machine);
      Assertions.assertEquals(5, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 2 - A negative integer stored in register EAX")
    void validAdditionTestTwo() {
      Instruction instruction = new MovInstruction(null, EAX, -5);
      instruction.execute(machine);
      Assertions.assertEquals(-5, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 3 - A zero integer stored in register EAX")
    void validAdditionTestThree() {
      Instruction instruction = new MovInstruction(null, EAX, 0);
      instruction.execute(machine);
      Assertions.assertEquals(0, machine.getRegisters().get(EAX));
    }
  }

  @Nested
  @DisplayName("Test of Valid equal inputs to the Class MovInstruction and execution of overridden equals() method")
  class ValidEqualsTests {

    @Nested
    @DisplayName("Test of Reflexivity (Against the same instances of MovInstruction) for the overridden equals() method")
    class ValidReflexivityTests {

//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 1 - A positive integer stored in register EAX")
      void validReflexiveEquals() {
        Instruction instruction = new MovInstruction(null, EAX, 5);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 2 - A negative integer stored in register EAX")
      void validReflexiveEqualsTwo() {
        Instruction instruction = new MovInstruction(null, EAX, -2);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 3 - A zero integer stored in registers EAX")
      void validReflexiveEqualsThree() {
        Instruction instruction = new MovInstruction(null, EAX, 0);
        Assertions.assertEquals(instruction, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Symmetry (Against two separate but identical instances of MovInstruction) for the overridden equals() method")
    class ValidSymmetryTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 1 - A positive integer stored in register EAX")
      void validSymmetricEquals() {
        Instruction instruction = new MovInstruction(null, EAX, 5);
        Instruction instructionTwo = new MovInstruction(null, EAX, 5);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 2 - A negative integer stored in register EAX")
      void validSymmetricEqualsTwo() {
        Instruction instruction = new MovInstruction(null, EAX, -10);
        Instruction instructionTwo = new MovInstruction(null, EAX, -10);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 3 - A zero integer stored in register EAX")
      void validSymmetricEqualsThree() {
        Instruction instruction = new MovInstruction(null, EAX, 0);
        Instruction instructionTwo = new MovInstruction(null, EAX, 0);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Transitivity (Against three separate but identical instances of MovInstruction) for the overridden equals() method")
    class ValidTransitivityTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 1 - A positive integer stored in register EAX")
      void validTransitiveEquals() {
        Instruction instruction = new MovInstruction(null, EAX, 9);
        Instruction instructionTwo = new MovInstruction(null, EAX, 9);
        Instruction instructionThree = new MovInstruction(null, EAX, 9);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 2 - A negative integer stored in register EAX")
      void validTransitiveEqualsTwo() {
        Instruction instruction = new MovInstruction(null, EAX, -51);
        Instruction instructionTwo = new MovInstruction(null, EAX, -51);
        Instruction instructionThree = new MovInstruction(null, EAX, -51);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 3 - A zero integer stored in register EAX")
      void validTransitiveEqualsThree() {
        Instruction instruction = new MovInstruction(null, EAX, 0);
        Instruction instructionTwo = new MovInstruction(null, EAX, 0);
        Instruction instructionThree = new MovInstruction(null, EAX, 0);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }
    }

    @Nested
    @DisplayName("Test that MovInstruction not equal to null for the overridden equals() method")
    class ValidNonNullTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 1 - A positive integer stored in register EAX")
      void validNonNullEquals() {
        Instruction instruction = new MovInstruction(null, EAX, 124);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 2 - A negative integer stored in register EAX")
      void validNonNullEqualsTwo() {
        Instruction instruction = new MovInstruction(null, EAX, -1485);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 3 - A zero integer stored in register EAX")
      void validNonNullEqualsThree() {
        Instruction instruction = new MovInstruction(null, EAX, 0);
        Assertions.assertNotEquals(instruction, null);
      }
    }
  }

  @Nested
  @DisplayName("Test of Valid Unequal inputs to the Class MovInstruction and execution of overridden equals() method")
  class ValidNonEqualsTests {
    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 1 - A positive integer stored in registers EAX and EBX")
    void validSymmetricUnequal() {
      Instruction instruction = new MovInstruction(null, EAX, 145);
      Instruction instructionTwo = new MovInstruction(null, EBX, 9854);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 2 - A negative integer stored in registers EAX and EBX")
    void validSymmetricEqualsTwo() {
      Instruction instruction = new MovInstruction(null, EAX, -1485);
      Instruction instructionTwo = new MovInstruction(null, EBX, -14586);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 3 - A zero integer stored in registers EAX and EBX")
    void validSymmetricEqualsThree() {
      Instruction instruction = new MovInstruction(null, EAX, 0);
      Instruction instructionTwo = new MovInstruction(null, EBX, 0);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }
  }
  @Nested
  @DisplayName("Test of Reflexivity, Symmetry and Transitivity (Against three separate but identical instances of MovInstruction) for the overridden hashCode() method")
  class ValidHashCodeTests {

    @Nested
    @DisplayName("Test of the overridden hashCode() method where MovInstructions are equal")
    class ValidHashCodeEqualTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Equal HashCode 1 - A positive integer stored in register EAX")
      void validHashCodeEquals() {
        Instruction instruction = new MovInstruction(null, EAX, 8546);
        Instruction instructionTwo = new MovInstruction(null, EAX, 8546);
        Instruction instructionThree = new MovInstruction(null, EAX, 8546);
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
        Instruction instruction = new MovInstruction(null, EAX, -145875);
        Instruction instructionTwo = new MovInstruction(null, EAX, -145875);
        Instruction instructionThree = new MovInstruction(null, EAX, -145875);
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
        Instruction instruction = new MovInstruction(null, EAX, 0);
        Instruction instructionTwo = new MovInstruction(null, EAX, 0);
        Instruction instructionThree = new MovInstruction(null, EAX, 0);
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
    @DisplayName("Test of the overridden hashCode() method where MovInstructions are not equal")
    class ValidHashCodeNotEqualTests {

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Not Equal HashCode 1 - A positive integer stored in registers EAX, EBX and ECX")
      void validHashCodeNotEquals() {
        Instruction instruction = new MovInstruction(null, EAX, 145);
        Instruction instructionTwo = new MovInstruction(null, EBX, 8546);
        Instruction instructionThree = new MovInstruction(null, ECX, 84567);
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
        Instruction instruction = new MovInstruction(null, EAX, -14568);
        Instruction instructionTwo = new MovInstruction(null, EBX, -8546);
        Instruction instructionThree = new MovInstruction(null, ECX, -9154);
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
        Instruction instruction = new MovInstruction(null, EAX, 0);
        Instruction instructionTwo = new MovInstruction(null, EBX, 0);
        Instruction instructionThree = new MovInstruction(null, ECX, 0);
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
