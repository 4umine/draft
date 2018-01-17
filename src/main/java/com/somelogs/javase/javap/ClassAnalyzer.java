package com.somelogs.javase.javap;

import com.somelogs.javase.javap.constantpool.ConstantPool;
import com.somelogs.javase.javap.datatype.U2;
import com.somelogs.javase.javap.datatype.U4;
import com.somelogs.javase.javap.file.ClassInfo;

import java.io.InputStream;

/**
 * class analyze
 *
 * @author LBG - 2018/1/15 0015
 */
public class ClassAnalyzer {

    private ClassAnalyzer() {}

    public static ClassInfo analyze(InputStream inputStream) {
        ClassInfo classInfo = new ClassInfo();

        // magic
        U4 magic = U4.read(inputStream);
        classInfo.setMagic(magic);

        // version
        U2 minorVersion = U2.read(inputStream);
        U2 majorVersion = U2.read(inputStream);
        classInfo.setMinorVersion(minorVersion);
        classInfo.setMajorVersion(majorVersion);

        // constant_pool_count
        U2 cpCount = U2.read(inputStream);
        classInfo.setConstantPoolCount(cpCount);

        // constant_pool
        int cpActualCount = cpCount.getValue() - 1;
        ConstantPool constantPool = new ConstantPool(cpActualCount);
        constantPool.analyze(inputStream);
        classInfo.setCpInfo(constantPool);

        return classInfo;
    }
}
