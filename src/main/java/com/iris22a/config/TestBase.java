package com.iris22a.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.beust.jcommander.Parameter;
import com.iris22a.keyword.UIKeyword;
import com.iriss22autil.Environment;

import io.cucumber.java.Before;

public class TestBase {

	@BeforeMethod
	public void setUp(@Optional String browserName) throws Exception {

		if (browserName == null) {

			browserName = "Chrome";
		}

		if (browserName.isEmpty()) {

			browserName = "Chrome";

			System.out.println("Setting default browser as chrome");
		}

		UIKeyword.openBrowser(browserName);
	}

	@AfterMethod

	public void tearDown() {
		UIKeyword.closeBrowser();

	}

}
