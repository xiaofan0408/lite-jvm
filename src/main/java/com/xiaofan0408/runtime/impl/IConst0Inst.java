package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 11:39
 */
public class IConst0Inst implements Instruction {
    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(0);
        frame.pc += offset();
    }
}
