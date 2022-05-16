package com.xiaofan0408.runtime;

/**
 * @author zefan.xzf
 * @date 2022/5/16 11:38
 */
public interface Instruction {

    // offset, 字长， 因为字节码的长度不一致，一般情况下是 1，此处提供默认方法用来获取指定的字长。用来在指令结束时改变栈帧的程序计数器，使之指向下一条指令。
    default int offset() {
        return 1;
    }

    // 具体指令需要实现的方法，是指令自身的业务逻辑。
    void eval(Frame frame);
}
