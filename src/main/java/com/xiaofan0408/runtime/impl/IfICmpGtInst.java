package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:28
 */
public class IfICmpGtInst implements Instruction {

    public final int offset;

    public IfICmpGtInst(int offset) {
        this.offset = offset;
    }

    @Override
    public void eval(Frame frame) {
        int v2 = frame.operandStack.pop();
        int v1 = frame.operandStack.pop();
        if (v1 > v2) {
            frame.pc += offset;
        } else {
            frame.pc += offset();
        }
    }

    @Override
    public int offset() {
        return 3;
    }
}
