package my.test;


import com.xiaofan0408.ClassReader;
import com.xiaofan0408.classfile.ClassFile;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        try (FileInputStream is = new FileInputStream(Paths.get("./data/Test.class").toFile());
             DataInputStream dis = new DataInputStream(is)
        ) {
            final ClassFile file = ClassReader.read(dis); // 1 从输入流中读取 ClassFile 实例 file
            System.out.println(file.toString());
        }
    }
}
