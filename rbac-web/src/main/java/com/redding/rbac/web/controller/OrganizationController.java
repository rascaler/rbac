package com.redding.rbac.web.controller;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.commons.pojo.dto.OrganizationEditDto;
import com.redding.rbac.commons.pojo.dto.OrganizationNodeDto;
import com.redding.rbac.infrastructure.domain.Enterprise;
import com.redding.rbac.service.EnterpriseService;
import com.redding.rbac.service.OrganizationService;
import com.redding.rbac.service.OrganizationUserService;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/getOrgTree", method = RequestMethod.GET)
    @OuterResponseBody
    List<OrganizationNodeDto> getOrgTree() {
        return organizationService.getOrgTree(1, EnterpriseDto.ENTERPRISE_ID_MOCK);
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @OuterResponseBody
    void saveOrganization(@RequestBody OrganizationEditDto organization) {
        // 获取父节点
        if(null == organization.getRoleIds() || organization.getRoleIds().isEmpty())
            throw new SPIException(BasicEcode.FAILED);
        organization.setEnterpriseId(EnterpriseDto.ENTERPRISE_ID_MOCK);
        if(null == organization.getId())
          organizationService.saveOrganization(organization);
        else
          organizationService.updateOrganization(organization);
    }


}
