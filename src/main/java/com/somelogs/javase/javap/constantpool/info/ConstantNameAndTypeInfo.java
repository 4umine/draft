package com.somelogs.javase.javap.constantpool.info;

import com.somelogs.javase.javap.constantpool.ConstantPoolInfo;
import com.somelogs.javase.javap.datatype.U2;
import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

/**
 * Constant_NameAndType_info
 *
 * @author LBG - 2018/1/15 0015 17:42
 */
@Getter
@Setter
public class ConstantNameAndTypeInfo extends ConstantPoolInfo {

    private short constantIndex;
    private short descriptorIndex;

    @Override
    public void read(InputStream inputStream) {
        constantIndex = U2.read(inputStream).getValue();
        descriptorIndex = U2.read(inputStream).getValue();
    }
}
