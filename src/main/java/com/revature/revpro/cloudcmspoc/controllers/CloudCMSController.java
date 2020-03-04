package com.revature.revpro.cloudcmspoc.controllers;

import com.revature.revpro.cloudcmspoc.service.CMSService;
import org.gitana.platform.client.repository.Repository;
import org.gitana.platform.support.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cloud-cms")
public class CloudCMSController {

    private CMSService cmsService;

    @Autowired
    public CloudCMSController(CMSService cmsService) {
        this.cmsService = cmsService;
    }

    /**
     * To Get Cloud CMS Repositories
     *
     * @return
     */
    @PostMapping(value = "/repositories",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultMap<Repository>> getRepositories(
        @RequestBody List<String> codes) {
        return Optional.ofNullable(cmsService.getRepositories())
            .filter(Objects::nonNull)
            .map(activityType ->ResponseEntity.ok(activityType))
            .orElse(ResponseEntity.noContent().build());
    }


}
