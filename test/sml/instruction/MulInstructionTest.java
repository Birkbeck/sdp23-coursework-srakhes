package sml.instruction;

import org.junit.jupiter.api.*;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

/**
 * @author Birkbeck College, and Samuel Rakhes
 */
class MulInstructionTest {
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
  @DisplayName("Test of Valid inputs to the Class MulInstruction and execution of execute() method")
  class ValidMultiplicationTests {

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 1 - Two positive integers stored in registers EAX and EBX")
    void validMultiplicationTest() {
      registers.set(EAX, 5);
      registers.set(EBX, 6);
      Instruction instruction = new MulInstruction(null, EAX, EBX);
      instruction.execute(machine);
      Assertions.assertEquals(30, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 2 - Two negative integers stored in registers EAX and EBX")
    void validMultiplicationTestTwo() {
      registers.set(EAX, -5);
      registers.set(EBX, -5);
      Instruction instruction = new MulInstruction(null, EAX, EBX);
      instruction.execute(machine);
      Assertions.assertEquals(25, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 3 - Two zero integers stored in registers EAX and EBX")
    void validMultiplicationTestThree() {
      registers.set(EAX, 0);
      registers.set(EBX, 0);
      Instruction instruction = new MulInstruction(null, EAX, EBX);
      instruction.execute(machine);
      Assertions.assertEquals(0, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 4 - A negative and positive integer stored in registers EAX and EBX")
    void validMultiplicationTestFour() {
      registers.set(EAX, -5);
      registers.set(EBX, 6);
      Instruction instruction = new MulInstruction(null, EAX, EBX);
      instruction.execute(machine);
      Assertions.assertEquals(-30, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 5 - A positive and negative integer stored in registers EAX and EBX")
    void validMultiplicationTestFive() {
      registers.set(EAX, 5);
      registers.set(EBX, -6);
      Instruction instruction = new MulInstruction(null, EAX, EBX);
      instruction.execute(machine);
      Assertions.assertEquals(-30, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 6 - A positive and zero integer stored in registers EAX and EBX")
    void validMultiplicationTestSix() {
      registers.set(EAX, 5);
      registers.set(EBX, 0);
      Instruction instruction = new MulInstruction(null, EAX, EBX);
      instruction.execute(machine);
      Assertions.assertEquals(0, machine.getRegisters().get(EAX));
    }

    @Test
//    @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test 7 - A negative and zero integer stored in registers EAX and EBX")
    void validMultiplicationTestSeven() {
      registers.set(EAX, 0);
      registers.set(EBX, -6);
      Instruction instruction = new MulInstruction(null, EAX, EBX);
      instruction.execute(machine);
      Assertions.assertEquals(0, machine.getRegisters().get(EAX));
    }
  }

  @Nested
  @DisplayName("Test of Valid equal inputs to the Class MulInstruction and execution of overridden equals() method")
  class ValidEqualsTests {

    @Nested
    @DisplayName("Test of Reflexivity (Against the same instances of MulInstruction) for the overridden equals() method")
    class ValidReflexivityTests {

//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 1 - Two positive integers stored in registers EAX and EBX")
      void validReflexiveEquals() {
        registers.set(EAX, 1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 2 - Two negative integers stored in registers EAX and EBX")
      void validReflexiveEqualsTwo() {
        registers.set(EAX, -1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 3 - Two zero integers stored in registers EAX and EBX")
      void validReflexiveEqualsThree() {
        registers.set(EAX, 0);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 4 - A negative and positive integer stored in registers EAX and EBX")
      void validReflexiveEqualsFour() {
        registers.set(EAX, -1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 5 - A positive and negative integer stored in registers EAX and EBX")
      void validReflexiveEqualsFive() {
        registers.set(EAX, 1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 6 - A positive and zero integer stored in registers EAX and EBX")
      void validReflexiveEqualsSix() {
        registers.set(EAX, 1);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Reflexivity 7 - A negative and zero integer stored in registers EAX and EBX")
      void validReflexiveEqualsSeven() {
        registers.set(EAX, 0);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Symmetry (Against two separate but identical instances of MulInstruction) for the overridden equals() method")
    class ValidSymmetryTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 1 - Two positive integers stored in registers EAX and EBX")
      void validSymmetricEquals() {
        registers.set(EAX, 1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 2 - Two negative integers stored in registers EAX and EBX")
      void validSymmetricEqualsTwo() {
        registers.set(EAX, -1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 3 - Two zero integers stored in registers EAX and EBX")
      void validSymmetricEqualsThree() {
        registers.set(EAX, 0);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 4 - A negative and positive integer stored in registers EAX and EBX")
      void validSymmetricEqualsFour() {
        registers.set(EAX, -1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 5 - A positive and negative integer stored in registers EAX and EBX")
      void validSymmetricEqualsFive() {
        registers.set(EAX, 1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 6 - A positive and zero integer stored in registers EAX and EBX")
      void validSymmetricEqualsSix() {
        registers.set(EAX, 1);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Symmetry 7 - A negative and zero integer stored in registers EAX and EBX")
      void validSymmetricEqualsSeven() {
        registers.set(EAX, 0);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instruction);
      }
    }

    @Nested
    @DisplayName("Test of Transitivity (Against three separate but identical instances of MulInstruction) for the overridden equals() method")
    class ValidTransitivityTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 1 - Two positive integers stored in registers EAX and EBX")
      void validTransitiveEquals() {
        registers.set(EAX, 1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 2 - Two negative integers stored in registers EAX and EBX")
      void validTransitiveEqualsTwo() {
        registers.set(EAX, -1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 3 - Two zero integers stored in registers EAX and EBX")
      void validTransitiveEqualsThree() {
        registers.set(EAX, 0);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 4 - A negative and positive integer stored in registers EAX and EBX")
      void validTransitiveEqualsFour() {
        registers.set(EAX, -1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 5 - A positive and negative integer stored in registers EAX and EBX")
      void validTransitiveEqualsFive() {
        registers.set(EAX, 1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 6 - A positive and zero integer stored in registers EAX and EBX")
      void validTransitiveEqualsSix() {
        registers.set(EAX, 1);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Transitivity 7 - A negative and zero integer stored in registers EAX and EBX")
      void validTransitiveEqualsSeven() {
        registers.set(EAX, 0);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
        Assertions.assertEquals(instruction, instructionTwo);
        Assertions.assertEquals(instructionTwo, instructionThree);
        Assertions.assertEquals(instruction, instructionThree);
      }
    }

    @Nested
    @DisplayName("Test that MulInstruction not equal to null for the overridden equals() method")
    class ValidNonNullTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 1 - Two positive integers stored in registers EAX and EBX")
      void validNonNullEquals() {
        registers.set(EAX, 1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 2 - Two negative integers stored in registers EAX and EBX")
      void validNonNullEqualsTwo() {
        registers.set(EAX, -1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 3 - Two zero integers stored in registers EAX and EBX")
      void validNonNullEqualsThree() {
        registers.set(EAX, 0);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 4 - A negative and positive integer stored in registers EAX and EBX")
      void validNonNullEqualsFour() {
        registers.set(EAX, -1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 5 - A positive and negative integer stored in registers EAX and EBX")
      void validNonNullEqualsFive() {
        registers.set(EAX, 1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 6 - A positive and zero integer stored in registers EAX and EBX")
      void validNonNullEqualsSix() {
        registers.set(EAX, 1);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertNotEquals(instruction, null);
      }

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Non-Null 7 - A negative and zero integer stored in registers EAX and EBX")
      void validNonNullEqualsSeven() {
        registers.set(EAX, 0);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Assertions.assertNotEquals(instruction, null);
      }
    }
  }

  @Nested
  @DisplayName("Test of Valid Unequal inputs to the Class MulInstruction and execution of overridden equals() method")
  class ValidNonEqualsTests {
    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 1 - Two positive integers stored in registers EAX and EBX")
    void validSymmetricUnequal() {
      registers.set(EAX, 1);
      registers.set(EBX, 2);
      Instruction instruction = new MulInstruction(null, EAX, EAX);
      Instruction instructionTwo = new MulInstruction(null, EBX, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 2 - Two negative integers stored in registers EAX and EBX")
    void validSymmetricEqualsTwo() {
      registers.set(EAX, -1);
      registers.set(EBX, -2);
      Instruction instruction = new MulInstruction(null, EAX, EAX);
      Instruction instructionTwo = new MulInstruction(null, EBX, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 3 - Two zero integers stored in registers EAX and EBX")
    void validSymmetricEqualsThree() {
      registers.set(EAX, 0);
      registers.set(EBX, 0);
      Instruction instruction = new MulInstruction(null, EAX, EAX);
      Instruction instructionTwo = new MulInstruction(null, EBX, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 4 - A negative and positive integer stored in registers EAX and EBX")
    void validSymmetricEqualsFour() {
      registers.set(EAX, -1);
      registers.set(EBX, 2);
      Instruction instruction = new MulInstruction(null, EAX, EAX);
      Instruction instructionTwo = new MulInstruction(null, EBX, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 5 - A positive and negative integer stored in registers EAX and EBX")
    void validSymmetricEqualsFive() {
      registers.set(EAX, 1);
      registers.set(EBX, -2);
      Instruction instruction = new MulInstruction(null, EAX, EAX);
      Instruction instructionTwo = new MulInstruction(null, EBX, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 6 - A positive and zero integer stored in registers EAX and EBX")
    void validSymmetricEqualsSix() {
      registers.set(EAX, 1);
      registers.set(EBX, 0);
      Instruction instruction = new MulInstruction(null, EAX, EAX);
      Instruction instructionTwo = new MulInstruction(null, EBX, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }

    @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
    @DisplayName("Test Unequal 7 - A negative and zero integer stored in registers EAX and EBX")
    void validSymmetricEqualsSeven() {
      registers.set(EAX, 0);
      registers.set(EBX, -2);
      Instruction instruction = new MulInstruction(null, EAX, EAX);
      Instruction instructionTwo = new MulInstruction(null, EBX, EBX);
      Assertions.assertNotEquals(instruction, instructionTwo);
      Assertions.assertNotEquals(instructionTwo, instruction);
    }
  }
  @Nested
  @DisplayName("Test of Reflexivity, Symmetry and Transitivity (Against three separate but identical instances of MulInstruction) for the overridden hashCode() method")
  class ValidHashCodeTests {

    @Nested
    @DisplayName("Test of the overridden hashCode() method where MulInstructions are equal")
    class ValidHashCodeEqualTests {
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Equal HashCode 1 - Two positive integers stored in registers EAX and EBX")
      void validHashCodeEquals() {
        registers.set(EAX, 1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
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
      @DisplayName("Test Equal HashCode 2 - Two negative integers stored in registers EAX and EBX")
      void validHashCodeEqualsTwo() {
        registers.set(EAX, -1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
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
      @DisplayName("Test Equal HashCode 3 - Two zero integers stored in registers EAX and EBX")
      void validHashCodeEqualsThree() {
        registers.set(EAX, 0);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
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
      @DisplayName("Test Equal HashCode 4 - A negative and positive integer stored in registers EAX and EBX")
      void validHashCodeEqualsFour() {
        registers.set(EAX, -1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
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
      @DisplayName("Test Equal HashCode 5 - A positive and negative integer stored in registers EAX and EBX")
      void validHashCodeEqualsFive() {
        registers.set(EAX, 1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
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
      @DisplayName("Test Equal HashCode 6 - A positive and zero integer stored in registers EAX and EBX")
      void validHashCodeEqualsSix() {
        registers.set(EAX, 1);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
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
      @DisplayName("Test Equal HashCode 7 - A negative and zero integer stored in registers EAX and EBX")
      void validHashCodeEqualsSeven() {
        registers.set(EAX, 0);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EAX, EBX);
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
    @DisplayName("Test of the overridden hashCode() method where MulInstructions are not equal")
    class ValidHashCodeNotEqualTests {

      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Not Equal HashCode 1 - Two positive integers stored in registers EAX and EBX")
      void validHashCodeNotEquals() {
        registers.set(EAX, 1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EAX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EBX, EAX);
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
      @DisplayName("Test Not Equal HashCode 2 - Two negative integers stored in registers EAX and EBX")
      void validHashCodeNotEqualsTwo() {
        registers.set(EAX, -1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EAX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EBX, EAX);
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

//      TODO: Check this!!
      @Test
//      @RepeatedTest(100) // Repeat the test multiple times to test for consistency - comment out @Test if using
      @DisplayName("Test Not Equal HashCode 3 - Two zero integers stored in registers EAX and EBX")
      void validHashCodeNotEqualsThree() {
        registers.set(EAX, 0);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EAX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EBX, EAX);
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
      @DisplayName("Test Not Equal HashCode 4 - A negative and positive integer stored in registers EAX and EBX")
      void validHashCodeNotEqualsFour() {
        registers.set(EAX, -1);
        registers.set(EBX, 2);
        Instruction instruction = new MulInstruction(null, EAX, EAX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EBX, EAX);
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
      @DisplayName("Test Not Equal HashCode 5 - A positive and negative integer stored in registers EAX and EBX")
      void validHashCodeNotEqualsFive() {
        registers.set(EAX, 1);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EAX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EBX, EAX);
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
      @DisplayName("Test Not Equal HashCode 6 - A positive and zero integer stored in registers EAX and EBX")
      void validHashCodeNotEqualsSix() {
        registers.set(EAX, 1);
        registers.set(EBX, 0);
        Instruction instruction = new MulInstruction(null, EAX, EAX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EBX, EAX);
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
      @DisplayName("Test Not Equal HashCode 7 - A negative and zero integer stored in registers EAX and EBX")
      void validHashCodeNotEqualsSeven() {
        registers.set(EAX, 0);
        registers.set(EBX, -2);
        Instruction instruction = new MulInstruction(null, EAX, EAX);
        Instruction instructionTwo = new MulInstruction(null, EAX, EBX);
        Instruction instructionThree = new MulInstruction(null, EBX, EAX);
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
