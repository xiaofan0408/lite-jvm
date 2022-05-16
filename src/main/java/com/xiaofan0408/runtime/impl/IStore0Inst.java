package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:32
 */
public class IStore0Inst implements Instruction {

    @Override
    public void eval(Frame frame) {
        frame.localVars.put(0, frame.operandStack.pop());
        frame.pc += offset();
    }
}