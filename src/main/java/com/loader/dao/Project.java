package com.loader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.loader.dto.FeedObjects;

public class Project
{
    public ArrayList<feedobjects> GetFeeds(Connection connection) throws Exception
    {
        ArrayList<feedobjects> feedData = new ArrayList<feedobjects>();
        try
        {
            PreparedStatement ps = connection.prepareStatement("SELECT title,description,url FROM website ORDER BY id DESC");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                FeedObjects feedObject = new FeedObjects();
                feedObject.setTitle(rs.getString("title"));
                feedObject.setDescription(rs.getString("description"));
                feedObject.setUrl(rs.getString("url"));
                feedData.add(feedObject);
            }
            return feedData;
        }
        catch(Exception e)
        {
            throw e;
        }
    }

}