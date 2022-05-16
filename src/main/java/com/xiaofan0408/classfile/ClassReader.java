package com.xiaofan0408.classfile;


import com.xiaofan0408.classfile.attribute.AttributeInfo;
import com.xiaofan0408.classfile.base.U1;
import com.xiaofan0408.classfile.base.U2;
import com.xiaofan0408.classfile.base.U4;
import com.xiaofan0408.classfile.contstant.Const;
import com.xiaofan0408.classfile.contstant.CpInfo;
import com.xiaofan0408.classfile.field.FieldInfo;
import com.xiaofan0408.classfile.method.MethodInfo;

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
        int accessFlags = dis.readUnsignedShort();
        int thisClass = dis.readUnsignedShort();
        int superClass = dis.readUnsignedShort();
        int interfaceCount = dis.readUnsignedShort();
        U2[] interfaces = readInterfaces(interfaceCount,dis);
        int fieldsCount = dis.readUnsignedShort();
        FieldInfo[] fieldInfos = readFieldInfo(fieldsCount, dis);
        int methodsCount = dis.readUnsignedShort();
        MethodInfo[] methodInfos = readMethodInfo(methodsCount,dis);
        int attrCount = dis.readUnsignedShort();
        AttributeInfo[] attributeInfos = readAttr(attrCount,dis);


        ClassFile classFile = new ClassFile(new U4(magic),new U2(minorVersion),new U2(majorVersion),new U2(constantPoolCount),cpInfos,
                new U2(accessFlags),new U2(thisClass),new U2(superClass),new U2(interfaceCount),interfaces,new U2(fieldsCount),fieldInfos,
                new U2(methodsCount), methodInfos,new U2(attrCount),attributeInfos);
        return classFile;

    }

    private static MethodInfo[] readMethodInfo(int methodsCount, DataInputStream dis) throws IOException {
        MethodInfo[] methods = new MethodInfo[methodsCount];
        for (int i = 0; i < methodsCount; i++) {
            int methodAccessFlags = dis.readUnsignedShort(); // 访问标志
            int methodNameIndex = dis.readUnsignedShort();   // 方法名
            int methodDescriptor = dis.readUnsignedShort();  // 方法描述符
            int methodAttributesCount = dis.readUnsignedShort(); // 方法属性数
            AttributeInfo[] methodAttributeInfo = readAttr(methodAttributesCount,dis);

            methods[i] = new MethodInfo(
                    new U2(methodAccessFlags),
                    new U2(methodNameIndex),
                    new U2(methodDescriptor),
                    new U2(methodAttributesCount),
                    methodAttributeInfo);
        }
        return methods;

    }

    private static AttributeInfo[] readAttr( int methodAttributesCount,DataInputStream dis) throws IOException {
        AttributeInfo[] methodAttributeInfo = new AttributeInfo[methodAttributesCount]; // 方法属性
        for (int j = 0; j < methodAttributesCount; j++) {
            int methodAttributeNameIndex = dis.readUnsignedShort();
            int methodAttributeLength = dis.readInt();
            byte[] info = new byte[methodAttributeLength];
            dis.read(info);

            methodAttributeInfo[j] = new AttributeInfo(
                    new U2(methodAttributeNameIndex),
                    new U4(methodAttributeLength),
                    info);
        }
        return methodAttributeInfo;
    }

    private static FieldInfo[] readFieldInfo(int fieldsCount, DataInputStream dis) throws IOException {
        FieldInfo[] fields = new FieldInfo[fieldsCount];
        for (int i = 0; i < fieldsCount; i++) {
            int fieldAccessFlags = dis.readUnsignedShort();
            int fieldNameIndex = dis.readUnsignedShort();
            int fieldDescriptor = dis.readUnsignedShort();
            int fieldAttributesCount = dis.readUnsignedShort();
            AttributeInfo[] fieldAttributeInfo = readAttr(fieldAttributesCount,dis);
            fields[i] = new FieldInfo(
                    new U2(fieldAccessFlags),
                    new U2(fieldNameIndex),
                    new U2(fieldDescriptor),
                    new U2(fieldAttributesCount),
                    fieldAttributeInfo);
        }
        return fields;
    }


    private static U2[] readInterfaces(int interfaceCount, DataInputStream dis) throws IOException {
        U2[] u2s = new U2[interfaceCount];
        for(int i=0 ;i < interfaceCount; i++) {
            int v = dis.readUnsignedShort();
            u2s[i] = new U2(v);
        }
        return u2s;
    }

    private static CpInfo[] readCpInfo(int constantPoolCount, DataInputStream dis) throws IOException {
        CpInfo[] cpInfos = new CpInfo[constantPoolCount - 1];
        for (int i=0;i < constantPoolCount - 1; i++) {
            int tag = dis.readUnsignedByte();
            byte[] info = null;
            int step = 0;
            switch (tag) {
                case Const.CONSTANT_Fieldref:
                case Const.CONSTANT_Methodref:
                case Const.CONSTANT_InterfaceMethodref:
                case Const.CONSTANT_InvokeDynamic:
                case Const.CONSTANT_NameAndType:
                case Const.CONSTANT_Integer:
                case Const.CONSTANT_Float:
                    info = new byte[4];
                    dis.read(info);
                    break;
                case Const.CONSTANT_MethodHandle:
                    info = new byte[3];
                    dis.read(info);
                    break;
                case Const.CONSTANT_Class:
                case Const.CONSTANT_String:
                case Const.CONSTANT_MethodType:
                    info = new byte[2];
                    dis.read(info);
                    break;
                case Const.CONSTANT_Utf8:
                    int ulen = dis.readUnsignedShort();
                    info = new byte[ulen];
                    dis.read(info);
                    break;
                case Const.CONSTANT_Double:
                case Const.CONSTANT_Long:
                    info = new byte[8];
                    dis.read(info);
//                    step = 1;
                    break;
                default:
                    throw new IllegalStateException("unknown tag, " + tag);
            }
            cpInfos[i] = new CpInfo(new U1(tag), info);
//            i += step;
        }
        return cpInfos;
    }
}
