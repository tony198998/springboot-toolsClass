package com;

import com.alibaba.fastjson.JSON;
import com.wode.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestController {

    @Resource
    private RestTemplate restTemplate;


    @Test
    public void test() {
        String sessionId = "2b7e7b37-6c4d-4a8e-a9c5-36ed8bbc3b28";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("sessionId", sessionId);
        params.add("pageNo", "2");
        params.add("pageSize", "10");
        String url = "http://beta.hongsong.club/user/api/page/userFollowLecturers";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        System.out.println(JSON.toJSONString(responseEntity));


    }

}
