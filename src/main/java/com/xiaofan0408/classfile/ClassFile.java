package com.xiaofan0408.classfile;

/**
 * @author zefan.xzf
 * @date 2022/5/10 18:39
 */
public class ClassFile {

    public U4 magic;

    public U2 minorVersion;

    public U2 majorVersion;

    public U2 constantPoolCount;

    public CpInfo[] constantPool;

    public U2 accessFlags;

    public U2 thisClass;

    public U2 superClass;

    public U2 interfacesCount;

    public U2 interfaces;

    public U2 fieldsCount;

    public FieldInfo[] fields;

    public U2 methodsCount;

    public MethodInfo methods;

    public U2 attributesCount;

    public AttributeInfo attributes;

    public ClassFile(U4 magic,
                     U2 minorVersion,
                     U2 majorVersion,
                     U2 constantPoolCount,
                     CpInfo[] constantPool,
                     U2 accessFlags,
                     U2 thisClass,
                     U2 superClass,
                     U2 interfacesCount,
                     U2 interfaces,
                     U2 fieldsCount,
                     FieldInfo[] fields,
                     U2 methodsCount,
                     MethodInfo methods,
                     U2 attributesCount,
                     AttributeInfo attributes) {
        this.magic = magic;
        this.minorVersion = minorVersion;
        this.majorVersion = majorVersion;
        this.constantPoolCount = constantPoolCount;
        this.constantPool = constantPool;
        this.accessFlags = accessFlags;
        this.thisClass = thisClass;
        this.superClass = superClass;
        this.interfacesCount = interfacesCount;
        this.interfaces = interfaces;
        this.fieldsCount = fieldsCount;
        this.fields = fields;
        this.methodsCount = methodsCount;
        this.methods = methods;
        this.attributesCount = attributesCount;
        this.attributes = attributes;
    }
}
