package com.greatlearning;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses(CalculatorTest.class)
@SelectPackages("com.greatlearning")
//@SelectPackages({"com.greatlearning","com.includemeseperatly"})
public class SelectDemoTest {

}
