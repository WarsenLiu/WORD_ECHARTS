package com.warsen.dev.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

/**
 * 检查导出word使用的模板文件
 * 若无则创建
 */
@Component
public class ExportTemplateUtil {

    private static final String TEMPLATE_PATH = "/template";

    private String path;

    // 初始化模板存放路径，因为项目打包后可能放在服务器不同的文件夹里
    @PostConstruct
    public void init() {
        String reportPath = this.getClass().getClassLoader().getResource("").getPath() + "template";

        path = reportPath.replace("\\", "/") + "/";
        if (!"linux".equals(System.getProperty("os.name"))) {
            path = path.substring(1);
        }
    }

    /**
     * 项目中的模板文件输入流
     */
    private InputStream templateIs = null;

    private Configuration cfg = null;




    /**
     * 检查导出word功能模板文件并返回模板文件
     */
    public Template localTemplate(String name) {
        Template template = null;
        //系统中路径
        File localPathDir = new File(path);
        if (!localPathDir.exists()) {
            try {
                localPathDir.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = new File(path + name + ".ftl");
        InputStream fileIs = null;
        try {
            ClassPathResource resource = new ClassPathResource(TEMPLATE_PATH + File.separator + name + ".ftl");
            templateIs = resource.getInputStream();
            if (file.exists()) {
                fileIs = new FileInputStream(file);
                if (fileIs.available() != templateIs.available()) {
                    writeTemplate(file);
                    initConfig(path);
                }
            } else {//文件不存在
                writeTemplate(file);
                initConfig(path);
            }
            if (cfg == null) {
                initConfig(path);
            }
            template = cfg.getTemplate(name + ".ftl", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (templateIs != null) {
                    templateIs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileIs != null) {
                    fileIs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return template;
    }

    /**
     * 初始化freemaker模板配置
     *
     * @param filePath 本地模板文件路径
     */
    private void initConfig(String filePath) {
        cfg = new Configuration(
                Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        cfg.setDefaultEncoding("UTF-8");
        File templateFile = new File(filePath);
        try {
            cfg.setDirectoryForTemplateLoading(templateFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入模板文件到运行环境本地
     *
     * @param file 模板文件
     * @throws IOException
     */
    private void writeTemplate(File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        byte[] bs = new byte[1024];
        int length = 0;
        while ((length = templateIs.read(bs)) != -1) {
            os.write(bs, 0, length);
            os.flush();
        }
        os.close();
    }

}

