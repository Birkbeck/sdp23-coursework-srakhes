package sml.instruction;

import org.junit.jupiter.api.*;
import sml.Instruction;
import sml.Labels;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

/**
 * @author Birkbeck College, and Samuel Rakhes
 */
class JnzInstructionTest {
  private Machine machine;
  private Registers registers;

  private Labels label;
  @BeforeEach
  void setUp() {
    machine = new Machine(new Registers());
    registers = machine.getRegisters();
    label = new Labels();
    //...
  }
  @AfterEach
  void tearDown() {
    machine = null;
    registers = null;
    label = null;
  }

  @Nested
  @DisplayName("Test of Valid inputs to the Class JnzInstruction and execution of execute() method")
  class ValidJnzTests {

    @Nested
    @DisplayName("Where the integer stored in register EAX is not equal to zero")
    class ValidJnzTestsRegisterNotZero {
      @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test 1 - Valid String label that exists with a positive integer in register EAX")
      void validJnzTest() {
        registers.set(EAX, 5);
        machine.getLabels().addLabel("f3", 7);
        Instruction instruction = new JnzInstruction(null, EAX, "f3");
        Assertions.assertEquals(7, instruction.execute(machine));
      }

      @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test 2 - Valid String label that exists with a negative integer in register EAX")
      void validJnzTestTwo() {
        registers.set(EAX, -5);
        machine.getLabels().addLabel("x5453", 4);
        Instruction instruction = new JnzInstruction(null, EAX, "x5453");
        Assertions.assertEquals(4, instruction.execute(machine));
      }

      @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test 3 - Valid String label that exists with a positive integer in register EAX")
      void validJnzTestThree() {
        registers.set(EAX, 1235487);
        machine.getLabels().addLabel(" ", 48545);
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Assertions.assertEquals(48545, instruction.execute(machine));
      }
    }

    @Nested
    @DisplayName("Where the integer stored in register EAX is equal to zero")
    class ValidJnzTestsRegisterZero {
      @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test 1 - Valid String label that exists with a zero integer in register EAX")
      void validJnzTest() {
        registers.set(EAX, 0);
        machine.getLabels().addLabel("f3", 7);
        Instruction instruction = new JnzInstruction(null, EAX, "f3");
        Assertions.assertEquals(-1, instruction.execute(machine));
      }

      @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test 2 - Valid String label that exists with a negative integer in register EAX")
      void validJnzTestTwo() {
        registers.set(EAX, 0);
        machine.getLabels().addLabel("x5453", 4);
        Instruction instruction = new JnzInstruction(null, EAX, "x5453");
        Assertions.assertEquals(-1, instruction.execute(machine));
      }

      @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test 3 - Valid String label that exists with a positive integer in register EAX")
      void validJnzTestThree() {
        registers.set(EAX, 0);
        machine.getLabels().addLabel(" ", 48545);
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Assertions.assertEquals(-1, instruction.execute(machine));
      }
    }
  }

  @Nested
  @DisplayName("Test of Valid equal inputs to the Class JnzInstruction and execution of overridden equals() method")
  class ValidEqualsTests {

    @Nested
    @DisplayName("Test of Reflexivity (Against the same instances of JnzInstruction) for the overridden equals() method")
    class ValidReflexivityTests {

//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 1")
      void validReflexiveEquals() {
        Instruction instruction = new JnzInstruction(null, EAX, "f1");
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 2")
      void validReflexiveEqualsTwo() {
        Instruction instruction = new JnzInstruction(null, EAX, "x1");
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 3")
      void validReflexiveEqualsThree() {
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Assertions.assertEquals(instruction, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Symmetry (Against two separate but identical instances of JnzInstruction) for the overridden equals() method")
    class ValidSymmetryTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 1")
      void validSymmetricEquals() {
        Instruction instruction = new JnzInstruction(null, EAX, "m1");
        Instruction instructionTwo = new JnzInstruction(null, EAX, "m1");
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 2")
      void validSymmetricEqualsTwo() {
        Instruction instruction = new JnzInstruction(null, EAX, "t5");
        Instruction instructionTwo = new JnzInstruction(null, EAX, "t5");
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 3")
      void validSymmetricEqualsThree() {
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Instruction instructionTwo = new JnzInstruction(null, EAX, " ");
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Transitivity (Against three separate but identical instances of JnzInstruction) for the overridden equals() method")
    class ValidTransitivityTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 1")
      void validTransitiveEquals() {
        Instruction instruction = new JnzInstruction(null, EAX, "9");
        Instruction instructionTwo = new JnzInstruction(null, EAX, "9");
        Instruction instructionThree = new JnzInstruction(null, EAX, "9");
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 2")
      void validTransitiveEqualsTwo() {
        Instruction instruction = new JnzInstruction(null, EAX, "x51");
        Instruction instructionTwo = new JnzInstruction(null, EAX, "x51");
        Instruction instructionThree = new JnzInstruction(null, EAX, "x51");
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 3")
      void validTransitiveEqualsThree() {
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Instruction instructionTwo = new JnzInstruction(null, EAX, " ");
        Instruction instructionThree = new JnzInstruction(null, EAX, " ");
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }
    }

    @Nested
    @DisplayName("Test that JnzInstruction not equal to null for the overridden equals() method")
    class ValidNonNullTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 1")
      void validNonNullEquals() {
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 2")
      void validNonNullEqualsTwo() {
        Instruction instruction = new JnzInstruction(null, EAX, "t1485");
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 3")
      void validNonNullEqualsThree() {
        Instruction instruction = new JnzInstruction(null, EAX, "f3");
        Assertions.assertNotEquals(instruction, null);
      }
    }
  }

  @Nested
  @DisplayName("Test of Valid Unequal inputs to the Class JnzInstruction and execution of overridden equals() method")
  class ValidNonEqualsTests {
    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 1")
    void validSymmetricUnequal() {
      Instruction instruction = new JnzInstruction(null, EAX, "t5");
      Instruction instructionTwo = new JnzInstruction(null, EBX, "t6");
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 2")
    void validSymmetricEqualsTwo() {
      Instruction instruction = new JnzInstruction(null, EAX, "m1");
      Instruction instructionTwo = new JnzInstruction(null, EBX, " ");
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 3")
    void validSymmetricEqualsThree() {
      Instruction instruction = new JnzInstruction(null, EAX, "0");
      Instruction instructionTwo = new JnzInstruction(null, EBX, " ");
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }
  }
  @Nested
  @DisplayName("Test of Reflexivity, Symmetry and Transitivity (Against three separate but identical instances of JnzInstruction) for the overridden hashCode() method")
  class ValidHashCodeTests {

    @Nested
    @DisplayName("Test of the overridden hashCode() method where JnzInstructions are equal")
    class ValidHashCodeEqualTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Equal HashCode 1")
      void validHashCodeEquals() {
        Instruction instruction = new JnzInstruction(null, EAX, "m8546");
        Instruction instructionTwo = new JnzInstruction(null, EAX, "m8546");
        Instruction instructionThree = new JnzInstruction(null, EAX, "m8546");
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
      @DisplayName("Test Equal HashCode 2")
      void validHashCodeEqualsTwo() {
        Instruction instruction = new JnzInstruction(null, EAX, "x145875");
        Instruction instructionTwo = new JnzInstruction(null, EAX, "x145875");
        Instruction instructionThree = new JnzInstruction(null, EAX, "x145875");
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
      @DisplayName("Test Equal HashCode 3")
      void validHashCodeEqualsThree() {
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Instruction instructionTwo = new JnzInstruction(null, EAX, " ");
        Instruction instructionThree = new JnzInstruction(null, EAX, " ");
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
    @DisplayName("Test of the overridden hashCode() method where JnzInstructions are not equal")
    class ValidHashCodeNotEqualTests {

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Not Equal HashCode 1")
      void validHashCodeNotEquals() {
        Instruction instruction = new JnzInstruction(null, EAX, "t145");
        Instruction instructionTwo = new JnzInstruction(null, EBX, "8546");
        Instruction instructionThree = new JnzInstruction(null, ECX, "m84567");
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
      @DisplayName("Test Not Equal HashCode 2")
      void validHashCodeNotEqualsTwo() {
        Instruction instruction = new JnzInstruction(null, EAX, "h14568");
        Instruction instructionTwo = new JnzInstruction(null, EBX, "8546");
        Instruction instructionThree = new JnzInstruction(null, ECX, "i9154");
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
      @DisplayName("Test Not Equal HashCode 3")
      void validHashCodeNotEqualsThree() {
        Instruction instruction = new JnzInstruction(null, EAX, " ");
        Instruction instructionTwo = new JnzInstruction(null, EBX, "t0");
        Instruction instructionThree = new JnzInstruction(null, ECX, "m45");
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
