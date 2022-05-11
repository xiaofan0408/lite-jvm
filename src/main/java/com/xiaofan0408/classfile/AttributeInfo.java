package com.xiaofan0408.classfile;

/**
 * @author zefan.xzf
 * @date 2022/5/11 17:12
 */
public class AttributeInfo {

    U2 attributeNameIndex; // 属性名索引
    U4 attributeLength; // 属性内容长度
    byte[] info; // 属性内容

    AttributeInfo(U2 attributeNameIndex, U4 attributeLength, byte[] info) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.info = info;
    }

}
