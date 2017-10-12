package com.elsynergy.nigerianpostcodes.util;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.base.Charsets;

public class QueryUriHelper
{

    private final List<NameValuePair> params = new ArrayList<>();
    private String path;

    public void addParam(final String name, final String value)
    {
        this.params.add(new BasicNameValuePair(name, value));
    }

    public String buildQueryString()
    {
        return URLEncodedUtils.format(this.params, StandardCharsets.UTF_8);
    }

    /**
     * Return an unescaped string representation of the URI.
     *
     * It would be nicer to simply return a java.net.URI, or even a properly escaped string,
     * but either of those are not escaped correctly when handled by
     * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get().
     */
    public String buildUri()
            throws URISyntaxException, UnsupportedEncodingException
    {
        String q = URLEncodedUtils.format(this.params, StandardCharsets.UTF_8);
        q = URLDecoder.decode(q, Charsets.UTF_8.name());

        return this.path + "?" + q;
    }

    public void deleteParam(final String name)
    {
        for (int i = 0; i < this.params.size(); i ++) {
            if (this.params.get(i).getName().equals(name)) {
                this.params.remove(i);
                return;
            }
        }
    }

    public String getPath()
    {
        return this.path;
    }

    public void setParam(final String name, final String value)
    {
        final NameValuePair replacement = new BasicNameValuePair(name, value);

        for (int i = 0; i < this.params.size(); i ++) {
            if (this.params.get(i).getName() == name) {
                this.params.remove(i);
                this.params.add(i, replacement);
                return;
            }
        }

        this.params.add(replacement);
    }

    public void setPath(final String path)
    {
        this.path = path;
    }

    @Override
    public String toString()
    {
        return this.path + "?" + this.buildQueryString();
    }



}
