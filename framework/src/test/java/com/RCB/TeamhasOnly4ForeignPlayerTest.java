package com.RCB;

import org.testng.Assert;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;
import java.io.File;

public class TeamhasOnly4ForeignPlayerTest {

	@Test
	public void palyertest() {
		File file=new File("./src/test/resources/Rcb.json");
		String resp=given()
		.body(file)
		.when()
		.get("India")
		.then().statusCode(403).extract().asString();
		JsonPath jpath = new JsonPath(resp);
		int Count=jpath.getInt("player.country");
		int countForeignPlayer=0;
		for(int i=0; i<=Count; i++)
		{
		if(jpath.getString("player.country")!="India")
		{
			 countForeignPlayer=i;
		}

	Assert.assertEquals(countForeignPlayer,4);
	}
		
	}

	

	
}

