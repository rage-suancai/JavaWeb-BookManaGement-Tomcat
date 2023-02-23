package com.web.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.Writer;

/**
 * @author YXS
 * @PackageName: com.web.utils
 * @ClassName: Thymeleat
 * @Desription:
 * @date 2023/2/16 10:58
 */
public class ThymeleafUtil {

    private static final TemplateEngine engine;

    static {

        engine = new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        engine.setTemplateResolver(r);

    }

    public static void process(String template, IContext context, Writer writer) {

        engine.process(template, context, writer);

    }

}
