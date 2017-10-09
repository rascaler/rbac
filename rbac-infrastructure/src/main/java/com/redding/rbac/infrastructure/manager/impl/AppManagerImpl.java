package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.App;
import com.redding.rbac.infrastructure.manager.AppManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class AppManagerImpl extends DefaultManager<App> implements AppManager {
}