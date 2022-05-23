package my.test;


import com.xiaofan0408.classfile.ClassFileReader;
import com.xiaofan0408.classfile.ClassFile;
import com.xiaofan0408.classfile.attribute.Code;
import com.xiaofan0408.interpreter.Interpreter;
import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        try (FileInputStream is = new FileInputStream(Paths.get("./data/Sub10.class").toFile());
             DataInputStream dis = new DataInputStream(is)
        ) {
            final ClassFile file = ClassFileReader.read(dis);
            System.out.println(file.toString());


            Code code = file.methods[1].getCode(file);
            Map<Integer, Instruction> instructionMap = code.getInstructions(file.constantPool);
            if (instructionMap != null) {
                Frame frame = new Frame();
                Interpreter.run(frame, instructionMap);
            }
        }
    }
}
