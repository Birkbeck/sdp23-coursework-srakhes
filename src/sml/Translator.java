package sml;

import sml.customExceptions.InvalidLabelSMLInputException;
import sml.instruction.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Constructor;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static sml.Registers.Register;

/**
 * This class ....
 * <p>
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 *
 * @author Birkbeck College, and Samuel Rakhes
 */
public final class Translator {

    private final String fileName; // source file of SML code

    // line contains the characters in the current line that's not been processed yet
    private String line = "";

    public Translator(String fileName) {
        this.fileName =  fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"

    public void readAndTranslate(Labels labels, List<Instruction> program) throws IOException {
        try (var sc = new Scanner(new File(fileName), StandardCharsets.UTF_8)) {
            labels.reset();
            program.clear();

            // Each iteration processes line and reads the next input line into "line"
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String label = getLabel();

                Instruction instruction = getInstruction(label);
                if (instruction != null) {
                    if (label != null)
                        labels.addLabel(label, program.size());
                    program.add(instruction);
                }
            }
        }
    }

    /**
     * Translates the current line into an instruction with the given label
     *
     * @param label the instruction label
     * @return the new instruction
     * <p>
     * The input line should consist of a single SML instruction,
     * with its label already removed.
     */
    private Instruction getInstruction(String label) {
        if (line.isEmpty())
            return null;

        String opcode = scan();
        switch (opcode) {
            case AddInstruction.OP_CODE -> {
                String r = scan();
                String s = scan();
                return new AddInstruction(label, Register.valueOf(r), Register.valueOf(s));
            }
            case SubInstruction.OP_CODE -> {
                String r = scan();
                String s = scan();
                return new SubInstruction(label, Register.valueOf(r), Register.valueOf(s));
            }
            case MulInstruction.OP_CODE -> {
                String r = scan();
                String s = scan();
                return new MulInstruction(label, Register.valueOf(r), Register.valueOf(s));
            }
            case DivInstruction.OP_CODE -> {
                String r = scan();
                String s = scan();
                return new DivInstruction(label, Register.valueOf(r), Register.valueOf(s));
            }
            case OutInstruction.OP_CODE -> {
                String r = scan();
//                String s = scan();
                return new OutInstruction(label, Register.valueOf(r));
            }
            case MovInstruction.OP_CODE -> {
                String r = scan();
                String s = scan();
                return new MovInstruction(label, Register.valueOf(r), Integer.valueOf(s)); //TODO: Check the type here are int is used in AddInstruction
            }
            case JnzInstruction.OP_CODE -> {
                String r = scan();
                String s = scan();
                return new JnzInstruction(label, Register.valueOf(r), String.valueOf(s));
            }
            // TODO: add code for all other types of instructions - * DONE *
            default -> {
                System.out.println("Unknown instruction: " + opcode);
                // TODO: Then, replace the switch by using the Reflection API
                // TODO: Next, use dependency injection to allow this machine class
                //       to work with different sets of opcodes (different CPUs)
            }
        }
        return null;
    }

    private String getLabel() {
        String word = scan();
        if (word.endsWith(":"))
            return word.substring(0, word.length() - 1);

        // undo scanning the word
        line = word + " " + line;
        return null;
    }

    /*
     * Return the first word of line and remove it from line.
     * If there is no word, return "".
     */
    private String scan() {
        line = line.trim();

        for (int i = 0; i < line.length(); i++)
            if (Character.isWhitespace(line.charAt(i))) {
                String word = line.substring(0, i);
                line = line.substring(i);
                return word;
            }

        return line;
    }
}


//    /**
//     * Translates the current line into an instruction with the given label
//     *
//     * @param label the instruction label
//     * @return the new instruction
//     * <p>
//     * The input line should consist of a single SML instruction,
//     * with its label already removed.
//     */
//    private Instruction getInstruction(String label) {
//        if (line.isEmpty())
//            return null;
//
//        String opcode = scan();
////          **** Replacement for switch using reflection ****
//            // TODO: Then, replace the switch by using the Reflection API
//            // - TODO: convert read opcode to format used to call the relevant instructions
//        // for testing
//
//
//        Class<?> c;
//        try {
//            c = Class.forName(opCodeToFullyQualified(opcode));
////          // Get a list of the constructors for the class, so we know how many parameters to pass.
//            // Source: Week 4, Question 1
//            Constructor<?>[] construct = c.getConstructors();
//            System.out.println(construct.length);
//            System.out.println(construct[0]);
//            System.out.println(Arrays.toString(c.getConstructors())); // TO REMOVE - added for debugging purposes
//            // TODO: count the number of constructions and then
//            List<?> constructorlist = new ArrayList();
//
//
//                // Source: Week 4, Question 2
////                System.out.println(classConstructorCount);
//                parameterTypesToStringArray(Arrays.toString(c.getConstructors()));
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e); // TODO: change this - intellij generated
//            }
//        // java.lang.reflect.Constructor.newInstance();
////            Class.forName("AddInstruction");
//            // TODO: Next, use dependency injection to allow this machine class
//            //       to work with different sets of opcodes (different CPUs)
//        return null;
//    }

//    /**
//     * Translates the current line into an instruction with the given label
//     *
//     * @param opcode the instruction opcode
//     * @return a fully qualified Java class name
//     * <p>
//     */
//    private String opCodeToFullyQualified(String opcode) {
//        // to convert incoming opcode string ready for constructor
//        // TODO: unsure whether to concatenate here of in the getInstruction
//        return "sml.instruction." + opcode.substring(0,1).toUpperCase() + opcode.substring(1) + "Instruction";
//    }

//    private String[] parameterTypesToStringArray(String word) {
//        // currently not working
//        // Source Week 4, Question 1
//        String[] splitWord = word.split("(?<=\\()[^\\)\\)]*(?=])");
//
////        for (int i = 0; i < splitWord.length; i++) {
////            Pattern p = Pattern.compile("([$_A-Za-z0-9]+?\\.)+([$_A-Za-z0-9]+.*)");
//            String regex = "\\((.*?)\\)";
//            Pattern p = Pattern.compile("\\((.*?)\\)");
//            Matcher m = p.matcher(word);
//            if (m.find()){
////                m = p.matcher(word);
//                word = m.group(1);
//            }
//            p = Pattern.compile("([$_A-Za-z0-9]+?\\.)+([$_A-Za-z0-9]+.*)");
//            while (m.find()){
//                word = m.replaceAll("$2");
//                m = p.matcher(word);
//            }
////        }
//        System.out.println("Word: " + word);
//        return splitWord;
//    }

