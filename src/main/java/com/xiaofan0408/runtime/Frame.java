package com.xiaofan0408.runtime;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zefan.xzf
 * @date 2022/5/16 11:37
 */
public class Frame {

    // 程序计数器，默认值为 0
    public int pc;

    // 本地变量表
    public final Map<Integer, Integer> localVars = new HashMap<>();

    // 操作数栈
    public final Stack<Integer> operandStack = new Stack<>();

}
