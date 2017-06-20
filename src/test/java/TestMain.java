import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.baibao.utils.JaxbHelper;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.controller.pay.CommonAnswer;
import com.baibao.web.p2p.controller.pay.FuyouResponse;

public class TestMain
{
	public static void main(String[] args)
		throws Exception
	{
		FuyouResponse<CommonAnswer> response = new FuyouResponse<CommonAnswer>();

		CommonAnswer answer = new CommonAnswer();

		answer.setMchnt_cd("123");
		answer.setMchnt_txn_ssn("321");
		answer.setResp_code("0000");

		response.setPlain(answer);
		response.setSignature("123123");

		String xml = JaxbHelper.formatXml(response, true);
		
		System.out.println(xml);
		System.out.println(JaxbHelper.formatXml(response.getPlain()));

		response = JaxbHelper.convert(xml, FuyouResponse.class);
		
		System.out.println(JsonHelper.formatJson(response));
	}
}
