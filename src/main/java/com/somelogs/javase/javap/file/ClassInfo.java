package com.somelogs.javase.javap.file;

import com.somelogs.javase.javap.constantpool.ConstantPool;
import com.somelogs.javase.javap.datatype.U2;
import com.somelogs.javase.javap.datatype.U4;
import lombok.Data;

/**
 * class info
 *
 * @author LBG - 2018/1/15 0015 16:42
 */
@Data
public class ClassInfo {

    /**
     * magic
     */
    private U4 magic;

    /**
     * minor_version
     */
    private U2 minorVersion;

    /**
     * major_version
     */
    private U2 majorVersion;

    /**
     * constant_pool_count
     */
    private U2 constantPoolCount;

    /**
     * cp_info
     */
    private ConstantPool cpInfo;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(magic.getHexValue()).append("\n")
                .append(minorVersion.getValue()).append("\n")
                .append(majorVersion.getValue()).append("\n")
                .append(constantPoolCount.getValue()).append("\n")
                .append(cpInfo.toString());
        return builder.toString();
    }
}
