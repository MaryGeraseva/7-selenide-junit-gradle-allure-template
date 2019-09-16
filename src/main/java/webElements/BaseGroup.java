package webElements;

import com.codeborne.selenide.ElementsCollection;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import reporting.LogInstance;

import static com.codeborne.selenide.Selenide.$$;

public class BaseGroup {

    By locator;
    ElementsCollection collection;
    Logger log = LogInstance.getLogger();

    BaseGroup(By locator) {
        this.locator = locator;
        this.collection = $$(locator);
    }

    BaseGroup(ElementsCollection collection) {
        this.collection = collection;
    }

    public By getLocator() {
        return locator;
    }

    public ElementsCollection getCollection() {
        return collection;
    }
}
