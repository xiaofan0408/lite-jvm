package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:28
 */
public class GotoInst implements Instruction {

    public final int offset;

    public GotoInst(int offset) {
        this.offset = offset;
    }

    @Override
    public void eval(Frame frame) {
        frame.pc += offset;
    }

    @Override
    public int offset() {
        return 3;
    }
}