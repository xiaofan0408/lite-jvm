package com.xiaofan0408.runtime.impl;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:29
 */
public class IIncInst implements Instruction {

    public final int index;
    public final int val;

    public IIncInst(int index, int val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public void eval(Frame frame) {
        int tmp = frame.localVars.get(index);
        tmp += val;
        frame.localVars.put(index, tmp);

        frame.pc += offset();
    }

    @Override
    public int offset() {
        return 3;
    }
}
