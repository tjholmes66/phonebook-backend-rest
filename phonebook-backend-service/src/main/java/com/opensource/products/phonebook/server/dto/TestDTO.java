package com.opensource.products.phonebook.server.dto;

import java.io.Serializable;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class TestDTO implements Serializable
{
    private String link1;
    private String link2;
    private String link3;

    private URL url1;
    private URL url2;
    private URL url3;

    public String getLink1()
    {
        return link1;
    }

    public void setLink1(String link1)
    {
        this.link1 = link1;
    }

    public String getLink2()
    {
        return link2;
    }

    public void setLink2(String link2)
    {
        this.link2 = link2;
    }

    public String getLink3()
    {
        return link3;
    }

    public void setLink3(String link3)
    {
        this.link3 = link3;
    }

    public URL getUrl1()
    {
        return url1;
    }

    public void setUrl1(URL url1)
    {
        this.url1 = url1;
    }

    public URL getUrl2()
    {
        return url2;
    }

    public void setUrl2(URL url2)
    {
        this.url2 = url2;
    }

    public URL getUrl3()
    {
        return url3;
    }

    public void setUrl3(URL url3)
    {
        this.url3 = url3;
    }

    @Override
    public String toString()
    {
        return "TestDTO [link1=" + link1 + ", link2=" + link2 + ", link3=" + link3 + ", url1=" + url1 + ", url2=" + url2 + ", url3=" + url3 + "]";
    }

}
