package com.xiaofan0408.classfile.attribute;


import com.xiaofan0408.classfile.contstant.CpInfo;
import com.xiaofan0408.runtime.Instruction;
import com.xiaofan0408.runtime.impl.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zefan.xzf
 * @date 2022/5/16 10:19
 */

public class Code {

    public int maxStack;

    public int maxLocals;

    public byte[] codes;

    public ExceptionTable[] exceptionTable;


    public AttributeInfo[] attributeInfos;

    public Code(int maxStack, int maxLocals, byte[] codes, ExceptionTable[] exceptionTable, AttributeInfo[] attributeInfos) {
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
        this.codes = codes;
        this.exceptionTable = exceptionTable;
        this.attributeInfos = attributeInfos;
    }

    public Map<Integer, Instruction> getInstructions(CpInfo[] cp) {
        Map<Integer, Instruction> instructionMap = new HashMap<>();
        try (ByteArrayInputStream bis = new ByteArrayInputStream(this.codes);
             final DataInputStream dis = new DataInputStream(bis)
        ) {
            int pc = 0;
            while (dis.available() > 0) {
                final int opcode = dis.read();
                switch (opcode) {
                    case 0x04:
                        instructionMap.put(pc, new IConst1Inst());
                        pc++;
                        break;
                    case 0x3b:
                        instructionMap.put(pc, new IStore0Inst());
                        pc++;
                        break;
                    case 0x1a:
                        instructionMap.put(pc, new ILoad0Inst());
                        pc++;
                        break;
                    case 0xac:
                        instructionMap.put(pc, new IReturnInst());
                        pc++;
                        break;
                    case 0x03:
                        instructionMap.put(pc, new IConst0Inst());
                        pc++;
                        break;
                    case 0x3c:
                        instructionMap.put(pc, new IStore1Inst());
                        pc++;
                        break;
                    case 0x3d:
                        instructionMap.put(pc, new IStore2Inst());
                        pc++;
                        break;
                    case 0x1b:
                        instructionMap.put(pc, new ILoad1Inst());
                        pc++;
                        break;
                    case 0x1c:
                        instructionMap.put(pc, new ILoad2Inst());
                        pc++;
                        break;
                    case 0x60:
                        instructionMap.put(pc, new IAddInst());
                        pc++;
                        break;
                    case 0x10:
                        instructionMap.put(pc, new BiPushInst(dis.readByte()));
                        pc += 2;
                        break;
                    case 0x84:
                        instructionMap.put(pc, new IIncInst(dis.readUnsignedByte(), dis.readByte()));
                        pc += 3;
                        break;
                    case 0xa7:
                        instructionMap.put(pc, new GotoInst(dis.readShort()));
                        pc += 3;
                        break;
                    case 0xa3:
                        instructionMap.put(pc, new IfICmpGtInst(dis.readShort()));
                        pc += 3;
                        break;
                    case 0x64:
                        instructionMap.put(pc,new ISubInst());
                        pc++;
                        break;
                    default:
                        throw new IllegalStateException("unknown opcode " + opcode);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("method code parse failure");
        }

        return instructionMap;
    }
}
