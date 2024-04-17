package com.hepsiburada.stepDefinitions;

import com.hepsiburada.utilities.ApiUtils;
import com.hepsiburada.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.tinylog.Logger;


import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class APIStepDefinitions {
    private static String petName, petData, updatedPetName, id;
    Response response;
    Response updatedResponse;
    Response getResponse;
    Response deleteResponse;
    Response getPetFromPetId;

    @Given("Generate new random pet name as {string}")
    public void generate_new_random_pet_name_as(String status) {
        Logger.info("Generating new random pet name as " + status);
        petName = ApiUtils.nameGenerator();
        Logger.info(petName);
        petData = ApiUtils.animalGenerate(petName, status);
        Logger.info("Generated new random pet name as " + status);
    }

    @Given("Sending {string} request with random pet data")
    public void sending_request_with_random_pet_data(String methodType) {
        Logger.info("Sending " + methodType + " request with random pet data");
        response = ApiUtils.requestType(ConfigurationReader.getProperty("BaseURI"), methodType, petData);
        //response.prettyPrint();
        Logger.info("Sent " + methodType + " request with random pet data");

    }

    @Then("Verify status code as {int}")
    public void verify_status_code_as(int statusCode) {
        Logger.info("Verifying status code as " + statusCode);
        Assert.assertEquals(response.statusCode(), statusCode);
        Logger.info("Verified status code as " + statusCode);
    }

    @Then("Verify contains random pet name")
    public void verify_random_pet_name_visible() {
        Logger.info("Verifying contains " + petName + " pet name");
        JsonPath jsonPath = response.jsonPath();
        String actualName = jsonPath.getString("name");
        Assert.assertEquals(petName, actualName);
        Logger.info("Verified contains " + petName + " pet name");
    }

    @And("Saving pet id")
    public void recordingPetId() {
        Logger.info("Saving pet id.");
        JsonPath updatedJsonPath = response.jsonPath();
        id = updatedJsonPath.getString("id");
        Logger.info("Saved pet id as " + id);
    }

    @And("Sending {string} request for all {string} pet data")
    public void sendingRequestForAllPetData(String methodType, String status) {
        Logger.info("Sending " + methodType + " request for all " + status + " pet data");
        response = ApiUtils.requestType(ConfigurationReader.getProperty("BaseURI") + "/findByStatus?status=" + status, methodType, petData);
        //response.prettyPrint();
        Logger.info("Sent " + methodType + " request for all " + status + " pet data");
    }

    @Then("Verify all data contains random pet name")
    public void verifyAllDataContainsRandomPetName() {
        Logger.info("Verifying response contains " + updatedPetName + " name.");
        List<String> names = response.jsonPath().getList("name");
        boolean nameExists = names.contains(updatedPetName);
        assertTrue(updatedPetName + " name doesn't exist.", nameExists);
        Logger.info("Verified response contains " + updatedPetName + " name.");
    }

    @Given("Sending {string} request for specific pet")
    public void sendingRequestForSpecificPet(String methodType) {
        Logger.info("Sending " + methodType + " request for pet id: " + id);
        System.out.println("id = " + id);
        System.out.println(ConfigurationReader.getProperty("BaseURI") + "/" + id);
        deleteResponse = ApiUtils.requestType(ConfigurationReader.getProperty("BaseURI") + "/" + id, methodType, "");
        //deleteResponse.prettyPrint();
        Logger.info("Sent " + methodType + " request for pet id: " + id);
    }

    @Then("Verify created pet is not exist anymore")
    public void verifyCreatedPetIsNotExistAnymore() {
        Logger.info("Verifying id: " + id + " pet does not exit.");
        List<String> ids = response.jsonPath().getList("id");
        boolean idExist = ids.contains(id);
        assertFalse(id + " id exist.", idExist);
        Logger.info("Verified id: " + id + " pet does not exit.");
    }
}
