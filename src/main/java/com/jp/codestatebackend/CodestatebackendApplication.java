package com.jp.codestatebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CodestatebackendApplication {

    final static String serverUrl1 = "https://raw.githubusercontent.com/jp-chl/codestatebackend/master/jsons/states_hash.json#";
    final static String serverUrl2 = "https://raw.githubusercontent.com/jp-chl/codestatebackend/master/jsons/states_titlecase.json#";

    public static void main(String[] args) {
        SpringApplication.run(CodestatebackendApplication.class, args);
    }

    public static String requestProcessedData(int urlId) {

        String serverUrl = null;
        if (urlId == 1) {

            serverUrl = serverUrl1;
        } else if (urlId == 2) {

            serverUrl = serverUrl2;
        } else {

            return "ERROR";
        }

        RestTemplate request = new RestTemplate();
        String result = request.getForObject(serverUrl, String.class);
        System.out.println(serverUrl);
        return (result);
    } // end static String requestProcessedData(int urlId)

    @GetMapping("/")
    public static String hello() {
        return "HELLO I'M DATA READER";
    } // end static String hello()

    @GetMapping("/readDataForCode")
    public static String requestCodeData() {

        return requestProcessedData(1);
    } // end static String requestCodeData()

    @GetMapping("/readDataForState")
    public static String requestStateData() {

        return requestProcessedData(2);
    } // end static String requestStateData()

} // end class CodestatebackendApplication
