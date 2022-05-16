package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:06
 */
public class IStore2Inst implements Instruction {
    @Override
    public void eval(Frame frame) {
        frame.localVars.put(1,frame.operandStack.pop());
        frame.pc += offset();
    }
}
