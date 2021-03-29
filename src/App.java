import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {

        try { 
			Client client = Client.create();

            JSONObject json = new JSONObject();
            json.put("email", "mail@gmail.com");
            json.put("password", "123456");
            String jsonStr = new String(json.toString());            

			WebResource resource = client.resource("https://...");
			ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonStr);
			if (response.getStatus() == 200) {
				System.out.println(response.getEntity(String.class));
			}
            
            JSONObject json2 = new JSONObject();
            json2.put("refreshToken", "eyJhbGciOiJIUzIwIjoxNjE2NzE0MTY5.............pkFD1zpjg6dkrI_fb1utLwnJh2vY");
            //json2.put("data", "{ \"userId\":\"5fccaa2c9065c724ec82d0ca\", \"_id\":\"5ff0b8cd39e97c14f0f56971\" }");
            String jsonStr2 = new String(json2.toString()); 
        //  Authorization: Bearer {{accessToken}}

            WebResource resource2 = client.resource("https://....");
			ClientResponse response2 = resource2.type(MediaType.APPLICATION_JSON)
            .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbG..........ICfYI8vyTdqEPi0goRoDvZ66R2I7V9X60vNb7sT58")
            .post(ClientResponse.class, jsonStr2);
            int res2 =response2.getStatus();
			
			System.out.println(response2.getEntity(String.class));		

		} catch (Exception e) {
			System.out.println("Exception is:" + e.getMessage());
		} 
    }
}
