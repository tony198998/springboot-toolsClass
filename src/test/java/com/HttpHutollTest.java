package com;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.wode.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * 使用hutool进行http请求
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class HttpHutollTest {

    @Test
    public void test() {
        String s = HttpUtil.get("localhost:8090/sss");
        System.out.println(s);
    }

    @Test
    public void testPost() {
        //POST请求
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 2);
        HttpResponse execute = HttpRequest.post("localhost:8090/sss")
                .body(JSON.toJSONString(paramMap), ContentType.JSON.toString())
                .execute();
        System.out.println(execute);
    }

    public static void main(String[] args) {
        System.out.println(ContentType.JSON.toString());
    }

}
