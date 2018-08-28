package com.univers.architecture.okhttpTutorial.cucumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractBaseStepDefinition<T> {
	private final Logger log = LoggerFactory.getLogger(AbstractBaseStepDefinition.class);

	/**
	 * Retrieve resource from response.
	 *
	 * @param          <T> the generic type
	 * @param response the response
	 * @param clazz    the clazz
	 * @return the t
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public T retrieveResourceFromResponse(String response, Class<T> clazz) throws IOException {

		log.info("Retreiving value for class {}", clazz);

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(response, clazz);
	}

	public List<T> retrieveResourceArrayFromResponse(String arrayString, Class<T> clazz)
			throws JSONException, JsonParseException, JsonMappingException, IOException {
		JSONArray jsonArray = (JSONArray) new JSONTokener(arrayString).nextValue();
		List<T> listObject = new ArrayList<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			listObject.add(mapper.readValue(jsonArray.get(i).toString(), clazz));
		}
		return listObject;
	}
}
