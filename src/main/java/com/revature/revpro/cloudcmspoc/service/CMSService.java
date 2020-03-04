package com.revature.revpro.cloudcmspoc.service;

import org.gitana.platform.client.repository.Repository;
import org.gitana.platform.support.ResultMap;

public interface CMSService {
    public ResultMap<Repository> getRepositories();
}
