package cn.itlz.jap.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public abstract class BaseController {

    @Resource
    private Configuration configuration;

    protected String renderFtlToString(String tpl, Map<String, Object> data) throws IOException, TemplateException {
        Template template = configuration.getTemplate(tpl);
        StringWriter writer = new StringWriter();
        template.process(data,writer);
        return writer.toString();
    }

}
