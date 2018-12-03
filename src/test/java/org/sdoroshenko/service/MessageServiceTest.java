package org.sdoroshenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MessageServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    MessageService simpleService;

    /**
     * We defined two property configurers in Spring context.
     * {@link org.springframework.beans.factory.config.PropertyPlaceholderConfigurer} works first,
     * then properties overridden by {@link org.springframework.beans.factory.config.PropertyOverrideConfigurer}.
     * @see "applicationContext.xml"
     */
    @Test
    public void getName() {
        String name = simpleService.getGreetingMessage();
        Assert.assertEquals(name, "jersey-spring-rest");
    }
}