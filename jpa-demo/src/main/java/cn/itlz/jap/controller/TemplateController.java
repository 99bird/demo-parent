package cn.itlz.jap.controller;

import freemarker.template.TemplateException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TemplateController extends BaseController {

    @GetMapping("render")
    public ResponseEntity<String> renderTpl() throws IOException, TemplateException {
        Map<String, Object> map = new HashMap<>();
        Test test = new Test();
        test.setName("<a href=\"http://www.baidu.com\">http://www.baidu.com</a>");
        map.put("test", test);
        String renderResult = renderFtlToString("test.ftl", map);
        return new ResponseEntity<>(renderResult, HttpStatus.OK);
    }

    @Data
    public static class Test {
        String name;
        String title;
    }
}
