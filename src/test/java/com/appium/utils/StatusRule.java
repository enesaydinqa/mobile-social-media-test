package com.appium.utils;

import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class StatusRule extends TestWatcher
{
    private Logger logger = Logger.getLogger(StatusRule.class);

    @Override
    protected void starting(Description description)
    {
        logger.info("=================================================================");
        logger.info(String.format("=====> TEST STARTED ... --> %s", description.getMethodName()));
    }

    @Override
    protected void succeeded(Description description)
    {
        logger.info("=================================================================");
        logger.info(String.format("=====> TEST PASSED ... --> %s", description.getMethodName()));
    }

    @Override
    protected void failed(Throwable e, org.junit.runner.Description description)
    {
        logger.info("=================================================================");
        logger.info(String.format("=====> TEST FAIL ... --> %s", description.getMethodName()));
    }
}
