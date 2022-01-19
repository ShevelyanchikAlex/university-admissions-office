SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema university_admissions_office_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `university_admissions_office_db` DEFAULT CHARACTER SET utf8;
USE `university_admissions_office_db`;

-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`roles`
(
    `role_id`   INT         NOT NULL,
    `role_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`role_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`users`
(
    `user_id`     INT          NOT NULL AUTO_INCREMENT,
    `password`    VARCHAR(100) NULL,
    `email`       VARCHAR(70)  NULL,
    `name`        VARCHAR(50)  NULL,
    `surname`     VARCHAR(70)  NULL,
    `passport_id` VARCHAR(20)  NULL,
    `status`      VARCHAR(10)  NOT NULL,
    `role_id`     INT          NOT NULL,
    PRIMARY KEY (`user_id`),
    INDEX `fk_Users_Roles1_idx` (`role_id` ASC) VISIBLE,
    CONSTRAINT `fk_Users_Roles1`
        FOREIGN KEY (`role_id`)
            REFERENCES `university_admissions_office_db`.`roles` (`role_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`faculties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`faculties`
(
    `faculty_id`          INT          NOT NULL AUTO_INCREMENT,
    `faculty_short_name`  VARCHAR(15)  NOT NULL,
    `faculty_name`        VARCHAR(50)  NOT NULL,
    `faculty_description` VARCHAR(300) NOT NULL,
    `logo_picture_url`    VARCHAR(150) NULL,
    PRIMARY KEY (`faculty_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`applications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`applications`
(
    `application_id`   INT          NOT NULL AUTO_INCREMENT,
    `apply_date`       DATETIME     NOT NULL,
    `is_approved`      TINYINT      NOT NULL,
    `decision_date`    DATETIME     NULL,
    `rejection_reason` VARCHAR(200) NULL,
    `user_id`          INT          NOT NULL,
    `faculty_id`       INT          NOT NULL,
    PRIMARY KEY (`application_id`),
    INDEX `fk_Applications_Users1_idx` (`user_id` ASC) VISIBLE,
    INDEX `fk_Applications_Faculties1_idx` (`faculty_id` ASC) VISIBLE,
    CONSTRAINT `fk_Applications_Users1`
        FOREIGN KEY (`user_id`)
            REFERENCES `university_admissions_office_db`.`users` (`user_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_Applications_Faculties1`
        FOREIGN KEY (`faculty_id`)
            REFERENCES `university_admissions_office_db`.`faculties` (`faculty_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`subjects`
(
    `subject_id`         INT         NOT NULL AUTO_INCREMENT,
    `subject_name`       VARCHAR(45) NOT NULL,
    `subject_short_name` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`subject_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`results`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`results`
(
    `result_id`                INT          NOT NULL AUTO_INCREMENT,
    `score`                    DOUBLE       NULL,
    `certificate_id`           VARCHAR(45)  NOT NULL,
    `certificate_image_url`    VARCHAR(150) NULL,
    `is_certificate_confirmed` TINYINT      NOT NULL,
    `application_id`           INT          NOT NULL,
    `subject_id`               INT          NOT NULL,
    PRIMARY KEY (`result_id`),
    INDEX `fk_Results_Applications1_idx` (`application_id` ASC) VISIBLE,
    INDEX `fk_results_subjects1_idx` (`subject_id` ASC) VISIBLE,
    CONSTRAINT `fk_Results_Applications1`
        FOREIGN KEY (`application_id`)
            REFERENCES `university_admissions_office_db`.`applications` (`application_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_results_subjects1`
        FOREIGN KEY (`subject_id`)
            REFERENCES `university_admissions_office_db`.`subjects` (`subject_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`faculties_admission_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`faculties_admission_info`
(
    `faculties_admission_info_id` INT      NOT NULL AUTO_INCREMENT,
    `passing_score`               DOUBLE   NOT NULL,
    `places`                      INT      NOT NULL,
    `year`                        DATETIME NOT NULL,
    `faculty_id`                  INT      NOT NULL,
    PRIMARY KEY (`faculties_admission_info_id`),
    CONSTRAINT `fk_Faculties_info_Faculties1`
        FOREIGN KEY (`faculty_id`)
            REFERENCES `university_admissions_office_db`.`faculties` (`faculty_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `university_admissions_office_db`.`faculties_has_subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university_admissions_office_db`.`faculties_has_subjects`
(
    `faculty_id` INT      NOT NULL,
    `subject_id` INT      NOT NULL,
    `year`       DATETIME NOT NULL,
    PRIMARY KEY (`faculty_id`, `subject_id`),
    INDEX `fk_Faculties_has_Subjects_Subjects1_idx` (`subject_id` ASC) VISIBLE,
    INDEX `fk_Faculties_has_Subjects_Faculties1_idx` (`faculty_id` ASC) VISIBLE,
    CONSTRAINT `fk_Faculties_has_Subjects_Faculties1`
        FOREIGN KEY (`faculty_id`)
            REFERENCES `university_admissions_office_db`.`faculties` (`faculty_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_Faculties_has_Subjects_Subjects1`
        FOREIGN KEY (`subject_id`)
            REFERENCES `university_admissions_office_db`.`subjects` (`subject_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
