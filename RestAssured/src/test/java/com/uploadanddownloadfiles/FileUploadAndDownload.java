package com.uploadanddownloadfiles;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
 // @Test
  public void singleFileUploadDownload() {
	  File f = new File("Path of the file");
	  given().multiPart("file",f).contentType("mutlipart/form-data")
	  .when().post("")
	  .then().statusCode(200);
  }
  @Test
  public void multipleFilesUploadAndDownload() {
	  File fOne = new File("");
	  File fTwo = new File("");
	  given().multiPart("files", fOne).multiPart("files", fTwo).contentType("multipart/form-data")
	  .when().post("")
	  .then().statusCode(200);
  }
}
