package com.hogwarts.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-01-20
 * Created by YangWang on 2019-01-20 10:53.
 */
public class GlobalConfig {
    public AppiumConfig appium;
    public XueqiuConfig xueqiu;

    static GlobalConfig load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            GlobalConfig config = mapper.readValue(GlobalConfig.class.getResource(path), GlobalConfig.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
