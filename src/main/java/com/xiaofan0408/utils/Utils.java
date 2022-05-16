package com.xiaofan0408.utils;

import com.xiaofan0408.classfile.Const;
import com.xiaofan0408.classfile.CpInfo;

import java.util.Objects;

/**
 * @author zefan.xzf
 * @date 2022/5/16 10:33
 */
public class Utils {

    public static String getUtf8(CpInfo[] cp, int utf8Idx) {
        final CpInfo utf8 = cp[utf8Idx - 1];
        if (utf8.tag.value != Const.CONSTANT_Utf8) {
            throw new IllegalStateException("unexpect tag");
        }

        return new String(utf8.info);
    }

    public static String arrayToString(Object[] objects) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (Object o : objects) {
            stringBuffer.append(o.toString());
            stringBuffer.append("\n");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

}
