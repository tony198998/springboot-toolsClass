package com.wode.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import org.junit.Test;

public class 二维码 {

    @Test
    public void generate(){
        // 生成指定url对应的二维码到文件，宽和高都是300像素
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
    }
}
