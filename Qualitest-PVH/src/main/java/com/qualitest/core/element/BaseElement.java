package com.qualitest.core.element;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WebElementFacade;

@ImplementedBy(BaseElementImpl.class)
public interface BaseElement extends WebElementFacade {

public void fill(String text);

public String getFill();

public boolean exists(int timeoutMilliSeconds);

public boolean exists();

public void waitForMe(int timeoutMilliSeconds);

public void waitForMe();




}