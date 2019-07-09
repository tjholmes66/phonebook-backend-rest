package com.opensource.products.phonebook.server.controller;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensource.products.phonebook.server.dto.TestDTO;

@Controller
@RequestMapping("/test")
public class LinkController
{
    private TestDTO testDto;

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody TestDTO getTestLinks() throws UnsupportedEncodingException, MalformedURLException
    {
        TestDTO testDto = new TestDTO();

        testDto.setLink1("http://www.ibm.com");
        testDto.setLink2("http://www.oracle.com");
        testDto.setLink3(URLEncoder.encode("http://www.dilbert.com", "UTF-8"));

        testDto.setUrl1(new URL("http://www.url1.com"));
        testDto.setUrl2(new URL("http://www.url2.com"));
        testDto.setUrl3(new URL("http://www.url3.com"));

        return testDto;
    }
}
