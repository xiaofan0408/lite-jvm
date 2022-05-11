package com.xiaofan0408.classfile;

/**
 * @author zefan.xzf
 * @date 2022/5/11 17:05
 */
public class CpInfo {

    U1 tag; // 标签，用来区分不同的常量池信息
    byte[] info; // 常量池信息内容

    public CpInfo(U1 tag, byte[] info) {
        this.info = info;
        this.tag = tag;
    }
}
