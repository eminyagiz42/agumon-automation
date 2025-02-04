package com.agumon.pages.profile;

import com.agumon.elements.internal.uat.UatUserProfileElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class UserProfileElements extends BaseElements {

    @FindBy(how = How.ID, using = UatUserProfileElements.fileUploadID)
    @Title(value = "This is file upload on profile page")
    public WebElement fileUpload;

    @FindBy(how = How.XPATH, using = UatUserProfileElements.deleteLogoButtonXPath)
    @Title(value = "This is delete for uploaded file on profile page")
    public WebElement deleteLogoButton;

    @FindBy(how = How.XPATH, using = UatUserProfileElements.notSupportedFileTypeMessageXpath)
    @Title(value = "This is error message for upload file on profile page")
    public WebElement fileExtensionIsntJpgorPngMessage;

    @FindBy(how = How.XPATH, using = UatUserProfileElements.logoImageXpath)
    @Title(value = "This is uploaded file image on profile page")
    public WebElement logoImage;

    @FindBy(how = How.XPATH, using = UatUserProfileElements.logoImageXpath + "/img[2]")
    @Title(value = "This is second uploaded file image on profile page")
    public WebElement secondLogoImage;
}
