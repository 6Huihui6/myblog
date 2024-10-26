package com.hui.config;

import cn.hutool.core.util.RandomUtil;
import com.hui.json.JacksonObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 创建Swagger配置
 * @since:knife4j-springdoc-openapi-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 20:40
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 根据@Tag 上的排序，写入x-order
     *
     * @return the global open api customizer
     */
    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags()!=null){
                openApi.getTags().forEach(tag -> {
                    Map<String,Object> map=new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0,100));
                    tag.setExtensions(map);
                });
            }
            if(openApi.getPaths()!=null){
                openApi.addExtension("x-test123","333");
                openApi.getPaths().addExtension("x-abb",RandomUtil.randomInt(1,100));
            }

        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("捉友API文档")
                        .version("1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("huijinhui")
                                .email("3103733088@qq.com"))
                        .description( "捉友API文档")
                        .termsOfService("http://doc.huijinhui.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.huijinhui.com")));
    }

    /**
     * 设置静态资源映射
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    //         扩展springmvc的消息转换器,
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        // 添加jackson2的cbor消息转换器
        MappingJackson2HttpMessageConverter converter= new MappingJackson2HttpMessageConverter();

        // 设置ObjectMapper为自定义的JacksonObjectMapper
        converter.setObjectMapper(new JacksonObjectMapper());


        // 将自定义的消息转换器添加到converters列表的第一个位置
        converters.add(2,converter);
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new ByteArrayHttpMessageConverter());
    }
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new LocalDateTimeFormatter());
//    }






}