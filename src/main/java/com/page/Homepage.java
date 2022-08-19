package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keyword.UIKeyword;

public class Homepage {

	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	public WebElement searchcomponent;

	public Homepage() {

		PageFactory.initElements(UIKeyword.driver, this);
	}

	public void searchcomponent(String productName) {

		UIKeyword.enterText(searchcomponent, productName);

	}

	

}
