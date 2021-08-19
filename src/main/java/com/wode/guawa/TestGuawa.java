package com.wode.guawa;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class TestGuawa {

    public static void main(String[] args) {
        String hello = "333";
        System.out.println(hello.hashCode());
        System.out.println(Objects.hashCode(hello));
        Preconditions.checkArgument(StringUtils.isNoneEmpty(hello),"hello不能为空");
    }

}
