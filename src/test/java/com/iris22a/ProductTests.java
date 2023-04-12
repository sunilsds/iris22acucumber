package com.iris22a;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.batik.ext.awt.image.codec.util.PropertyUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeyword;
import com.iriss22autil.Environment;
import com.iriss22autil.PropUtil;

public class ProductTests extends TestBase {
	
	private static final Logger log = Logger.getLogger(ProductTests.class);

	@Test
	public void VerifySearchResultForPoloMen() throws AWTException {

		PropUtil repo = new PropUtil();

		UIKeyword.launchurl(Environment.URL);

		UIKeyword.enterText(By.xpath(repo.getLocator("search_products_txtBx")), "polo men");

		UIKeyword.hitButton(KeyEvent.VK_ENTER);

		List<String> productTitles = UIKeyword.getTexts(By.xpath(repo.getLocator("product_titles_txt")));

		for (String productTitle : productTitles) {

			Assert.assertTrue(productTitle.contains("polo"), "product title doesnt contain polo" + productTitle);
		}
		
		log.info("polo men search complete");
		
		
	}

	@Test
	public void verifyAccountList() {

		PropUtil repo = new PropUtil();
		UIKeyword.launchurl(Environment.URL);

		UIKeyword.mouseMove(By.xpath(repo.getLocator("account_list")));

		UIKeyword.click(By.xpath(repo.getLocator("your_account")));
		
		log.info("click on account");
		log.info("click on accounted");

	}

}
