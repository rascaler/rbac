-- MySQL Script generated by MySQL Workbench
-- 05/10/17 17:35:53
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

-- -----------------------------------------------------
-- Schema rbac
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rbac
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rbac` DEFAULT CHARACTER SET utf8 ;
USE `rbac` ;

-- -----------------------------------------------------
-- Table `rbac`.`tb_element`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_element` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_privilege` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_ element_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_ element_privilege` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `elementId` INT(11) NOT NULL,
  `privilegeId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`elementId` ASC),
  INDEX `id_idx1` (`privilegeId` ASC),
  CONSTRAINT `fk_element_privilege_elementId`
    FOREIGN KEY (`elementId`)
    REFERENCES `rbac`.`tb_element` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_element_privilege_privilegeId`
    FOREIGN KEY (`privilegeId`)
    REFERENCES `rbac`.`tb_privilege` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_file`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_file` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_file_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_file_privilege` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fileId` INT(11) NOT NULL,
  `privilegeId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`fileId` ASC),
  INDEX `id_idx1` (`privilegeId` ASC),
  CONSTRAINT `fk_file_privilege_fileId`
    FOREIGN KEY (`fileId`)
    REFERENCES `rbac`.`tb_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_file_privilege_privilegeId`
    FOREIGN KEY (`privilegeId`)
    REFERENCES `rbac`.`tb_privilege` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_menu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `enterpriseId` INT(11) NOT NULL,
  `sequence` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_menu_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_menu_privilege` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `menuId` INT(11) NOT NULL,
  `privilegeId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`privilegeId` ASC),
  INDEX `id_idx1` (`menuId` ASC),
  CONSTRAINT `fk_menu_privilege_menuId`
    FOREIGN KEY (`menuId`)
    REFERENCES `rbac`.`tb_menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_privilege_privilegeId`
    FOREIGN KEY (`privilegeId`)
    REFERENCES `rbac`.`tb_privilege` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_operation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_operation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_operation_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_operation_privilege` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `operationId` INT(11) NOT NULL,
  `privilegeId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`privilegeId` ASC),
  INDEX `id_idx1` (`operationId` ASC),
  CONSTRAINT `fk_operation_privilege_operationId`
    FOREIGN KEY (`operationId`)
    REFERENCES `rbac`.`tb_operation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operation_privilege_privilegeId`
    FOREIGN KEY (`privilegeId`)
    REFERENCES `rbac`.`tb_privilege` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `name` VARCHAR(45) NOT NULL,
  `state` TINYINT(2) NOT NULL DEFAULT 1 COMMENT '角色状态，默认值1，0=禁用，1=启用',
  `description` VARCHAR(128) NULL,
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_role_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_role_privilege` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `roleId` INT(11) NOT NULL,
  `privilegeId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx1` (`roleId` ASC),
  INDEX `id_idx` (`privilegeId` ASC),
  CONSTRAINT `fk_role_privilege_roleId`
    FOREIGN KEY (`roleId`)
    REFERENCES `rbac`.`tb_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_privilege_privilegeId`
    FOREIGN KEY (`privilegeId`)
    REFERENCES `rbac`.`tb_privilege` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_user_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_user_group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `name` VARCHAR(32) NOT NULL COMMENT '组名称',
  `parentId` INT(11) NOT NULL COMMENT '父用户组id',
  `pidList` VARCHAR(64) CHARACTER SET 'dec8' NULL COMMENT '父用户组id列表',
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_role_user_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_role_user_group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userGroupId` INT(11) NOT NULL,
  `roleId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`userGroupId` ASC),
  INDEX `id_idx1` (`roleId` ASC),
  CONSTRAINT `fk_role_user_group_userGroupId`
    FOREIGN KEY (`userGroupId`)
    REFERENCES `rbac`.`tb_user_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_user_group_roleId`
    FOREIGN KEY (`roleId`)
    REFERENCES `rbac`.`tb_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_enterprise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_enterprise` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` VARCHAR(64) NOT NULL COMMENT '公司名称',
  `englishName` VARCHAR(64) NULL COMMENT '英文名称',
  `address` VARCHAR(128) NOT NULL COMMENT '公司地址',
  `phone` VARCHAR(32) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rbac`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `username` VARCHAR(45) NOT NULL COMMENT '用户名',
  `password` VARCHAR(64) NOT NULL COMMENT '密码',
  `state` TINYINT(2) NOT NULL DEFAULT '1' COMMENT '账户状态,默认值为1，0=禁用，1=启用',
  `nickName` VARCHAR(45) NULL COMMENT '昵称',
  `name` VARCHAR(45) NOT NULL COMMENT '真实姓名',
  `email` VARCHAR(45) NULL COMMENT '邮箱',
  `phone` VARCHAR(45) NULL COMMENT '电话',
  `sex` TINYINT(2) NOT NULL COMMENT '性别,默认值为0. 1=男,2=女,0=未知',
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `enterpriseId_idx` (`enterpriseId` ASC),
  CONSTRAINT `enterpriseId`
    FOREIGN KEY (`enterpriseId`)
    REFERENCES `rbac`.`tb_enterprise` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `roleId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`userId` ASC),
  INDEX `roleId_idx` (`roleId` ASC),
  CONSTRAINT `fk_user_role_userId`
    FOREIGN KEY (`userId`)
    REFERENCES `rbac`.`tb_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_roleId`
    FOREIGN KEY (`roleId`)
    REFERENCES `rbac`.`tb_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_user_user_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_user_user_group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userGroupId` INT(11) NOT NULL,
  `userId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`userGroupId` ASC),
  INDEX `id_idx1` (`userId` ASC),
  CONSTRAINT `fk_user_user_group_userGroupId`
    FOREIGN KEY (`userGroupId`)
    REFERENCES `rbac`.`tb_user_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_group_userId`
    FOREIGN KEY (`userId`)
    REFERENCES `rbac`.`tb_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rbac`.`tb_login_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_login_log` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` INT(11) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  `loginDate` TIMESTAMP NOT NULL,
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`userId` ASC),
  CONSTRAINT `id`
    FOREIGN KEY (`userId`)
    REFERENCES `rbac`.`tb_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rbac`.`tb_organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_organization` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedDate` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `parentId` INT(11) NOT NULL COMMENT '父节点',
  `pidList` VARCHAR(64) NOT NULL COMMENT '父节点ID列表',
  `name` VARCHAR(45) NOT NULL COMMENT '组织名称',
  `enterpriseId` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rbac`.`tb_organization_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rbac`.`tb_organization_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `organizationId` INT(11) NOT NULL,
  `userId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `organizationId_idx` (`userId` ASC),
  INDEX `organizationId_idx1` (`organizationId` ASC),
  CONSTRAINT `fk_organization_user_userId`
    FOREIGN KEY (`userId`)
    REFERENCES `rbac`.`tb_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_organization_user_organizationId`
    FOREIGN KEY (`organizationId`)
    REFERENCES `rbac`.`tb_organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
