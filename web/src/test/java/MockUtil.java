import org.assertj.core.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;


public class MockUtil {
	static Logger logger = LoggerFactory.getLogger(MockUtil.class);

	public static String mock(MockMvc mockMvc, String uri, Map<String, Object> map) throws  Exception{

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(uri, "json").characterEncoding("utf-8")
				.contentType(MediaType.APPLICATION_JSON);

		for (Entry<String, Object> entry : map.entrySet()) {
			builder.param(entry.getKey(), entry.getValue().toString());
		}
		return mockMvc.perform(builder).andReturn().getResponse().getContentAsString();

	}


	public static String mock(MockMvc mockMvc, String uri, Map<String,Object> map, String...pathname) throws Exception{
		MockMultipartHttpServletRequestBuilder builder = MockMvcRequestBuilders.fileUpload(new URI(uri));


		for (String fileName : pathname) {
			if(Strings.isNullOrEmpty(fileName)){
				continue;
			}
			for (Entry<String, Object> entry : map.entrySet()) {
				builder.param(entry.getKey(), entry.getValue().toString());
			}
			String multFileName = null;
			if (fileName.contains("/")) {
				multFileName = fileName.split("/")[fileName.split("/").length - 1];
				/*if (multFileName.contains(".")) {
					multFileName = multFileName.split("\\.")[0];
				}*/
			}
			if (multFileName == null){
				multFileName = "DCM_DATA.rar";
			}
			builder.file( new MockMultipartFile("file", multFileName,"multipart/form-data", new FileInputStream(new File(fileName))));
		}

		return mockMvc.perform(builder).andReturn().getResponse().getContentAsString();
	}

}
