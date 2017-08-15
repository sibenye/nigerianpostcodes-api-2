package com.elsynergy.nigerianpostcodes.model.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.elsynergy.nigerianpostcodes.model.DAO.BaseDAO;

public class ApiFindResponse extends BaseResponse
{

    private Integer numberOfResults;
    private List<? extends BaseDAO> content;

    public ApiFindResponse(final List<? extends BaseDAO> content) {
        this.content = content;
        this.numberOfResults = content != null ? content.size() : 0;
    }

    public ApiFindResponse(final BaseDAO content) {
        this.content = content != null ? Arrays.asList(content) : new ArrayList<>();
        this.numberOfResults = content != null ? 1 : 0;
    }

    public List<? extends BaseDAO> getContent()
    {
        return this.content;
    }
    public void setContent(final List<? extends BaseDAO> content)
    {
        this.content = content;
    }
    public Integer getNumberOfResults()
    {
        return this.numberOfResults;
    }
    public void setNumberOfResults(final Integer numberOfResults)
    {
        this.numberOfResults = numberOfResults;
    }

}
