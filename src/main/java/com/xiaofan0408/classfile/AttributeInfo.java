package com.xiaofan0408.classfile;

import java.util.Arrays;

/**
 * @author zefan.xzf
 * @date 2022/5/11 17:12
 */
public class AttributeInfo {

    public U2 attributeNameIndex; // 属性名索引
    public U4 attributeLength; // 属性内容长度
    public byte[] info; // 属性内容

    public AttributeInfo(U2 attributeNameIndex, U4 attributeLength, byte[] info) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.info = info;
    }

    @Override
    public String toString() {
        return "AttributeInfo{" +
                "attributeNameIndex=" + attributeNameIndex +
                ", attributeLength=" + attributeLength +
                ", info=" + Arrays.toString(info) +
                '}';
    }
}
