import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.verification.WSResponseManager as WSResponseManager
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.Cookie as Cookie
import com.kms.katalon.core.logging.KeywordLogger
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

RequestObject Createproduct = findTestObject('Object Repository/create product')

String reqMethodCreate = "POST"

Createproduct.setRestRequestMethod(reqMethodCreate)

resCreateproduct = WS.sendRequest(Createproduct)

WS.verifyResponseStatusCode(resCreateproduct,200)

RequestObject getproduct = findTestObject('Object Repository/get data product')

String reqMethodget = "GET"

getproduct.setRestRequestMethod(reqMethodget)

resgetproduct = WS.sendRequest(getproduct)

WS.verifyResponseStatusCode(resgetproduct,200)

RequestObject editproduct = findTestObject('Object Repository/edit product')

String reqMethodedit = "PUT"

editproduct.setRestRequestMethod(reqMethodedit)

reseditproduct = WS.sendRequest(editproduct)

WS.verifyResponseStatusCode(reseditproduct,200)

id = '422'
RequestObject deleteproduct = findTestObject('Object Repository/get data product')

String reqMethoddelete = "DELETE"
String reqUrlDetails = ''+GlobalVariable.url+'?id='+id+''

deleteproduct.setRestUrl(reqUrlDetails)
deleteproduct.setRestRequestMethod(reqMethoddelete)
'Add REST parameter using local variable from Variables tab'
deleteproduct.getRestParameters().add(new TestObjectProperty('page', ConditionType.EQUALS, id))

deleteproduct.setRestRequestMethod(reqMethoddelete)

resdeleteproduct = WS.sendRequest(deleteproduct)

WS.verifyResponseStatusCode(resdeleteproduct,200)


