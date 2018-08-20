package com.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @program: Tradingplatform
 * @description:
 * @author: Robert_Wang
 * @create: 2018-08-17 20:06
 **/
@Configurable
@ComponentScan(basePackages = {"spitter"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {

}
