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

    @Test
    public void getName() {
        String name = simpleService.getGreetingMessage();
        Assert.assertEquals(name, "application");
    }
}