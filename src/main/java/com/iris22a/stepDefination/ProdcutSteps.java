package com.iris22a.stepDefination;

import javax.swing.text.Element;

import com.iris22a.keyword.UIKeyword;
import com.iriss22autil.Environment;
import com.page.Homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.no.Gitt;

public class ProdcutSteps {

	@Given("chrome browser is opened")
	public void m1() {
		UIKeyword.openBrowser("chrome");

	}

	@And("url is launched")
	public void launchurl() {

		UIKeyword.launchurl(Environment.URL);

	}

	@When("user searches for polo t shirts")
	public void searchPoloTshirt() {

		Homepage home = new Homepage();

		home.searchcomponent("polo");

	}

}
