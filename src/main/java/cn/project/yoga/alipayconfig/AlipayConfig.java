package cn.project.yoga.alipayconfig;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092800612265";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCTTH32QZsMzEm+S1KSdzvppNNlO+SxjHzcvelC5GbjgteqnuZkHmV+WH2W8n9QQA+pJMkm6FMe8FnU11Cv3WWEWUr4AQNDKl3kIiu2MAPozk22f7AW9UkEGgIry+VzmP4k05LWsLgVnh65NkCheOQbW0czEuDRRfPfbOJxfLCrBpUhjxBom8hDHRYMKejzBuRCo06BH+3uDcu4pa41lAegB6t8K+F97GAVCIfoT4uH3NyJlEhrxAfb/lNyGDRmP32VYk68d5ptYK/K0xLdOoCIR1g1WIwNxcec7f9v+prExMF7R9ciG06L436RHQeGQsSYL7HpHvcX7sZrFWbXmGpZAgMBAAECggEBAISGib4KAMpe8uo3Mq98f3cTSO8IGBZ2Y9DnPPtmK/v+OLPWC0uA3afzTeuFem5ldLGl2yUaWc64SNpqbroL485T2FOR9bF0aM1cwR9Fy/6lvt23vGKrhWofTFzDMknzGJVhlfd7P+STQuk4mqWs8u56DXEyRvuCiIw4lvOsT/dOstuslqv8xJfUi8B5/vLKErCmdZSUfpTQeyfTmo9xx32EgHeQuUSgL1R3c+7vcxuUGKXakko+a67IoVY5/xbk2qXTH8zwxXRc5r8Oq/nJCNuEyknL3dw+imgNKW41CHwSSCUJRnJ97XH4pefWQYZ0HJUJA2hz1Dpg6KjpzxGkyUECgYEAzWpWR6fXTqqTl/wPJg7Le93T0I8lkZtdDb1BN9hrJlKqxIhHNz2vWSCdS1XQNdk5+TisGyQF9TXvapS6jh52n+lAU1vB2UEW5V/W6FxBNhKVd8bloVme1EHNILQDPyp9aJG250oCBwNm0v/nFH6XMTbyfKUaf5NpF91i89dYPIUCgYEAt5JoPJpEsIYJaoVoaNe5RiKatJWhkbgqxt9Q7pi1QiQZnZigf2/Dpxa0qRpJ+dFEwqiTmev1EHSLfx/4J2Ea82dWExDAgu0rBWUTAdjGSo/BPPva7StWPtq433LyWDYdKb9yN74ZdA+2CEj3HH+G4mjxYkX7sZ3R/pr0Ug8d+MUCgYBWdfjFBmeAzBl9snGp4jZR98fNFEOK6ysauls2J1jKc6c/O+FF5iflSu4KJJ+T2tAlD26Zqer8EGyqntl7MmVZ37Lco1WPnW8GsvVhLlugZ+gT11sWNAO/ccbmif6H2tmYZyTma2c5Dnx8OYxJOxNmeqtMPa5OnnxwuBWLb0vLhQKBgCKUMJBh2tiJlxJ6qM0+/YZplEy59uJVF7G4dS1MlLAtzqlyC6GVsvwxebx02ER3mAU27f7LhLEh0vkSU5NPZl09NOiIekrvU/BDNs5dQBTheVv8cSPFywwx9SsaIu5c2yd3CZPYekDziK2M2QeEOitB615AooW1nc3g8G7YrCOlAoGAJQQKJ3Jr1Vyd35AF3ascWZ2THj9kXgzvGYoEeGXB/mrANcMgWAAocmLUdpYEcgDHNgveYeIekZLi8rWrdT6U3GtKGCnYdDLKGm+U7F5Hr0HTXRC7jekn+/ZFs6+KHgivmcS2gDLboT50FCI5aURZCTV/fQ3v4gCpdBjG9wkq2cI=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwWp4BpLtoh6/Uy1oQvQSndE6Ld8s75MZL2raW+MxITiFINW20oDIUqze3TR1REEL6XWjt4JIdMh+18QV7tDkbPfv9iGZrkpKI2zU1AyPJD9Clkciod6Km9XBVH7NYjmCr80NQP9pM2F5l6HntHTTkNhZvjUad4r8iRzHmMTNrXMh6jM7sJFlMy1fpc5MARpOuQbnAcsH1K0SEaZtVk7+ZO6CUTFRoODkzE1FWdlO7EZvQFS8cDCpiMTDxpsVg4dcHU+PedmYRiRyHMtHTl+3nyUm/D7UJHliVQOqWbTt18pNA+fFmYULMqpLA3FPsS4fLyGxwEtD6krLCf5zSPZEgQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost/yoga/manager/success";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost/yoga/manager/success";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

