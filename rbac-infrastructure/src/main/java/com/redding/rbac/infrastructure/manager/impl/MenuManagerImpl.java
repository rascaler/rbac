package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Menu;
import com.redding.rbac.infrastructure.manager.MenuManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class MenuManagerImpl extends DefaultManager<Menu> implements MenuManager {
}