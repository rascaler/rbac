package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.FilePrivilege;
import com.redding.rbac.infrastructure.manager.FilePrivilegeManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class FilePrivilegeManagerImpl extends DefaultManager<FilePrivilege> implements FilePrivilegeManager {
}