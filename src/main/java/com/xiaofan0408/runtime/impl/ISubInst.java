package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/18 11:25
 */
public class ISubInst implements Instruction {
    @Override
    public void eval(Frame frame) {
        int val2 = frame.operandStack.pop();
        int val1 = frame.operandStack.pop();
        frame.operandStack.push(val1  - val2);
        frame.pc+=offset();
    }
}
