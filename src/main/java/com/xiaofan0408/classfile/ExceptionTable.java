package com.xiaofan0408.classfile;

/**
 * @author zefan.xzf
 * @date 2022/5/16 10:22
 */

public class ExceptionTable {

    public int startPc;

    public int endPc;

    public int handlerPc;

    public int catchType;

    public ExceptionTable(int startPc, int endPc, int handlerPc, int catchType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }
}
