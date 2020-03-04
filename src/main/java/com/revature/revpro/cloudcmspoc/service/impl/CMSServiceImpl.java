package com.revature.revpro.cloudcmspoc.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.revpro.cloudcmspoc.service.CMSService;
import org.gitana.platform.client.Gitana;
import org.gitana.platform.client.platform.Platform;
import org.gitana.platform.client.repository.Repository;
import org.gitana.platform.support.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CMSServiceImpl implements CMSService {
    @Autowired
    private Environment environment;

    @Override public ResultMap<Repository> getRepositories()  {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("clientKey",environment.getProperty("gitana.clientId"));
        objectNode.put("clientSecret",environment.getProperty("gitana.clientSecret"));
        objectNode.put("username",environment.getProperty("gitana.credentials.username"));
        objectNode.put("password",environment.getProperty("gitana.credentials.password"));


        Platform platform = Gitana.connect(objectNode);
        ResultMap<Repository> repositories = platform.listRepositories();
        return repositories;
    }
}
