package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Element;
import com.redding.rbac.infrastructure.manager.ElementManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class ElementManagerImpl extends DefaultManager<Element> implements ElementManager {
}