package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:30
 */
public class IAddInst implements Instruction {

    @Override
    public void eval(Frame frame) {
        int v2 = frame.operandStack.pop();
        int v1 = frame.operandStack.pop();
        frame.operandStack.push(v1 + v2);

        frame.pc += offset();
    }
}
