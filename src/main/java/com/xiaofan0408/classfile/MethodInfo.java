package com.xiaofan0408.classfile;

/**
 * @author zefan.xzf
 * @date 2022/5/11 17:11
 */
public class MethodInfo {

    U2 accessFlags; // 访问标志
    U2 nameIndex; // 方法名索引
    U2 descriptorIndex; // 方法描述符索引
    U2 attributesCount; // 属性数
    AttributeInfo[] attributes; // 属性

    public MethodInfo(U2 accessFlags,
                      U2 nameIndex,
                      U2 descriptorIndex,
                      U2 attributesCount,
                      AttributeInfo[] attributes) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
        this.attributes = attributes;
    }
}
