package com.xiaofan0408.interpreter;

import com.xiaofan0408.runtime.Frame;
import com.xiaofan0408.runtime.Instruction;

import java.util.Map;

/**
 * @author zefan.xzf
 * @date 2022/5/16 12:33
 */
public class Interpreter {
    /**
     * 解释器运行
     *
     * @param frame 栈帧
     * @param instructions 指令集合
     */
    public static void run(Frame frame, Map<Integer, Instruction> instructions) {
        // 核心循环
        do {
            // 获取指令
            Instruction instruction = instructions.get(frame.pc);
            // 执行指令
            instruction.eval(frame);
        } while (instructions.containsKey(frame.pc));
    }
}
