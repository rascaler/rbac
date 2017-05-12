package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.File;
import com.redding.rbac.infrastructure.manager.FileManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class FileManagerImpl extends DefaultManager<File> implements FileManager {
}