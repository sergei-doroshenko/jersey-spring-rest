package org.sdoroshenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class SimpleServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SimpleService simpleService;

    @Test
    public void getName() {
        String name = simpleService.getName();
        Assert.assertEquals(name, "jersey-spring-rest");
    }
}