//package com.notimplement.happygear.security.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.json.JSONObject;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.util.Formatter;
//import java.util.HashMap;
//import java.util.UUID;
//
//@Component
//public class MoMoConfig {
//    public static String PARTNER_CODE = "MOMOI3J920220921";
//    public static String ACCESS_KEY = "yzp3lsHbJJifAkNU";
//    public static String SECRET_KEY = "CJLOBZMb1CpjqpDl9bhA9zqnCTv2ThSY";
//    public static String END_POINT = "https://test-payment.momo.vn/v2/gateway/api/create";
//    public static String RETURN_URL = "http://localhost:8080/ETrans/MoMoResponse"; // Gửi đến trang checkout thành công
//    public static String NOTIFY_URL = "http://localhost:8080/ETrans/MoMoNotify";
//    public static String ORDER_ID = UUID.randomUUID().toString();
//    public static String ORDER_INFOR = "PAY WITH MOMO";
//    public static String REQUEST_ID = UUID.randomUUID().toString();
//    public static String REQUEST_TYPE = "captureWallet";
//    public static String EXTRA_DATA = "";
//
//    public HttpResponse<String> sendPost(final String partnerCode, final String partnerName, final String storeId,
//                                         final String requestId, final String amount, final String orderId, final String orderInfo,
//                                         final String redirectUrl, final String ipnUrl, final String extraData, final String requestType,
//                                         final String signature) throws IOException, InterruptedException, URISyntaxException {
//
//        HashMap<String, String> values = new HashMap<String, String>() {
//            {
//                put("partnerCode", partnerCode);
//                put("partnerName", partnerName);
//                put("storeId", storeId);
//                put("requestId", requestId);
//                put("amount", amount);
//                put("orderId", orderId);
//                put("orderInfo", orderInfo);
//                put("redirectUrl", redirectUrl);
//                put("ipnUrl", ipnUrl);
//                put("lang", "en");
//                put("extraData", extraData);
//                put("requestType", requestType);
//                put("signature", signature);
//            }
//        };
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        String requestBody = objectMapper.writeValueAsString(values);
//
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .setHeader("Content-Type", "application/json")
//                .uri(new URI(END_POINT))
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        return response;
//    }
//
//    public String paymentUrl(String amount)
//            throws IOException, InterruptedException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException {
//        String requestRawData = new StringBuilder()
//                .append("accessKey").append("=").append(ACCESS_KEY).append("&")
//                .append("amount").append("=").append(amount).append("&")
//                .append("extraData").append("=").append(EXTRA_DATA).append("&")
//                .append("ipnUrl").append("=").append(NOTIFY_URL).append("&")
//                .append("orderId").append("=").append(ORDER_ID).append("&")
//                .append("orderInfo").append("=").append(ORDER_INFOR).append("&")
//                .append("partnerCode").append("=").append(PARTNER_CODE).append("&")
//                .append("redirectUrl").append("=").append(RETURN_URL).append("&")
//                .append("requestId").append("=").append(REQUEST_ID).append("&")
//                .append("requestType").append("=").append(REQUEST_TYPE)
//                .toString();
//
//        String signRequest = signHmacSHA256(requestRawData, SECRET_KEY);
//        HttpResponse<String> res = sendPost(PARTNER_CODE, "HappyGear", "MoMoStore", REQUEST_ID, amount, ORDER_ID,
//                ORDER_INFOR, RETURN_URL, NOTIFY_URL, EXTRA_DATA, REQUEST_TYPE, signRequest);
//
//        JSONObject jj = new JSONObject(res.body());
//        return jj.get("payUrl").toString();
//    }
//
//    private static String toHexString(byte[] bytes) {
//        StringBuilder sb = new StringBuilder(bytes.length * 2);
//        Formatter formatter = new Formatter(sb);
//        for (byte b : bytes) {
//            formatter.format("%02x", b);
//        }
//        return sb.toString();
//    }
//
//    public static String signHmacSHA256(String data, String secretKey)
//            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
//        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
//        Mac mac = Mac.getInstance("HmacSHA256");
//        mac.init(secretKeySpec);
//        byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
//        return toHexString(rawHmac);
//    }
//}
