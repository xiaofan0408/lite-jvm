package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:33
 */
public class IReturnInst implements Instruction {

    @Override
    public void eval(Frame frame) {
        System.out.println(frame.operandStack.pop());

        frame.pc += offset();
    }
}
