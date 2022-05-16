package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:27
 */
public class BiPushInst implements Instruction {

    public final int val;

    public BiPushInst(int val) {
        this.val = val;
    }

    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(val);
        frame.pc += offset();
    }

    @Override
    public int offset() {
        return 2;
    }
}
