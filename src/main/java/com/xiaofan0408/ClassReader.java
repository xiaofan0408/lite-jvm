package com.xiaofan0408;

import com.xiaofan0408.classfile.ClassFile;
import com.xiaofan0408.classfile.CpInfo;
import com.xiaofan0408.classfile.U2;
import com.xiaofan0408.classfile.U4;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author zefan.xzf
 * @date 2022/5/12 16:42
 */
public class ClassReader {

    public static ClassFile read(DataInputStream dis) throws IOException {

        int magic = dis.readInt();
        int minorVersion = dis.readUnsignedShort();
        int majorVersion = dis.readUnsignedShort();
        int constantPoolCount = dis.readUnsignedShort();
        CpInfo[] cpInfos = readCpInfo(constantPoolCount,dis);

        ClassFile classFile = new ClassFile(new U4(magic),new U2(minorVersion),new U2(majorVersion),new U2(constantPoolCount),null,
                null,null,null,null,null,null,null, null,
                null,null,null);
        return classFile;

    }

    private static CpInfo[] readCpInfo(int constantPoolCount, DataInputStream dis) {
        CpInfo[] cpInfos = new CpInfo[constantPoolCount];
        for (int i=0;i < constantPoolCount; i++) {
               
        }
        return cpInfos;
    }
}
