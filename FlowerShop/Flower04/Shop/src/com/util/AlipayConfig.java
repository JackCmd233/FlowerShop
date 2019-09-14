package com.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.po.pojo.AlipayBean;

public class AlipayConfig {
	public static String app_id = "2016100900648705";
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChWDjtfwZm5LB4VIGWvTOCkHmQoLZRlhIfvArisgE+dXreMhTwxLI/O/3OtdK1jb0tlhWPOvv7jLZOkli6Of+Y77UfWz23mAFIOzdkmEdc1bpizAvTHBM3YbCKHNK914OIMsCIB1lHTfvw09tjnJTG11D/yNGq+0iwJIxTPPH2NuNDs66evZp3rareqKvL9BNsv/mrPaMZTGhIV1Pie033uH4zAGzjJ0Pw79XWLwSAtzCdST9bYfrqfefdopU3oGQrx8Nz6zaY6BU/wNlu/6fNNcb6wIhS6GdEYnk9aQwZvLqInrfG79GwD0W3WfZ25bnLQWw8mIS7+ayYLau6ADftAgMBAAECggEBAJr/dNj7cbwBMGK41DFqm4RvpMlDC0M/hzPDYzW6yaUmGR5CQIm4fIBw8nfVhpHxk26qwxVxFcfnuu+qeeCVfS2AAqEX9ydbuMeaU7Go9M2DaWYmHan2S6OljoJwBChqVKrQDtPfM25jxYfrDtUYBHktOlwvoPTAKGlHAyOn5c6gBqkatzlN1RGdJqKYZD+ITsIkdAeGAHjTmB20cz6b8cHqgh7oyr7xLuH12rD0plkhtm8IUhW+Z2HbtcogQxspariq3x88lce3YaNelhm2nq5csTuvL+k+TQxKyNaCmgyGHs4XJ7+uNtATmxIoNxH+vGHh2GrtpRpm9YMl1hYO2uECgYEA+7djNXmZCO3HPCQ1bVgr9o7/uSmbPP+mWgd0oD4/Ee0f1HGdMS3FdQtiq8ZSlO5JG5DkwUaf/NPIww0Re89nHL/ZieHq1pCR1dui+36PSMZN3sxa3is+rK8GzE5gIC52mIRaFMA4FMpY0ZCKJiIcsldCWt8f2rBt1i95AZ4bHMkCgYEApBcgcEfkT0/JNlYJaksu4AXTc5sLJYnrJMdVjM0yYXujUf+SSbm/16ib9VVCsq4wdST9V5xwUtmw1MDMUD/dfY7NrSIzOvGwF3E5mJoqLg78488A+f3nJIILbPnrCYg/HQbTbIpoa/nVlmjn2x8yy8SP2HTUv/xc71q1anAPaAUCgYAhtvx4yyKuSXroGUl2rdqlmZ2y5Vm/n9ZeNKVwWSYFdqdOwzD0x1atSKscquGgxRHRuWSKZrVDHfLD/VocJTmAZkny5+mWd6Kw7Ew2N0tlyfngH6sEGvK4GnFkqBLD/LUx1HhkUyKv1jJzT1LRrLv/PyTKGxyfJAZyK8Wfa9fh0QKBgE3NcWILlGNOr1cGIFy33Tf3SzVLVFOuO0IrCZNDUBoMp3mftlsiqaW1mo0OqhtSoENLEJxT3qZJ9aBK8hUy0vBPn5Hx31yZcCcNVoPWxR0lmh7h7dKa4tfamVRIg3r3kQVQUTrrvWtFAFLa1uR8vHcFcjbt3lpRbDdJSS94hrWJAoGAdR1NIVxuu2H2ztaJe5hSCvS72Wxpxt7H2E0F5mTHDPuVYHZ+ygy8nk6p9TW8mJ9ob29c8aBG5pMJWkilt/wn7LkhF/HN1RqJIIbRxi1XIMmTDfTS9snFsHcL3/HroPNEM2QDC4u3oX00OD1L+OWM9evKn2FZJC/53uziJwPDh84=";
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiLADDsc2L/4rKhmA4N2H/QTg0zdmTTN0Af9gni0M981anHqu4ptoEerXes1CbimnQlDNuLnATA3L2UDWUTjyR/GprmIg/kADCPEc1bhCQXqUXuwTVsgJSZOS1nDooJ29wY3hQqSDKYUZzozICA7mHW7QbE9BsmssPs/zTGYD50kXpNrQ2lOEIZBCyU5vVobiEeWLiHjpVFHizcH+2H3NPLS+bvSuyefb85nsuE1be2kuYDZfpKoKlCozCxcYnVmV6yCn2xqEwTbjUt+tFBrMCEioTJ5VYin7oDAqhehEzwZ5/N8Ur4c2O2I4kkgAdXvGFWTV6LybAJamt0Y/F3Z1aQIDAQAB";
    public static String notify_url = "http://localhost:8080/Shop/paysuccess.jsp";
	public static String return_url = "http://localhost:8080/Shop/paysuccess.jsp";
	public static String sign_type = "RSA2";
	public static String charset = "utf-8";
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	public static String log_path = "C:\\";
	public String pay(AlipayBean alipayBean) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		String out_trade_no = alipayBean.getOrderId();
		String total_amount = alipayBean.getAmount();
		String subject = alipayBean.getOrderName();
		String body = alipayBean.getOrderDesc();
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		return result;
	}
}

