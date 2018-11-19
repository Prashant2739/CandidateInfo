import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.candidates.model.CheckUnicityRequest;
import com.candidates.model.CheckUnicityResponse;
public class CandidatesControllerTest extends AbstractTest {
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	  /* @Test
	   public void checkEmailUnicityTest() throws Exception {
	      String uri = "/email/checkUnicity/Adecco";
	      
	      CheckUnicityRequest checkUnicityRequest =new CheckUnicityRequest();
	      checkUnicityRequest.setEmail("testing1234@gmail.com");
	      
	      String inputJson = super.mapToJson(checkUnicityRequest);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      CheckUnicityResponse checkUnicityResponse = super.mapFromJson(content, CheckUnicityResponse.class);
	      assertTrue(checkUnicityResponse.isSuccess()==true);
	   }*/

}
