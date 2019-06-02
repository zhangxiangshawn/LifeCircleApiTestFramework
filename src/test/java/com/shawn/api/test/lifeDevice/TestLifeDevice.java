package com.shawn.api.test.lifeDevice;

import com.shawn.api.validation.ResponseChecker;
import com.shawn.apitest02.HttpRequest;
import org.apache.http.HttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestLifeDevice {
    private String baseUrl = "https://life-circle-prd.xinchao.com/life";
    @Test
    public void testGetLifeDevice() throws IOException {
        String url = baseUrl + "/device/price?cityCode=110100";
        HttpResponse response = new HttpRequest(url).doGet();

        Map<String, Object> exceptMap = new HashMap<String,Object>();

        exceptMap.put("status.message", "成功");

        ResponseChecker responseChecker = new ResponseChecker(response);
        responseChecker.codeCheck(200);
        responseChecker.dataCheck(exceptMap);
    }
}
