package controllers;

import play.mvc.*;
import java.util.*;
import java.lang.*;

import play.libs.*;
import play.data.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import com.mashape.unirest.http.*;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Options;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import org.apache.commons.io.IOUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import java.io.*;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

	public Result doGet () {

        DynamicForm dynamicForm = Form.form().bindFromRequest();
        String hub_mode = dynamicForm.get("hub.mode");
        String hub_challenge = dynamicForm.get("hub.challenge");
        String hub_verify_token = dynamicForm.get("hub.verify_token");

        if( (hub_mode != null) && (hub_challenge != null) && hub_mode.equals("subscribe") ){
        	if( (hub_verify_token == null) || !hub_verify_token.equals("djhwndgjxtyewfwgde") ){
        		return ok("Verification token mismatch");
        	}
        	return ok(hub_challenge);
        }

        return ok("Hello World");
	}

	public Result doPost ()  throws JSONException, UnirestException {
		JsonNode json = request().body().asJson();
		JsonNode object = json.get("object");
		JsonNode entry = json.get("entry");

		String obj_type = object.textValue();

		if( !obj_type.equals("page") ){
			return ok("Oops!");
		}

		if (entry.isArray()) {
		    for (JsonNode entry_item : entry) {
		    	if (entry_item.get("messaging").isArray()) {
					for (JsonNode entry_item_message : entry_item.get("messaging")) {
						JsonNode message = entry_item_message.get("message");
						JsonNode sender = entry_item_message.get("sender");
						JsonNode recipient = entry_item_message.get("recipient");
						return sendMsg(sender.get("id").textValue(), "Welcome Brother!");
					}
		    	}
		    }
		}

		return ok("Something Wrong!");
	}

	public Result testPost()
	{
		JsonNode json = request().body().asJson();

		return ok(json);
	}

	public Result sendMsg(String recipient_id, String message) throws JSONException, UnirestException {

		//https://graph.facebook.com/v2.6/me/messages?access_token=
		String url = "https://graph.facebook.com/v2.6/me/messages?access_token=EAAEPZCEjGRwwBAJbEgadksysycoXuAeSVbhLMVulAUEZBBwt55SURvXRLVahyI6FmXAzvYop2LiILcQ4JHkAze31mUHIuZARyGvwTgUlHyluj80We5IDbFNVySvFRI6pqy7HChCDkOO5sn3bYdYniZCv1X5ZBEWc1IBt2KQNERgnw9gqrTzXt";
		String body = "{\"recipient\":{\"id\":\"" + recipient_id + "\"},{\"message\":{\"text\":\"" + message + "\"}}}";
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/json").body(body).asString();

		return ok("ok");
	}
}
