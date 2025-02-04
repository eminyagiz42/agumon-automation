package com.agumon.pages.billing;

import com.agumon.stepdefinition.base.BasePage;
import com.agumon.utility.driver.DriverManager;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BillingPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(BillingPage.class);

    public static List<String> getInvoiceIdBillings() {
        return invoiceIdBillings;
    }

    public static void setInvoiceIdBillings(List<String> invoiceIdBillings) {
        BillingPage.invoiceIdBillings = invoiceIdBillings;
    }

    private static List<String> invoiceIdBillings = new ArrayList<>();

    public void userClicksOnBilling() {
        homeElements.userMenuElements.get(5).click();
        utils.wait(5);
        utils.waitForPageToLoad(15);
    }

    public void userChecksACheckboxOfABilling() {
        utils.waitFor(5);
        WebElement table = billingElements.tableInBillingPage;
        List<WebElement> checkboxes = table.findElements(By.cssSelector("input[type='checkbox']"));
        if (!checkboxes.isEmpty()) {
            final Integer randomIndex = utils.faker().random().nextInt(1, checkboxes.size() - 1);
            WebElement randomCheckbox = checkboxes.get(randomIndex);
            utils.scrollIntoView(randomCheckbox);
            utils.wait(3);
            randomCheckbox.click();
            utils.wait(5);
            utils.scrollToTop();
            utils.wait(5);
        } else {
            System.out.println("No checkboxes found on the page.");
        }
    }

    public void userChecksACheckboxOfABilling2() {
        utils.waitFor(10);
        List<WebElement> checkboxes = DriverManager.driver().findElements(billingElements.invoiceCheckboxes);

        if (!checkboxes.isEmpty()) {
            final Integer randomIndex = utils.faker().random().nextInt(1, checkboxes.size() - 1);
            WebElement randomCheckbox = checkboxes.get(randomIndex);
            utils.scrollIntoView(randomCheckbox);
            utils.wait(3);
            randomCheckbox.click();
            utils.wait(5);
            utils.scrollToTop();
            utils.wait(5);
        } else {
            System.out.println("No checkboxes found on the page.");
        }
    }

    public void userChecksSomeCheckboxesOfBillings(int number) {
        utils.waitFor(5);
        WebElement table = billingElements.tableInBillingPage;
        List<WebElement> checkboxes = table.findElements(By.cssSelector("input[type='checkbox']"));
        if (!checkboxes.isEmpty()) {
            Set<Integer> randomNumbers = new LinkedHashSet<>();

            while (randomNumbers.size() != number) {
                randomNumbers.add(utils.faker().random().nextInt(1, checkboxes.size() - 1));
            }
            List<WebElement> checkboxList = new ArrayList<>();

            for (int randomNumber : randomNumbers) {
                checkboxList.add(checkboxes.get(randomNumber));
                utils.scrollIntoView(checkboxes.get(randomNumber));
                utils.wait(3);
                checkboxes.get(randomNumber).click();
                utils.wait(5);
            }

            utils.scrollToTop();
            utils.wait(5);
        } else {
            System.out.println("No checkboxes found on the page.");
        }
    }

    public Set<Integer> getRandomNumbers(int size, int maxRange) {
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() != size) {
            randomNumbers.add(utils.faker().random().nextInt(1, maxRange));
        }
        return randomNumbers;
    }

    private List<WebElement> getRandomCheckboxes(List<WebElement> allCheckboxList, Set<Integer> randomNumbers) {
        List<WebElement> selectedCheckboxes = new ArrayList<>();
        for (int number : randomNumbers) {
            selectedCheckboxes.add(allCheckboxList.get(number));
        }
        return selectedCheckboxes;
    }

    public void userChecksSomeCheckboxesOfCertainBillings(int number) {
        utils.waitFor(5);
        List<WebElement> checkboxes = billingElements.checkboxesInTable;
        List<WebElement> invoiceIdBilling = billingElements.invoiceIdBilling;
        if (!checkboxes.isEmpty()) {

            Set<Integer> randomNumbers = getRandomNumbers(number, checkboxes.size() - 1);

            for (Integer r : randomNumbers) {
                WebElement randomCheckbox = checkboxes.get(r);
                WebElement checkBoxesInvoiceId = invoiceIdBilling.get(r - 2);
                invoiceIdBillings.add(checkBoxesInvoiceId.getText());
                utils.scrollIntoView(randomCheckbox);
                utils.wait(3);
                randomCheckbox.click();
                utils.wait(5);
            }

            utils.scrollToTop();
            utils.wait(5);
        } else {
            System.out.println("No checkboxes found on the page.");
        }
    }

    public void userChecksSomeCheckboxesOfCertainBillings2(int number) {
        utils.waitFor(5);
        List<WebElement> checkboxes = DriverManager.driver().findElements(billingElements.checkboxesInTable2);
        List<WebElement> invoiceIdBilling = DriverManager.driver().findElements(billingElements.invoiceIdBilling2);
        if (!checkboxes.isEmpty()) {

            Set<Integer> randomNumbers = getRandomNumbers(number, checkboxes.size() - 1);

            for (Integer r : randomNumbers) {
                WebElement randomCheckbox = checkboxes.get(r);
                WebElement randomInvoiceId = invoiceIdBilling.get(r - 1);
                invoiceIdBillings.add(randomInvoiceId.getText());
                utils.scrollIntoView(randomCheckbox);
                utils.wait(3);
                randomCheckbox.click();
                utils.wait(5);
            }

            utils.scrollToTop();
            utils.wait(5);
        } else {
            System.out.println("No checkboxes found on the page.");
        }
    }

    public void userClicksOnPaySelectedInvoicesButton() {
        utils.clickOnElement(billingElements.paySelectedInvoicesButton);
    }

    public void userClicksOnPaySelectedInvoicesButton2() {
        utils.clickOnElement(DriverManager.driver().findElement(billingElements.paySelectedInvoicesButton2));
    }

    public void userClicksOnAvailableCredits() {
        utils.clickWebElement(billingElements.avaliableCreditsAccordion);
    }

    public void userSelectsAnAvailableCreditLowerThanTheInvoiceSummary() {
        for (int i = 0; i < billingElements.availableCreditsValues.size(); i++) {
            if (replaceCharacters(billingElements.availableCreditsValues.get(i).getText())
                    < replaceCharacters(billingElements.invoiceSummaryValue.getText())) {
                billingElements.availableCreditsCheckBoxes.get(i).click();
                LOGGER.debug(replaceCharacters(billingElements.availableCreditsValues.get(i).getText()));
                break;
            }
        }
        utils.waitFor(3);
    }

    public void userSelectsPayByCreditCardMethod() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END)
                .perform();
        utils.waitForVisibility(billingElements.payByCreditCardRadioButton, 20);
        utils.waitFor(5);
        billingElements.payByCreditCardRadioButton.isSelected();
        utils.waitFor(5);
        utils.clickWebElement(billingElements.payByCreditCardRadioButton);
    }

    public void userEntersCreditCardDetailsAndClickProcessTransactionButton(DataTable dataTable) throws IOException {
        utils.waitFor(5);
        driver.switchTo().frame(billingElements.creditCardiFrame);
        utils.sendKeys(billingElements.creditCardNumberField, dataTable.row(1).get(0)
                + Keys.TAB + "10"
                + Keys.TAB + "2027"
                + Keys.TAB + dataTable.row(1).get(1));
        driver.switchTo().defaultContent();
    }

    public void userClicksOnProcessTransactionButton() throws IOException {
        driver.switchTo().frame(billingElements.creditCardiFrame);
        billingElements.processTransactionButton.click();
        driver.switchTo().defaultContent();
        utils.waitFor(10);
    }

    public boolean confirmationPageIsDisplayed() {
        utils.waitFor(5);
        return billingElements.paymentWithCCandCreditConfirmationMessage.isDisplayed();
    }

    public double replaceCharacters(String str) {
        return Double.parseDouble(str.replace("$", "").replace(",", ""));
    }

    public void userClicksOnPayPartialBalanceRadioButton() {
        billingElements.payPartialBalanceRadioButton.click();
        utils.waitFor(2);
    }

    public void usersClearsTheAmountToPayAreaAndEntersZeroToSeeItFails() throws Exception {
        List<WebElement> invoiceInputs = billingElements.amountToPayArea;
        if (!invoiceInputs.isEmpty()) {
            WebElement firstInvoiceInput = invoiceInputs.get(0);
            utils.clearAndEnterText(firstInvoiceInput, "0");
            utils.waitFor(5);
        }
    }

    public boolean minimumAmountMessageDisplay() {
        String minimumAmountText = billingElements.minimumAmountToPayErrorMessage.getText();
        return minimumAmountText.equalsIgnoreCase("Minimum $0.01");
    }

    public boolean isAllInvoicesDisplaysOnInvoiceSummary() {
        waitUtils.waitForElementPresent(paymentElements.invoiceIdOnInvoiceSummary.get(0));
        boolean flag = true;
        for (int i = 0; i < (paymentElements.invoiceIdOnInvoiceSummary.size()) / 2; i++) {
            if (!paymentElements.invoiceIdOnInvoiceSummary.get(i).getText().equalsIgnoreCase(invoiceIdBillings.get(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void clickMakePaymentOnAccount() {
        utils.wait(5);
        DriverManager.driver().findElement(billingElements.makePaymentOnAccount).click();
    }

    public void selectAnInvoice() {
        final Integer number = utils.faker().random().nextInt(1, billingElements.invoicesCheckboxes.size() - 1);
        utils.wait(3);
        utils.selectCheckBox(billingElements.invoicesCheckboxes.get(number), true);
    }

    public void clickDownloadButton() {
        utils.wait(5);
        utils.clickWebElement(DriverManager.driver().findElement(billingElements.downloadInvoiceButton2));
        utils.wait(5);
    }

    public void clickMakePaymentInPreviewPopUp() {
        utils.clickWebElement(DriverManager.driver().findElement(billingElements.makePaymentInPreviewPopUp2));
    }

    public boolean agingBucketsAreDisplayed() {
        utils.wait(5);
        return DriverManager.driver().findElement(billingElements.agingBuckets).isDisplayed();
    }

    public void clickPreviewButton() {
        utils.wait(5);
        utils.javaScriptClick(DriverManager.driver().findElement(billingElements.previewButton2));
        utils.wait(5);
    }

    public boolean userCanSeeMultipleInvoicesAtATime() {
        utils.wait(10);
        return DriverManager.driver().findElement(billingElements.slideBoxOnPreviewPopUp2).isDisplayed();
    }

    public void clickVisibleColumnIcon() {
        utils.wait(5);
        utils.clickWebElement(DriverManager.driver().findElement(billingElements.visibleColumnIcon2));
        utils.wait(5);
    }

    public void columnsBasedOnVisibleColumnFeature() throws Exception {
        List<WebElement> columnHeader = DriverManager.driver().findElements(By.xpath("//div[@role='columnheader']"));
        DriverManager.driver().findElement(billingElements.visibleColumnIcon2).click();
        utils.wait(5);
        List<WebElement> columnsWithCheckboxes = DriverManager.driver().findElements(By.xpath("//div[@class='styles__ViewCheckBox-sc-18xgdkw-2 jgBIGo MuiBox-root css-0']"));
        List<String> checkedNames = new ArrayList<>();
        checkedNames.add(columnsWithCheckboxes.get(0).getText().toLowerCase());
        for (int i = 1; i < columnsWithCheckboxes.size(); i++) {
            if (columnsWithCheckboxes.get(i).findElement(By.tagName("input")).isSelected()) {
                checkedNames.add(columnsWithCheckboxes.get(i).getText().toLowerCase());
            }
        }

        List<String> columnHeaderNamesUpdated = columnHeader.stream()
                .map(s -> s.getText().toLowerCase().replace("ship-to seq #", "ship-to-seq #")
                        .replace("ship-to name", "ship-to-name")
                        .replace("ship-to address", "ship-to-address"))
                .filter(s -> !StringUtils.isBlank(s))
                .collect(Collectors.toList());


        for (String headerName : columnHeaderNamesUpdated) {
            if (!checkedNames.contains(headerName)) {
                throw new Exception("Header column not same with checkboxes");
            }
        }
    }

    public void userCanSelectOrUnSelectColumns() {
        utils.waitFor(5);
        List<WebElement> columnCheckBoxes = DriverManager.driver().findElements(By.xpath("//input[@name='checkbox']"));
        Set<Integer> randomNumbers = getRandomNumbers(4, columnCheckBoxes.size() - 1);
        for (Integer number : randomNumbers) {
            WebElement randomCheckbox = columnCheckBoxes.get(number);
            utils.scrollIntoView(randomCheckbox);
            utils.wait(3);
            randomCheckbox.click();
            utils.wait(5);
        }
        Actions actions = new Actions(DriverManager.driver());
        actions.moveToElement(DriverManager.driver().findElement(billingElements.visibleColumnIcon2)).click().perform();
    }

    public boolean paySelectedInvoicesButtonEnabled() {
        return DriverManager.driver().findElement(billingElements.paySelectedInvoicesButton2).isEnabled();
    }

    //TODO The method needs to be improved in the future
    public boolean verifySelectedInvoiceBalanceDue() {
        utils.wait(5);
        utils.selectCheckBox(DriverManager.driver().findElement(billingElements.firstInvoiceCheckbox), true);
        return DriverManager.driver().findElement(billingElements.balanceDueOfFirstInv).getText().
                equalsIgnoreCase(DriverManager.driver().findElement(billingElements.selectedInvBalanceDue).getText());
    }

    public boolean billingSearchCaseInsensitive() {
        DriverManager.driver().findElement(billingElements.invoiceSearchBar).sendKeys(DriverManager.driver()
                .findElement(billingElements.firstInvoiceID).getText().toLowerCase());
        utils.wait(5);
        DriverManager.driver().findElement(billingElements.firstInvoiceIDofSearchResultPreview).click();
        utils.wait(5);
        WebElement searchResult = DriverManager.driver().findElement(By.xpath("//div[@class='MuiStack-root tdFixed css-1hz1e32']"));
        return DriverManager.driver().findElement(billingElements.firstInvoiceID).getText().equals(searchResult.getText());
    }

    public boolean searchWithPOID() throws Exception {
        List<String> invoiceIDsWhereAllowRmaFalse = new ArrayList<>();
        invoiceIDsWhereAllowRmaFalse.add("WEST1000371165-001");
        DriverManager.driver().findElement(billingElements.invoiceSearchBar).sendKeys("allowrmafalse");
        utils.wait(3);
        List<WebElement> result = DriverManager.driver().findElements(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[1]/div[2]/div/div/div[4]/div[1]/div[2]/div/p[1]"));

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < invoiceIDsWhereAllowRmaFalse.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).getText().contains(invoiceIDsWhereAllowRmaFalse.get(i))) {
                    resultList.add(result.get(j).getText());
                }
            }
        }
        return resultList.equals(invoiceIDsWhereAllowRmaFalse);
    }
}
