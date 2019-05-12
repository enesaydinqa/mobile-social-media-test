package com.appium;

import com.appium.context.configuration.AppConfig;
import com.appium.context.devices.DeviceManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("default")
@ContextConfiguration(classes = AppConfig.class)
public abstract class AbstractTest
{
    @Autowired
    protected DeviceManager deviceManager;
}
