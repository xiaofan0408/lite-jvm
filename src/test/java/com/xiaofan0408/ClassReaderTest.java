package com.xiaofan0408;

import com.xiaofan0408.classfile.ClassFile;

import org.junit.Assert;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author zefan.xzf
 * @date 2022/5/12 16:42
 */
public class ClassReaderTest {

    @Test
    public  void testRead() throws IOException {
        try (FileInputStream is = new FileInputStream(Paths.get("./data/Test.class").toFile());
             DataInputStream dis = new DataInputStream(is)
        ) {
            final ClassFile file = ClassReader.read(dis); // 1 从输入流中读取 ClassFile 实例 file

            Assert.assertEquals(0xCAFEBABE, file.magic.value); // 2 断言 file 的 magic 是 0xCAFEBABE
            Assert.assertEquals(0, file.minorVersion.value); // 3 断言 file 的 minnor_version 是 0
            Assert.assertEquals(52, file.majorVersion.value); // 4 断言 file 的 major_version 是 52
            Assert.assertEquals(31, file.constantPoolCount.value); // 5
            Assert.assertEquals(2, file.methodsCount.value); // 6
            Assert.assertEquals(1, file.attributesCount.value); // 7
        }
    }
}
