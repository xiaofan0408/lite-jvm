package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 11:40
 */
public class IStore1Inst implements Instruction {

    @Override
    public void eval(Frame frame) {
        frame.localVars.put(1, frame.operandStack.pop());
        frame.pc += offset();
    }
}